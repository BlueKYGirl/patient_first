<template>
    <body>
        <div class="header">
            <global-header/>
        </div>


        <div class="footer">
            <global-footer/>
        </div>
    </body>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';

export default {
    components: {
        GlobalHeader,
        GlobalFooter
    }
};
</script>

<style scoped>
@import '../css/styles.css';
</style>