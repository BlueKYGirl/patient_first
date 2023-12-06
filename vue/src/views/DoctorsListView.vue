<template>
    <div>
        <doctors-list v-bind:doctors="doctors" />
        
    </div>
</template>

<script>
import DoctorsList from '../components/DoctorsList.vue';
import doctorsService from '../services/DoctorsService.js';

export default {
    components: {
        DoctorsList,
    },
    data() {
        return {
            doctors: {},
            isLoading: true

        };
    },
    methods: {
        getDoctors() {
      
      doctorsService.list()
        .then(response => {
          this.doctors = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleErrorResponse();
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get doctor data from server.`);
    }
  },
  created() {
    this.getDoctors();
  }
  
  }


</script>

<style scoped>
/*@import '../css/styles.css'; */

</style>