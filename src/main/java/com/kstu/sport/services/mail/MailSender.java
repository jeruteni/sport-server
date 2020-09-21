package com.kstu.sport.services.mail;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class MailSender {

    @Qualifier("getJavaMailSender")
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sent(String toAccount, String subj, String message, boolean multipart, String path){

        if(multipart){

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            try {

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart);

                helper.setFrom(username);
                helper.setTo(toAccount);
                helper.setSubject(subj);
                helper.setText(message);

                FileSystemResource file = new FileSystemResource(new File(path));
                helper.addAttachment("AttachmentFile."+ FilenameUtils.getExtension(file.getFilename()), file);

            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }
        else{

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(username);
            simpleMailMessage.setTo(toAccount);
            simpleMailMessage.setSubject(subj);
            simpleMailMessage.setText(message);

            javaMailSender.send(simpleMailMessage);
        }

    }
}
