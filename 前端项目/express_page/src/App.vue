<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>

import store from "./store";

export default {
  name: 'app',
  store:store,
  components: {
  }
}
</script>

<style scoped>

#app {

  /*background-image:url("");*/
  margin: 0px;
  padding: 0px;
  /*background: linear-gradient(to right,red,blue);*/
  background: url("../public/th.jpeg");
  position: fixed;
  width: 100%;
  height: 100%;

}
</style>
