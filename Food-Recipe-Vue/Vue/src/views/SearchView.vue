<template>
  <div id="search">
    <header style="display:flex; flex-direction: column; justify-content: left; align-items: center;">
      <figure class="figure">
        <img @click="home" src="../assets/logo.png" class="figure-img img-fluid rounded"
          style="width:40%; cursor: pointer;">
        <figcaption class="figure-caption">
          <h4>천계의 레시피</h4> 천개의 레시피로 천계의 맛을 느끼세요!
        </figcaption>
      </figure>

      <div class="input-group mb-3" style="width:60%; height:8vh; vertical-align: middle;">
        <input v-model="word" @keyup.enter="search" type="text" class="form-control" aria-label="Recipient's username"
          aria-describedby="button-addon2">
        <button @click="search" class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
      </div>
      <hr>

    </header>

    <body>
      <div class="topContainer">
        <div v-for="(r, index) in recipeArr" :key="index">
          <list-view :recipe=r></list-view>
        </div>
      </div>

    </body>
  </div>
</template>
  
<script>
import ListRecipe from "@/components/ListRecipe.vue";
export default {
  name: "search-recipe",
  components: {
    "list-view": ListRecipe,
  },
  data() {
    return {
      recipeArr: [],
      recipe: {},
      word: "",

    }
  },
  methods: {
    search() {
      location.href = "/search" + "?" + this.word
    },
    home() {
      location.href = "/";
    }
  },
  created: function () {
    //eslint-disable-next-line no-unused-vars
    const url = decodeURI(window.location.href.split("?")[1]);
    let totalArr = JSON.parse(localStorage.getItem("recipeDB")).COOKRCP01.row;
    for (let r of totalArr) {

      if (r.RCP_NM.indexOf(url) !== -1) {
        this.recipeArr.push(r);
      }
    }
  },
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.topContainer {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  padding: 5px;
}

h4 {
  color: black;
  font-weight: bold;

}
</style>
  



