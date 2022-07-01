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
public class Feedback implements Serializable{
    private int feedback_id;
    private int hostel_id;
    private int room_id;
    private int client_id;
    private String content;
    private Date send_at;

    public Feedback() {
        
    }

    public Feedback(int hostel_id, int room_id, int client_id, String content) {
        this.hostel_id = hostel_id;
        this.room_id = room_id;
        this.client_id = client_id;
        this.content = content;
    }



    
    

    public Feedback(int feedback_id, int hostel_id, int room_id, int client_id, String content, Date send_at) {
        this.feedback_id = feedback_id;
        this.hostel_id = hostel_id;
        this.room_id = room_id;
        this.client_id = client_id;
        this.content = content;
        this.send_at = send_at;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(int hostel_id) {
        this.hostel_id = hostel_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSend_at() {
        return send_at;
    }

    public void setSend_at(Date send_at) {
        this.send_at = send_at;
    }
    
    
}
