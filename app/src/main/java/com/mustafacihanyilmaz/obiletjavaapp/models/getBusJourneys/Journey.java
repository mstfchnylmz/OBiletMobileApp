
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Journey {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("stops")
    @Expose
    private List<Stop> stops = null;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("departure")
    @Expose
    private String departure;
    @SerializedName("arrival")
    @Expose
    private String arrival;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("original-price")
    @Expose
    private Double originalPrice;
    @SerializedName("internet-price")
    @Expose
    private Double internetPrice;
    @SerializedName("provider-internet-price")
    @Expose
    private Double providerInternetPrice;
    @SerializedName("booking")
    @Expose
    private Object booking;
    @SerializedName("bus-name")
    @Expose
    private String busName;
    @SerializedName("policy")
    @Expose
    private Policy policy;
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("available")
    @Expose
    private Object available;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getInternetPrice() {
        return internetPrice;
    }

    public void setInternetPrice(Double internetPrice) {
        this.internetPrice = internetPrice;
    }

    public Double getProviderInternetPrice() {
        return providerInternetPrice;
    }

    public void setProviderInternetPrice(Double providerInternetPrice) {
        this.providerInternetPrice = providerInternetPrice;
    }

    public Object getBooking() {
        return booking;
    }

    public void setBooking(Object booking) {
        this.booking = booking;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getAvailable() {
        return available;
    }

    public void setAvailable(Object available) {
        this.available = available;
    }

}
