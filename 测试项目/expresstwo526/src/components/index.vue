<template  lang="html">
  <div id="app">
      <el-container style="height: 800px; border: 1px solid #eee">
  <!-- 构建左侧菜单 -->
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu router :default-openeds="['0','1','2']">
      <el-submenu v-for= "(item,index) in $router.options.routes" :index="index+''" v-bind:key="item.id">
        <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
        <el-menu-item v-for="item_ in item.children"  :index="item_.path" v-bind="item_" :class="$route.path==item_.path?'is-active':''">{{item_.name}}</el-menu-item>
      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>菜鸟物流管理系统</span>
    </el-header>
    
    <el-main>
      <!-- 页面刷新的地方 -->
     <router-view></router-view>
    </el-main>
  </el-container>
</el-container>
  
  </div>
</template>

<style >
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

<script>

</script>