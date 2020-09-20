package com.kstu.sport.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

// TODO использовать в будущем готовые решения с гордами и тд
@Entity
public class City extends LongIdEntity {

    @Column(name = "caption", nullable = false)
    private String caption;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
