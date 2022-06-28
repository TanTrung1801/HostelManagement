/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Truong Thanh Trung
 */
public class Rooms {

    private int room_id;
    private int hostel_id;
    private String name;
    private String room_slug;
    private int max_contract;

    public Rooms() {
        this.room_id = 0;
        this.hostel_id = 0;
        this.name = "";
        this.room_slug = "";
        this.max_contract = 0;
    }
    
    public Rooms(int hostel_id, String name, int max_contract) {
        this.hostel_id = hostel_id;
        this.name = name;
        this.max_contract = max_contract;
    }
    
    public Rooms(int room_id, int hostel_id, String name, String room_slug, int max_contract) {
        this.room_id = room_id;
        this.hostel_id = hostel_id;
        this.name = name;
        this.room_slug = room_slug;
        this.max_contract = max_contract;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(int hostel_id) {
        this.hostel_id = hostel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom_slug() {
        return room_slug;
    }

    public void setRoom_slug(String room_slug) {
        this.room_slug = room_slug;
    }

    public int getMax_contract() {
        return max_contract;
    }

    public void setMax_contract(int max_contract) {
        this.max_contract = max_contract;
    }

    @Override
    public String toString() {
        return "Rooms{" + "room_id=" + room_id + ", hostel_id=" + hostel_id + ", name=" + name + ", room_slug=" + room_slug + ", max_contract=" + max_contract + '}';
    }

}
