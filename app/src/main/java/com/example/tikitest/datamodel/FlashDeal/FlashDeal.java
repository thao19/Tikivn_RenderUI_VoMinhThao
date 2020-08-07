package com.example.tikitest.datamodel.FlashDeal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlashDeal {


    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("discount_percent")
    @Expose
    private Integer discountPercent;
    @SerializedName("special_price")
    @Expose
    private Integer specialPrice;
    @SerializedName("special_from_date")
    @Expose
    private Integer specialFromDate;
    @SerializedName("from_date")
    @Expose
    private String fromDate;
    @SerializedName("special_to_date")
    @Expose
    private Integer specialToDate;
    @SerializedName("progress")
    @Expose
    private Progress progress;
    @SerializedName("product")
    @Expose
    private Product product;

    /**
     * No args constructor for use in serialization
     *
     */
    public FlashDeal() {
    }

    /**
     *
     * @param fromDate
     * @param specialFromDate
     * @param product
     * @param discountPercent
     * @param progress
     * @param specialPrice
     * @param url
     * @param status
     * @param tags
     * @param specialToDate
     */
    public FlashDeal(Integer status, String url, String tags, Integer discountPercent, Integer specialPrice, Integer specialFromDate, String fromDate, Integer specialToDate, Progress progress, Product product) {
        super();
        this.status = status;
        this.url = url;
        this.tags = tags;
        this.discountPercent = discountPercent;
        this.specialPrice = specialPrice;
        this.specialFromDate = specialFromDate;
        this.fromDate = fromDate;
        this.specialToDate = specialToDate;
        this.progress = progress;
        this.product = product;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Integer specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Integer getSpecialFromDate() {
        return specialFromDate;
    }

    public void setSpecialFromDate(Integer specialFromDate) {
        this.specialFromDate = specialFromDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getSpecialToDate() {
        return specialToDate;
    }

    public void setSpecialToDate(Integer specialToDate) {
        this.specialToDate = specialToDate;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
