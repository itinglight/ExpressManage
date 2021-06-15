package com.example.mavenspringboot7.repository;

import com.example.mavenspringboot7.entity.RootUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootuserRepository extends JpaRepository<RootUser,String> {
}
