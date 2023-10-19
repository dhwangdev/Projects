<template>
    <div>
        <detail-view :recipe=recipe></detail-view>
    </div>
</template>

<script>
import DetailRecipe from "@/components/DetailRecipe.vue";
export default {
    name: "detail-recipe",
    components: {
        "detail-view": DetailRecipe,
    },
    data() {
        return {
            recipe: {},
        }
    },
    created: function () {
        //eslint-disable-next-line no-unused-vars
        const url = decodeURI(window.location.href.split("?")[1]);
        let totalArr = JSON.parse(localStorage.getItem("recipeDB")).COOKRCP01.row;
        for (let r of totalArr) {
            if (r.RCP_NM === url) {
                this.recipe = r;
                console.log(r);
                return;
            }
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
</style>
  