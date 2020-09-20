package com.kstu.sport.persistence.enums;

import org.springframework.security.core.GrantedAuthority;

public enum AccountEventRole implements GrantedAuthority {

    ADMIN("ADMIN"),

    MODERATOR("MODERATOR");

    private String caption;

    AccountEventRole(String caption) {
        this.caption = caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String getAuthority() {
        return caption;
    }
}
