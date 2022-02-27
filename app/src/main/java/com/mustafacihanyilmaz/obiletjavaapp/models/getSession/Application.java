
package com.mustafacihanyilmaz.obiletjavaapp.models.getSession;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Application {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("equipment-id")
    @Expose
    private String equipmentId;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

}
