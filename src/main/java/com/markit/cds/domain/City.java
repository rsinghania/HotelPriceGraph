package com.markit.cds.domain;

import java.io.Serializable;

public class City implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String cityName;
    private String cityId;
    public String getCityName() {
        return cityName;
    }
    public String getCityId() {
        return cityId;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    
}
