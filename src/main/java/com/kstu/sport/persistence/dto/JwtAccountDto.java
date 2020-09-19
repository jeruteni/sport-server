package com.kstu.sport.persistence.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.enums.AccountRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@AllArgsConstructor
public class JwtAccountDto implements UserDetails {

    private final Long id;

    private final String username;

    private final String password;

    @JsonIgnore
    private final boolean enabled;

    @JsonIgnore
    private Set<AccountRole> accountRoleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountRoleList;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
