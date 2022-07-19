/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lekha
 */
public class RoomModel implements Serializable {
    private int roomId;
    private int hostelId;
    private String name;
    private String roomSlug;
    private int maxContract;
    private List<Contract> activeContracts;

    public RoomModel() {
    }

    public RoomModel(int roomId, int hostelId, String name, String roomSlug, int maxContract, List<Contract> activeContracts) {
        this.roomId = roomId;
        this.hostelId = hostelId;
        this.name = name;
        this.roomSlug = roomSlug;
        this.maxContract = maxContract;
        this.activeContracts = activeContracts;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomSlug() {
        return roomSlug;
    }

    public void setRoomSlug(String roomSlug) {
        this.roomSlug = roomSlug;
    }

    public int getMaxContract() {
        return maxContract;
    }

    public void setMaxContract(int maxContract) {
        this.maxContract = maxContract;
    }

    public List<Contract> getActiveContracts() {
        return activeContracts;
    }

    public void setActiveContracts(List<Contract> activeContracts) {
        this.activeContracts = activeContracts;
    }
   
    
}
