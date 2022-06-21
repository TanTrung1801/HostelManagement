
package dtos;

import java.io.Serializable;

public class Hostel implements Serializable {
    private int hostelId;
    private int ownerId; 
    private String city; 
    private String district;
    private String ward; 
    private String street; 
    private String name; 
    private String hostelSlug;

    public Hostel() {
        this.hostelId = 0;
        this.ownerId = 0;
        this.city = "";
        this.district = "";
        this.ward = "";
        this.street = "";
        this.name = "";
        this.hostelSlug = "";
    }

    public Hostel(int hostelId, int ownerId, String city, String district, String ward, String street, String name, String hostelSlug) {
        this.hostelId = hostelId;
        this.ownerId = ownerId;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.street = street;
        this.name = name;
        this.hostelSlug = hostelSlug;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostelSlug() {
        return hostelSlug;
    }

    public void setHostelSlug(String hostelSlug) {
        this.hostelSlug = hostelSlug;
    }

}