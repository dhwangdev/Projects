<template>
  <div class="form">
    <h1 @click="goList">자유게시판</h1>
    <hr>
    <router-view :articles="articles"></router-view>

  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  computed: {
    ...mapState({
      articles: "articleArr",
    })
  },
  methods:{
    goList(){
            this.$store.dispatch("readArticle");
        },
  }
  
};
</script >

<style scoped>

hr {
  border: 0;
  height: 3px;
  background: rgb(9, 8, 8);
}

.form {
  margin-top : 5%;
  margin-bottom : 5%;
  margin-left : 10%;
  margin-right : 10%;
}
h1{
  cursor: pointer;
}
</style>
