/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Payment_detail implements Serializable{
    private int detail_id;
    private int payment_id;
    private String name;
    private float price;

    public Payment_detail() {
    }

    public Payment_detail(int payment_id, String name, float price) {
        this.payment_id = payment_id;
        this.name = name;
        this.price = price;
    }

    
    public Payment_detail(int detail_id, int payment_id, String name, float price) {
        this.detail_id = detail_id;
        this.payment_id = payment_id;
        this.name = name;
        this.price = price;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
