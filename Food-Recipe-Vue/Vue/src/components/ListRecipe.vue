<template>
    <div class="card" style="width: 18rem; padding: 10px;">
        <img :src="food.ATT_FILE_NO_MAIN" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">{{ food.RCP_NM }}</h5>
            <p class="card-text">{{ food.RCP_PAT2 }}<br>{{ food.RCP_WAY2 }}</p>
            <a @click="moveDetail" class="btn btn-primary">Recipe</a>
        </div>
    </div>
</template>

<script>
export default {
    name: "List-Recipe",
    props: {
        recipe: Object,
    },
    data() {
        return {
            food: this.recipe,
            title: "",
        }
    },
    methods: {
        moveDetail() {
            this.title = this.food.RCP_NM;
            location.href = "/detail" + "?" + this.title;
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
</style>
  