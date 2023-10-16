<template>
    <div>
        <div class="search">
            <input type="text" placeholder="검색할 단어를 입력하세요." v-model="read" @keyup.enter="search">
            <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" @click="search">
        </div>
        <div class="form">
            <movie-card v-for="movie in movies" :key="movie.id" :movie="movie"></movie-card>
        </div>
    </div>
</template>
<script>
import MovieCard from "@/components/movie/MovieCard.vue";
import { mapState } from 'vuex';
export default {
    components: {
        MovieCard,
    },
    computed: {
        ...mapState({
            movies: "movieArr",
        }),
    },
    methods: {
        search() {
            if (this.read === "") {
                this.$store.dispatch("readMovie");
            }
            else {
                this.$store.dispatch("searchTitleMovie", this.read);
            }
        },
    },
    data() {
        return {
            read: "",
        };
    },
    watch: {
        movies(val) {
            return val;
        }
    }
}
</script>
<style scoped>
.search {
    position: relative;
    width: 300px;
    color: #808080;
}

input {
    width: 100%;
    border: 1px solid #bbb;
    border-radius: 8px;
    padding: 10px 12px;
    font-size: 14px;
}

img {
    position: absolute;
    width: 17px;
    top: 10px;
    right: 12px;
    margin: 0;
    cursor: pointer;
}

.form {
    display: flex;
    flex-wrap: wrap;
}
</style>