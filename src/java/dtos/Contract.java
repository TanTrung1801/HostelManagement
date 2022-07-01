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
public class Contract implements Serializable{
    private int contract_id;
    private int room_id;
    private int client_id;
    private double room_price;
    private Date start_date;
    private Date end_date;
    private int contract_status;
    private double deposit; 
    private Date created_at;

    public Contract() {
    }

    public Contract(int contract_id, int room_id, int client_id, double room_price, Date start_date, Date end_date, int contract_status, double deposit, Date created_at) {
        this.contract_id = contract_id;
        this.room_id = room_id;
        this.client_id = client_id;
        this.room_price = room_price;
        this.start_date = start_date;
        this.end_date = end_date;
        this.contract_status = contract_status;
        this.deposit = deposit;
        this.created_at = created_at;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(double room_price) {
        this.room_price = room_price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getContract_status() {
        return contract_status;
    }

    public void setContract_status(int contract_status) {
        this.contract_status = contract_status;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    
}
