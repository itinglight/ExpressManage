package com.example.mavenspringboot7.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Postuser {

    @Id
    private String uid; //账号
    private String uname;//姓名
    private String phonenumber;//手机号码
    private String password;//密码


}
