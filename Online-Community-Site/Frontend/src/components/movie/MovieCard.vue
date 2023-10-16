<template>
  <b-card-group columns class="form">
    <b-card :img-src="'https://image.tmdb.org/t/p/original/' + movie.posterPath" img-alt="Image" img-top
      class="posterImg" @click="goMovieDetail" img-height="70%">
      <b-card-text class="title">
        {{ movie.title }}
      </b-card-text>
      <b-card-text class="small text-muted">{{ movie.genre }}</b-card-text>
      <b-card-text class="small text-muted">{{
          movie.releaseDate
      }}</b-card-text>
    </b-card>
  </b-card-group>
</template>

<script>
export default {
  props: {
    movie: Object,
  },
  methods: {
    goMovieDetail() {
      this.$store.dispatch('readComment', { category: 'movie', articleId: this.movie.id });
      this.$store.dispatch("movieDetail", this.movie);
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

.posterImg {
  cursor: pointer;
  height: 35rem;
  object-fit: cover;
}

.title {
  font-weight: bold;
}
</style>
