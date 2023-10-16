import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router/index.js";
import createPersistedState from "vuex-persistedstate";
Vue.use(Vuex);
const url = "http://localhost:9999";
export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    //user정보
    nickname: "",
    user: {},
    //회원가입
    checkId: false,
    checkNickname: false,
    checkEmail: false,
    //movie
    movieArr: [],
    movie: {},
    //sports
    sportsArr: [],
    esportsArr: [],
    extremeArr: [],
    healthArr: [],
    searchSportsArr: [],
    sport: {},
    //book
    bookArr: [],
    searchBookArr: [],
    book: {},
    //recipe
    recipeArr: [],
    recipe: {},
    //article
    articleArr: [],
    article: {},
    icon: "",
    //comment
    commentArr: [],
  },
  getters: {
    articleChange(state) {
      return state.article;
    },
    commentChange(state) {
      return state.commentArr;
    },
    getEmailCheck(state) {
      return state.checkEmail;
    },
    getIdCheck(state) {
      return state.checkId;
    },
    getNameCheck(state) {
      return state.checkNickname;
    },
  },
  mutations: {
    READ_MOVIE(state, payload) {
      state.movieArr = payload.data;
    },
    READ_SPORTS(state, payload) {
      if (payload.category === "sports") {
        state.sportsArr = payload.data;
      } else if (payload.category === "esports") {
        state.esportsArr = payload.data;
      } else if (payload.category === "health") {
        state.healthArr = payload.data;
      } else {
        state.extremeArr = payload.data;
      }
    },
    READ_RECIPE(state, payload) {
      state.recipeArr = payload.data;
    },
    READ_ARTICLE(state, payload) {
      state.articleArr = payload.data;
    },
    REGIST_ARTICLE(state) {
      state;
    },
    GO_DETAIL(state, payload) {
      state.article = payload.article;
      state.article.viewCnt += 1;
      state.icon = payload.icon;
    },
    MOVIE_DETAIL(state, payload) {
      state.movie = payload.movie;
      state.movie.viewCnt += 1;
    },
    RECIPE_DETAIL(state, payload) {
      state.recipe = payload.recipe;
      state.recipe.viewCnt += 1;
    },
    BOOK_DETAIL(state, payload) {
      state.book = payload.book;
      state.book.viewCnt += 1;
    },
    SPORTS_DETAIL(state, payload) {
      state.sport = payload.sports;
    },
    READ_COMMENT(state, payload) {
      state.commentArr = payload;
    },
    ADD_ARTICLE_RECO(state) {
      state.article.recommendCnt += 1;
    },
    UPDATE_ARTICLE(state) {
      state;
    },
    REGIST_COMMENT(state) {
      state;
    },
    UPDATE_COMMENT(state) {
      state;
    },
    USER_LOGIN(state, payload) {
      state.nickname = payload.nickname;
    },
    USER_LOGOUT(state) {
      state.nickname = "";
      state.user = {};
    },
    OVERLAP_CHECK(state, payload) {
      if (payload.message === "success") {
        if (payload.type === "id") {
          state.checkId = true;
        } else if (payload.type === "nickname") {
          state.checkNickname = true;
        } else {
          state.checkEmail = true;
        }
      } else {
        if (payload.type === "id") {
          state.checkId = false;
          alert("이미 사용중인 ID 입니다.");
        } else if (payload.type === "nickname") {
          state.checkNickname = false;
          alert("이미 사용중인 닉네임 입니다.");
        } else {
          state.checkEmail = false;
          alert("이미 사용중인 이메일 입니다.");
        }
      }
    },
    CHECK_INIT(state) {
      state.checkId = false;
      state.checkNickname = false;
      state.checkEmail = false;
    },
    REGIST_USER(state, payload) {
      if (payload.data === "success") {
        alert("가입되었습니다.");
      }
    },
    READ_USER(state, payload) {
      state.user = payload;
    },
    DELETE_ARTICLE(state, payload) {
      for (let i = 0; i < state.articleArr.length; i++) {
        if (state.articleArr[i].id === payload) {
          state.articleArr.splice(i, 1);
          break;
        }
      }
    },
    SEARCH_SPORTS(state, payload) {
      state.searchSportsArr = payload;
    },
    READ_BOOK(state, payload) {
      state.bookArr = payload;
    },
    SEARCH_BOOK(state, payload) {
      state.searchBookArr = payload;
    }
  },
  actions: {
    readMovie({ commit }) {
      let finalUrl = url + "/movie";
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_MOVIE", res);
          router.push({ name: "MovieList" });
        })
        .catch((err) => console.log(err));
    },

    readSports({ commit }, payload) {
      let finalUrl =
        url +
        "/sport/category/" +
        payload.category +
        "/" +
        payload.target +
        "/" +
        payload.direction;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_SPORTS", { data: res.data, category: payload.category });
          if (payload.category === "extreme") {
            router.push({ name: "SportsList" });
          }
        })
        .catch((err) => console.log(err));
    },

    readBook({ commit }, payload) {
      let finalUrl = url + "/book/category/" + payload.category;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_BOOK", res.data);
          router.push({ name: "BookList" });
        })
        .catch((err) => console.log(err));
    },

    readRecipe({ commit }) {
      let finalUrl = url + "/recipe";
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_RECIPE", res);
          router.push({ name: "RecipeList" });
        })
        .catch((err) => console.log(err));
    },

    readArticle({ commit }) {
      let finalUrl = url + "/article";
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_ARTICLE", res);
          router.push({ name: "ArticleList" });
        })
        .catch((err) => console.log(err));
    },

    registArticle({ commit }, payload) {
      let finalUrl = url + "/article";
      console.log(payload);
      axios({
        url: finalUrl,
        method: "POST",
        data: payload.article,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => console.log(res))
        .then(commit("REGIST_ARTICLE", payload))
        .catch((err) => console.log(err));
    },
    readComment({ commit }, payload) {
      let finalUrl =
        url + "/comment/" + payload.category + "/" + payload.articleId;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => commit("READ_COMMENT", res.data))
        .catch((err) => console.log(err));
    },
    goDetail({ commit }, payload) {
      let finalUrl = url + "/article/" + payload.id;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("GO_DETAIL", { article: res.data, icon: payload.icon });
          router.push({ name: "ArticleDetail" });
        })
        .catch((err) => console.log(err));
    },

    updateArticle({ commit }, payload) {
      let finalUrl = url + "/article";
      axios({
        url: finalUrl,
        method: "PUT",
        data: payload.article,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then(commit("UPDATE_ARTICLE"))
        .catch((err) => console.log(err));
    },
    addArticleRecommend({ commit }) {
      commit("ADD_ARTICLE_RECO");
    },
    registComment({ commit }, payload) {
      let finalUrl = url + "/comment/co";
      axios({
        url: finalUrl,
        method: "POST",
        data: payload.comment,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then(commit("REGIST_COMMENT"))
        .catch((err) => console.log(err));
    },

    updateComment({ commit }, payload) {
      let finalUrl = url + "/comment/co";
      axios({
        url: finalUrl,
        method: "PUT",
        data: payload.comment,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then(commit("UPDATE_COMMENT"))
        .catch((err) => console.log(err));
    },
    userLogin({ commit }, payload) {
      let finalUrl = url + "/user/login";
      axios
        .post(finalUrl, payload.user)
        .then((res) => {
          if (res.data.message === "success") {
            sessionStorage.setItem("access-token", res.data["access-token"]);
            commit("USER_LOGIN", res.data);
            router.push({ name: "CategoryView" });
          } else {
            console.log(res);
          }
        })
        .catch((err) => console.log(err));
    },
    userLogout({ commit }) {
      sessionStorage.removeItem("access-token");
      commit("USER_LOGOUT");
      router.push({ name: "HomeView" });
    },
    overlapCheck({ commit }, payload) {
      let finalUrl = `${url}/user/check/${payload.type}/${payload.val}`;
      axios({
        url: finalUrl,
        method: "GET",
        data: payload.comment,
      })
        .then((res) => {
          commit("OVERLAP_CHECK", { message: res.data, type: payload.type });
        })
        .catch((err) => console.log(err));
    },
    checkInit({ commit }) {
      commit("CHECK_INIT");
    },
    registUser({ commit }, payload) {
      let finalUrl = `${url}/user/regist`;
      axios({
        url: finalUrl,
        method: "POST",
        data: payload.user,
      })
        .then((res) => commit("REGIST_USER", res))
        .catch((err) => console.log(err));
    },
    readUser({ commit }, payload) {
      let finalUrl = `${url}/user/search/${payload.nickname}`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => commit("READ_USER", res.data))
        .catch((err) => console.log(err));
    },
    searchTitleMovie({ commit }, payload) {
      let finalUrl = url + `/movie/search/${payload}`;

      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_MOVIE", res);
        })
        .catch((err) => console.log(err));
    },
    searchMenuRecipe({ commit }, payload) {
      let finalUrl = url + `/recipe/search/${payload}`;

      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_RECIPE", res);
        })
        .catch((err) => console.log(err));
    },
    searchBestBook({ commit }, payload) {
      let finalUrl = url + `/book/search/${payload.target}/${payload}`;

      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_BOOK", res);
        })
        .catch((err) => console.log(err));
    },
    searchTitle({ commit }, payload) {
      let finalUrl = url + `/sport/search/${payload.word}`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("SEARCH_SPORTS", res.data);
        })
        .catch((err) => console.log(err));
    },
    sortArticle({ commit }, payload) {
      let finalUrl = `${url}/article/search/${payload.category}/${payload.sortTarget}`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_ARTICLE", res);
        })
        .catch((err) => console.log(err));
    },
    searchArticle({ commit }, payload) {
      let finalUrl = `${url}/article/search/${payload.category}/${payload.searchTarget}/${payload.word}`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_ARTICLE", res);
        })
        .catch((err) => console.log(err));
    },
    deleteArticle({ commit }, payload) {
      let finalUrl = `${url}/article/${payload.id}`;
      axios({
        url: finalUrl,
        method: "DELETE",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then(commit("DELETE_ARTICLE", payload.id))
        .catch((err) => console.log(err));
    },

    movieDetail({ commit }, payload) {
      let finalUrl = url + "/movie/" + payload.id;
      console.log(payload);
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("MOVIE_DETAIL", { movie: res.data });
          router.push({ name: "MovieDetail" });
        })
        .catch((err) => console.log(err));
    },
    recipeDetail({ commit }, payload) {
      let finalUrl = url + "/recipe/" + payload.id;
      console.log(payload);
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("RECIPE_DETAIL", { recipe: res.data });
          router.push({ name: "RecipeDetail" });
        })
        .catch((err) => console.log(err));
    },
    bookDetail({ commit }, payload) {
      let finalUrl = url + "/book/" + payload.id;
      console.log(payload);
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("BOOK_DETAIL", { book: res.data });
          router.push({ name: "BookDetail" });
        })
        .catch((err) => console.log(err));
    },
    sportsDetail({ commit }, payload) {
      let finalUrl = url + "/sport/" + payload.id;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("SPORTS_DETAIL", { sports: res.data });
          router.push({ name: "SportsDetail" });
        })
        .catch((err) => console.log(err));
    },
    readBestbook({ commit }) {
      let finalUrl = `${url}/book/category/Bestseller`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_BOOK", res.data);
        })
        .catch((err) => console.log(err));
    },
    readNewbook({ commit }) {
      let finalUrl = `${url}/book/category/New`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("READ_BOOK", res.data);
        })
        .catch((err) => console.log(err));
    },
    searchTitleBook({ commit }, payload) {
      let finalUrl = `${url}/book/search/${payload.word}`;
      axios({
        url: finalUrl,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("SEARCH_BOOK", res.data);
        })
        .catch((err) => console.log(err));
    }
  },

  modules: {},
});
