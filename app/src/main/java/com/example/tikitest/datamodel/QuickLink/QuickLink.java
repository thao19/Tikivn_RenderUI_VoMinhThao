package com.example.tikitest.datamodel.QuickLink;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuickLink {


    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("authentication")
    @Expose
    private Boolean authentication;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    /**
     * No args constructor for use in serialization
     *
     */
    public QuickLink() {
    }

    /**
     *
     * @param webUrl
     * @param imageUrl
     * @param title
     * @param content
     * @param url
     * @param authentication
     */
    public QuickLink(String title, String content, String url, Boolean authentication, String webUrl, String imageUrl) {
        super();
        this.title = title;
        this.content = content;
        this.url = url;
        this.authentication = authentication;
        this.webUrl = webUrl;
        this.imageUrl = imageUrl;
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

    public Boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Boolean authentication) {
        this.authentication = authentication;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
