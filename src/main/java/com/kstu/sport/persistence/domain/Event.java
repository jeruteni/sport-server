package com.kstu.sport.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Мероприятия спортивное
 */
@Entity
public class Event extends LongIdEntity {

    private String eventDate;

    private String eventTime;

    @ManyToOne
    @JoinColumn(name = "sports_complex_id")
    private SportsComplex sportsComplex;

    @ManyToOne
    @JoinColumn(name = "sports_category_id")
    private SportsCategory sportsCategory;

    //stepTwo
    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    //step 3
    @Column(name = "ageForm")
    private String ageFrom;

    @Column(name = "ageTo")
    private String ageTo;

    @Column(name = "form")
    private Long form;

    @Column(name = "place")
    private Long place;

    @Column(name = "type")
    private Long type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public SportsComplex getSportsComplex() {
        return sportsComplex;
    }

    public void setSportsComplex(SportsComplex sportsComplex) {
        this.sportsComplex = sportsComplex;
    }

    public SportsCategory getSportsCategory() {
        return sportsCategory;
    }

    public void setSportsCategory(SportsCategory sportsCategory) {
        this.sportsCategory = sportsCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public Long getForm() {
        return form;
    }

    public void setForm(Long form) {
        this.form = form;
    }

    public Long getPlace() {
        return place;
    }

    public void setPlace(Long place) {
        this.place = place;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
