<template>
  <div class="form">
    <h1 @click="goSports">인기 운동영상을 만나보세요!</h1>
    <hr>

    <router-view></router-view>
  </div>
</template>

<script scoped>
export default {
  data() {
    return {
    };
  },
  methods: {

    goSportsDetail() {
      this.$store.dispatch("sportsDetail");
      this.$router.push({ name: "SportsDetail" });
    },
    goSports() {
      this.$store.dispatch("readSports", {
        category: "health",
        target: "recommend",
        direction: "DESC",
      });
      this.$store.dispatch("readSports", {
        category: "sports",
        target: "recommend",
        direction: "DESC",
      });
      this.$store.dispatch("readSports", {
        category: "esports",
        target: "recommend",
        direction: "DESC",
      });
      this.$store.dispatch("readSports", {
        category: "extreme",
        target: "recommend",
        direction: "DESC",
      });
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
