<template>
  <div class="home">
    <global-header />
    <img class="printLogo" src="../assets/justText.png" />
    
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
.printLogo {
  margin: 0;
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translate(-50%, -50%);
    
}

</style>
