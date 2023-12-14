<template>
    <body>
      <div class="header">
          <global-header />
          <h1>Welcome to Patient First</h1>
      <p>We're glad you're here.</p>
      <p class="subheader-two" >
        Your Physicians:
      </p>
      
    </div>
    <div class="doctor-list">
      
          <doctors-list v-bind:doctors="doctors" />
  </div>
  <div class="footer">
  
  </div>
  </body> 
      <global-footer/>
  </template>
  
  <script>
  import DoctorsList from '../components/DoctorsList.vue';
  import doctorsService from '../services/DoctorsService.js';
  import GlobalHeader from '../components/GlobalHeader.vue';
  import GlobalFooter from '../components/GlobalFooter.vue';
  
  
  export default {
      components: {
          DoctorsList,
          GlobalHeader,
          GlobalFooter
      },
      data() {

      },
      
    
    }
  
  
  </script>
  
  <style scoped>
  @import '../css/styles.css';
  .header {
    text-align: center;
  }
  .subheader-two {
    text-align: left;
    margin-top: 5%;
    padding-left: 8%;
    font-weight: bold;
  }
  
  
  
  
  
  </style>