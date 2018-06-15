package com.khadka.khadkaradio.model;

public class Station {

    private String stationTitle;
    final String DRAWABLE = "drawable/";
    private String imageUri;

    public Station(String stationTitle, String imageUri) {
        this.stationTitle = stationTitle;
        this.imageUri = imageUri;
    }


    public String getStationTitle() {
        return stationTitle;
    }

    public String getImageUri() {
        return DRAWABLE + imageUri;
    }

}
