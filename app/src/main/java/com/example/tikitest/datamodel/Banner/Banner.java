package com.example.tikitest.datamodel.Banner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("mobile_url")
    @Expose
    private String mobileUrl;
    @SerializedName("ratio")
    @Expose
    private Double ratio;

    /**
     * No args constructor for use in serialization
     *
     */
    public Banner() {
    }

    /**
     *
     * @param imageUrl
     * @param id
     * @param mobileUrl
     * @param title
     * @param content
     * @param url
     * @param thumbnailUrl
     * @param ratio
     */
    public Banner(Integer id, String title, String content, String url, String imageUrl, String thumbnailUrl, String mobileUrl, Double ratio) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.imageUrl = imageUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.mobileUrl = mobileUrl;
        this.ratio = ratio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

}
