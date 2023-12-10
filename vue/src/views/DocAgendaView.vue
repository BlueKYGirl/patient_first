<template>
    <body>
        <div class="header">
            <global-header />
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
        DocAgenda,
        GlobalHeader,
        GlobalFooter
    },
}
</script>

<style>
@import '../css/styles.css';

</style>