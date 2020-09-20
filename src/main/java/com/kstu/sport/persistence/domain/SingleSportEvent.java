package com.kstu.sport.persistence.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "singleSport_event")
public class SingleSportEvent extends SportEvent{

    @Column(name = "firstSportsmanName",nullable = false)
    private String firstSportsmanName;
    @Column(name = "secondSportsmanName",nullable = false)
    private String secondSportsmanName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
