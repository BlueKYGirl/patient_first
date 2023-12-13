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
            <div >
                <table>
                    <thead>
                        <tr >
                            <th class="table-title" colspan="5">Agenda for: {{ this.filterDate }}</th>
                        </tr>
                        <tr>
                            <th>Time</th>
                            <th>Schedule Status</th>
                            <th>Patient Name</th>
                            <th>Appointment Reason</th>
                            <th>Appointment Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="appointment in filteredList" v-bind:key="appointment.appointmentId">
                            <td>{{ formattedTime(appointment.startTime) }}</td>
                            <td>{{ appointment.scheduleStatus }}</td>
                            <td>{{ appointment.patientName }}</td>
                            <td>{{ appointment.appointmentReason }}</td>
                            <td>{{ appointment.appointmentStatus }}</td>
                        </tr>
                    </tbody>
                </table>
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

th {
    display: flex;
    text-transform: uppercase;
    padding: 10px;
    text-align: center;
    margin-bottom: 3%;
}

td{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 10px;
    text-align: left;
}
tr {
    display: flex;
    flex-direction: row;
    justify-content: center;
}
.table-title {
    text-transform: none;
    font-size: x-large;
}


.header-agenda{
    display: flex;
    flex-direction: row;
    margin-top: 7%;
    margin-left: 10%;
    font-weight: bold;

}

table{
  display: flex;
  flex-direction: column;
  align-content: center;
  padding: 4%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
  margin-left: 10%;
  margin-right: 10%;
  text-align: center;
}
</style>
