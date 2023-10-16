<template>
  <div>


    <body>
      <div class="container">
        <div class="feature-grid-container grid grid--columns">
          <div class="feature-grid-text">
            SSAFIT Healing을 통해<br>
            <span class="text-primary">힐링 세계</span> 로 입장하세요!
            <h2 class="fs-700 uppercase text-compressed">
            </h2>
            <p>Physical and Mental healing through SSAFIT Healing</p>
          </div>
          <div class="grid feature-grid">
            <a href="#" aria-label="movie"><img src="../assets/category/movie.jpg" class="pic" @click="goMovie" /></a>
            <a href="#" aria-label="sports"><img src="../assets/category/sports.jpg" class="pic"
                @click="goSports" /></a>
            <a href="#" aria-label="book"><img src="../assets/category/book.jpg" class="pic" @click="goBook" /></a>
            <a href="#" aria-label="recipe"><img src="../assets/category/recipe.jpg" class="pic"
                @click="goRecipe" /></a>
            <a href="#" aria-label="article"><img src="../assets/category/article.png" class="pic"
                @click="goArticle" /></a>
            <a href="#" aria-label="logout"><img src="../assets/category/logout.png" class="pic" @click="goHome" /></a>
            <a href="#" aria-label="user"><img src="../assets/category/userInfo.png" class="pic"
                @click="[$bvModal.show('bv-modal-example'), getUserInfo()]" /></a>
          </div>
        </div>

        <div>
          <b-modal id="bv-modal-example" hide-footer>
            <template #modal-title>
              <code>회원정보</code>
            </template>
            <div class="d-block text-center">
              <div class="infoForm">
                <div>
                  <div class="title">ID</div>
                  <div class="content">{{ user.userId }}</div>
                </div>

                <div>
                  <div class="title">Password</div>
                  <div class="content">{{ user.password }}</div>
                </div>

                <div>
                  <div class="title">E-mail</div>
                  <div class="content">{{ user.email }}</div>
                </div>

                <div>
                  <div class="title">Nickname</div>
                  <div class="content">{{ user.nickname }}</div>
                </div>
                <div>
                  <div class="title">JoinDate</div>
                  <div class="content">{{ user.joinDate }}</div>
                </div>
              </div>
            </div>
            <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example')">닫기</b-button>
          </b-modal>
        </div>
      </div>
    </body>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  computed: {
    ...mapState([
      'nickname',
      'user',

    ])
  },
  methods: {
    getUserInfo() {
      this.$store.dispatch("readUser", { nickname: this.nickname });
    },
    goMovie() {
      this.$store.dispatch("readMovie");
    },
    goHome() {
      this.$store.dispatch("userLogout");
    },
    goSports() {
      this.$store.dispatch("readSports", {
        category: "health",
        target: "recommend",
        direction: "DESC",
      });
      this.$store.dispatch("readSports", {
        category: "sports",
        target: "recommend",
        direction: "DESC",
      });
      this.$store.dispatch("readSports", {
        category: "esports",
        target: "recommend",
        direction: "DESC",
      });
      this.$store.dispatch("readSports", {
        category: "extreme",
        target: "recommend",
        direction: "DESC",
      });
    },
    goBook() {
      this.$store.dispatch("readBook", { category: "Bestseller" });
    },
    goRecipe() {
      this.$store.dispatch("readRecipe");
    },
    goArticle() {
      this.$store.dispatch("readArticle");
    },
  },
  created() {
    if (sessionStorage.getItem('access-token') === null) {
      this.$router.push({ name: 'HomeView' })
    }

  }
};
</script>

<style scoped>
:root {
  --clr-primary: #fc307b;
  --clr-accent: #2c92ef;

  --fs-700: 3.5rem;
  --fs-400: 1.25rem;
}

*,
*::before,
*::after {
  box-sizing: border-box;
}

body,
h1,
h2,
h3,
h4,
p,
figure,
blockquote,
dl,
dd {
  margin: 0;
}

ul[role="list"],
ol[role="list"] {
  list-style: none;
}

html:focus-within {
  scroll-behavior: smooth;
}

body {
  min-height: 100vh;
  text-rendering: optimizeSpeed;
  line-height: 1.5;
}

a:not([class]) {
  text-decoration-skip-ink: auto;
}

img,
picture {
  max-width: 100%;
  display: block;
}

input,
button,
textarea,
select {
  font: inherit;
}

@media (prefers-reduced-motion: reduce) {
  html:focus-within {
    scroll-behavior: auto;
  }

  *,
  *::before,
  *::after {
    animation-duration: 0.01ms !important;
    animation-iteration-count: 1 !important;
    transition-duration: 0.01ms !important;
    scroll-behavior: auto !important;
  }
}

body {
  background: black;
  font-size: var(--fs-400);
  color: white;
  padding: 20vw 0;
  font-family: sans-serif;
  overflow-x: hidden;
}

.uppercase {
  text-transform: uppercase;
}

.text-primary {
  color: var(--clr-primary);
}

.fs-700 {
  font-size: var(--fs-700);
  line-height: 1;
}

.container {
  padding: 0rem 2rem;
  max-width: 75rem;
  margin: 0 auto;
}

.flex {
  display: flex;
  gap: var(--gap, 1rem);
}

.grid {
  display: grid;
  gap: var(--gap, 1rem);
}

.grid--columns {
  grid-auto-columns: 1fr;
  grid-auto-flow: column;
}

.feature-grid-container {
  perspective: 100rem;
  position: relative;
}

.feature-grid-text {
  padding: 1rem;
  background: linear-gradient(90deg,
      hsl(255 50% 0% / 0.8) 75%,
      hsl(255 50% 50% / 0));
}

.feature-grid {
  position: relative;
  z-index: -1;
  left: min(calc(1000px - 100vw) * -1, 0px);
  width: 55rem;
  align-self: center;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: repeat(6, 1fr);
  transform-origin: left;
  transform: rotateY(-40deg);
}

.feature-grid>a {
  border-radius: 0.75em;
  transition: transform 350ms ease-in-out;
  overflow: hidden;
}

.feature-grid>a:hover,
.feature-grid>a:focus-visible {
  transform: scale(1.1);
  box-shadow: 0 0 1.5rem hsl(0 0% 100% / 0.8);
}

.feature-grid> :nth-child(1),
.feature-grid> :nth-child(2),
.feature-grid> :nth-child(3),
.feature-grid> :nth-child(4),
.feature-grid> :nth-child(5),
.feature-grid> :nth-child(6),
.feature-grid> :nth-child(7) {
  grid-row: span 2;
}

.pic {
  height: 200px;
}

code {
  font-weight: bold;
  font-size: 110%;
}

.infoForm {

  text-align: left;
}

.infoForm>div {

  box-shadow: rgba(0, 0, 0, 0.15) 2.4px 2.4px 3.2px;
}

.title {
  font-weight: bold;
  font-size: 120%;
  padding-left: 5%;
  padding-top: 5%;
}

.content {
  padding-left: 5%;
  padding-bottom: 5%;
}
</style>
