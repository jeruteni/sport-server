package com.kstu.sport.persistence.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "sports_category")
public class SportsCategory extends LongIdEntity{

    @Column(name = "categoryId",nullable = false)
    private int categoryId;

    @Column(name = "caption",nullable = false)
    private String caption;
}
