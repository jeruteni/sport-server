//package com.kstu.sport.persistence.domain;
//
//import com.kstu.sport.persistence.enums.AccountEventRole;
//
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * Сущность для определения роли в рамках eventa
// */
//@Entity(name = "event_account")
//public class EventAccount extends LongIdEntity {
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "event_id")
//    private TeamSportEvent event;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "account_id")
//    private Account account;
//
//    @ElementCollection(targetClass = AccountEventRole.class)
//    @JoinTable(name = "account_roles", joinColumns = @JoinColumn(name = "account_id"))
//    @Column(name = "role", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Set<AccountEventRole> eventRoles;
//
//    public TeamSportEvent getEvent() {
//        return event;
//    }
//
//    public void setEvent(TeamSportEvent event) {
//        this.event = event;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public Set<AccountEventRole> getEventRoles() {
//        return eventRoles;
//    }
//
//    public void setEventRoles(Set<AccountEventRole> eventRoles) {
//        this.eventRoles = eventRoles;
//    }
//}
