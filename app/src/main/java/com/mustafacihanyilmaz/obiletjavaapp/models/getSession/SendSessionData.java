
package com.mustafacihanyilmaz.obiletjavaapp.models.getSession;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendSessionData {

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("connection")
    @Expose
    private Object connection;
    @SerializedName("application")
    @Expose
    private Application application;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getConnection() {
        return connection;
    }

    public void setConnection(Object connection) {
        this.connection = connection;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
