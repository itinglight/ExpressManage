package com.example.mavenspringboot7.repository;

import com.example.mavenspringboot7.entity.Postuser;
import com.example.mavenspringboot7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostuserRepository extends JpaRepository<Postuser,Integer> {


}
