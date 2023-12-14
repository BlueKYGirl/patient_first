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
      
          <my-doctors v-bind:doctors="doctors" v-bind:patientAppointments="patientAppointments"  />
  </div>
  <div class="footer">
  
  </div>
  </body> 
      <global-footer/>
  </template>
  
  <script>
  import MyDoctors from '../components/MyDoctors.vue';
  import GlobalHeader from '../components/GlobalHeader.vue';
  import GlobalFooter from '../components/GlobalFooter.vue';
  import doctorsService from '../services/DoctorsService';
  import appointmentService from '../services/AppointmentService'; 
  
  
  export default {
      components: {
          MyDoctors,
          GlobalHeader,
          GlobalFooter
      },
      data() {
        return {
            doctors: [],
            patientAppointments: [],
        };
      },
      methods: {
        getDoctors() {        
            
            doctorsService.list()
            .then(response => {
                this.doctors = response.data;
                
  
             })
            .catch(error => {
            
            })
        },
        getPatientAppointments(patientId) {
            
            appointmentService.listAppointmentsByPatientId(patientId)
            .then(response => {
                //alert("got response" + response.data);
                this.patientAppointments = response.data;
                this.getDoctors();
  
             })
            .catch(error => {
                alert("Something went wrong");
            })
        }, 
        },
      created() {
        this.getPatientAppointments(this.$store.state.user.personId);

      }
    
    
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