package com.example.mavenspringboot7.repository;


import com.example.mavenspringboot7.entity.express_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpressRepository extends JpaRepository<express_information,Integer>{


    @Query("select u from express_information  u where u.to_send_phone = ?1")
    List<express_information> findByto_send_phone(String To_send_phone); //根据寄件人手机号码查询快递

    @Query("select u from express_information  u where u.to_send_phone = ?1")
    List<express_information> findBytOtTo_receive_phone(String To_send_phone);//根据收件人手机号码查询快递


    @Query("select ex from express_information ex where ex.to_send_address like %?1")
    List<express_information>findByto_send_address(String address);//根据寄件地址查询快递信息


    @Modifying
    @Transactional
    @Query("update express_information ex set ex.express_static=?1 where ex.express_number=?2")
    int updataexperess(String express_static,Integer express_number);
    @Modifying
    @Transactional

    @Query("delete from express_information  where express_number=?1")
    void deleteexperess(Integer express_number);
}
