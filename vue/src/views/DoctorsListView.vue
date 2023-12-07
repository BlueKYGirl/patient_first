<template>
  <body>
    <div class="header">
        <global-header />
        <h1>Welcome to Patient First</h1>
    <p>We're glad you're here.</p>
    <p class="subheader" >
      Our Physicians:
    </p>
    
  </div>
  <div class="doctor-list">
    
        <doctors-list v-bind:doctors="doctors" />
</div>
</body> 
    
</template>

<script>
import DoctorsList from '../components/DoctorsList.vue';
import doctorsService from '../services/DoctorsService.js';
import GlobalHeader from '../components/GlobalHeader.vue';


export default {
    components: {
        DoctorsList,
        GlobalHeader
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
@import '../css/styles.css';
.header {
  text-align: center;
}
.subheader {
  text-align: left;
  margin-top: 50px;
  padding-left: 20px;
  font-weight: bold;
}




</style>