<template>
    <header style="display:flex; flex-direction: column; justify-content: left; align-items: center;">
        <figure class="figure">
            <img @click="home" src="../assets/logo.png" class="figure-img img-fluid rounded"
                style="width:100%; cursor: pointer;">
            <figcaption class="figure-caption">
                <br>
                <h2>천계의 레시피</h2> 천개의 레시피로 천계의 맛을 느끼세요!
            </figcaption>
        </figure>

        <div class="input-group mb-3" style="width:80%; height:8vh; vertical-align: middle;">
            <input v-model="word" @keyup.enter="search" type="text" class="form-control"
                aria-label="Recipient's username" aria-describedby="button-addon2">
            <button @click="search" class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
        </div>
        <hr>

    </header>
</template>
<script>
export default {
    data() {
        return {
            word: "",
        }
    },
    methods: {
        search() {
            location.href = "/search" + "?" + this.word
        },
        home() {
            location.href = "/";
        }
    },
    created: function () {
        if (!localStorage.getItem("recipeDB")) {
            fetch('https://openapi.foodsafetykorea.go.kr/api/73479912b78a422fbdd5/COOKRCP01/json/1/1000')
                .then(res => res.json())
                .then(data => {
                    {
                        localStorage.setItem("recipeDB", JSON.stringify(data));
                    }
                });
        }
    },
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

h2 {
    color: black;
    font-weight: bold;

}
</style>
  