package com.example.tikitest.datamodel.FlashDeal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sku")
    @Expose
    private Object sku;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url_path")
    @Expose
    private String urlPath;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("list_price")
    @Expose
    private Integer listPrice;
    @SerializedName("badges")
    @Expose
    private List<Object> badges = null;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("rating_average")
    @Expose
    private Integer ratingAverage;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("order_count")
    @Expose
    private Integer orderCount;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("is_visible")
    @Expose
    private Boolean isVisible;
    @SerializedName("is_fresh")
    @Expose
    private Boolean isFresh;
    @SerializedName("is_flower")
    @Expose
    private Boolean isFlower;
    @SerializedName("is_gift_card")
    @Expose
    private Boolean isGiftCard;
    @SerializedName("inventory")
    @Expose
    private Inventory inventory;
    @SerializedName("url_attendant_input_form")
    @Expose
    private String urlAttendantInputForm;
    @SerializedName("master_id")
    @Expose
    private Integer masterId;
    @SerializedName("seller_product_id")
    @Expose
    private Integer sellerProductId;
    @SerializedName("price_prefix")
    @Expose
    private String pricePrefix;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param isFlower
     * @param isGiftCard
     * @param orderCount
     * @param discount
     * @param isVisible
     * @param inventory
     * @param pricePrefix
     * @param urlPath
     * @param badges
     * @param masterId
     * @param sellerProductId
     * @param reviewCount
     * @param price
     * @param name
     * @param urlAttendantInputForm
     * @param id
     * @param sku
     * @param listPrice
     * @param ratingAverage
     * @param thumbnailUrl
     * @param isFresh
     */
    public Product(Integer id, Object sku, String name, String urlPath, Integer price, Integer listPrice, List<Object> badges, Integer discount, Integer ratingAverage, Integer reviewCount, Integer orderCount, String thumbnailUrl, Boolean isVisible, Boolean isFresh, Boolean isFlower, Boolean isGiftCard, Inventory inventory, String urlAttendantInputForm, Integer masterId, Integer sellerProductId, String pricePrefix) {
        super();
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.urlPath = urlPath;
        this.price = price;
        this.listPrice = listPrice;
        this.badges = badges;
        this.discount = discount;
        this.ratingAverage = ratingAverage;
        this.reviewCount = reviewCount;
        this.orderCount = orderCount;
        this.thumbnailUrl = thumbnailUrl;
        this.isVisible = isVisible;
        this.isFresh = isFresh;
        this.isFlower = isFlower;
        this.isGiftCard = isGiftCard;
        this.inventory = inventory;
        this.urlAttendantInputForm = urlAttendantInputForm;
        this.masterId = masterId;
        this.sellerProductId = sellerProductId;
        this.pricePrefix = pricePrefix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getSku() {
        return sku;
    }

    public void setSku(Object sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    public List<Object> getBadges() {
        return badges;
    }

    public void setBadges(List<Object> badges) {
        this.badges = badges;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Integer ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Boolean getIsFresh() {
        return isFresh;
    }

    public void setIsFresh(Boolean isFresh) {
        this.isFresh = isFresh;
    }

    public Boolean getIsFlower() {
        return isFlower;
    }

    public void setIsFlower(Boolean isFlower) {
        this.isFlower = isFlower;
    }

    public Boolean getIsGiftCard() {
        return isGiftCard;
    }

    public void setIsGiftCard(Boolean isGiftCard) {
        this.isGiftCard = isGiftCard;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getUrlAttendantInputForm() {
        return urlAttendantInputForm;
    }

    public void setUrlAttendantInputForm(String urlAttendantInputForm) {
        this.urlAttendantInputForm = urlAttendantInputForm;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getSellerProductId() {
        return sellerProductId;
    }

    public void setSellerProductId(Integer sellerProductId) {
        this.sellerProductId = sellerProductId;
    }

    public String getPricePrefix() {
        return pricePrefix;
    }

    public void setPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
    }

}
