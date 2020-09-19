package com.kstu.sport.persistence.enums;

import org.springframework.security.core.GrantedAuthority;

public enum AccountRole implements GrantedAuthority {

    ADMIN("ADMIN"),

    ORGANIZER("ORGANIZER"),

    USER("USER");

    private String caption;

    AccountRole(String caption) {
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
