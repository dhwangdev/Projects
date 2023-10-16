<template>
  <div class="form">
    <h1 @click="goRecipe">맛있는 레시피!</h1>
    <hr />
    <router-view></router-view>
  </div>
</template>

<script scoped>
export default {
  methods: {
    goRecipe() {
      this.$store.dispatch("readRecipe");
    },
  },
};
</script>

<style scoped>
.form {
  margin-top: 5%;
  margin-bottom: 5%;
  margin-left: 5%;
  margin-right: 5%;
}

::-webkit-scrollbar {
  width: 10px;
  height: 5px;
}

::-webkit-scrollbar-track {
  box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.2);
}

::-webkit-scrollbar-thumb {
  background: #089da1;
  border-radius: 10px;
}

h1 {
  cursor: pointer;
}

hr {
  border: 0;
  height: 3px;
  background: rgb(9, 8, 8);
}
</style>
