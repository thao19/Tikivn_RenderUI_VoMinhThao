package com.example.tikitest.datamodel.FlashDeal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlashDealRespone {

    @SerializedName("data")
    @Expose
    private List<FlashDeal> data = null;
    @SerializedName("tabs")
    @Expose
    private List<Tab> tabs = null;
    @SerializedName("version")
    @Expose
    private String version;

    /**
     * No args constructor for use in serialization
     *
     */
    public FlashDealRespone() {
    }

    /**
     *
     * @param data
     * @param tabs
     * @param version
     */
    public FlashDealRespone(List<FlashDeal> data, List<Tab> tabs, String version) {
        super();
        this.data = data;
        this.tabs = tabs;
        this.version = version;
    }

    public List<FlashDeal> getData() {
        return data;
    }

    public void setData(List<FlashDeal> data) {
        this.data = data;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
