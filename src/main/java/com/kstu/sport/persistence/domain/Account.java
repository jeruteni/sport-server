package com.kstu.sport.persistence.domain;

import com.kstu.sport.persistence.enums.AccountRole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account extends LongIdEntity {

    // Чтобы не выкидывать хэш на фронт
    public static final String PASSWORD = "PASSWORD";

    @Column(name = "login",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "middle_name",nullable = false)
    private String middleName;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @ElementCollection(targetClass = AccountRole.class)
    @JoinTable(name = "account_roles", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<AccountRole> roles;

    public Account(){
        super();
        isEnabled = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Set<AccountRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AccountRole> roles) {
        this.roles = roles;
    }
}
