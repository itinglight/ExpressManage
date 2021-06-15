<template>
  <div class="about">
    <!--    <h1>我寄出的</h1>-->
    <!--    <h2>根据手机号码查询数据库快递信息表中的 寄件人手机号码 和当前登录用户手机号码相匹配的订单</h2>-->
    <!--    <a href="http://localhost:8081/express/findall"> 后台快递数据</a>-->
    <el-table
        :data="expressinformation"
        style="width: 100%">
      //快递单号
      <el-table-column
          prop="express_number"
          label="快递单号"
          width="180">
      </el-table-column>
      //寄件人姓名
      <el-table-column
          prop="to_send_name"
          label="寄件人姓名"
          width="100">
      </el-table-column>
      //寄件人电话
      <el-table-column
          prop="to_send_phone"
          label="寄件人电话"
          width="180">
      </el-table-column>
      //寄件人地址
      <el-table-column
          prop="to_send_address"
          label="寄件人地址">
      </el-table-column>
      //寄件人详细地址
      <el-table-column
          prop="to_send_detailed_address"
          label="寄件人详细地址">
      </el-table-column>
      //收件人姓名
      <el-table-column
          prop="to_receive_name"
          label="收件人姓名"
          width="100">
      </el-table-column>
      //收件人电话
      <el-table-column
          prop="to_receive_phone"
          label="收件人电话"
          width="180">
      </el-table-column>
      //收件人地址
      <el-table-column
          prop="to_receive_address"
          label="收件人地址">
      </el-table-column>
      //收件人详细地址
      <el-table-column
          prop="to_receive_detailed_address"
          label="收件人详细地址">
      </el-table-column>
      //备注
      <el-table-column
          prop="express_desc"
          label="快递备注">
      </el-table-column>
      //快递价格
      <el-table-column
          prop="price"
          label="订单价格">
      </el-table-column>
      //物流信息
      <el-table-column
          prop="express_static"
          label="物流信息">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <!--          <el-button-->
          <!--              size="mini"-->
          <!--              @click="handleEdit(scope.$index, scope.row)">确认揽件</el-button>-->
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">开始派件</el-button>
        </template>
      </el-table-column>

    </el-table>
    <el-pagination
        style="text-align:center"
        background
        layout="prev, pager, next"
        page-size="6"
        :total="10">
    </el-pagination>
    <el-button  type="primary" @click='refresh()'>刷新</el-button>
  </div>
</template>

<script>
import store from "../../store";

export default {
  name: "Putsearchstatic",
  store:store,
  data() {
    return {
      expressinformation:[]
    }
  },
  created() {
    const _this=this;
    axios.get("http://localhost:8081/express/findall").then(function (response) {
      console.log(response);
      _this.expressinformation=response.data;
    })
  },
  methods:{
    refresh(){
      const _this=this;
      axios.get("http://localhost:8081/express/findall").then(function (response) {
        console.log(response);
        _this.expressinformation=response.data.data;
      })
          .catch(function (error) {
            console.log(error);
          });
    },
    handleDelete(index, row) {
      console.log(index, row);
      alert("物流信息更新为：派件中")
    }


  }
}
</script>

<style scoped>

</style>