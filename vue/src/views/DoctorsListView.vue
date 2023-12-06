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
            doctors: [],


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