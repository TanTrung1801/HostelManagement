package dtos;

import java.io.Serializable;

public class Room implements Serializable {
    private int roomId;
    private int hostelId;
    private String name;
    private String roomSlug;
    private int maxContract;

    public Room() {
    }

    public Room(int hostelId, String name, int maxContract) {
        this.hostelId = hostelId;
        this.name = name;
        this.maxContract = maxContract;
    }

    public Room(int hostelId, String name, String roomSlug, int maxContract) {
        this.hostelId = hostelId;
        this.name = name;
        this.roomSlug = roomSlug;
        this.maxContract = maxContract;
    }

    public Room(int roomId, int hostelId, String name, String roomSlug, int maxContract) {
        this.roomId = roomId;
        this.hostelId = hostelId;
        this.name = name;
        this.roomSlug = roomSlug;
        this.maxContract = maxContract;
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
}
