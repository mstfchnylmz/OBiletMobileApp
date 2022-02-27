
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stop {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("is-origin")
    @Expose
    private Boolean isOrigin;
    @SerializedName("is-destination")
    @Expose
    private Boolean isDestination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getIsOrigin() {
        return isOrigin;
    }

    public void setIsOrigin(Boolean isOrigin) {
        this.isOrigin = isOrigin;
    }

    public Boolean getIsDestination() {
        return isDestination;
    }

    public void setIsDestination(Boolean isDestination) {
        this.isDestination = isDestination;
    }

}
