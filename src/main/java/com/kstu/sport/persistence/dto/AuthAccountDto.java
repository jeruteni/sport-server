package com.kstu.sport.persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthAccountDto {

    private String email;

    private String password;

    @Override
    public String toString() {
        return "{email=" + email  + ", password= ******}";
    }
}
