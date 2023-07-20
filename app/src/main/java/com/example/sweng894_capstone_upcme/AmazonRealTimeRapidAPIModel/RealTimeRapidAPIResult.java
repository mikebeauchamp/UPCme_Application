package com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealTimeRapidAPIResult
{
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("request_id")
    @Expose
    private String requestId;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}

