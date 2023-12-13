<template>
    <body>
        <div class="header">
            <global-header />
        </div>
        <div class="doc-agenda">
            <doc-agenda />
        </div>
        


    </body>
    <div class="footer">
        <global-footer />
    </div>
</template>

<script>
import DocAgenda from '../components/DocAgenda.vue';
import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';  

export default{
    components: {
        GlobalHeader,
        GlobalFooter,
        DocAgenda
    },

}
</script>

<style scoped>
@import '../css/styles.css';


th {
    text-transform: uppercase;
    padding: 10px;
    text-align: center;
}
.table-title {
    text-transform: none;
    text-decoration: underline;
    font-size: x-large;
}
td {
    padding: 20px;
}

</style>