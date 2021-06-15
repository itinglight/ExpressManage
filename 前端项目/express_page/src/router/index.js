import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/Home";
import Login from "../views/Login"
import Register from "../views/Register";
//用户界面
import Useraisde from "../views/Userpage/userAisdepage.vue"
import Addexpress from "../views/Userpage/Addexpress";
import Putsearchstatic from "../views/Userpage/Putsearchstatic";
import Getsearchstatic from "../views/Userpage/Getsearchstatic";

//驿站管理界面
import PostAisdepage from "../views/Postpage/PostAisdepage";
import Dailanjian from "../views/Postpage/Dailanjian";
import Daipaijian from "../views/Postpage/Daipaijian";
import Datastatistics from "../views/Postpage/Datastatistics";
//root管理界面
import RootAisdepage from "../views/Rootpage/RootAisdepage";
import Settingprice from "../views/Rootpage/Settingprice";
import Managepostpeople from "../views/Rootpage/Managepostpeople";
import Payoff from "../views/Rootpage/Payoff"
import Allexpress from "../views/Rootpage/Allexpress";
import Manageuser from "../views/Rootpage/Manageuser";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/user',
    name: 'User',
    component: Useraisde,
    children:[
      {
        path:"addexpress",
        name:"Useraddexpress",
        component:Addexpress
      },
      {
        path:"putsearchstatic",
        name:"Putsearchstatic",
        component: Putsearchstatic
      },
      {
        path: "getsearchstatic",
        name:"Getsearchstatic",
        component: Getsearchstatic
      }
    ]
  },{
    path: '/post',
    name:'Post',
    component: PostAisdepage,
    children:[
      {
        path:'dailanjian',
        name:'待揽件',
        component: Dailanjian
      },
      {
        path:'daipaijian',
        name:'待派件',
        component: Daipaijian

      },
      {
        path:'datastatistics',
        name:'待派件',
        component: Datastatistics

      }
    ]

  },
  {//root管理界面
    path: '/root',
    name: 'Root',
    component:RootAisdepage,
    children:[
      {
        path:'settingprice',
        name:'设置快递价格',
        component: Settingprice
      },
      {
        path:'manageuser',
        name:'用户人员管理',
        component: Manageuser
      },
      {
        path:'managepost',
        name:'驿站人员管理',
        component: Managepostpeople
      },
      {
        path:'payoff',
        name:'发放工资',
        component: Payoff
      },
      {
        path:'allexpress',
        name:'所有包裹',
        component: Allexpress
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
