<template>
  <div class="home">
    <global-header />
    <h1>Welcome to Patient First</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import FileUpload from '../components/FileUpload.vue';
import ImageViewer from '../components/ImageViewer.vue';

export default {
  components: {
    GlobalHeader
    
  }
};
</script>
