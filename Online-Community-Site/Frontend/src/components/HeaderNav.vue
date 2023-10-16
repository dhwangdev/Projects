<template>
  <span>
    <b-navbar toggleable type="dark" variant="dark">
      <b-navbar-brand class="goHomeLink" @click="goHome">SSAFIT HEALING</b-navbar-brand>
      <!-- <div>
        <button v-if="isManager" @click="getApi">api호출</button>
        <button v-if="isManager" @click="sendApiData">api데이터저장</button>
      </div> -->
      <b-navbar-toggle v-if="isManager" target="navbar-toggle-collapse">
        <template #default="{ expanded }">
          <b-icon v-if="expanded" icon="chevron-bar-up"></b-icon>
          <b-icon v-else icon="chevron-bar-down"></b-icon>
        </template>
      </b-navbar-toggle>

      <b-collapse id="navbar-toggle-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item @click="getApi">api호출</b-nav-item>
          <b-nav-item @click="sendApiData">api데이터저장</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </span>
</template>
<script>
import axios from 'axios';
import { mapState } from 'vuex';
export default {
  data() {
    return {
      movieArr: [],
      bookArr: [],
      recipeArr: [],
    }
  },
  computed: {
    ...mapState([
      'nickname'
    ]),
    isManager() {
      if (this.nickname === 'ssafy') {
        return true;
      }
      return false;
    }

  },
  methods: {
    goHome() {
      if (sessionStorage.getItem('access-token') !== null && this.$route.path !== '/category') {
        this.$router.push({ name: 'CategoryView' })
      }
    },
    getApi() {
      this.movieArr = [];
      this.bookArr = [];
      this.recipeArr = [];
      this.getMovie()
      this.getBook()
      this.getRecipe()
    },
    sendApiData() {
      //영화

      let url = "http://localhost:9999/movie/api"
      axios({
        url: url,
        method: "POST",
        data: this.movieArr,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        }
      })
        .then(res => console.log(res))
        .catch(err => console.log(err));

      //책
      url = "http://localhost:9999/book/api"
      axios({
        url: url,
        method: "POST",
        data: this.bookArr,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        }
      })
        .then(res => console.log(res))
        .catch(err => console.log(err));

      //recipe
      url = "http://localhost:9999/recipe/api"
      axios({
        url: url,
        method: "POST",
        data: this.recipeArr,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        }
      })
        .then(res => console.log(res))
        .catch(err => console.log(err));

    },
    getMovie() {
      let genres = new Map();
      let url = "https://api.themoviedb.org/3/genre/movie/list?api_key=1f4449e071a78d41ca07320f6589e903&language=ko"
      fetch(url)
        .then(res => res.json())
        .then(json => {
          for (let i = 0; i < json.genres.length; i++) {
            genres.set(json.genres[i].id, json.genres[i].name)
          }
        });

      for (let i = 1; i <= 5; i++) {
        url = "https://api.themoviedb.org/3/movie/popular?api_key=1f4449e071a78d41ca07320f6589e903&language=ko&page=" + i + "&region=kr";
        fetch(url)
          .then(res => res.json())
          .then(json => {
            for (let j = 0; j < json.results.length; j++) {
              let dataObject = json.results[j];
              let movie = { id: 0, title: "", genre: "", overview: "", recommendCnt: 0, backdropPath: "", posterPath: "", popularity: 0, releaseDate: "", commentCnt: 0, key: "" }
              movie.id = dataObject.id
              movie.title = dataObject.title
              movie.overview = dataObject.overview
              movie.backdropPath = dataObject.backdrop_path
              movie.posterPath = dataObject.poster_path
              movie.popularity = dataObject.popularity
              movie.releaseDate = dataObject.release_date
              for (let a = 0; a < dataObject.genre_ids.length; a++) {
                movie.genre += genres.get(dataObject.genre_ids[a]) + ",";
              }
              movie.genre = movie.genre.slice(0, movie.genre.length - 1);
              this.movieArr.push(movie);
            }
          });
      }
    },
    getBook() {
      //베스트셀러
      for (let i = 1; i <= 10; i++) {
        let url = "/book/ttb/api/ItemList.aspx?ttbkey=ttbhero_pain1230001&QueryType=Bestseller&MaxResults=50&Output=js&Version=20131101&Cover=MidBig&SearchTarget=Book&Start=" + i;
        fetch(url)
          .then(res => res.json())
          .then(json => {
            for (let j = 0; j < json.item.length; j++) {
              let dataObject = json.item[j];
              let book = {
                id: 0, isbn: "", title: "", author: "", pubDate: "", description: "", price: 0, coverImg: "", publisher: "", category: "", categoryName: "",
                reviewRank: 0, bestDuration: "", bestRank: 0, recommendCnt: 0, commentCnt: 0
              };
              book.isbn = dataObject.isbn13;
              book.title = dataObject.title;
              book.author = dataObject.author;
              book.pubDate = dataObject.pubDate;
              book.description = dataObject.description;
              book.price = dataObject.priceStandard;
              book.coverImg = dataObject.cover;
              book.publisher = dataObject.publisher;
              book.category = "Bestseller";
              book.categoryName = dataObject.categoryName;
              book.bestRank = dataObject.bestRank;
              this.bookArr.push(book);
            }
          })
      }
      //신간
      for (let i = 1; i <= 10; i++) {
        let url = "/book/ttb/api/ItemList.aspx?ttbkey=ttbhero_pain1230001&QueryType=ItemNewAll&MaxResults=50&Output=js&Version=20131101&Cover=MidBig&SearchTarget=Book&Start=" + i;
        fetch(url)
          .then(res => res.json())
          .then(json => {
            for (let j = 0; j < json.item.length; j++) {
              let dataObject = json.item[j];
              let book = {
                id: 0, isbn: "", title: "", author: "", pubDate: "", description: "", price: 0, coverImg: "", publisher: "", category: "", categoryName: "",
                reviewRank: 0, bestDuration: "", bestRank: 0, recommendCnt: 0, commentCnt: 0
              };
              book.isbn = dataObject.isbn13;
              book.title = dataObject.title;
              book.author = dataObject.author;
              book.pubDate = dataObject.pubDate;
              book.description = dataObject.description;
              book.price = dataObject.priceStandard;
              book.coverImg = dataObject.cover;
              book.publisher = dataObject.publisher;
              book.category = "New";
              book.categoryName = dataObject.categoryName;
              book.bestRank = 99999;
              this.bookArr.push(book);
            }
          })
      }
    },
    getRecipe() {
      let url = "https://openapi.foodsafetykorea.go.kr/api/73479912b78a422fbdd5/COOKRCP01/json/1/500";
      fetch(url)
        .then(res => res.json())
        .then(json => {
          for (let j = 0; j < json.COOKRCP01.row.length; j++) {
            let dataObject = json.COOKRCP01.row[j];
            let recipe = {
              id: 0, menu: "", energy: "", carbon: "", protein: "", fat: "", natrium: "", smallImg: "", bigImg: "", recommendCnt: 0, parts: "", commentCnt: 0,
              manual01: "", manual02: "", manual03: "", manual04: "", manual05: "", manual06: "", manual07: "", manual08: "", manual09: "", manual10: "",
              manual11: "", manual12: "", manual13: "", manual14: "", manual15: "", manual16: "", manual17: "", manual18: "", manual19: "", manual20: "",
              manualImg01: "", manualImg02: "", manualImg03: "", manualImg04: "", manualImg05: "", manualImg06: "", manualImg07: "", manualImg08: "", manualImg09: "", manualImg10: "",
              manualImg11: "", manualImg12: "", manualImg13: "", manualImg14: "", manualImg15: "", manualImg16: "", manualImg17: "", manualImg18: "", manualImg19: "", manualImg20: ""
            };
            recipe.menu = dataObject.RCP_NM;
            recipe.energy = dataObject.INFO_ENG;
            recipe.carbon = dataObject.INFO_CAR;
            recipe.protein = dataObject.INFO_PRO;
            recipe.fat = dataObject.INFO_FAT;
            recipe.natrium = dataObject.INFO_NA;
            recipe.smallImg = dataObject.ATT_FILE_NO_MAIN;
            recipe.bigImg = dataObject.ATT_FILE_NO_MK;
            recipe.parts = dataObject.RCP_PARTS_DTLS;
            recipe.manual01 = dataObject.MANUAL01;
            recipe.manual02 = dataObject.MANUAL02;
            recipe.manual03 = dataObject.MANUAL03;
            recipe.manual04 = dataObject.MANUAL04;
            recipe.manual05 = dataObject.MANUAL05;
            recipe.manual06 = dataObject.MANUAL06;
            recipe.manual07 = dataObject.MANUAL07;
            recipe.manual08 = dataObject.MANUAL08;
            recipe.manual09 = dataObject.MANUAL09;
            recipe.manual10 = dataObject.MANUAL10;
            recipe.manual11 = dataObject.MANUAL11;
            recipe.manual12 = dataObject.MANUAL12;
            recipe.manual13 = dataObject.MANUAL13;
            recipe.manual14 = dataObject.MANUAL14;
            recipe.manual15 = dataObject.MANUAL15;
            recipe.manual16 = dataObject.MANUAL16;
            recipe.manual17 = dataObject.MANUAL17;
            recipe.manual18 = dataObject.MANUAL18;
            recipe.manual19 = dataObject.MANUAL19;
            recipe.manual20 = dataObject.MANUAL20;
            recipe.manualImg01 = dataObject.MANUAL_IMG01;
            recipe.manualImg02 = dataObject.MANUAL_IMG02;
            recipe.manualImg03 = dataObject.MANUAL_IMG03;
            recipe.manualImg04 = dataObject.MANUAL_IMG04;
            recipe.manualImg05 = dataObject.MANUAL_IMG05;
            recipe.manualImg06 = dataObject.MANUAL_IMG06;
            recipe.manualImg07 = dataObject.MANUAL_IMG07;
            recipe.manualImg08 = dataObject.MANUAL_IMG08;
            recipe.manualImg09 = dataObject.MANUAL_IMG09;
            recipe.manualImg10 = dataObject.MANUAL_IMG10;
            recipe.manualImg11 = dataObject.MANUAL_IMG11;
            recipe.manualImg12 = dataObject.MANUAL_IMG12;
            recipe.manualImg13 = dataObject.MANUAL_IMG13;
            recipe.manualImg14 = dataObject.MANUAL_IMG14;
            recipe.manualImg15 = dataObject.MANUAL_IMG15;
            recipe.manualImg16 = dataObject.MANUAL_IMG16;
            recipe.manualImg17 = dataObject.MANUAL_IMG17;
            recipe.manualImg18 = dataObject.MANUAL_IMG18;
            recipe.manualImg19 = dataObject.MANUAL_IMG19;
            recipe.manualImg20 = dataObject.MANUAL_IMG20;
            this.recipeArr.push(recipe);
          }
        })
    }
  }
}
</script>
<style scoped>
.goHomeLink {
  font-weight: bold;
  font-size: 30px;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-use-select: none;
  user-select: none;
}

b-nav-item {
  cursor: pointer;
}
</style>