<template>
    <body>
        <div class="agenda">
            <div v-for="appointment in doctorAppointments" v-bind:key="appointment.appointmentId">
                    <p>{{ patient.firstName }} {{ patient.lastName }}: {{ appointment.date }} {{ appointment.time }} {{ appointment.purpose }}</p> 
                </div>
            </div>        
    </body>

</template>

<script>
import appointmentService from '../services/AppointmentService';

export default{
    data(){
        return {
            doctorAppointments: [],
            doctorId: ''
        }
    },

    methods: {
        getAllAppointments(doctorId){
            appointmentService.listAllAppointments(doctorId)
            .then(response => {
                this.offices = response.data;
                })
                .catch(error => {
                this.handleErrorResponse();
                })
        }
    }
}    
</script>

<style>
@import '../css/styles.css';

</style>
