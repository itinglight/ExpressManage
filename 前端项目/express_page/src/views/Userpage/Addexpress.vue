<template>
  <div class="addexpress">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <div id="to_send_information">
        <el-form-item id="to_send_name" label="寄件人姓名" prop="to_send_name">
          <el-input class="inputs" v-model="ruleForm.to_send_name"></el-input>
        </el-form-item>

        <el-form-item id="to_send_phone" label="寄件人电话" prop="to_send_phone">
          <el-input class="inputs" v-model="ruleForm.to_send_phone"></el-input>
        </el-form-item>
        <!-- 地址-->
        <el-form-item id="to_send_address" label="寄件人地址" prop="to_send_address">
          <el-cascader :options="ruleForm.options"  v-model="ruleForm.to_send_address" :props="{ value: 'name', label: 'name'}" placeholder="寄件地址" clearable @change="handleChange"></el-cascader>
        </el-form-item>

        <el-form-item id="to_send_detailed_address" label="详细地址" prop="to_send_detailed_address">
          <el-input class="inputs" v-model="ruleForm.to_send_detailed_address"></el-input>
        </el-form-item>
      </div>


      <div id="to_receive_information">
        <el-form-item id="to_receive_name" label="收件人姓名" prop="to_receive_name">
          <el-input class="inputs" v-model="ruleForm.to_receive_name"></el-input>
        </el-form-item>

        <el-form-item id="to_receive_phone" label="收件人电话" prop="to_receive_phone">
          <el-input class="inputs" v-model="ruleForm.to_receive_phone"></el-input>
        </el-form-item>
        <!-- 地址-->
        <el-form-item id="to_receive_address" label="收件人地址" prop="to_receive_address">
          <el-cascader :options="ruleForm.options"  v-model="ruleForm.to_receive_address" :props="{ value: 'name', label: 'name'}" placeholder="寄件地址" clearable @change="handleChange"></el-cascader>
        </el-form-item>

        <el-form-item id="to_receive_detailed_address" label="详细地址" prop="to_receive_detailed_address">
          <el-input class="inputs" v-model="ruleForm.to_receive_detailed_address"></el-input>
        </el-form-item>

        <el-form-item label="备注：" prop="desc">
          <el-input type="textarea" v-model="ruleForm.desc"></el-input>
        </el-form-item>


      </div>
      <el-form-item>

      </el-form-item>

      <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>

    </el-form>






  </div>
</template>

<script>
// let pcas= require('../utils/pcas/pcas-code.json')
export default {

  data() {
    return {

      ruleForm: {
        //寄件人信息
        to_send_name: '',
        to_send_phone:'',
        options:[{"code":"43","name":"湖南省","children":[{"code":"4304","name":"衡阳市","children":[{"code":"430408","name":"蒸湘区","children":[{"code":"430408100","name":"呆鹰岭镇"}]}]}]}],
        to_send_address:[],
        to_send_detailed_address:'',
        //收件人信息
        to_receive_name: '',
        to_receive_phone:'',
        // options: pcas,
        to_receive_address:[],
        to_receive_detailed_address:'',
        desc: ''
      },
      rules: {
        to_send_name: [
          { required: true, message: '请输入寄件人姓名', trigger: 'blur' },
          // { min: 6, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        to_send_phone:[
          { required: true, message: '请输入寄件人电话', trigger: 'blur' },
          // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        to_send_address: [
          { required: true, message: '请选择寄件人地址', trigger: 'blur' },

        ],
        to_send_detailed_address:[
          { required: true, message: '请输入寄件人详细地址', trigger: 'blur' },
          // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],

        //收件人信息
        to_receive_name: [
          { required: true, message: '请输入收件人姓名', trigger: 'blur' },
          // { min: 6, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        to_receive_phone:[
          { required: true, message: '请输入收件人电话', trigger: 'blur' },
          // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        to_receive_address: [
          { required: true, message: '请选择收件人地址', trigger: 'blur' },

        ],
        to_receive_detailed_address:[
          { required: true, message: '请输入收件人详细地址', trigger: 'blur' },
          // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],




        desc: [
          { required: false, message: '请填写活动形式', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    handleChange(code) {
      console.log(code);
      console.log();

    },
    submitForm(formName) {
      let express_number=10001;
      const expressinformation = {

        //快递单号
        express_number:express_number,
        //寄件人信息
        to_send_name:this.ruleForm.to_send_name,
        to_send_phone:this.ruleForm.to_send_phone,
        to_send_address:this.ruleForm.to_send_address.toString(),
        to_send_detailed_address:this.ruleForm.to_send_detailed_address,
        //收件人信息
        to_receive_name:this.ruleForm.to_receive_name,
        to_receive_phone:this.ruleForm.to_receive_phone,
        to_receive_address:this.ruleForm.to_receive_address.toString(),
        to_receive_detailed_address:this.to_receive_detailed_address,
        //物流状态
        express_static:"待揽件",
        //价格
        price:10,
        //备注
        desc:this.desc

      }

      var str=JSON.stringify(expressinformation);
      console.log(str);
      console.log(expressinformation);
      // axios.post(' http://localhost:8081/addexpress',this.ruleForm).then(function (response) {
      //       console.log(response);
      //     })
      //     .catch(function (error) {
      //       console.log(error);
      //     });

      axios.post('http://localhost:8081/addexpress', {
        //快递单号
        express_number:express_number,
        //寄件人信息
        to_send_name:this.ruleForm.to_send_name,
        to_send_phone:this.ruleForm.to_send_phone,
        to_send_address:this.ruleForm.to_send_address.toString(),
        to_send_detailed_address:this.ruleForm.to_send_detailed_address,
        //收件人信息
        to_receive_name:this.ruleForm.to_receive_name,
        to_receive_phone:this.ruleForm.to_receive_phone,
        to_receive_address:this.ruleForm.to_receive_address.toString(),
        to_receive_detailed_address:this.ruleForm.to_receive_detailed_address,
        //物流状态
        express_static:"待揽件",
        //价格
        price:10,
        //备注
        express_desc:this.ruleForm.desc
      })
          .then(function (response) {
            console.log(response);
            alert("订单提交成功！")
          })
          .catch(function (error) {
            console.log(error);
            alert("后台出错！！！")
          });


    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>
<style >

#to_send_information{
  /*position: absolute;*/
  width: 559px;
  height: 248px;
  left: 438px;
  top: 97px;

}
#to_receive_information{
  /*position: absolute;*/
  width: 559px;
  height: 248px;
  left: 438px;
  top: 97px;

}


</style>