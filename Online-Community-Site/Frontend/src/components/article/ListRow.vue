<template>
    <tr>
        <td>{{ article.id }}</td>
        <td>{{ categoryIcon }}</td>
        <td class="title" @click="goDetail">
            {{ article.title }}
            <span class="commentCount">&nbsp;&nbsp;💬{{ article.commentCnt }}</span>
        </td>
        <td>{{ article.writer }}
            <span class="delete" v-if="isWriter" @click="deleteArticle">🗑️</span>
        </td>
        <td>{{ article.writeDate }}</td>
        <td>{{ article.viewCnt }}</td>
        <td>{{ article.recommendCnt }}</td>
    </tr>
</template>

<script>
import { mapState } from 'vuex';

export default {
    props: {
        articleProps: Object,
    },
    data() {
        return {
            icon: "",
            article: {},
        }
    },
    computed: {
        ...mapState([
            'nickname',
        ]),
        categoryIcon() {
            if (this.article.category === 'chat') {
                return '🍔잡담';
            }
            else if (this.article.category === 'joke') {
                return '👍유머';
            }
            else if (this.article.category === 'info') {
                return '🌐정보';
            }
            else {
                return '📝전체';
            }

        },
        isWriter() {
            if (this.nickname === this.article.writer) {
                return true;
            }
            return false;
        },
    },
    methods: {
        goDetail() {
            this.$store.dispatch('readComment', { category: 'article', articleId: this.article.id });
            this.$store.dispatch('goDetail', { id: this.article.id, 'icon': this.categoryIcon });

        },
        deleteArticle() {
            if (confirm("게시글을 삭제하시겠습니까?") === true) {
                this.$store.dispatch('deleteArticle', { id: this.article.id });
            }
        }

    },
    created() {
        this.article = this.articleProps;
    }

}
</script>

<style scoped>
.title {
    cursor: pointer;
}

td,
th {
    text-align: center;
    padding: 1em .5em;
    vertical-align: middle;
}

td {
    border-bottom: 1px solid rgba(0, 0, 0, .1);
    background: #fff;
}

a {
    color: #73685d;
}

.delete {
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-use-select: none;
    user-select: none;
}

.commentCount {
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-use-select: none;
    user-select: none;
}
</style>