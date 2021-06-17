<template>
  <div class="home">
    <div id="cards">
      <h1  style="text-align: center" >快递物流管理系统</h1>
      <div class="buttons"  style="text-align: center"> <router-link id="login" to="/register"><el-button type="primary">注册</el-button></router-link></div>
      <div class="buttons"  style="text-align: center"><router-link to="/login"><el-button type="primary">登录</el-button></router-link> </div>
    </div>


  </div>
</template>


<style scoped>
#cards{
  /*width: 1920px;*/
  /*height:1080px;*/
  font-size: 39px;
  /*!*background:url("/public/th.jpeg");*!*/
  /*!*background-image: url("/public/th.jpeg");*!*/
  /*!*background:#F00;*!*/
  margin: 0;
}
.buttons{
  margin: 20px;

}
h1:hover{
  color: #343434;
}
.buttons{

}

</style>