package com.example.mavenspringboot7.entity;

import javax.persistence.criteria.CriteriaBuilder;

public class price {

    private Integer price;//快递价格
    private Integer postwage;//驿站单价价格

    public price() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPostwage() {
        return postwage;
    }

    public void setPostwage(Integer postwage) {
        this.postwage = postwage;
    }
}
