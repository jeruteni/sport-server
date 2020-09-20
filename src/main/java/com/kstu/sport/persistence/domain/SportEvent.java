package com.kstu.sport.persistence.domain;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@Data
public abstract class SportEvent extends LongIdEntity {

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "audienceCount",nullable = false)
    private int audienceCount;
    @Column(name = "city",nullable = false)
    private String city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportsCategory_id")
    private SportsCategory sportsCategory;

}
