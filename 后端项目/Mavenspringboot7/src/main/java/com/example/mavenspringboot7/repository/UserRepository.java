package com.example.mavenspringboot7.repository;

import com.example.mavenspringboot7.entity.User;
import com.example.mavenspringboot7.entity.express_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {


    @Query("select u from User u where u.phonenumber=?1")
    List<User> findbyphone(String id);
}
