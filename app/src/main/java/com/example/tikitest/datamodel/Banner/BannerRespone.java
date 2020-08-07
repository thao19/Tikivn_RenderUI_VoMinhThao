package com.example.tikitest.datamodel.Banner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerRespone {

    @SerializedName("data")
    @Expose
    private List<Banner> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BannerRespone() {
    }

    /**
     *
     * @param data
     */
    public BannerRespone(List<Banner> data) {
        super();
        this.data = data;
    }

    public List<Banner> getData() {
        return data;
    }

    public void setData(List<Banner> data) {
        this.data = data;
    }

}
