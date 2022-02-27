
package com.mustafacihanyilmaz.obiletjavaapp.models.getSession;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("session-id")
    @Expose
    private String sessionId;
    @SerializedName("device-id")
    @Expose
    private String deviceId;
    @SerializedName("affiliate")
    @Expose
    private Object affiliate;
    @SerializedName("device-type")
    @Expose
    private Integer deviceType;
    @SerializedName("device")
    @Expose
    private Object device;

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

    public Object getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Object affiliate) {
        this.affiliate = affiliate;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Object getDevice() {
        return device;
    }

    public void setDevice(Object device) {
        this.device = device;
    }

}
