package com.example.mavenspringboot7.entity;

import javax.persistence.*;

@Entity
public class User {


    @Id
//    @Column(name="userid")
    private String phonenumber;
    private String userid;
    private String username;


    private String password;

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String uid) {
        this.userid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String uname) {
        this.username = uname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userid, String username, String phonenumber, String password) {
        this.userid = userid;
        this.username = username;
        this.phonenumber = phonenumber;
        this.password = password;
    }
}
