package com.example.mavenspringboot7.controller;



import com.example.mavenspringboot7.entity.Postuser;
import com.example.mavenspringboot7.entity.express_information;
import com.example.mavenspringboot7.entity.User;
import com.example.mavenspringboot7.repository.ExpressRepository;
import com.example.mavenspringboot7.repository.UserRepository;
import com.example.mavenspringboot7.vo.BaseResponse;
import com.example.mavenspringboot7.vo.StatusCode;
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
    public BaseResponse addexpress(@RequestBody express_information express)  { //添加快递
        System.out.println(express);

        System.out.println("请求来源于快递添加页面！！！");
        express_information reseat =repository.save(express);
        if (reseat!=null){
            BaseResponse baseResponse=new BaseResponse(StatusCode.Success);
            baseResponse.setData(express);
            return baseResponse;
        }else{
            BaseResponse baseResponse=new BaseResponse(StatusCode.Fail);
            return baseResponse;
        }


    }
    @GetMapping("/express/findall")
    public BaseResponse findAll(){ //查询所有快递
        Date time =new Date();
        System.out.println("findall"+ time.getTime());
        System.out.println(repository.findAll());

            BaseResponse baseResponse=new BaseResponse(StatusCode.Success);
            baseResponse.setData(repository.findAll());
            return baseResponse;

    }
        @PostMapping("/express/sendphone")
        public List<express_information> finalbyphone(@RequestBody express_information express){//根据寄件人手机号码查询快递

        System.out.println("查询用户手机号码为： "+express.getTo_send_phone()+" 的寄件信息");
        List<express_information> a= repository.findByto_send_phone(express.getTo_send_phone());
        return repository.findByto_send_phone(express.getTo_send_phone());
        }

    @PostMapping("/express/receivephone")
    public List<express_information> finalbyreceivephone(@RequestBody express_information express){//根据寄件人手机号码查询快递

        System.out.println("查询用户手机号码为： "+express.getTo_send_phone()+" 的收件件信息");
        List<express_information> a= repository.findByto_receive_phone(express.getTo_send_phone());
        return repository.findByto_receive_phone(express.getTo_send_phone());
    }
    @PostMapping("/express/findbypostsend")//根据寄件地址查询快递信息
    public List<express_information> expressfinalbypostsend(@RequestBody Postuser puser){

        System.out.println("查询寄件地址为： "+puser.getPostaddress()+" 的快递信息");
        List<express_information> a= repository.findByto_send_address(puser.getPostaddress());

        return repository.findByto_send_address(puser.getPostaddress());
    }
    @PostMapping("/express/findbypostrecive")//根据收件地址查询快递信息
    public List<express_information> expressfinalbypostrecive(@RequestBody Postuser puser){

        System.out.println("查询寄件地址为： "+puser.getPostaddress()+" 的快递信息");
        List<express_information> a= repository.findByto_send_address(puser.getPostaddress());

        return repository.findByto_receive_address(puser.getPostaddress());
    }



    @PostMapping("express/updata")//更新物流信息 待揽件 改为已揽件
        public int updataexpress(@RequestBody express_information express){
//
            System.out.println(express.getExpress_number());
            express.setExpress_static("已揽件");

            return repository.updataexperess(express.getExpress_static(),express.getExpress_number());
        }


         @PostMapping("express/delete") //根据单号删除快递
            public void deleteexpress(@RequestBody String str){
                Integer express_number = Integer.valueOf(str);
                repository.deleteexperess(express_number);

            }




        @PostMapping("/user/login") //用户登录验证
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
        @PostMapping("/user/add") //注册新用户
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
        @GetMapping("/user/findall")//查询全部用户
        public List<User> findalluser(){
        System.out.println("查询全部用户");
        return userRepository.findAll();
        }






}
