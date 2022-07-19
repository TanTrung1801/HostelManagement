/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author lekha
 */
public class Contract implements Serializable {
    private int contractId;
    private int roomId;
    private int clientId;
    private BigDecimal roomPrice;
    private Date startDate;
    private Date endDate;
    private int status;
    private BigDecimal deposit;
    private Timestamp createdAt;

    public Contract() {
    }

    public Contract(int roomId, int clientId, BigDecimal roomPrice, Date startDate, Date endDate, int status, BigDecimal deposit) {
        this.roomId = roomId;
        this.clientId = clientId;
        this.roomPrice = roomPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.deposit = deposit;
    }

    public Contract(int contractId, int roomId, int clientId, BigDecimal roomPrice, Date startDate, Date endDate, int status, BigDecimal deposit, Timestamp createdAt) {
        this.contractId = contractId;
        this.roomId = roomId;
        this.clientId = clientId;
        this.roomPrice = roomPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.deposit = deposit;
        this.createdAt = createdAt;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
