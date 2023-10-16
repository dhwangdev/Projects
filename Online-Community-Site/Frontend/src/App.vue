<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view />
  </div>
</template>

<script>

import HeaderNav from "@/components/HeaderNav.vue";
export default {
  components: {
    HeaderNav,
  },
  created() {
    // this.$store.state.nickname = "";
  }

}
</script>

<style>
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50; */
}
</style>
