<template>
    <h1>Placeholder</h1>
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
            schedulingDoctorId: 3,   // hard coding this for now will need to be passed from previous screen ($store)?

    
            appointmentReasons: [],
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

        getAllTimeBlocks() {
            doctorAvailabilityService.listAllTimeBlocks()
                .then(response => {
                    this.timeBlocks = response.data;
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
    created() {
        this.getAllTimeBlocks();
        this.getAppointmentReasons();
        this.getAvailableAppointments(this.schedulingDoctorId);
        // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    }
};

</script>

<style>

</style>