package com.kstu.sport.persistence.dto;

public class SportsComplexDto extends LongIdEntityDto {

    private String caption;

    private String address;

    private String phoneNumber;

    private GeoPointDto geoPoint;

    private CityDto city;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public GeoPointDto getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPointDto geoPoint) {
        this.geoPoint = geoPoint;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }
}
