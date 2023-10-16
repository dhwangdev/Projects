<template>
  <div>
    <div class="form">
      <iframe :src="'https://www.youtube.com/embed/' + sport.key" title="YouTube video player" frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen></iframe>

      <div class="content">
        <div class="title">
          <b-badge pill variant="dark"> {{ sport.category }} </b-badge>
          {{ sport.title }}
        </div>
        <span>조회수 : {{ sport.viewCnt }} | </span>
        <span>👍 {{ sport.recommendCnt }}</span>
      </div>
    </div>
    <hr class="commentLine">
    <div>
      <comment-list v-for="comment in comments" :key="comment.id" :commentProps="comment"></comment-list>
    </div>
    <div class="commentForm">
      <div>댓글 쓰기</div>
      <input type="text" placeholder="댓글을 작성하세요.." v-model="content" @keyup.enter="registComment">
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
      sport: "sport",
      comments: 'commentArr',
      nickname: 'nickname',
    }),
  },
  data() {
    return {
      content: "",
    }
  },
  methods: {
    registComment() {
      if (this.content.length > 0) {
        let comment = {
          id: 0, writer: "", content: "", articleId: 0, category: "",
          recommendCnt: 0, writeDate: "", isDelete: 0
        };
        comment.writer = this.nickname;
        comment.content = this.content;
        comment.articleId = this.sport.id;
        comment.category = "sport";

        let today = new Date();
        let year = today.getFullYear();
        let month = ('0' + (today.getMonth() + 1)).slice(-2);
        let day = ('0' + today.getDate()).slice(-2);
        let hours = ('0' + today.getHours()).slice(-2);
        let minutes = ('0' + today.getMinutes()).slice(-2);
        let seconds = ('0' + today.getSeconds()).slice(-2);
        comment.writeDate = year + '-' + month + '-' + day + " " + hours + ':' + minutes + ':' + seconds;
        this.$store.dispatch('registComment', { comment: comment });
        this.$store.dispatch('readComment', { category: 'sport', articleId: this.sport.id });
        this.content = "";
      }
    }
  },
};
</script>

<style scoped>
.commentLine {
  margin-top: 1%;
  margin-bottom: 1%;
  border: 0;
  height: 2px;
  background: rgb(4, 8, 125);
}

.commentForm {
  height: auto;
  width: 100%;
  height: 13vh;
  background-color: rgb(250, 250, 250);
  border: 0;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 20px 25px -5px, rgba(0, 0, 0, 0.04) 0px 10px 10px -5px;
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
  box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px, rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}

.commentForm>button {
  margin-left: 10px;
  width: 7%;
  height: 7vh;
  border: 0;
  margin-bottom: 4px;
  box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px, rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}

.form {
  display: flex;
  flex-direction: column;
  align-items: center;

}

iframe {
  width: 60%;
  height: 60vh;
  margin: 0.5%;
}



.content {
  margin: 0.5%;
}

.title {
  font-weight: bold;
  font-size: 20px;
}
</style>
