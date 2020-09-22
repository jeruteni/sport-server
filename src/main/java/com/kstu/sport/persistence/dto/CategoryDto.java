package com.kstu.sport.persistence.dto;

public class CategoryDto extends LongIdEntityDto {

    private Long categoryId;

    private String caption;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
