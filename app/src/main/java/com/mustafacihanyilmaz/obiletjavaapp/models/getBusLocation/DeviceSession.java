
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceSession {

    @SerializedName("session-id")
    @Expose
    private String sessionId;
    @SerializedName("device-id")
    @Expose
    private String deviceId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
