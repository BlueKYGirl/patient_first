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
<<<<<<< HEAD
            doctors: {},
            isLoading: true
=======
            doctors: [],

>>>>>>> 1abe896bb5ff4ede16e0cb789dc996f500641159

        };
    },
    methods: {
        getDoctors() {
      
      doctorsService.list()
        .then(response => {
          this.doctors = response.data;

        })
        .catch(error => {
          this.handleErrorResponse();
        })
    },
    handleErrorResponse() {

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