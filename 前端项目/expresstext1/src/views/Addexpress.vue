<template>
  <div>

    <el-row>
      <el-col :span="6"><div class="grid-content bg-purple">
          <span class="ss">寄件人信息：</span>
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
import {get} from '../src/utils/request'
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
          };
          var s=JSON.stringify(person);
          console.log(s);
          axios.get("http://localhost:8081/addexpress",{
        
          }).then(res => console.log(res));
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
ss{
  text-align: center;
}
</style>