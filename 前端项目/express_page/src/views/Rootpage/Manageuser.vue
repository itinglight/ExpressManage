<template>
  <div>
    <h1>客户人员管理</h1>
    <el-table
        :data="user"
        v-loading="loading"
        style="width: 100%">
      //快递单号
<!--      <el-table-column-->
<!--          prop="userid"-->
<!--          label="用户ID"-->
<!--          width="180">-->
<!--      </el-table-column>-->
      <el-table-column
          prop="username"
          label="用户姓名"
          width="180">
      </el-table-column>
      //寄件人姓名
      <el-table-column
          prop="phonenumber"
          label="用户手机号码"
          width="100">
      </el-table-column>
      <el-table-column
          prop="password"
          label="用户密码">
      </el-table-column>


      //寄件人地址



    </el-table>

  </div>
</template>

<script>
import store from "../../store";


export default {
  name: "Putsearchstatic",
  store:store,
  data() {
    return {
      user:[]
    }
  },
  created() {
    // const _this=this;
    // axios.post("http://localhost:8081/express/sendphone",{
    //   to_send_phone:_this.$store.state.userphone
    // }).then(function (response) {
    //   console.log(response);
    //   _this.expressinformation=response.data;
    // })
    //     .catch(function (error) {
    //       console.log(error);
    //     });
    const _this=this;
    axios.get("http://localhost:8081/user/findall").then(function (response) {
      console.log(response);
      _this.user=response.data;
    })
        .catch(function (error) {
          console.log(error);
        });
  },
  methods:{
    refresh(){


      console.log(this.$store.state.userphone)
      const _this=this;
      axios.get("http://localhost:8081/user/findall").then(function (response) {
        console.log(response);
        _this.postuser=response.data.data;
      })
          .catch(function (error) {
            console.log(error);
          });
      // setTimeout((_this=this) => _this.loading=false, 1000)
      // setTimeout(1000);
      // console.log(this.loading)
      // setTimeout((_this=this) =>console.log("延迟两秒"),2000)
      // this.loading=true;


    }


  }
}
</script>

<style scoped>

</style>