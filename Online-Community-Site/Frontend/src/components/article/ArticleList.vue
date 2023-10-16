<template>
    <div>
        <div class="header">
            <div>
                <button v-bind:class="{ clicked: allState }" @click="clickAll">📝전체</button>
                <button v-bind:class="{ clicked: chatState }" @click="clickChat">🍔잡담</button>
                <button v-bind:class="{ clicked: infoState }" @click="clickInfo">🌐정보</button>
                <button v-bind:class="{ clicked: jokeState }" @click="clickJoke">🤣유머</button>
            </div>
            <div>
                <button class="writeBtn" @click="goWriteForm">✍글쓰기</button>
            </div>
        </div>
        <div class="header2">
            <div v-bind:class="{ clicked1: timeState }" @click="clickTime">🕛시간</div>
            <div v-bind:class="{ clicked1: recoState }" @click="clickReco">👍추천</div>
            <div v-bind:class="{ clicked1: viewState }" @click="clickView">👀조회</div>
            <div v-bind:class="{ clicked1: commState }" @click="clickComm">💬댓글</div>
        </div>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>말머리</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>작성일</th>
                    <th>조회</th>
                    <th>추천</th>
                </tr>
            </thead>
            <tbody>
                <list-row v-for="article in articles" :key="article.id" :articleProps="article"></list-row>
            </tbody>
        </table>
        <div class="commentForm">
            <div class="searchTitle">검색</div>
            <b-form-select class='selectForm' v-model="selected" :options="options"></b-form-select>
            <div>
                <input class='searchForm' type="text" placeholder="검색어를 입력하세요." v-model="word"
                    @keyup.enter="searchArticle">
                <b-button class='searchButton' variant="light" @click="searchArticle">🔎</b-button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex';
import ListRow from '@/components/article/ListRow.vue';
export default {
    components: {
        ListRow,
    },
    methods: {
        searchArticle() {
            if (this.word.length > 0) {
                this.timeState = true;
                this.recoState = false;
                this.viewState = false;
                this.commState = false;
                this.$store.dispatch('searchArticle', { category: this.category, searchTarget: this.selected, word: this.word });
            }
        },
        goWriteForm() {
            this.$router.push({ name: 'ArticleForm' })
        },
        clickAll() {
            this.allState = true;
            this.chatState = false;
            this.infoState = false;
            this.jokeState = false;
            this.category = 'all';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickChat() {
            this.allState = false;
            this.chatState = true;
            this.infoState = false;
            this.jokeState = false;
            this.category = 'chat';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickInfo() {
            this.allState = false;
            this.chatState = false;
            this.infoState = true;
            this.jokeState = false;
            this.category = 'info';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickJoke() {
            this.allState = false;
            this.chatState = false;
            this.infoState = false;
            this.jokeState = true;
            this.category = 'joke';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickTime() {
            this.timeState = true;
            this.recoState = false;
            this.viewState = false;
            this.commState = false;
            this.sortTarget = 'date';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickReco() {
            this.timeState = false;
            this.recoState = true;
            this.viewState = false;
            this.commState = false;
            this.sortTarget = 'recommend';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickView() {
            this.timeState = false;
            this.recoState = false;
            this.viewState = true;
            this.commState = false;
            this.sortTarget = 'view';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
        clickComm() {
            this.timeState = false;
            this.recoState = false;
            this.viewState = false;
            this.commState = true;
            this.sortTarget = 'comment';
            this.$store.dispatch('sortArticle', { category: this.category, sortTarget: this.sortTarget });
        },
    },

    computed: {
        ...mapState({
            articles: "articleArr",
        })
    },
    data() {
        return {
            tmpArticles: [],
            allState: true,
            chatState: false,
            infoState: false,
            jokeState: false,
            timeState: true,
            recoState: false,
            viewState: false,
            commState: false,
            category: "all",
            sortTarget: "date",

            selected: 'all',
            options: [
                { value: 'all', text: '전체' },
                { value: 'title', text: '제목' },
                { value: 'writer', text: '작성자' },
                { value: 'content', text: '내용' },
            ],
            word: "",
        }
    },
    watch: {
        articles(val) {
            this.tmpArticles = val;
        }
    }
}
</script>

<style scoped>
.header {
    display: flex;
    justify-content: space-between;
    width: 100%;
}

.header>div {
    width: 100%;
}

.clicked {
    color: white;
    background-color: darkblue;
    text-align: center;
    border-radius: 10px;
    border: 0;
    outline: 0;
}

button {
    border-radius: 10px;
    background-color: whitesmoke;
    color: black;
    border: 0;
    outline: 0;
    width: 10%;
    height: 4vh;
    margin: 0.2%;
}

.writeBtn {
    float: right;
    width: 20%;
}

.header2 {
    display: flex;
    width: 50%;
}

.header2>div {
    text-align: center;
    margin: 5px;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-use-select: none;
    user-select: none;
}

.clicked1 {
    text-align: center;
    margin: 5px;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-use-select: none;
    user-select: none;
    color: red;
    font-weight: bold;
}

body {
    padding: 1.5em;
    background: #f5f5f5
}

table {
    border: 1px #a39485 solid;
    font-size: .9em;
    box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
    width: 100%;
    border-collapse: collapse;
    border-radius: 5px;
    overflow: hidden;
}

th {
    text-align: center;
}

thead {
    font-weight: bold;
    color: #fff;
    background: #73685d;
}

td,
th {
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

.commentForm {
    height: auto;
    width: 30%;
    height: 15vh;
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

.searchForm {
    width: 80%;
    height: 4vh;
    text-align: center;
    background-color: rgb(241, 243, 245);
    border: 0;
    box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px, rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}

.searchButton {
    margin-left: 10px;
    width: 15%;
    height: 4vh;
    border: 0;
    margin-bottom: 4px;
    box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px, rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
}

.selectForm {
    width: 20%;
    margin-left: 20px;
}

.searchTitle {
    text-align: center;
    padding-top: 10px;
}
</style>