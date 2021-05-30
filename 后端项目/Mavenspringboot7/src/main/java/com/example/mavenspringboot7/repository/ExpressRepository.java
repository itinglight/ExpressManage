package com.example.mavenspringboot7.repository;


import com.example.mavenspringboot7.entity.express_information;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ExpressRepository extends JpaRepository<express_information,Integer>{

    @Override
    List<express_information> findAll();

    @Override
    <S extends express_information> S save(S s);
}
