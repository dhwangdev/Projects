<template>
    <div>
        <div class="divForm">[{{ icon }}] {{ article.title }}</div>
        <div class="form">
            <div class="divForm">{{ article.writer }} | {{ article.writeDate }}</div>
            <div class="divForm">조회 {{ article.viewCnt }} | 추천 {{ article.recommendCnt }} | 댓글 {{ article.commentCnt }}
            </div>
        </div>
        <hr>
        <div class="content">
            {{ article.content }}
        </div>

        <div class="divForm2">
            <div><span>전체 댓글 </span><span class="commCnt">&nbsp;{{ article.commentCnt }}</span>개</div>
            <div class="text-center">
                <b-button variant="primary" @click="addArticleRecommend">
                    ⭐추천
                    <b-badge variant="danger">{{ article.recommendCnt }}<span class="sr-only"></span></b-badge>
                </b-button>
            </div>
            <b-button variant="light" class="listBtn" @click="goList">목록으로</b-button>
        </div>
        <hr class="commentLine">
        <div>
            <comment-list v-for="comment in comments" :key="comment.id" :commentProps="comment"></comment-list>
        </div>
        <hr class="commentLine">
        <div class="commentForm">
            <div>댓글 쓰기</div>
            <input type="text" placeholder="댓글을 작성하세요.." v-model="content" @keyup.enter="registComment">
            <b-button variant="light" @click="registComment">등록</b-button>
            <!-- <button @click="registComment">등록</button> -->
        </div>
    </div>
</template>

<script>
import CommentList from '@/components/comment/CommentList.vue'
import { mapState, mapGetters } from 'vuex';
export default {
    components: {
        CommentList,
    },
    data() {
        return {
            content: "",

        }
    },
    created() {
        console.log(this.article)
        this.$store.dispatch('updateArticle', { article: this.article });

    },
    computed: {
        ...mapState({
            article: "article",
            icon: "icon",
            comments: "commentArr",
            nickname: "nickname",
        }),
        ...mapGetters([
            'articleChange',
            'commentChange',
        ])
    },
    watch: {
        article(val) {
            return val;
        },
        comments(val) {
            return val;
        }

    },
    methods: {
        goList() {
            this.$store.dispatch("readArticle");
        },
        addArticleRecommend() {
            this.$store.dispatch('addArticleRecommend');
            this.$store.dispatch('updateArticle', { article: this.article });

        },
        registComment() {
            if (this.content.length > 0) {
                let comment = {
                    id: 0, writer: "", content: "", articleId: 0, category: "",
                    recommendCnt: 0, writeDate: "", isDelete: 0
                };
                comment.writer = this.nickname;
                comment.content = this.content;
                comment.articleId = this.article.id;
                comment.category = "article";

                let today = new Date();
                let year = today.getFullYear();
                let month = ('0' + (today.getMonth() + 1)).slice(-2);
                let day = ('0' + today.getDate()).slice(-2);
                let hours = ('0' + today.getHours()).slice(-2);
                let minutes = ('0' + today.getMinutes()).slice(-2);
                let seconds = ('0' + today.getSeconds()).slice(-2);
                comment.writeDate = year + '-' + month + '-' + day + " " + hours + ':' + minutes + ':' + seconds;
                this.$store.dispatch('registComment', { comment: comment });
                this.$store.dispatch('readComment', { category: 'article', articleId: this.article.id });
                this.article.commentCnt++;
                this.$store.dispatch('updateArticle', { article: this.article });
                this.content = "";
            }
        }
    }

}
</script>

<style scoped>
.divForm {
    text-align: left;
    font-weight: bold;
    display: flex;
    flex-direction: column;
    cursor: default;

}

.form {
    margin-top: 5px;
    display: flex;
    justify-content: space-between;
}

.content {
    margin-top: 5%;
    margin-bottom: 5%;
    text-align: left;
    cursor: default;
}

.commCnt {
    color: red;
    cursor: default;
}

.commentLine {
    border: 0;
    height: 2px;
    background: rgb(4, 8, 125);
}

.recommendImg {
    width: 4%;
    cursor: pointer;
}

.divForm {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    font-weight: bold;
}

.divForm2 {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    font-weight: bold;
    width: 100%;
}

.divForm2>div {
    display: flex;
    align-items: center;
    justify-content: center;
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

.listBtn {
    border: 0;
    box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px, rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}
</style>