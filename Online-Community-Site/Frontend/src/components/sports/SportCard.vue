<template>
  <b-card-group columns class="form">
    <b-card :img-src="'https://i1.ytimg.com/vi/' + sport.key + '/sddefault.jpg'" img-alt="Image" img-top
      class="posterImg" @click="goSportsDetail" img-height="70%">
      <b-card-text class="title">
        {{ sport.title }}
      </b-card-text>
    </b-card>
  </b-card-group>
</template>

<script>
export default {
  props: {
    sport: Object,
  },
  methods: {
    goSportsDetail() {
      this.$store.dispatch('readComment', { category: 'sport', articleId: this.sport.id });
      this.$store.dispatch("sportsDetail", { id: this.sport.id });
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

.title {
  font-weight: bold;
}

.posterImg {
  cursor: pointer;
  height: 23rem;
  object-fit: cover;
}
</style>
