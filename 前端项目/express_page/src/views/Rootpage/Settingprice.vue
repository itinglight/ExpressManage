<template>
<div>
  <h1>设置物流价格</h1>
  <div class="demo-input-suffix">
    属性方式：
    <el-input
        style="width: 100px"
        placeholder="请输入价格"
        suffix-icon="el-icon-news"
        v-model="input1">
    </el-input> 元
    <el-button

        type="primary">修改单价</el-button>
    </div>

</div>
</template>

<script>
import store from "../../store";

export default {
  name: "Settingprice",
  store:store,
  data() {
    return {
      input1: '10'
    }
  }
}
</script>

<style scoped>

</style>