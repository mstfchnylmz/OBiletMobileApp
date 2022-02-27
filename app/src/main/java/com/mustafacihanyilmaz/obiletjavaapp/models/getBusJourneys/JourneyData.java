
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JourneyData {

    @SerializedName("origin-id")
    @Expose
    private Integer originId;
    @SerializedName("destination-id")
    @Expose
    private Integer destinationId;
    @SerializedName("departure-date")
    @Expose
    private String departureDate;

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

}
