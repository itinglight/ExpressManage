package com.example.mavenspringboot7.repository;

import com.example.mavenspringboot7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


}
