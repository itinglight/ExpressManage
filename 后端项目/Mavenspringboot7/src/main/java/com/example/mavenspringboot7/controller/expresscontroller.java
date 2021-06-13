package com.example.mavenspringboot7.controller;



import com.example.mavenspringboot7.entity.express_information;
import com.example.mavenspringboot7.entity.User;
import com.example.mavenspringboot7.repository.ExpressRepository;
import com.example.mavenspringboot7.repository.UserRepository;
import com.example.mavenspringboot7.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@ResponseBody
public class expresscontroller {
    Userservice user =new Userservice();
    private final ExpressRepository repository;
    private final UserRepository userRepository;

    public expresscontroller(ExpressRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @PostMapping("/addexpress")
    public void addexpress(@RequestBody express_information express)  { //添加快递
        System.out.println(express);

        System.out.println("请求来源于快递添加页面！！！");

        repository.save(express);


    }
    @GetMapping("/express/findall")
    public List<express_information> findAll(){ //查询所有快递
        Date time =new Date();

        System.out.println("findall"+ time.getTime());
        System.out.println(repository.findAll());
        return repository.findAll();
    }
        @GetMapping("/express/sendphone")
        public List<express_information> finalphone(@RequestBody String phone){

        System.out.println("查询用户手机号码为： "+phone+" 的寄件信息");
        List<express_information> a= repository.findByto_send_phone(phone);

        return repository.findByto_send_phone(phone);
        }

        @PostMapping("express/updata")
        public int updataexpress(@RequestBody String str){
            Integer express_number = Integer.valueOf(str);
            String express_static="以揽件";
            return repository.updataexperess(express_static,express_number);

        }
            @PostMapping("express/delete")
            public void deleteexpress(@RequestBody String str){
                Integer express_number = Integer.valueOf(str);
                repository.deleteexperess(express_number);


            }

        @PostMapping("/user/login")
        public String finduser(@RequestBody User user){
            System.out.println("user 登录");
            System.out.println(user.getPhonenumber());
            List<User> u=userRepository.findbyphone(user.getPhonenumber());
            if(u.size()==0){
                System.out.println("用户名无效");
                return "用户名无效";
            }else{
                User user1=u.get(0);
                System.out.println(user.getPassword());
                System.out.println(user1.getPassword());
                if(user.getPassword().equalsIgnoreCase(user1.getPassword())){
                return "success";
                }else {
                    return "密码错误";
                }
            }

        }
        @PostMapping("/user/add")
        public String adduser(@RequestBody User user){

            System.out.println(user);
            User result = userRepository.save(user);
            if(result != null){
                return "success";
            }else {
                return "error";
            }
        }



        @GetMapping("/user/findid")
        public User findusers(@RequestBody String id){
            List<User> u =userRepository.findbyphone(id);

            System.out.println("查询单个用户");
            User user =new User();
            if (u.size()==0){
                System.out.println("账号错误");

            }else{
                user =u.get(0);

            }


            return user;
        }
        @GetMapping("/user/findall")
        public List<User> findalluser(){
        System.out.println("查询全部用户");
        return userRepository.findAll();
        }



            @GetMapping("/post/find")
            public List<express_information> postfinal(@RequestBody String address){

                System.out.println("查询寄件地址为： "+address+" 的快递信息");
                List<express_information> a= repository.findByto_send_address(address);

                return repository.findByto_send_address(address);
            }



}
