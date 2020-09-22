package com.kstu.sport.services;

import com.kstu.sport.persistence.domain.Event;

public interface MailService {
    public void mailingPreferences(Event event);
}
