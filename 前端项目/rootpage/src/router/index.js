import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Addexpress from '../views/users/Addexpress.vue'
import Searchstatic from '../views/users/Addexpress.vue'
import Getsearchstatic from '../views/users/Getsearchstatic.vue'
import Putsearchstatic from '../views/users/Putsearchstatic.vue'
import Index from '../components/index.vue'
import About from '../views/About'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '设置价格',
    component: Index,
    children:[
      {

        path: '/settingcharge',
        name:"设置快递价格",
        component:Addexpress
    
      },
    ]
  },{

      path: '/',
      name: "管理员工",
      component:Index,
      children:[
      {
        path: '/getsearchstatic',
        name:"驿站员工管理",
        component:Getsearchstatic
      },{
        path:'/putsearchstatic',
        name:"我寄出的",
        component:Putsearchstatic
      }
    ]
    
  },
  {
    path: '/about',
    name: '数据统计',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component:Index,
      children: [{
        path:'/about',
        name:"关于",
        component: About
      }]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
