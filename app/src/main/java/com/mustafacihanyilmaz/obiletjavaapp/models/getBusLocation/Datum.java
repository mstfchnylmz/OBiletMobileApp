
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parent-id")
    @Expose
    private Integer parentId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("geo-location")
    @Expose
    private GeoLocation geoLocation;
    @SerializedName("zoom")
    @Expose
    private Integer zoom;
    @SerializedName("tz-code")
    @Expose
    private String tzCode;
    @SerializedName("weather-code")
    @Expose
    private Object weatherCode;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("reference-code")
    @Expose
    private Object referenceCode;
    @SerializedName("keywords")
    @Expose
    private String keywords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public String getTzCode() {
        return tzCode;
    }

    public void setTzCode(String tzCode) {
        this.tzCode = tzCode;
    }

    public Object getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Object weatherCode) {
        this.weatherCode = weatherCode;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Object getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(Object referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
