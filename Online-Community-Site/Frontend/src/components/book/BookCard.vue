<template>
  <b-card :img-src="book.coverImg" img-alt="Card image" img-left class="mb-3">
    <b-card-text>
      <div class="title">📕{{ book.title }}</div>
      <span class="author">✍{{ book.author }} &nbsp;&nbsp;&nbsp;&nbsp;</span>
      <span class="author">🏢{{ book.publisher }}&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <span class="author">📅{{ book.pubDate }}</span><br>
      <span class="author">📁{{ book.categoryName }}</span><br>
      <span class="author">💵{{ book.price }}원</span><br>
      <span class="author">📃{{ book.description }}</span>
    </b-card-text>
  </b-card>
</template>

<script>
export default {
  props: {
    book: Object,
  },

  methods: {
    big() {
      window.open(this.book.coverImg)
    }
  },
};
</script>

<style scoped>
.form {
  display: flex;
  flex-direction: column;
  height: 30vh;
  width: 100%;
  padding-bottom: 5%;
}

.title {
  font-weight: bold;
  font-size: 15px;
}

.author {
  font-size: 13px;
}

img {
  cursor: pointer;
}
</style>
