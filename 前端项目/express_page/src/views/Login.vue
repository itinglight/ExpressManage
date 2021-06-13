<template>
  <div class="login">

    <div class="bg_black">

        <div style="text-align: center; margin:25px 150px 10px 150px;color:#787676" > <h1>登录账号</h1></div>
        <el-radio class="radio" v-model="radio1" label="1" border>普通用户</el-radio>
        <el-radio class="radio" v-model="radio1" label="2" border>驿站管理</el-radio>
        <el-radio class="radio" v-model="radio1" label="3" border>超级管理</el-radio>
        <div style=" width: 220px; margin: auto" > <el-input  placeholder="请输入账号" suffix-icon="el-icon-user-solid" v-model="username"></el-input></div>
        <div style=" width: 220px; margin: auto" > <el-input placeholder="请输入密码" show-password v-model="password"></el-input></div>


      <div style="margin:30px auto" >
        <el-button  type="primary" @click="commit()">登录</el-button>
        <router-link class="back_button" to="/"><el-button type="primary">回到首页</el-button></router-link>


      </div>

    </div>



<!--    <div>-->
<!--      <a href="http://localhost:8080/user">User用户登录成功进入的页面</a>-->
<!--      <br>-->
<!--      <a href="http://localhost:8080/Post">Post用户登录成功进入的页面</a>-->
<!--      <br>-->
<!--      <a href="http://localhost:8080/root">root用户登录成功进入的页面</a>-->
<!--    </div>-->






  </div>
</template>
<script>
export default {
  data(){
    return {
      username:'',
      password:'',
      radio1: '1',
    }

  },
  methods: {
    commit(){

      if(this.radio1==1){

        if(this.username=='itinglight' && this.password=="123"){
          this.$message({
            message: '登录成功',
            type: 'success'
          });
          // alert("登录成功");
          this.$router.push('/user')

        }else{
          this.$message({
            message: '请检查账号或密码是否正确',
            type: 'warning'
          });
        }

      }else if(this.radio1==2){

        this.$message({
          message: '登录成功',
          type: 'success'
        });
        this.$router.push('/post')

      }else if(this.radio1==3){

        this.$message({
          message: '登录成功',
          type: 'success'
        });
        this.$router.push('/root')

      }



    }
  }
}

</script>
<style lang="css" scoped>
.bg_black{


  background: rgba(179, 192, 209, 1);
  width: 500px;
  height: 400px;
  margin:120px auto;
  padding: 10px;
  border-radius: 50px;
  /*box-shadow:3px 1px 1px 1px #7b7b7b;*/
}
.radio{
  /*margin-right: 30px;*/
  margin-left: 35px;
  margin-bottom: 20px;
  width: 100px;
}

</style>