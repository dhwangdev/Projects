<template>
  <b-card-group columns class="form">
    <b-card :img-src="recipe.smallImg" img-alt="Image" img-top class="posterImg" @click="goRecipeDetail"
      img-height="80%">
      <b-card-text class="text">
        {{ recipe.menu }}
      </b-card-text>
    </b-card>

  </b-card-group>
</template>

<script>
export default {
  props: {
    recipe: Object,
  },
  methods: {
    goRecipeDetail() {
      this.$store.dispatch("readComment", {
        category: "recipe",
        articleId: this.recipe.id,
      });
      this.$store.dispatch("recipeDetail", this.recipe);
    },
  },
};
</script>

<style scoped>
.form {
  display: flex;
  flex-direction: column;
  width: 20%;
  padding: 0.2%;
}

.text {
  font-weight: bold;
}

.posterImg {
  cursor: pointer;
  height: 20rem;
  object-fit: cover;
}
</style>
