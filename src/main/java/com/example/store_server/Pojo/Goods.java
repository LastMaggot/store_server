package com.example.store_server.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Goods {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("pictureUrl")
    private String pictureUrl;
    @JsonProperty("version")
    private String version;
    @JsonProperty("description")
    private String description;
    @JsonProperty("publishingHouse")
    private String publishingHouse;
    @JsonProperty("purchaseCost")
    private Integer purchaseCost;
    @JsonProperty("retailPrice")
    private Integer retailPrice;
    @JsonProperty("inventory")
    private Integer inventory;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", purchaseCost=" + purchaseCost +
                ", retailPrice=" + retailPrice +
                ", inventory=" + inventory +
                '}';
    }

    public Goods() {
    }

    public Goods(
            Integer id, String name, String manufacturer,
            String pictureUrl,
            String version,
            String description,
            String publishingHouse,
            Integer purchaseCost,
            Integer retailPrice,
            Integer inventory
    ) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.pictureUrl = pictureUrl;
        this.version = version;
        this.description = description;
        this.publishingHouse = publishingHouse;
        this.purchaseCost = purchaseCost;
        this.retailPrice = retailPrice;
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Integer getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(Integer purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
