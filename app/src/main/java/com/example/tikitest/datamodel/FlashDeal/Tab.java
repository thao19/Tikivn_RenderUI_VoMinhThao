package com.example.tikitest.datamodel.FlashDeal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tab {

    @SerializedName("query_value")
    @Expose
    private Integer queryValue;
    @SerializedName("from_date")
    @Expose
    private String fromDate;
    @SerializedName("to_date")
    @Expose
    private String toDate;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("active")
    @Expose
    private Boolean active;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tab() {
    }

    /**
     *
     * @param fromDate
     * @param toDate
     * @param display
     * @param active
     * @param queryValue
     */
    public Tab(Integer queryValue, String fromDate, String toDate, String display, Boolean active) {
        super();
        this.queryValue = queryValue;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.display = display;
        this.active = active;
    }

    public Integer getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(Integer queryValue) {
        this.queryValue = queryValue;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
