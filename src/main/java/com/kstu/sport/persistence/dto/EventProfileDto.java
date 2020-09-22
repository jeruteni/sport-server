package com.kstu.sport.persistence.dto;


public class EventProfileDto extends LongIdEntityDto {

    private AccountDto accountDto;

    private String eventDate;

    private String eventTime;

    private String description;

    private String name;

    private String ageFrom;

    private String ageTo;

    private Long form;

    private Long place;

    private Long type;

    private CategoryDto categoryDto;

    private SportsComplexDto sportsComplexDto;

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

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

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public SportsComplexDto getSportsComplexDto() {
        return sportsComplexDto;
    }

    public void setSportsComplexDto(SportsComplexDto sportsComplexDto) {
        this.sportsComplexDto = sportsComplexDto;
    }
}
