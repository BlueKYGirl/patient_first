<template>
    <body>
        <div class="header-agenda" >
            <label for="doc-date-list">Select a Date to see your Agenda: </label>
            <select class="doc-date-list" name="doc-date-list" id="doc-date-list" v-model="this.filterDate">            
                <option v-for="agendaDate in doctorDatesWithSchedule" v-bind:key="agendaDate"  >
                    {{ agendaDate }}
                </option>
            </select>
            
        </div>
        <div>
            <br><br><br>  

        </div>


        <div class="agenda">
            <div v-for="appointment in filteredList" v-bind:key="appointment.appointmentId">
                    <p> {{ formattedTime(appointment.startTime) }}&nbsp;&nbsp;&nbsp; 
                        {{ appointment.scheduleStatus }} &nbsp;&nbsp;&nbsp;
                        {{ appointment.patientName }} &nbsp;&nbsp;&nbsp;
                        {{ appointment.appointmentReason }} &nbsp;&nbsp;&nbsp;
                        {{ appointment.appointmentStatus }} </p> 
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
            doctorDatesWithSchedule: [],
            filterDate: '',
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
                // create an array of dates for which there is a schedule
                this.doctorDatesWithSchedule = [];
                this.doctorAppointments.forEach((appt) => {
                    if (!this.doctorDatesWithSchedule.includes(appt.date)) {
                        this.doctorDatesWithSchedule.push(appt.date)
                    }
                });
                })
                .catch(error => {
             
                })
        }, 
        alert(value) {
            alert(value);
        },
    },

    computed: {
        filteredList() {
        let filteredAgendas = this.doctorAppointments;

            filteredAgendas = filteredAgendas.filter((date) => date.date===this.filterDate);
   
        return filteredAgendas;
        },
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
