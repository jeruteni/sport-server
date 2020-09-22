package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.AccountPreferencesRepository;
import com.kstu.sport.persistence.domain.AccountPreferences;
import com.kstu.sport.persistence.domain.Event;
import com.kstu.sport.services.mail.MailSender;
import com.kstu.sport.util.Constraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailSender mailSender;

    @Autowired
    private AccountPreferencesRepository accountPreferencesRepository;


    @Override
    public void mailingPreferences(Event event) {

        if (Objects.nonNull(event.getSportsCategory())) {
            List<AccountPreferences> accountsForMailingBasedOnPreferences = accountPreferencesRepository.findAccountPreferencesBySportsCategoryId(event.getSportsCategory().getCategoryId());

            final String message = "Доброго времени суток.На нашем портале только что создали новое мероприятие, которое может быть вам интересно - "
                    + event.getName() + " - " + event.getDescription();
            accountsForMailingBasedOnPreferences.stream()
                    .filter(e -> Objects.nonNull(e.getAccount().getEmail()))
                    .forEach(e -> mailSender.sent(e.getAccount().getEmail(), Constraints.SUBJECT, message, false, ""));

        }
    }
}
