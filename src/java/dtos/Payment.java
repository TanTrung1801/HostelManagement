/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author nguye
 */
public class Payment implements Serializable{
    private int payment_id;
    private int contract_id;
    private int sender_id;
    private int receiver_id;
    private Date created_at;
    private Date paid_at;
    private int payment_status;

    public Payment() {
    }

    public Payment(int contract_id, int sender_id, int receiver_id, int payment_status) {
        this.contract_id = contract_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.payment_status = payment_status;
    }

    
    public Payment(int payment_id, int contract_id, int sender_id, int receiver_id, Date created_at, Date paid_at, int payment_status) {
        this.payment_id = payment_id;
        this.contract_id = contract_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.created_at = created_at;
        this.paid_at = paid_at;
        this.payment_status = payment_status;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }
    
    
    
            
}
