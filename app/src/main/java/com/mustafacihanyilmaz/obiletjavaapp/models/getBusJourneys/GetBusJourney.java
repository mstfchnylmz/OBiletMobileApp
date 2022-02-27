
package com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetBusJourney implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeList(this.data);
        dest.writeParcelable((Parcelable) this.message, flags);
        dest.writeParcelable((Parcelable) this.userMessage, flags);
        dest.writeParcelable((Parcelable) this.apiRequestId, flags);
        dest.writeString(this.controller);
        dest.writeParcelable((Parcelable) this.clientRequestId, flags);
    }

    public void readFromParcel(Parcel source) {
        this.status = source.readString();
        this.data = new ArrayList<Datum>();
        source.readList(this.data, Datum.class.getClassLoader());
        this.message = source.readParcelable(Object.class.getClassLoader());
        this.userMessage = source.readParcelable(Object.class.getClassLoader());
        this.apiRequestId = source.readParcelable(Object.class.getClassLoader());
        this.controller = source.readString();
        this.clientRequestId = source.readParcelable(Object.class.getClassLoader());
    }

    public GetBusJourney() {
    }

    protected GetBusJourney(Parcel in) {
        this.status = in.readString();
        this.data = new ArrayList<Datum>();
        in.readList(this.data, Datum.class.getClassLoader());
        this.message = in.readParcelable(Object.class.getClassLoader());
        this.userMessage = in.readParcelable(Object.class.getClassLoader());
        this.apiRequestId = in.readParcelable(Object.class.getClassLoader());
        this.controller = in.readString();
        this.clientRequestId = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Creator<GetBusJourney> CREATOR = new Creator<GetBusJourney>() {
        @Override
        public GetBusJourney createFromParcel(Parcel source) {
            return new GetBusJourney(source);
        }

        @Override
        public GetBusJourney[] newArray(int size) {
            return new GetBusJourney[size];
        }
    };
}

