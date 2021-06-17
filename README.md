# ExpressManage
database course  design

```vue
<template>
  <div>

    <el-row>
      <el-col :span="6"><div class="grid-content bg-purple">
          <span class="">寄件人信息：</span>
          <el-input v-model="input1"  size="medium" placeholder="姓名"></el-input></div>
      </el-col>
    </el-row>

    <el-row>

      <el-col :span="6">
        <div>
          <span  class="">电话</span>
        </div>
        <div class="grid-content bg-purple-light">
          <el-input v-model="input2"  size="medium" placeholder="电话"></el-input>
        </div>
      </el-col>
    </el-row>

    <div>
      <span class="">寄件人地址：</span>
      <el-cascader :options="options"  v-model="name1" :props="{ value: 'code', label: 'name'}" placeholder="寄件地址" clearable @change="handleChange"></el-cascader>
    </div>
    <div>
      <span class="">收件人地址：</span>
      <el-cascader :options="options" v-model="name2" :props="{ value: 'code', label: 'name'}" placeholder="收件地址" clearable @change="twoChange"></el-cascader>
    </div>
    <div>
      <el-button type="primary" v-on:click="commits">提交订单</el-button>
    </div>
  </div>

</template>

<script>

let pcas = require("./pcas/pcas-code.json")
export default {
  data(){
    return {
      input1: '',
      input2: '',
      options: pcas, //传入数组
      name1:[],
      name2:[],

    }
  },
  mounted(){

  },
  methods: {

    commits() {

      const person =
          {
            firstName : this.input1,
            iphone : this.input2,
            address   :
                {
                  city: this.name1,
                  tocity :this.name2,
                  state : 'MA'
                }
          }
          console.log(JSON.stringify(person));
          window.alert("订单提交成功！！！")

    },
    handleChange(code) {
      console.log(code);
      console.log();

    },

    twoChange(label){
      console.log(label);
      const todoJSON =JSON.stringify(label);
      console.log(todoJSON) // 将数据转换为JSON格式
    }
  }
};
</script>

<style>

</style>
```

## 技术栈

### 前端

- HTML
- CSS
- JavaScript
- Vue.js
- axios

### 后端

- java
- javaspringBoot
- javaJPA

sql 

```sql

create database expresss;
use express;
show tables ;
show table status ;
#创建快递信息表
create table express_information
(
    express_number              int auto_increment
        primary key,
    express_desc                varchar(255) null,
    express_static              varchar(255) null,
    price                       int          null,
    to_receive_address          varchar(255) null,
    to_receive_detailed_address varchar(255) null,
    to_receive_name             varchar(255) null,
    to_receive_phone            varchar(255) null,
    to_send_address             varchar(255) null,
    to_send_detailed_address    varchar(255) null,
    to_send_name                varchar(255) null,
    to_send_phone               varchar(255) null,
    constraint FK_ID
        foreign key (to_send_phone) references user (phonenumber)
);
#创建用户表
create table user
(
    phonenumber varchar(255) not null
        primary key,
    password    varchar(255) null,
    userid      varchar(255) null,
    username    varchar(255) null
);

#创建驿站管理表
create table postuser
(
    uid         int auto_increment
        primary key,
    password    varchar(255) null,
    phonenumber varchar(255) null,
    postaddress varchar(255) null,
    uname       varchar(255) null
);

#创建超级管理员表
create table root_user
(
    rootid       varchar(255) not null
        primary key,
    postwage     int          null,
    price        int          null,
    rootpassword varchar(255) null
);

#登录与注册
   # 功能实现
        # 登录
        select password
        from user
        where phonenumber="17673450739";
        # 注册
              #用户注册
                INSERT INTO express.user (phonenumber, password, userid, username) VALUES ('13257461153', '147258369', '1001', '唐玮');
              #驿站管理注册
              INSERT INTO express.postuser (uid, password, phonenumber, postaddress, uname) VALUES (10001, '123', '18845614520', '呆鹰岭镇', ' 湖南交通工程学院');

   # 触发器：
   show triggers;
       DROP TRIGGER IF EXISTS registertrigger;    #删除触发器
     create trigger registertrigger before INSERT ON user #功能：当用户密码为null时报错
        FOR EACH ROW
        BEGIN
            if(NEW.password ='' ) then
                signal sqlstate 'HY004' set message_text = '用户密码不能为空';
            end if;
        end
            ;
     # ********************************** 测试区域 begin ******
     #正确数据
    INSERT INTO express.user (phonenumber, password, userid, username) VALUES ('13257461153', '147258369', '1001', '唐玮');
    #错误数据
    INSERT INTO express.user (phonenumber, password, userid, username) VALUES ('13257461153', '', '1001', '唐玮');
     # ********************************** 测试区域 end ******

   # 存储过程：
    # 作用：根据用户手机号码查询密码

    DROP PROCEDURE IF EXISTS searchpassword;    #删除存储过程
     create procedure searchpassword(    # 根据用户手机号码查询密码
     IN phone varchar(200),
     OUT password1 varchar(200)
    )

        begin
           select password INTO password1
            from user
            where phonenumber=phone;
        end;
    #使用存储过程
    set @phone=17673450739;
    select @phone;
    set @password1=null;
    call searchpassword(@phone,@password1);
    select @password1;



#用户
   # 功能实现：
        # 寄件
        INSERT INTO express.express_information (express_number, express_desc, express_static, price, to_receive_address, to_receive_detailed_address, to_receive_name, to_receive_phone, to_send_address, to_send_detailed_address, to_send_name, to_send_phone) VALUES (10035, '', '待揽件', 10, '湖南省,衡阳市,蒸湘区,呆鹰岭镇', '湖南交通工程学院', '胡芷康 616test', '18244801507', '湖南省,衡阳市,蒸湘区,呆鹰岭镇', '15栋624', '姜斌', '17673450739');
        # 根据用户手机号码查询收件列表
        select *
        from express_information
        where to_receive_phone ='17673450739';
        # 根据用户手机号码查询寄件列表
        select *
        from express_information
        where to_send_phone ='17673450739';
        #签收
        update express_information
        set express_static='已签收'
        where express_number='100035';
    # 触发器：
        show triggers;
       DROP TRIGGER IF EXISTS usertrigger;    #删除触发器
     create trigger usertrigger before INSERT ON express_information #功能：当收件人手机号码为null时报错
        FOR EACH ROW
        BEGIN
            if(NEW.to_receive_phone ='' ) then
                signal sqlstate 'HY004' set message_text = '寄件人手机号码不能为空';
            end if;
        end
            ;
     # ********************************** 测试区域 begin ******
        INSERT INTO express.express_information (express_number, express_desc, express_static, price, to_receive_address, to_receive_detailed_address, to_receive_name, to_receive_phone, to_send_address, to_send_detailed_address, to_send_name, to_send_phone) VALUES (10038, '', '待揽件', 10, '湖南省,衡阳市,蒸湘区,呆鹰岭镇', '湖南交通工程学院', '胡芷康 616test', '', '湖南省,衡阳市,蒸湘区,呆鹰岭镇', '15栋624', '姜斌', '17673450739');
     # ********************************** 测试区域 end ******

    # 存储过程：
         # 功能：查看所有已签收的包裹
        DROP PROCEDURE IF EXISTS Completepackage;    #删除存储过程
        create procedure Completepackage()
        begin
            select count(*) as 已签收的包裹数
            from express_information
            where express_static='已签收' and to_send_phone='17673450739';
        end;
        #使用存储过程
        call Completepackage();

# 驿站管理
    #功能实现
        #查看待揽件列表
        select *
        from express_information
        where express_static='待揽件' and to_send_address like '%呆鹰岭镇';
        #查看待派件列表
        select *
        from express_information
        where express_static='待派件' and to_receive_address like '%呆鹰岭镇';
        #揽件
        update express_information
        set express_static='已揽件'
        where express_number='10034';
        #派件
        update express_information
        set express_static='揽件中'
        where express_number='100035';
        #累计揽件包裹
        select count(*)
        from express_information
        where express_static <>'待揽件'and to_send_address like '%呆鹰岭镇';
        #累计派件包裹
        select count(*)
        from express_information
        where express_static = '已签收' and to_receive_address like '%呆鹰岭镇';
    # 触发器：
    show triggers;
    use express;
        DROP TRIGGER IF EXISTS updatestatic;    #删除触发器
        create trigger updatestatic before UPDATE ON express_information
        FOR EACH ROW
        BEGIN
            if(OLD.express_static='待揽件' && NEW.express_static <>'已揽件') then
                signal sqlstate 'HY000' set message_text = '快递当前为待揽件 物流信息只能改为以揽件';
            end if;
            if(OLD.express_static='已揽件' && NEW.express_static <> '运输中') then
                signal sqlstate 'HY001' set message_text = '快递当前为已揽件 物流信息只能改为运输中';
            end if;
            if(OLD.express_static='运输中' && NEW.express_static <> '待派件') then
                signal sqlstate 'HY002' set message_text = '快递当前为运输中 物流信息只能改为待派件';
            end if;
             if(OLD.express_static='待派件' && NEW.express_static <> '派件中') then
                signal sqlstate 'HY003' set message_text = '快递当前为运输中 物流信息只能改为待派件';
            end if;
            if(OLD.express_static='派件中' && NEW.express_static <> '已签收') then
                signal sqlstate 'HY004' set message_text = '快递当前为运输中 物流信息只能改为已签收';
            end if;
        end
            ;
     # ********************************** 测试区域 begin ******
        update express_information
        set express_static='已揽件'
        where express_number='10034';
     # ********************************** 测试区域 end ******
    # 存储过程：
           DROP PROCEDURE IF EXISTS postCompletepackage;    #删除存储过程
        create procedure postCompletepackage()
        begin
            select count(*) as 已揽件的包裹数
            from express_information
            where express_static <>'待揽件' and to_send_address like '%呆鹰岭镇';
        end;
        #使用存储过程
        call postCompletepackage();

# 超级管理员
    # 功能实现：
        # 1.设置快递价格
        update root_user set price =10 where rootid='root';
        # 2.查看所有用户
        select *
        from user;
        # 3.查看所有驿站管理
        select *
        from postuser;
        # 4.查看所有包裹
            select *
            from express_information;
        # 5.删除快递订单
        delete FROM express_information
        where express_number ='10032';
    # 触发器：
     DROP TRIGGER IF EXISTS roottrigger;    #删除触发器
     create trigger roottrigger before UPDATE ON root_user
        FOR EACH ROW
        BEGIN
            if (NEW.price =0)then
                signal sqlstate 'HY004' set message_text = '快递单价不能为0元噢，否则会亏本噢！';
            end if;
        end
            ;
     # ********************************** 测试区域 begin ******
     update root_user set price =0 where rootid='root';
     # ********************************** 测试区域 end ******
    # 存储过程：
        # 功能：统计所有用户寄出的包裹数
        DROP PROCEDURE IF EXISTS allpackage;    #删除存储过程
        create procedure allpackage()
        begin
            select count(*) as 系统中所有的包裹数
            from express_information;
        end;
        #使用存储过程
        call allpackage();

select * from express_information as u where u.to_send_phone = 17673450739;

update express_information set express_static="已揽件" where express_number=10002;

# alter table 表名 add constraint FK_ID foreign key(你的外键字段名) REFERENCES 外表表名(对应的表的主键字段名);//FK_ID是外键的名称
alter table express_information add constraint FK_ID foreign key(to_send_phone) REFERENCES user(phonenumber);

# 删除外键
# 语法： ALTER TABLE table-name DROP FOREIGN KEY key-id;
# 例：   ALTER TABLE `tb_active` DROP FOREIGN KEY `FK_ID`

# 查看表有哪些外键
show create table express_information;

#外连接
select *
from express_information
left join user u on express_information.to_send_phone = u.phonenumber;


# 2 驿站管理已揽件的包裹数
# 3 驿站管理已派件的包裹数
# 4 root查看所有包裹数
# 5 root查看所有用户人数
# 6 root查看所有驿站管理人数

# 触发器：
# 1 新增快递前 验证收件人手机信息是否正确
create trigger
# 2用户注册时验证手机号码是否正确
# 3驿站管理注册时验证手机号码or驿站地址
# 4 驿站管理更新快递信息时验证
```

