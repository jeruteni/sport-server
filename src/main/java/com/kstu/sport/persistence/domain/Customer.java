package com.kstu.sport.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends LongIdEntity {

    private String caption;

    // Аккаунт владельца организации
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Account account;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
