package com.example.jspritdemo.entity;

public class Goods {

    private int goodsId;
    private int index;
    private int value;
    private double pickupLocationX;
    private double pickupLocationY;
    private double deliveryLocationX;
    private double deliveryLocationY;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getPickupLocationX() {
        return pickupLocationX;
    }

    public void setPickupLocationX(double pickupLocationX) {
        this.pickupLocationX = pickupLocationX;
    }

    public double getPickupLocationY() {
        return pickupLocationY;
    }

    public void setPickupLocationY(double pickupLocationY) {
        this.pickupLocationY = pickupLocationY;
    }

    public double getDeliveryLocationX() {
        return deliveryLocationX;
    }

    public void setDeliveryLocationX(double deliveryLocationX) {
        this.deliveryLocationX = deliveryLocationX;
    }

    public double getDeliveryLocationY() {
        return deliveryLocationY;
    }

    public void setDeliveryLocationY(double deliveryLocationY) {
        this.deliveryLocationY = deliveryLocationY;
    }
}
