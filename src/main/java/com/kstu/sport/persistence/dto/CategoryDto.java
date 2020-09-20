package com.kstu.sport.persistence.dto;

public class CategoryDto extends LongIdEntityDto {

    private int categoryId;

    private String caption;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
