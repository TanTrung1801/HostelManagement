/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author lekha
 */
public class UpdateToken implements Serializable {
    private String      token;
    private int         accountId;
    private Timestamp   created_at;
    private int         timeout;
    private int         status;
    private String      type;

    public UpdateToken() {
    }

    public UpdateToken(String token, int accountId, int timeout, String type) {
        this.token = token;
        this.accountId = accountId;
        this.timeout = timeout;
        this.type = type;
    }

    public UpdateToken(String token, int accountId, Timestamp created_at, int timeout, int status, String type) {
        this.token = token;
        this.accountId = accountId;
        this.created_at = created_at;
        this.timeout = timeout;
        this.status = status;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
