<template>
    <div class="bg_black">
      <h1 style="text-align: center">注册账号</h1>
      <el-radio v-model="radio1" label="1" border>普通用户</el-radio>
      <el-radio v-model="radio1" label="2" border>驿站管理</el-radio>

      <el-input v-model="username" placeholder="请输入姓名"></el-input>
      <el-input v-model="userphone" placeholder="请输入手机号码"></el-input>
      <el-input v-if="radio1==2" v-model="input0" placeholder="请选择服务地址"></el-input>
      <el-input v-model="input2" show-password placeholder="请设置密码"></el-input>
      <el-input v-model="input3" show-password placeholder="请确认密码"></el-input>
      <el-button  type="primary" @click="commit()">注册账号</el-button>
      <router-link  to="/"><el-button type="primary">回到首页</el-button></router-link>
    </div>



</template>
<script>

export default {
  data() {
    return {
      input0:'',
      username:'',
      radio1: '1',
      userphone: '',
      input2: '',
      input3: '',
      input4: ''
    }
  },
  methods: {
    commit(){

      if(this.radio1=1){


        alert("注册成功成功");
        this.$router.push("/login")

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