package com.kstu.sport.persistence.dto;

import lombok.Data;

@Data
public class MailMessageDto {

    private String message;
    private String subj;
    private Long eventId;
    private Boolean teamSport;

}
