package com.example.mavenspringboot7.controller;



import com.example.mavenspringboot7.entity.express_information;
import com.example.mavenspringboot7.entity.User;
import com.example.mavenspringboot7.repository.ExpressRepository;
import com.example.mavenspringboot7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@ResponseBody
public class expresscontroller {

    private final ExpressRepository repository;
    private final UserRepository userRepository;

    public expresscontroller(ExpressRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @PostMapping("/addexpress")
    public String addexpress(@RequestBody express_information express)  {

        System.out.println(express);
        System.out.println(express.getClass());

        System.out.println("请求来源于快递添加页面！！！");
//        @RequestBody express_information express
//        System.out.println(express);
//        express_information express2=new express_information();

        express_information result =repository.save(express);
        if(result != null){
            return "success";
        }else{
            return "error";
        }

//        express_information ex =new express_information();
//        express_information express3 = new express_information(ex.getExpress_number(),ex.getTo_send_name(),ex.getTo_send_phone(),ex.getTo_send_address(),ex.getTo_send_detailed_address(),ex.getTo_receive_name(),ex.getTo_receive_phone(),ex.getTo_receive_address(), ex.getTo_receive_detailed_address(),ex.getPrice(),ex.getExpress_desc());
//        express3.setExpress_number(10001);
//        express3.setTo_send_name("itinglight");
//        express_information exp = repository.save(express3);   //有问题！！！ 要加resource注解
//
//       System.out.println(exp);


    }
    @GetMapping("/express/findall")
    public List<express_information> findAll(){
        Date time =new Date();

        System.out.println("findall"+ time.getTime());
        System.out.println(repository.findAll());
        return repository.findAll();
    }

//    @GetMapping("/express/:phone/findall")
//    public List<express_information>ufindAll(){
//
//        return List<express_information>;
//    }

        @GetMapping("/user/findall")
        public List<User> findalluser(){
        System.out.println("查询全部用户");
        return userRepository.findAll();
        }

        @GetMapping("/user/add")
        public String adduser(@RequestBody User user){

        System.out.println(user);
        User result = userRepository.save(user);
            if(result != null){
                return "success";
            }else {
                return "error";
            }
        }



}
