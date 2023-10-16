<template >
    <div>
        <div v-if="isDelete">
            <div class="form">
                <div> 삭제된 댓글입니다...</div>
            </div>
        </div>
        <div v-else>
            <div class="form">
                <div>
                    <div class="writer">{{ comment.writer }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>{{ comment.writeDate }}&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <span class="delete" v-if="isWriter" @click="deleteComment">🗑️</span>
                    </div>
                    <div class="recommend" @click="addCommentRecommend">👍{{ comment.recommendCnt }}</div>
                </div>
            </div>
            <div class="content">{{ comment.content }} </div>
        </div>
        <hr>
        <!-- 대댓글공간 -->
    </div>
</template>
<script>
import { mapState } from 'vuex';
export default {
    props: {
        commentProps: Object,
    },
    data() {
        return {
            comment: {},
        }
    },
    computed: {
        ...mapState({
            nickname: 'nickname',
            article: 'article',

        }),
        isWriter() {
            if (this.nickname === this.comment.writer) {
                return true;
            }
            return false;
        },
        isDelete() {
            if (this.comment.isDelete === 1) {
                return true;
            }
            return false;
        }
    },
    created() {
        this.comment = this.commentProps;
    },
    watch: {
        comment(val) {
            return val;
        }
    },
    methods: {
        addCommentRecommend() {
            this.comment.recommendCnt += 1;
            this.$store.dispatch('updateComment', { comment: this.comment });
        },
        deleteComment() {
            if (confirm("정말 삭제하시겠습니까??") == true) {    //확인
                this.comment.isDelete = 1;
                this.$store.dispatch('updateComment', { comment: this.comment });
                if (this.comment.category === "article") {
                    this.article.commentCnt--;
                    this.$store.dispatch('updateArticle', { article: this.article });
                }
            } else {   //취소
                return false;

            }
        }
    }
}
</script>
<style scoped>
.form {
    width: 100%;
    margin: 1%;
    display: flex;
    justify-content: space-between;
    cursor: default;
}

.form>div {
    width: 100%;
    display: flex;
}

.content {
    margin: 1%;
    text-align: left;
    cursor: default;
}

.writer>span {
    width: 100%;
    color: gray;
    text-align: left;
}

.writer {
    font-weight: bold;
    width: 90%;
    text-align: left;
}

.recommend {
    font-size: 150%;
    font-weight: bold;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-use-select: none;
    user-select: none;
    width: 10%;
    text-align: center;
}

.delete {
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-use-select: none;
    user-select: none;
}
</style>