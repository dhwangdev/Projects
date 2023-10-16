<template>
  <div class="form">
    <h1>하루에 책 한권 어떠신가요?</h1>
    <hr />
    <div>
      <b-tabs content-class="mt-3">
        <b-tab title="베스트셀러" active @click="readBestseller">
          <router-view :books="books"></router-view>
        </b-tab>
        <b-tab title="신간" @click="readNew">
          <router-view :books="books"></router-view>
        </b-tab>
        <b-tab title="검색" @click="goSearch">
          <p class="search">
            <input type="text" placeholder="검색할 단어를 입력하세요." v-model="searchContent" @keyup.enter="search">
            <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" @click="search">
          </p>
          <div class="bookView">
            <router-view :books="searchBooks"></router-view>
          </div>
        </b-tab>
      </b-tabs>
    </div>
  </div>
</template>

<script scoped>
import { mapState } from 'vuex';
export default {
  computed: {
    ...mapState({
      books: "bookArr",
      searchBooks: "searchBookArr"
    })
  },
  methods: {
    readBestseller() {
      this.$store.dispatch("readBestbook");
    },
    readNew() {
      this.$store.dispatch("readNewbook");
    },
    goSearch() {

      this.$store.state.bookArr = [];
    },
    search() {
      if (this.searchContent === "") {
        this.$store.state.searchBookArr = [];
      } else {
        this.$store.dispatch("searchTitleBook", { word: this.searchContent });
        this.searchContent = "";
      }
    },
  },
  data() {
    return {
      searchContent: "",
    }
  },
  watch: {
    searchContent(val) {
      return val;
    }
  }
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
</style>
