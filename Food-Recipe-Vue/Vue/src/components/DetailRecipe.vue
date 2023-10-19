<template>
    <div>
        <div class="content">
            <figure class="figure">
                <img :src="food.ATT_FILE_NO_MAIN" class="figure-img img-fluid rounded">
                <figcaption class="figure-caption">
                    <br>
                    <h2 style="font-weight: bold; color: black;">{{ food.RCP_NM }}</h2>
                </figcaption>
            </figure>
            <div class="nutri">
                <div>열량 : {{ food.INFO_ENG }}</div>
                <div>탄수화물 : {{ food.INFO_CAR }}</div>
                <div>단백질 : {{ food.INFO_PRO }}</div>
                <div>지방 : {{ food.INFO_FAT }}</div>
                <div>나트륨 : {{ food.INFO_NA }}</div>
            </div>
        </div>
        <hr>
        <h3>재료정보</h3>
        <div>{{ food.RCP_PARTS_DTLS }}</div>
        <hr>
        <h3>조리방법</h3>
        <div style="display: flex; justify-content: space-evenly; flex-wrap: wrap;">
            <div v-for="(m, index) in manual" :key="index">
                <div class="card" style="width: 18rem;">
                    <img :src=manualImg[index] class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">{{ manual[index] }}</p>
                    </div>
                </div>
                <!-- <figure class="figure">
                <img :src=manualImg[index] class="figure-img img-fluid rounded" alt="...">
                <figcaption class="figure-caption">{{ manual[index] }}</figcaption>
            </figure> -->
                <!-- <img :src=manualImg[index]>
            <div>{{ manual[index] }}</div> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Detail-Recipe",
    props: {
        recipe: Object,
    },
    data() {
        return {
            food: this.recipe,
            manual: [],
            manualImg: [],
            word: "",
        }
    },
    methods: {
    },
    created: function () {
        if (this.food.MANUAL01 !== "") {
            this.manual.push(this.food.MANUAL01);
            this.manualImg.push(this.food.MANUAL_IMG01);
        }
        if (this.food.MANUAL02 !== "") {
            this.manual.push(this.food.MANUAL02);
            this.manualImg.push(this.food.MANUAL_IMG02);
        }
        if (this.food.MANUAL03 !== "") {
            this.manual.push(this.food.MANUAL03);
            this.manualImg.push(this.food.MANUAL_IMG03);
        }
        if (this.food.MANUAL04 !== "") {
            this.manual.push(this.food.MANUAL04);
            this.manualImg.push(this.food.MANUAL_IMG04);
        }
        if (this.food.MANUAL05 !== "") {
            this.manual.push(this.food.MANUAL05);
            this.manualImg.push(this.food.MANUAL_IMG05);
        }
        if (this.food.MANUAL06 !== "") {
            this.manual.push(this.food.MANUAL06);
            this.manualImg.push(this.food.MANUAL_IMG06);
        }
        if (this.food.MANUAL07 !== "") {
            this.manual.push(this.food.MANUAL07);
            this.manualImg.push(this.food.MANUAL_IMG07);
        }
        if (this.food.MANUAL08 !== "") {
            this.manual.push(this.food.MANUAL08);
            this.manualImg.push(this.food.MANUAL_IMG08);
        }
        if (this.food.MANUAL09 !== "") {
            this.manual.push(this.food.MANUAL09);
            this.manualImg.push(this.food.MANUAL_IMG09);
        }
        if (this.food.MANUAL10 !== "") {
            this.manual.push(this.food.MANUAL10);
            this.manualImg.push(this.food.MANUAL_IMG10);
        }
        if (this.food.MANUAL11 !== "") {
            this.manual.push(this.food.MANUAL11);
            this.manualImg.push(this.food.MANUAL_IMG11);
        }
        if (this.food.MANUAL12 !== "") {
            this.manual.push(this.food.MANUAL12);
            this.manualImg.push(this.food.MANUAL_IMG12);
        }
        if (this.food.MANUAL13 !== "") {
            this.manual.push(this.food.MANUAL13);
            this.manualImg.push(this.food.MANUAL_IMG13);
        }
        if (this.food.MANUAL14 !== "") {
            this.manual.push(this.food.MANUAL14);
            this.manualImg.push(this.food.MANUAL_IMG14);
        }
        if (this.food.MANUAL15 !== "") {
            this.manual.push(this.food.MANUAL15);
            this.manualImg.push(this.food.MANUAL_IMG15);
        }
        if (this.food.MANUAL16 !== "") {
            this.manual.push(this.food.MANUAL16);
            this.manualImg.push(this.food.MANUAL_IMG16);
        }
        if (this.food.MANUAL17 !== "") {
            this.manual.push(this.food.MANUAL17);
            this.manualImg.push(this.food.MANUAL_IMG17);
        }
        if (this.food.MANUAL18 !== "") {
            this.manual.push(this.food.MANUAL18);
            this.manualImg.push(this.food.MANUAL_IMG18);
        }
        if (this.food.MANUAL19 !== "") {
            this.manual.push(this.food.MANUAL19);
            this.manualImg.push(this.food.MANUAL_IMG19);
        }
        if (this.food.MANUAL20 !== "") {
            this.manual.push(this.food.MANUAL20);
            this.manualImg.push(this.food.MANUAL_IMG20);
        }
    }
}
</script>

<style scoped>
#input {
    border: none;
    position: relative;
    outline: 0;
    padding-inline-end: 44px;
    padding-inline-start: 52px;
    box-sizing: border-box;
}

.content {
    display: flex;
    justify-content: space-evenly;

}

.nutri {
    font-size: 25px;
    text-align: center;
    font-weight: bold;
    margin: auto 0;

}
</style>
  