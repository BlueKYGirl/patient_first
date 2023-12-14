<template>
    <main>
    <h1>Welcome! We're glad you're here.</h1>
    <h3>What time works for you?</h3>

    <div v-for="(group, date) in groupedItems" :key="date">
      <h2>{{ formattedDate(date) }}</h2>
      <ul class="time-button-container">
        <li class="list-item"  v-for="item in group" :key="item.appointmentId" v-on:click="setSelectedId(item.appointmentId)" 
        v-bind:class="{selected: this.selectedAppointmentId===item.appointmentId}">
            <div class="time-button">
                {{ formattedTime(item.startTime) }} 
            </div>
            
            <div class="appt-reason-form"  v-if="item.appointmentId===this.selectedAppointmentId">
                <label for="appt-reason-list">Select a reason for your appointment: <br></label>
                <select class="appt-reason-list" name="appt-reason-list" id="appt-reason-list" v-model="this.selectedApptReason">            
                    <option v-for="reason in appointmentReasons" v-bind:key="reason.appointmentReasonId">
                        {{ reason.appointmentReason }}
                    </option>
                    
                </select>
                <button class="book-it" type="Submit" value="Submit" v-on:click="bookAnAppointment(item.appointmentId)">Book Appointment</button>
            </div>
            
        </li>
      </ul>
    </div>
</main>
</template>

<script>
    import appointmentService from '../services/AppointmentService';
    import doctorAvailabilityService from '../services/DoctorAvailabilityService';

    export default {
    props: {

    },
    data() {
        return {
            timeBlocks: [],
            availableAppts: [],
            schedulingDoctorId: this.$route.params.doctorId,   

    
            appointmentReasons: [],
            selectedAppointment: {},
            selectedAppointmentId: 0,
            selectedApptReasonId: 0,
            selectedApptReason: '',
        };
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

        formattedDate(date) {
            let year = date.substr(0, 4);
            let month = date.substr(5, 2);
            let day = date.substr(8, 2);

            if (month === '01') {
                month = "Jan.";
            }
            if (month === '02') {
                month = "Feb.";
            }
            if (month === '03') {
                month = "March";
            }
            if (month === '04') {
                month = "April";
            }
            if (month === '05') {
                month = "May";
            }
            if (month === '06') {
                month = "June";
            }
            if (month === '07') {
                month = "July";
            }
            if (month === '08') {
                month = "Aug.";
            }
            if (month === '09') {
                month = "Sept.";
            }
            if (month === '10') {
                month = "Oct.";
            }
            if (month === '11') {
                month = "Nov.";
            }
            if (month === '12') {
                month = "Dec.";
            }
            return month + " " + day + "," + " " + year;
        },

        setSelectedId(apptId) {
            this.selectedAppointmentId = apptId;

        },
        bookAnAppointment(apptId) {
            //alert(apptId);
            this.selectedAppointment = {};
            this.availableAppts.forEach((appt) => {
                if (appt.appointmentId === apptId) {
                    //alert("Selected Reason Id = " + this.selectedApptReasonId);
                    // update these from the appt
                    this.selectedAppointment.appointmentId = apptId;
                    this.selectedAppointment.doctorId = appt.doctorId;
                    this.selectedAppointment.date = appt.date;
                    this.selectedAppointment.timeBlockId = appt.timeBlockId;
                    this.selectedAppointment.officeId = appt.officeId;
                    this.selectedAppointment.scheduleStatusId = appt.scheduleStatusId;
                    // update these from other places
                    this.selectedAppointment.patientId = this.$store.state.user.personId;
                    this.selectedAppointment.appointmentStatusId = 2;
                    this.selectedAppointment.appointmentReasonId = 1;
                    this.appointmentReasons.forEach((reason) => {
                        if (reason.appointmentReason === this.selectedApptReason) {
                            this.selectedAppointment.appointmentReasonId = reason.appointmentReasonId;
                        }
                    });
                    //alert(this.selectedAppointment.appointmentReasonId);
                    
                }
            });
            this.updateAppointmentHttp();
            
        },

        updateAppointmentHttp(){
            appointmentService.updateBookedAppointment(this.selectedAppointment.appointmentId, this.selectedAppointment)
                .then(response => {
                    if (response.status == 200) {
                        alert("Appointment successfully booked.")
                        ///  DO SOMETHING?  this.$router.push({ name: 'MessageDetailsView', params: {topicId: this.editMessage.topicId} });
                        this.$router.push( {name: 'home' });
                        }
                    })
                .catch(error => {
                    alert(error)
                });


        },

        getAllTimeBlocks() {
            doctorAvailabilityService.listAllTimeBlocks()
                .then(response => {
                    this.timeBlocks = response.data;
                    this.getAvailableAppointments(this.schedulingDoctorId);
                    })
                .catch(error => {
                
                })
        },
        getAppointmentReasons() {
            appointmentService.listAppointmentReasons()
                .then(response => {
                    this.appointmentReasons = response.data;
                    })
                .catch(error => {
                
                })
        },
        getAvailableAppointments(doctorId) {
            appointmentService.listAvailableAppointments(doctorId)
                .then(response => {
                    this.availableAppts = response.data;

                    this.availableAppts.forEach((appt) => {
                        this.timeBlocks.forEach((timeBlock) => {
                            if (timeBlock.timeBlockId === appt.timeBlockId) {
                                appt.startTime = timeBlock.startTime;
                            }
                        });
                    });
                    })
                .catch(error => {
                
                })
        },
    },
    computed: {
        groupedItems() {
        const grouped = {};
        this.availableAppts.forEach(appt => {
        const date = appt.date;
        if (!grouped[date]) {
            grouped[date] = [];
        }
        grouped[date].push(appt);
    });
    return grouped;
  },
},
    created() {
        this.getAllTimeBlocks();   // etAvailableAppointments moved to getAllTimeBlocks so they run in sequence
        this.getAppointmentReasons();     
        
    }
};

</script>

<style scoped>
main {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
.time-button-container{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;

}
.list-item{
    list-style-type: none;
    display: flex;   

}
.time-button{
    flex-wrap: wrap;
    border: whitesmoke;
    color: black;
    background-color: #85E6C5;
    border-style: groove;
    border-radius: 6px;
    margin: 5px;
    padding: 5px;
    width: 100px;
    text-align: center;
    box-shadow: 0 2px 5px white, inset 0 0 6px whitesmoke;
    font-weight: bold;

}
.time-button:hover {
    border: solid black;
}
.time-button:active {
    background-color: #C8FFE0;
}
.selected {
    border: 2px solid black;
    border-radius: 6px;
    opacity: 80%;
    box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
    background-color: #C8FFE0;
}

.appt-reason-form{
    color: black;
    font-weight: bold;

}
.book-it {
    background-color: #85E6C5;
    box-shadow: 0 1px 1px white,  inset 0 0 6px whitesmoke;
    border: 2px groove whitesmoke;
    font-weight: bold;
    border-radius: 4px;
}
.book-it:hover {
    border: solid black;
}
.book-it:active {
    background-color: #C8FFE0;
}


</style>