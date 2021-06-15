package com.example.mavenspringboot7.repository;


import com.example.mavenspringboot7.entity.express_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpressRepository extends JpaRepository<express_information,Integer>{


    /**
     * //根据手机号码查询快递
     * @param To_send_phone
     * @return
     */
    @Query("select u from express_information  u where u.to_send_phone = ?1")
    List<express_information> findByto_send_phone(String To_send_phone);

    @Query("select u from express_information  u where u.to_receive_phone = ?1")
    List<express_information> findByto_receive_phone(String To_receive_phone);//根据收件人手机号码查询快递

    /**
     * //根据寄件地址查询快递信息
     * @param address
     * @return
     */
    @Query("select ex from express_information ex where ex.to_send_address like %?1")//根据寄件地址查询快递信息
    List<express_information>findByto_send_address(String address);

    @Query("select ex from express_information ex where ex.to_send_address like %?1 and ex.express_static=?2")//根据寄件地址查询快递信息
    List<express_information>findByto_send_addressandstatic(String address,String express_static);


    /**
     * //根据收件地址查询快递信息
     * @param address
     * @return
     */
    @Query("select ex from express_information ex where ex.to_receive_address like %?1")//根据寄件地址查询快递信息
    List<express_information>findByto_receive_address(String address);
    @Query("select ex from express_information ex where ex.to_send_address like %?1 and ex.express_static=?2")//根据寄件地址和快递状态查询快递信息
    List<express_information>findByto_receive_addressandstatic(String address,String express_static);

    /**
     * //修改物流状态
     * @param express_static
     * @param express_number
     * @return
     */
    @Modifying
    @Transactional
    @Query("update express_information ex set ex.express_static=?1 where ex.express_number=?2")
    int updataexperess(String express_static,Integer express_number);

    @Modifying
    @Transactional

    @Query("delete from express_information  where express_number=?1")//根据物流单号删除订单
    void deleteexperess(Integer express_number);
}
