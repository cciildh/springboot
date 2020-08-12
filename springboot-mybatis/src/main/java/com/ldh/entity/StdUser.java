package com.ldh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * StdUser
 */
public class StdUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String userName;

    private String userPassword;

    private Date userDate;

    private Integer id;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userDate=").append(userDate);
        sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}