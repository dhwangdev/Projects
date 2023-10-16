<template>
  <div>
    <div class="form">
      <div>
        <img class="bigImg" :src="recipe.bigImg">
      </div>
      <div class="v-line">
        <p class="detail-subtitle">당신의 힐링을 위한 요리 레시피:</p>
        <h1 class="h1 detail-title">{{ recipe.menu }}</h1>
        <div class="storyline">
          <div class="nutri">
            <br>
            <div>열량 : {{ recipe.energy }}kcal</div>
            <div>탄수화물 : {{ recipe.carbon }}g</div>
            <div>단백질 : {{ recipe.protein }}g</div>
            <div>지방 : {{ recipe.fat }}g</div>
            <div>나트륨 : {{ recipe.natrium }}mg</div>
          </div>
          <br>
          <h3>재료정보</h3>
          <div>{{ recipe.parts }}</div>
        </div>
      </div>
    </div>

    <div class="manual">
      <hr />
      <h3>조리방법</h3>
      <div>
        <img :src="recipe.manualImg01" />
        <p>{{ recipe.manual01 }}</p>
      </div>
      <div>
        <img :src="recipe.manualImg02" />
        <p>{{ recipe.manual02 }}</p>
      </div>
      <div>
        <img :src="recipe.manualImg03" />
        <p>{{ recipe.manual03 }}</p>
      </div>
      <div>
        <img :src="recipe.manualImg04" />
        <p>{{ recipe.manual04 }}</p>
      </div>
      <div>
        <img :src="recipe.manualImg05" />
        <p>{{ recipe.manual05 }}</p>
      </div>
      <div>
        <img :src="recipe.manualImg06" />
        <p>{{ recipe.manual06 }}</p>
      </div>
      <div>
        <img :src="recipe.manualImg07" />
        <p>{{ recipe.manual07 }}</p>
      </div>

    </div>

    <br />
    <hr class="commentLine" />
    <div>
      <comment-list v-for="comment in comments" :key="comment.id" :commentProps="comment"></comment-list>
    </div>
    <div class="commentForm">
      <div>댓글 쓰기</div>
      <input type="text" placeholder="댓글을 작성하세요.." v-model="content" @keyup.enter="registComment" />
      <b-button variant="light" @click="registComment">등록</b-button>
      <!-- <button @click="registComment">등록</button> -->
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import CommentList from "../comment/CommentList.vue";
export default {
  components: {
    CommentList,
  },
  computed: {
    ...mapState({
      recipe: "recipe",
      comments: "commentArr",
      nickname: "nickname",
    }),
  },
  data() {
    return {
      content: "",
      manual: [],
      manualImg: [],
    };
  },
  methods: {
    registComment() {
      if (this.content.length > 0) {
        let comment = {
          id: 0,
          writer: "",
          content: "",
          articleId: 0,
          category: "",
          recommendCnt: 0,
          writeDate: "",
          isDelete: 0,
        };
        comment.writer = this.nickname;
        comment.content = this.content;
        comment.articleId = this.recipe.id;
        comment.category = "recipe";

        let today = new Date();
        let year = today.getFullYear();
        let month = ("0" + (today.getMonth() + 1)).slice(-2);
        let day = ("0" + today.getDate()).slice(-2);
        let hours = ("0" + today.getHours()).slice(-2);
        let minutes = ("0" + today.getMinutes()).slice(-2);
        let seconds = ("0" + today.getSeconds()).slice(-2);
        comment.writeDate =
          year +
          "-" +
          month +
          "-" +
          day +
          " " +
          hours +
          ":" +
          minutes +
          ":" +
          seconds;
        this.$store.dispatch("registComment", { comment: comment });
        this.$store.dispatch("readComment", {
          category: "recipe",
          articleId: this.recipe.id,
        });
        this.recipe.commentCnt++;
        this.content = "";
      }
    },
  },
};
</script>

<style scoped>
.manual>div {

  padding: 10px;
}

.form {
  display: flex;

}

.bigImg {
  margin: 0.5%;
  margin-top: 2%;
}

.v-line {
  height: 50vh;
  margin: 0.5%;
  margin-left: 1%;
}

.commentForm {
  height: auto;
  width: 100%;
  height: 13vh;
  background-color: rgb(250, 250, 250);
  border: 0;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 20px 25px -5px,
    rgba(0, 0, 0, 0.04) 0px 10px 10px -5px;
}

.commentForm>div {
  text-align: left;
  margin-left: 20px;
  margin-top: 10px;
  font-weight: bold;
}

.commentForm>input {
  margin-top: 15px;
  margin-left: 15px;
  width: 90%;
  height: 7vh;
  text-align: center;
  background-color: rgb(241, 243, 245);
  border: 0;
  box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px,
    rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}

.commentForm>button {
  margin-left: 10px;
  width: 7%;
  height: 7vh;
  border: 0;
  margin-bottom: 4px;
  box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px,
    rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}

.commCnt {
  color: red;
  cursor: default;
}

.commentLine {
  margin-top: 1%;
  margin-bottom: 1%;
  border: 0;
  height: 2px;
  background: rgb(4, 8, 125);
}
</style>
