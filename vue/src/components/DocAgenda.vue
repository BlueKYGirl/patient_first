<template>
    <body>
        <div class="agenda">
            <div v-for="appointment in doctorAppointments" v-bind:key="appointment.appointmentId">
                    <p>{{ appointment.date }} &nbsp;&nbsp;&nbsp;&nbsp; {{ formattedTime(appointment.startTime) }}&nbsp;&nbsp;&nbsp; {{ appointment.scheduleStatus }} &nbsp;&nbsp;&nbsp;{{ appointment.patientName }} &nbsp;&nbsp;&nbsp;{{ appointment.appointmentReason }}</p> 
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
        }
    },

    methods: {
        formattedTime(time) {
            let hours = time.substr(0, 2);
            let amHours = 'PM';
            let minutes = time.substr(3, 2)
                       
                if (hours < 10 && hours > 0) {
                    hours = time.substr(1, 1);
                    amHours = 'AM';
                }
                    
                    
                if (hours >= 10 && hours < 12) {
                    amHours = 'AM';
                }
                   
                    
                if (hours > 12) {
                    hours -= 12;
                }
                if (hours == 0) {
                    hours = '12';
                    amHours = 'AM';
                }

            return hours + ":" + minutes + amHours;
        },
        getAllAppointments(doctorId){
            appointmentService.listDoctorAgenda(doctorId)
            .then(response => {
                this.doctorAppointments = response.data;
                })
                .catch(error => {
             
                })
        }
    },

    created () {
        this.getAllAppointments(this.$store.state.user.doctorId)
    }


}    
</script>

<style>
@import '../css/styles.css';

.agenda {
    display: grid;

}

</style>
