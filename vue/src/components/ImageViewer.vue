<template>
    <div v-for="id in imageIds" v-bind:key="id">
        <img v-bind:src =imageUrl+id>
    </div>
</template>

<script>
import imageService from '../services/ImageService';

export default {
  data() {
    return {
      imageUrl: "http://localhost:9000/images/",
      imageIds: []
    };
  },
  methods: {
    getTopics() {
      imageService.getImageIds()
        .then(response => {
          this.imageIds = response.data;
        })
        .catch(error => {
          console.log(error);
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get topic data from server.`);
    }
  },
  created() {
    this.getTopics();
  }
}
</script>