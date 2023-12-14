<template>

    <div class="doctors" v-for="doctor in filteredDoctorList" v-bind:key="doctor.doctorId">
       <div  class="doctor-names"> 
        <p style="font-size: large;">{{ doctor.firstName }} {{ doctor.lastName }}</p>
        <p style="font-weight: 100; font-size: medium;">{{ doctor.specialty }}</p>
        </div>
        <div class="doctor-list">
            <img class="doctor-headshot" src="../assets/PF-doctor-headshot-MG.jpg" />
            </div>
           <div class="display"> 
         <router-link v-bind:to ="{ name: 'offices', params: { doctorId: doctor.doctorId } }"><button type="submit" class="doctor-links">View Office Details</button></router-link>
         <router-link v-bind:to ="{ name: 'schedule-appointment', params: { doctorId: doctor.doctorId }}"> <button type="submit" class="doctor-links">Book Appointment</button></router-link>
            </div>
        </div>    

  </template>

<script>
import doctorsService from '../services/DoctorsService';
import appointmentService from '../services/AppointmentService'


export default {
    props: {
        doctors: {
            type: Array,
            required: true
        },
        patientAppointments: {
            type: Array,
            required: true
        },
    },

    // data() {
    //       return {
    //           doctors: [],
    //           patientAppointments: [],
    //       };
    // },
    methods: {
        // getDoctors() {        
            
        //     doctorsService.list()
        //     .then(response => {
        //         this.doctors = response.data;
                
  
        //      })
        //     .catch(error => {
            
        //     })
        // },
        // getPatientAppointments(patientId) {
        //     alert("get appointments fired " + patientId)
        //     appointmentService.listAppointmentsByPatientId(patientId)
        //     .then(response => {
        //         //alert("got response" + response.data);
        //         this.patientAppointments = response.data;
        //         this.getDoctors();
  
        //      })
        //     .catch(error => {
        //         alert("Something went wrong");
        //     })
        // },    
    },
    computed: {
        filteredDoctorList() {         
            return this.doctors.filter((doctor1) =>
                this.patientAppointments.some((doctor2) => doctor2.doctorId === doctor1.doctorId));
          },
    },



};


</script>

<style>
@import '../css/styles.css';

.doctor-links{
  display: flex;
  flex-wrap: wrap;
  margin-left: 60%;
  margin-right: auto;
  background-color: #614BC3;
  color: white;
  margin-bottom: 4%;
  padding: 7px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 1px 2px #0000001f, inset 0 0 1px #00000052;
}

button:hover {
    background-color: #85E6C5;
}
.doctor-list {
    display: flex;
    font-weight: bold;
    padding-left: 5%;
    width: 400px;
}
.doctor-headshot{
   display: flex;
   height: 250px;
   border-style: solid;
   border-radius: 10px;
   border-color: black;
   border-width: 2px;
}

.doctor-names{
    display: inline-block;
    align-content: center;
    margin-top: 2%;
    padding-left: 10%;
    padding-bottom: 1%;
   
}

.doctors{
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    width: 600px;
    border-style: solid;
    border-radius: 15px;
    padding-top: 1%;
    border-width: .5px;
    border-radius: 2%;
    box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
    background-color: white;
    margin-left: 10%;
    margin: 5%;
        a {
            text-decoration: none;
            &:hover {
                color: #33BBC5;
            }
        }
}
</style>