<template>
    <div>
        <div class="form">
            <div class="search">
                <input type="text" placeholder="검색할 단어를 입력하세요." v-model="read" @keyup.enter="search">
                <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" @click="search">
                <hr>
            </div>
            <div v-if="searchLength > 0">
                <div class="title">검색결과</div>
                <div>
                    <health-card v-for="health in searchs" :key="health.id" :health="health"></health-card>
                </div>
                <hr>
            </div>

            <div>
                <div class="title">헬스</div>
                <div>
                    <health-card v-for="health in healths" :key="health.id" :health="health"></health-card>
                </div>
                <hr>
                <div class="title">스포츠</div>
                <div>
                    <sport-card v-for="sport in sports" :key="sport.id" :sport="sport"></sport-card>
                </div>
                <hr>
                <div class="title">이스포츠</div>
                <div>
                    <esport-card v-for="esport in esports" :key="esport.id" :esport="esport"></esport-card>
                </div>
                <hr>
                <div class="title">익스트림 스포츠</div>
                <div>
                    <extreme-card v-for="extreme in extremes" :key="extreme.id" :extreme="extreme"></extreme-card>
                </div>

            </div>

        </div>
    </div>
</template>
<script>
import SportCard from "@/components/sports/SportCard.vue";
import EsportCard from "@/components/sports/EsportCard.vue";
import HealthCard from "@/components/sports/HealthCard.vue";
import ExtremeCard from "@/components/sports/ExtremeCard.vue";
import { mapState } from 'vuex';
export default {
    components: {
        SportCard,
        EsportCard,
        HealthCard,
        ExtremeCard,
    },
    computed: {
        ...mapState({
            sports: "sportsArr",
            esports: "esportsArr",
            extremes: "extremeArr",
            healths: "healthArr",
            searchs: "searchSportsArr",
        }),
        searchLength() {
            return this.searchs.length
        }
    },
    watch: {
        sports(val) {
            return val;
        },
        esports(val) {
            return val;
        },
        extremes(val) {
            return val;
        },
        healths(val) {
            return val;
        },
        // searchs(val) {
        //     return val;
        // }
    },
    methods: {
        search() {
            if (this.read === "") {
                this.$store.state.searchSportsArr = [];
            }
            else {
                this.$store.dispatch("searchTitle", { word: this.read });

            }
        },
    },
    data() {
        return {
            read: "",
        }
    }
}
</script>
<style scoped>
.form>div>div {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}

.title {
    font-weight: bold;
    font-size: 30px;
    justify-content: start;
}

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
</style>