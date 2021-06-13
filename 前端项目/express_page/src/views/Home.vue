<template>
  <div class="home">
    <div id="cards">
      <h1  style="text-align: center" >菜鸟物流管理系统</h1>
      <div class="buttons"  style="text-align: center"> <router-link id="login" to="/register"><el-button type="primary">注册</el-button></router-link></div>
      <div class="buttons"  style="text-align: center"><router-link to="/login"><el-button type="primary">登录</el-button></router-link> </div>
    </div>


  </div>
</template>


<style scoped>
.home{
  font-size: 39px;
  color: #3d3d3d;
}
h1:hover{
  color: #343434;
}
.buttons{

}

</style>