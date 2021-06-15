<template>
    <div class="bg_black">
      <h1 style="text-align: center">注册账号</h1>
      <el-radio v-model="radio1" label="1" border>普通用户</el-radio>
      <el-radio v-model="radio1" label="2" border>驿站管理</el-radio>

      <el-input v-model="username" placeholder="请输入姓名"></el-input>
      <el-input v-model="userphone" placeholder="请输入手机号码"></el-input>
      <el-input v-if="radio1==2" v-model="address" placeholder="请选择服务地址"></el-input>
      <el-input v-model="password" show-password placeholder="请设置密码"></el-input>
<!--      <el-input v-model="passwords" show-password placeholder="请确认密码"></el-input>-->
      <el-button  type="primary" @click="commit()">注册账号</el-button>
      <router-link  to="/"><el-button type="primary">回到首页</el-button></router-link>
    </div>



</template>
<script>

import store from "../store";

export default {
  store:store,
  data() {
    return {
      address:'',//服务地址
      username:'',//用户名
      radio1: '1',//用户类型
      userphone: '',//手机号码
      password: '',
      passwords: ''
    }
  },
  methods: {
    commit(){

      let _this=this;
      if(this.radio1=1){ //普通用户

        axios.post('http://localhost:8081/user/add', {
          userid:"1001",
          username:this.username,
          phonenumber:this.userphone,
          password:this.password,

        }).then(function (response) {
              console.log(response);
              alert("注册成功");
              _this.$router.push("/login")
            }).catch(function (error) {
              console.log(error);
            });


      }else if(this.radio1=2){

      }



    },
    watch:{

    }
  }
}

</script>


<style scoped>

.bg_black{
  background: rgba(179, 192, 209, 1);
  width: 500px;
  height: 400px;
  margin:120px auto;
  padding: 10px;
  border-radius: 50px;
}


</style>