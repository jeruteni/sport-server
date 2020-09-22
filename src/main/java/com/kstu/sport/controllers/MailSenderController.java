package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.dao.SingleSportEventRepository;
import com.kstu.sport.persistence.dao.TeamSportEventRepository;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.domain.Customer;
import com.kstu.sport.persistence.domain.SingleSportEvent;
import com.kstu.sport.persistence.domain.TeamSportEvent;
import com.kstu.sport.persistence.dto.MailMessageDto;
import com.kstu.sport.services.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController("senderController")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MailSenderController {

    @Autowired
    MailSender mailSender;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TeamSportEventRepository teamSportEventRepository;
    @Autowired
    SingleSportEventRepository singleSportEventRepository;

    @Value("${upload.path}")
    String uploadPath;

    String path = "";

    @PostMapping("/mail/sent")
    public HttpStatus createMailSend(@RequestBody MailMessageDto mailMessageDto){

        if(mailMessageDto.getTeamSport()){

            TeamSportEvent teamSportEvent = teamSportEventRepository.getOne(mailMessageDto.getEventId());
            Customer customer = teamSportEvent.getCustomer();
            Account account = customer.getAccount();
/*
            if(checkRequestForFile(file)){

                path = saveMultipartFile(file);
                sentMessageWithfile(account.getEmail(), mailMessageDto.getSubj(), mailMessageDto.getMessage(), path);
            }
            else{
                sentMessageWithoutfile(account.getEmail(), mailMessageDto.getSubj(), mailMessageDto.getMessage());
            }
*/
            sentMessageWithoutfile(account.getEmail(), mailMessageDto.getSubj(), mailMessageDto.getMessage());

        }
        else{

            SingleSportEvent singleSportEvent = singleSportEventRepository.getOne(mailMessageDto.getEventId());
            Customer customer = singleSportEvent.getCustomer();
            Account account = customer.getAccount();
/*
            if(checkRequestForFile(file)){

                path = saveMultipartFile(file);
                sentMessageWithfile(account.getEmail(), mailMessageDto.getSubj(), mailMessageDto.getMessage(), path);
            }
            else{
                sentMessageWithoutfile(account.getEmail(), mailMessageDto.getSubj(), mailMessageDto.getMessage());

            }
*/
            sentMessageWithoutfile(account.getEmail(), mailMessageDto.getSubj(), mailMessageDto.getMessage());

        }
        return HttpStatus.OK;
    }


    private String saveMultipartFile(MultipartFile file){

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();

        try {
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path = uploadPath + "/" + resultFileName;

        return path;
    }

    private boolean checkRequestForFile(MultipartFile file){

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            return true;
        }

        return  false;
    }

    private void sentMessageWithfile(String toAcc, String subj, String message, String path){
        mailSender.sent(toAcc, subj, message, true, path);
    }

    private void sentMessageWithoutfile(String toAcc, String subj, String message){
        mailSender.sent(toAcc, subj, message, false, "");
    }

}
