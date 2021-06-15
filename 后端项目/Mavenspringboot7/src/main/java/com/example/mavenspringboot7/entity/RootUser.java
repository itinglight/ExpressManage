package com.example.mavenspringboot7.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RootUser {
    @Id
    private String rootid;//管理员账号
    private String rootpassword;//管理员密码
    private Integer price;//快递价格
    private Integer postwage;//驿站单价价格


}
