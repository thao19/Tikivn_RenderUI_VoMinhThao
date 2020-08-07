package com.example.tikitest.datamodel.FlashDeal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inventory {

    @SerializedName("product_virtual_type")
    @Expose
    private Object productVirtualType;
    @SerializedName("fulfillment_type")
    @Expose
    private String fulfillmentType;

    /**
     * No args constructor for use in serialization
     *
     */
    public Inventory() {
    }

    /**
     *
     * @param productVirtualType
     * @param fulfillmentType
     */
    public Inventory(Object productVirtualType, String fulfillmentType) {
        super();
        this.productVirtualType = productVirtualType;
        this.fulfillmentType = fulfillmentType;
    }

    public Object getProductVirtualType() {
        return productVirtualType;
    }

    public void setProductVirtualType(Object productVirtualType) {
        this.productVirtualType = productVirtualType;
    }

    public String getFulfillmentType() {
        return fulfillmentType;
    }

    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

}
