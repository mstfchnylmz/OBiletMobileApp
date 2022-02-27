
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBusLocation {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("user-message")
    @Expose
    private Object userMessage;
    @SerializedName("api-request-id")
    @Expose
    private Object apiRequestId;
    @SerializedName("controller")
    @Expose
    private String controller;
    @SerializedName("client-request-id")
    @Expose
    private Object clientRequestId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(Object userMessage) {
        this.userMessage = userMessage;
    }

    public Object getApiRequestId() {
        return apiRequestId;
    }

    public void setApiRequestId(Object apiRequestId) {
        this.apiRequestId = apiRequestId;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public Object getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(Object clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

}
