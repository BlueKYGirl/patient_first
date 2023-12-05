<template>
    <div class="imagePreviewWrapper">
      <img v-if="image" v-bind:src="image" />
      <input type="file" v-on:change="loadImage" />
      <button v-on:click="saveImage">Save</button>
    </div>
  </template>
  
  <script>
  import imageService from "../services/ImageService";
  
  export default {
    data() {
      return {
        image: null,
        imageFile: null,
      };
    },
    methods: {
      loadImage(e) {
        this.imageFile = e.target.files[0];
        const reader = new FileReader();
        reader.onload = (evt) => {
          this.image = evt.target.result;
        };
        reader.readAsDataURL(this.imageFile);
      },
      saveImage() {
        this.imageFile.userId = this.$store.state.userId;
        imageService.addImage(this.imageFile)
        .catch((err) => {
          console.error(err);
        });
        this.$router.push({name: 'home'});
      },
    },
  };
  </script>
  
  <style scoped>
  .imagePreviewWrapper {
    display: flex;
    flex-direction: column;
  }
  .imagePreviewWrapper img {
    height: 20em;
    width: 20em;
  }
  .imagePreviewWrapper button {
    width: 20em;
  }
  </style>