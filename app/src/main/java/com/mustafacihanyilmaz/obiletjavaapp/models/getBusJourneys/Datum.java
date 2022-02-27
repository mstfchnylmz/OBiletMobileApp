
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("partner-id")
    @Expose
    private Integer partnerId;
    @SerializedName("partner-name")
    @Expose
    private String partnerName;
    @SerializedName("route-id")
    @Expose
    private Integer routeId;
    @SerializedName("bus-type")
    @Expose
    private String busType;
    @SerializedName("bus-type-name")
    @Expose
    private String busTypeName;
    @SerializedName("total-seats")
    @Expose
    private Integer totalSeats;
    @SerializedName("available-seats")
    @Expose
    private Integer availableSeats;
    @SerializedName("journey")
    @Expose
    private Journey journey;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("origin-location")
    @Expose
    private String originLocation;
    @SerializedName("destination-location")
    @Expose
    private String destinationLocation;
    @SerializedName("is-active")
    @Expose
    private Boolean isActive;
    @SerializedName("origin-location-id")
    @Expose
    private Integer originLocationId;
    @SerializedName("destination-location-id")
    @Expose
    private Integer destinationLocationId;
    @SerializedName("is-promoted")
    @Expose
    private Boolean isPromoted;
    @SerializedName("cancellation-offset")
    @Expose
    private Integer cancellationOffset;
    @SerializedName("has-bus-shuttle")
    @Expose
    private Boolean hasBusShuttle;
    @SerializedName("disable-sales-without-gov-id")
    @Expose
    private Boolean disableSalesWithoutGovId;
    @SerializedName("display-offset")
    @Expose
    private String displayOffset;
    @SerializedName("partner-rating")
    @Expose
    private Double partnerRating;
    @SerializedName("has-dynamic-pricing")
    @Expose
    private Boolean hasDynamicPricing;
    @SerializedName("disable-sales-without-hes-code")
    @Expose
    private Boolean disableSalesWithoutHesCode;
    @SerializedName("disable-single-seat-selection")
    @Expose
    private Boolean disableSingleSeatSelection;
    @SerializedName("change-offset")
    @Expose
    private Integer changeOffset;
    @SerializedName("rank")
    @Expose
    private Object rank;
    @SerializedName("display-coupon-code-input")
    @Expose
    private Boolean displayCouponCodeInput;
    @SerializedName("disable-sales-without-date-of-birth")
    @Expose
    private Boolean disableSalesWithoutDateOfBirth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusTypeName() {
        return busTypeName;
    }

    public void setBusTypeName(String busTypeName) {
        this.busTypeName = busTypeName;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getOriginLocationId() {
        return originLocationId;
    }

    public void setOriginLocationId(Integer originLocationId) {
        this.originLocationId = originLocationId;
    }

    public Integer getDestinationLocationId() {
        return destinationLocationId;
    }

    public void setDestinationLocationId(Integer destinationLocationId) {
        this.destinationLocationId = destinationLocationId;
    }

    public Boolean getIsPromoted() {
        return isPromoted;
    }

    public void setIsPromoted(Boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    public Integer getCancellationOffset() {
        return cancellationOffset;
    }

    public void setCancellationOffset(Integer cancellationOffset) {
        this.cancellationOffset = cancellationOffset;
    }

    public Boolean getHasBusShuttle() {
        return hasBusShuttle;
    }

    public void setHasBusShuttle(Boolean hasBusShuttle) {
        this.hasBusShuttle = hasBusShuttle;
    }

    public Boolean getDisableSalesWithoutGovId() {
        return disableSalesWithoutGovId;
    }

    public void setDisableSalesWithoutGovId(Boolean disableSalesWithoutGovId) {
        this.disableSalesWithoutGovId = disableSalesWithoutGovId;
    }

    public String getDisplayOffset() {
        return displayOffset;
    }

    public void setDisplayOffset(String displayOffset) {
        this.displayOffset = displayOffset;
    }

    public Double getPartnerRating() {
        return partnerRating;
    }

    public void setPartnerRating(Double partnerRating) {
        this.partnerRating = partnerRating;
    }

    public Boolean getHasDynamicPricing() {
        return hasDynamicPricing;
    }

    public void setHasDynamicPricing(Boolean hasDynamicPricing) {
        this.hasDynamicPricing = hasDynamicPricing;
    }

    public Boolean getDisableSalesWithoutHesCode() {
        return disableSalesWithoutHesCode;
    }

    public void setDisableSalesWithoutHesCode(Boolean disableSalesWithoutHesCode) {
        this.disableSalesWithoutHesCode = disableSalesWithoutHesCode;
    }

    public Boolean getDisableSingleSeatSelection() {
        return disableSingleSeatSelection;
    }

    public void setDisableSingleSeatSelection(Boolean disableSingleSeatSelection) {
        this.disableSingleSeatSelection = disableSingleSeatSelection;
    }

    public Integer getChangeOffset() {
        return changeOffset;
    }

    public void setChangeOffset(Integer changeOffset) {
        this.changeOffset = changeOffset;
    }

    public Object getRank() {
        return rank;
    }

    public void setRank(Object rank) {
        this.rank = rank;
    }

    public Boolean getDisplayCouponCodeInput() {
        return displayCouponCodeInput;
    }

    public void setDisplayCouponCodeInput(Boolean displayCouponCodeInput) {
        this.displayCouponCodeInput = displayCouponCodeInput;
    }

    public Boolean getDisableSalesWithoutDateOfBirth() {
        return disableSalesWithoutDateOfBirth;
    }

    public void setDisableSalesWithoutDateOfBirth(Boolean disableSalesWithoutDateOfBirth) {
        this.disableSalesWithoutDateOfBirth = disableSalesWithoutDateOfBirth;
    }

}
