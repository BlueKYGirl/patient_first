<template>
  <div class="home">
    <global-header />
    <h1>Welcome to Patient First</h1>
    <p>We're glad you're here.</p>
  </div>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';

//import FileUpload from '../components/FileUpload.vue';
//import ImageViewer from '../components/ImageViewer.vue';

export default {
  components: {
    GlobalHeader
    
  }
};
</script>

<style scoped>
@import '../css/styles.css';
</style>
