<template>
  <el-container style="height: 800px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '2','3']" router="true">
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-message"></i>我要寄件</template>

          <el-menu-item index="/user/addexpress">开始寄件</el-menu-item>


        </el-submenu>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-message"></i>物流查询</template>

          <el-menu-item index="/user/putsearchstatic">我寄出的</el-menu-item>
          <el-menu-item index="/user/getsearchstatic">我收到的</el-menu-item>


        </el-submenu>
        <el-submenu index="3">

          <template slot="title"><i class="el-icon-message"></i>账号信息</template>

          <el-menu-item index="/home">回到首页</el-menu-item>


        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <router-link to="/">首页</router-link>
            </el-dropdown-item>
            <el-dropdown-item>退出账号</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>菜鸟物流信息管理系统</span>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>
<style>
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
import router from "../../router";

export default {
  data() {

    return {

    }
  },

  methods:{

  }
};
</script>