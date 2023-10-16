<template>

    <div>
        <div class="btnForm">
            <button v-bind:class="{ select: isChat }" @click="chat"> 🍔잡담 </button>
            <button v-bind:class="{ select: isInfo }" @click="info"> 🌐정보 </button>
            <button v-bind:class="{ select: isJoke }" @click="joke"> 🤣유머 </button>
        </div>
        <b-container fluid>
            <b-row class=" my-1">
                <b-col sm="10">
                    <b-form-input id="input-large" v-model="title" size="lg" placeholder="제목을 입력하세요..">
                    </b-form-input>
                </b-col>
            </b-row>
        </b-container>
        <div class="textarea">
            <b-form-textarea id="textarea" v-model="content" placeholder="내용을 입력하세요.." rows="20" max-rows="6">
            </b-form-textarea>
        </div>
        <div>
            <b-button id="cancleBtn" variant="danger" @click="cancel">취소</b-button>
            <b-button variant="primary" @click="regist">등록</b-button>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    data() {
        return {
            title: "",
            content: "",
            category: "chat",
            isChat: true,
            isInfo: false,
            isJoke: false,
        }
    },
    methods: {
        regist() {
            let article = { id: 0, title: "", writer: "", content: "", category: "", viewCnt: 0, writeDate: "", recommendCnt: 0, commentCnt: 0, };
            article.writer = this.nickname;
            article.title = this.title;
            article.content = this.content;
            article.category = this.category;

            let today = new Date();
            let year = today.getFullYear();
            let month = ('0' + (today.getMonth() + 1)).slice(-2);
            let day = ('0' + today.getDate()).slice(-2);
            let hours = ('0' + today.getHours()).slice(-2);
            let minutes = ('0' + today.getMinutes()).slice(-2);
            let seconds = ('0' + today.getSeconds()).slice(-2);
            article.writeDate = year + '-' + month + '-' + day + " " + hours + ':' + minutes + ':' + seconds;
            this.$store.dispatch('registArticle', { article: article });
            this.$store.dispatch('readArticle');
        },
        cancel() {
            this.$store.dispatch('readArticle');
        },
        chat() {
            this.isChat = true;
            this.isInfo = false;
            this.isJoke = false;
            this.category = "chat"
        },
        info() {
            this.isChat = false;
            this.isInfo = true;
            this.isJoke = false;
            this.category = "info"
        },
        joke() {
            this.isChat = false;
            this.isInfo = false;
            this.isJoke = true;
            this.category = "joke"
        },
    },
    computed: {
        ...mapState({
            nickname: "nickname",
        })
    }
}
</script>

<style scoped>
.btnForm>.select {
    color: white;
    background-color: darkblue;
    text-align: center;
    border-radius: 10px;
    border: 0;
    outline: 0;
}

.btnForm>button {
    border-radius: 10px;
    background-color: whitesmoke;
    color: black;
    border: 0;
    outline: 0;
    width: 7%;
    height: 4vh;
    margin: 0.2%;
}

.btnForm {
    display: flex;
    padding: 10px;
}

.textarea {
    padding: 10px;
    margin: 0.2%
}

div>button {
    width: 7%;
    float: right;
    margin-left: 10px;
}

#cancleBtn {
    margin-right: 10px;
}
</style>