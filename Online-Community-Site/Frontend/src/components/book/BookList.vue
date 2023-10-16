<template>
  <div class="form">
    <book-card v-for="(book, index) in books" :key="index" :book="book"></book-card>
  </div>
</template>
<script>
import BookCard from "@/components/book/BookCard.vue";
// import { mapState } from "vuex";
export default {
  props: {
    books: Array,
  },
  components: {
    BookCard,
  },
  computed: {
    // ...mapState({
    //   books: "bookArr",
    // }),
  },
  methods: {
  },
  watch: {
    books(val) {
      return val;
    },
  },
};
</script>
<style scoped>
.form {
  display: flex;
  flex-direction: column;
  margin-left: 2%;
}
</style>
