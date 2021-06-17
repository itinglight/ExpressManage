import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)


const store = new Vuex.Store({
  state: {
    username:'itinglight',
    userphone:'6666',
    postaddress:'呆鹰岭镇',
    // ip:'http://192.168.1.185:8081',
    ip:'http://localhost:8081'
  },
  mutations: {
    updates (state, payload) {
      state.username=payload.username;
      state.userphone=payload.userphone
    }
  },
  actions: {
  },
  modules: {
  }
})
export default store