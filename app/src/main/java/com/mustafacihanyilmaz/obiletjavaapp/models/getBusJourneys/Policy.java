
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Policy {

    @SerializedName("max-seats")
    @Expose
    private Object maxSeats;
    @SerializedName("max-single")
    @Expose
    private Object maxSingle;
    @SerializedName("max-single-males")
    @Expose
    private Object maxSingleMales;
    @SerializedName("max-single-females")
    @Expose
    private Integer maxSingleFemales;
    @SerializedName("mixed-genders")
    @Expose
    private Boolean mixedGenders;
    @SerializedName("gov-id")
    @Expose
    private Boolean govId;
    @SerializedName("lht")
    @Expose
    private Boolean lht;

    public Object getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Object maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Object getMaxSingle() {
        return maxSingle;
    }

    public void setMaxSingle(Object maxSingle) {
        this.maxSingle = maxSingle;
    }

    public Object getMaxSingleMales() {
        return maxSingleMales;
    }

    public void setMaxSingleMales(Object maxSingleMales) {
        this.maxSingleMales = maxSingleMales;
    }

    public Integer getMaxSingleFemales() {
        return maxSingleFemales;
    }

    public void setMaxSingleFemales(Integer maxSingleFemales) {
        this.maxSingleFemales = maxSingleFemales;
    }

    public Boolean getMixedGenders() {
        return mixedGenders;
    }

    public void setMixedGenders(Boolean mixedGenders) {
        this.mixedGenders = mixedGenders;
    }

    public Boolean getGovId() {
        return govId;
    }

    public void setGovId(Boolean govId) {
        this.govId = govId;
    }

    public Boolean getLht() {
        return lht;
    }

    public void setLht(Boolean lht) {
        this.lht = lht;
    }

}
