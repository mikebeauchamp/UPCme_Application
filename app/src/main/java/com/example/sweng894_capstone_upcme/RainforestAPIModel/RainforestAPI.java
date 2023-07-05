package com.example.sweng894_capstone_upcme.RainforestAPIModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RainforestAPI
{
    @SerializedName("request_info")
    @Expose
    private RequestInfo requestInfo;
    @SerializedName("request_parameters")
    @Expose
    private RequestParameters requestParameters;
    @SerializedName("request_metadata")
    @Expose
    private RequestMetadata requestMetadata;
    @SerializedName("product")
    @Expose
    private RainforestProduct rainforestProduct;
    @SerializedName("compare_with_similar")
    @Expose
    private List<CompareWithSimilar> compareWithSimilar;
    @SerializedName("also_bought")
    @Expose
    private List<AlsoBought> alsoBought;

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
    }

    public RequestMetadata getRequestMetadata() {
        return requestMetadata;
    }

    public void setRequestMetadata(RequestMetadata requestMetadata) {
        this.requestMetadata = requestMetadata;
    }

    public RainforestProduct getRainforestProduct() {
        return rainforestProduct;
    }

    public void setRainforestProduct(RainforestProduct rainforestProduct) {
        this.rainforestProduct = rainforestProduct;
    }

    public List<CompareWithSimilar> getCompareWithSimilar() {
        return compareWithSimilar;
    }

    public void setCompareWithSimilar(List<CompareWithSimilar> compareWithSimilar) {
        this.compareWithSimilar = compareWithSimilar;
    }

    public List<AlsoBought> getAlsoBought() {
        return alsoBought;
    }

    public void setAlsoBought(List<AlsoBought> alsoBought) {
        this.alsoBought = alsoBought;
    }
}
