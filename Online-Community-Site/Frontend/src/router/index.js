import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import CategoryView from "../views/CategoryView.vue";
import ArticleView from "../views/ArticleView.vue";
import MovieView from "../views/MovieView.vue";
import SportsView from "../views/SportsView.vue";
import BookView from "../views/BookView.vue";
import RecipeView from "../views/RecipeView.vue";
import SportsDetail from "@/components/sports/SportsDetail.vue";
import RecipeDetail from "@/components/recipe/RecipeDetail.vue";
import MovieDetail from "@/components/movie/MovieDetail.vue";
import ArticleDetail from "@/components/article/ArticleDetail.vue";
import ArticleList from "@/components/article/ArticleList.vue";
import ArticleForm from "@/components/article/ArticleForm.vue";
import MovieList from "@/components/movie/MovieList.vue";
import SportList from "@/components/sports/SportList.vue";
import RecipeList from "@/components/recipe/RecipeList.vue";
import BookList from "@/components/book/BookList.vue";

import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeView",
    component: HomeView,
  },
  {
    path: "/category",
    name: "CategoryView",
    component: CategoryView,
  },

  {
    path: "/movie",
    name: "MovieView",
    component: MovieView,
    children: [
      {
        path: "detail",
        name: "MovieDetail",
        component: MovieDetail,
      },
      {
        path: "list",
        name: "MovieList",
        component: MovieList,
      },
    ],
  },
  {
    path: "/recipe",
    name: "RecipeView",
    component: RecipeView,
    children: [
      {
        path: "detail",
        component: RecipeDetail,
        name: "RecipeDetail",
      },
      {
        path: "list",
        name: "RecipeList",
        component: RecipeList,
      },
    ],
  },
  {
    path: "/sports",
    name: "SportsView",
    component: SportsView,
    children: [
      {
        path: "detail",
        name: "SportsDetail",
        component: SportsDetail,
      },
      {
        path: "list",
        name: "SportsList",
        component: SportList,
      },
    ],
  },
  {
    path: "/book",
    name: "BookView",
    component: BookView,
    children: [
      {
        path: "list",
        name: "BookList",
        component: BookList,
      },
    ],
  },
  {
    path: "/article",
    name: "ArticleView",
    component: ArticleView,
    children: [
      {
        path: "detail",
        name: "ArticleDetail",
        component: ArticleDetail,
      },
      {
        path: "list",
        name: "ArticleList",
        component: ArticleList,
      },
      {
        path: "Form",
        name: "ArticleForm",
        component: ArticleForm,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
