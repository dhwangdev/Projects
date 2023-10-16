<template>
  <div>
    <div class="search">
      <input
        type="text"
        placeholder="검색할 단어를 입력하세요."
        v-model="read"
        @keyup.enter="search"
      />
      <img
        src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"
        @click="search"
      />
    </div>
    <div class="form">
      <recipe-card
        v-for="recipe in recipes"
        :key="recipe.id"
        :recipe="recipe"
      ></recipe-card>
    </div>
  </div>
</template>
<script>
import RecipeCard from "@/components/recipe/RecipeCard.vue";
import { mapState } from "vuex";
export default {
  components: {
    RecipeCard,
  },
  computed: {
    ...mapState({
      recipes: "recipeArr",
    }),
  },
  methods: {
    search() {
      if (this.read === "") {
        this.$store.dispatch("readRecipe");
      } else {
        this.$store.dispatch("searchMenuRecipe", this.read);
      }
    },
    goRecipeDetail() {
      this.$store.dispatch("recipeDetail");
      this.$router.push({ name: "RecipeDetail" });
    },
  },
  data() {
    return {
      read: "",
    };
  },
  watch: {
    recipes(val) {
      return val;
    },
  },
};
</script>
<style scoped>
.search {
  position: relative;
  width: 300px;
  color: #808080;
}

input {
  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

img {
  position: absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
  cursor: pointer;
}

.form {
  display: flex;
  flex-wrap: wrap;
}
</style>
