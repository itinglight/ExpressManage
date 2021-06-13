package com.example.mavenspringboot7.service;

import com.example.mavenspringboot7.entity.express_information;
import com.example.mavenspringboot7.repository.ExpressRepository;

public class Userservice {

    ExpressRepository expressrepository;

    public void Useraddexpress(express_information express){
        expressrepository.save(express);

    }

}
