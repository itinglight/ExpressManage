package com.example.mavenspringboot7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {


    @Column(name="userid")
    private String userid;
    private String uname;
    @Id
    private String phonenumber;
    private String password;

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String uid) {
        this.userid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public User(String userid, String uname, String phonenumber, String password) {
        this.userid = userid;
        this.uname = uname;
        this.phonenumber = phonenumber;
        this.password = password;
    }
}
