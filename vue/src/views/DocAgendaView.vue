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

    data(){

    },

    props: {

    },

    methods: {

    }

}
</script>

<style scoped>
@import '../css/styles.css';

</style>