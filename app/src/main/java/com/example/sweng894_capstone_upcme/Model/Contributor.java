package com.example.sweng894_capstone_upcme.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contributor {

    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("name")
    @Expose
    private String name;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
