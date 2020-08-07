package com.example.tikitest.datamodel.QuickLink;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuickLinkRespone {


    @SerializedName("data")
    @Expose
    private List<List<QuickLink>> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public QuickLinkRespone() {
    }

    /**
     *
     * @param data
     */
    public QuickLinkRespone(List<List<QuickLink>> data) {
        super();
        this.data = data;
    }

    public List<List<QuickLink>> getData() {
        return data;
    }

    public void setData(List<List<QuickLink>> data) {
        this.data = data;
    }

}
