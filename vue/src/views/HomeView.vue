<template>
  <body>
  <div class="home">
    <global-header />
    
  </div>
</body>
<div class="footer"> 
  <global-footer/>
</div>
</template>

<script>


//*********************************************************************
//ADDED THE FOOTER ON HERE FOR YOU, IF YOU DON'T NEED IT, JUST DELETE :) -Shianne
//**********************************************************************


import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';

//import FileUpload from '../components/FileUpload.vue';
//import ImageViewer from '../components/ImageViewer.vue';

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
