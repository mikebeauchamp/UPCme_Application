package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Condition {

    @SerializedName("is_new")
    @Expose
    private boolean isNew;

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

}
