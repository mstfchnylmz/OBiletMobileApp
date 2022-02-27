
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("is-promoted")
    @Expose
    private Boolean isPromoted;
    @SerializedName("back-color")
    @Expose
    private Object backColor;
    @SerializedName("fore-color")
    @Expose
    private Object foreColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getIsPromoted() {
        return isPromoted;
    }

    public void setIsPromoted(Boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    public Object getBackColor() {
        return backColor;
    }

    public void setBackColor(Object backColor) {
        this.backColor = backColor;
    }

    public Object getForeColor() {
        return foreColor;
    }

    public void setForeColor(Object foreColor) {
        this.foreColor = foreColor;
    }

}
