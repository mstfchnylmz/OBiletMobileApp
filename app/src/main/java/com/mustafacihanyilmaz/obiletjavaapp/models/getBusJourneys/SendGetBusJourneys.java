
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendGetBusJourneys {

    @SerializedName("device-session")
    @Expose
    private JourneyDeviceSession deviceSession;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("data")
    @Expose
    private JourneyData data;

    public JourneyDeviceSession getDeviceSession() {
        return deviceSession;
    }

    public void setDeviceSession(JourneyDeviceSession deviceSession) {
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

    public JourneyData getData() {
        return data;
    }

    public void setData(JourneyData data) {
        this.data = data;
    }

}
