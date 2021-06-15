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

}
</style>
