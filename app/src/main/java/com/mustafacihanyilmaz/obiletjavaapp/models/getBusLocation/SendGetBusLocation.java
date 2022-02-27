
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendGetBusLocation {

    @SerializedName("data")
    @Expose
    private Object data;
    @SerializedName("device-session")
    @Expose
    private DeviceSession deviceSession;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("language")
    @Expose
    private String language;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DeviceSession getDeviceSession() {
        return deviceSession;
    }

    public void setDeviceSession(DeviceSession deviceSession) {
        this.deviceSession = deviceSession;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
