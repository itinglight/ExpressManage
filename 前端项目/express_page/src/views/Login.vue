<template>
  <div class="login">

    <div class="bg_black">

        <div style="text-align: center; margin:25px 150px 10px 150px;color:#787676" > <h1>登录账号</h1></div>
        <el-radio class="radio" v-model="radio1" label="1" border>普通用户</el-radio>
        <el-radio class="radio" v-model="radio1" label="2" border>驿站管理</el-radio>
        <el-radio class="radio" v-model="radio1" label="3" border>超级管理</el-radio>
        <div style=" width: 220px; margin: auto" > <el-input  placeholder="请输入账号/手机号码" suffix-icon="el-icon-user-solid" v-model="userphone"></el-input></div>
        <div style=" width: 220px; margin: auto" > <el-input placeholder="请输入密码" show-password v-model="password"></el-input></div>


        <div style="margin:30px auto" >
        <el-button  type="primary" @click="commit()">登录</el-button>
        <router-link class="back_button" to="/"><el-button type="primary">回到首页</el-button></router-link>


      </div>

    </div>

  </div>
</template>
<script>
import store from "../store";

export default {
  store:store,
  data(){
    return {
      userphone:'',
      password:'',
      radio1: '1',

    }

  },
  methods: {
    commit(){
      let loginstatic=false;
      let _this=this;
      console.log(_this.$store.state.username)
      console.log(_this.$store.state.userphone)


      console.log(_this.$store.state.userphone)
      console.log(_this.$store.state.username)
      if(this.radio1==1){

        axios.post(this.$store.state.ip+'/user/login', {
            phonenumber:this.userphone,
            password:this.password

        }).then(function (response) {
              // console.log(response);
              // console.log(response.data);


              if(response.data=="success"){


                _this.$store.commit('updates',{
                  username: _this.password,
                  userphone:_this.userphone,
                })
                console.log(_this.$store.state.userphone)

                _this.$message({
                  message: '登录成功',
                  type: 'success'
                });


                // alert("登录成功");
                _this.$router.push('/user')

              }else{

                _this.$message({
                  message: '请检查账号或密码是否正确',
                  type: 'warning'
                });
              }

            }).catch(function (error) {

              console.log(error);
            })

        console.log(loginstatic)


      }else if(this.radio1==2){//驿站管理
    //     if(response.data=="success"){
    //       _this.$message({
    //         message: '登录成功',
    //         type: 'success'
    //       });
    //       // alert("登录成功");
    //       _this.$router.push('/user')
    //
    //     }else{
    //       _this.$message({
    //         message: '请检查账号或密码是否正确',
    //         type: 'warning'
    //       });
    //     }
    //
    //   }).catch(function (error) {
    //   console.log(error);
    // })

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