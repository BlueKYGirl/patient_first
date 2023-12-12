<template>
    <body>
        <div class="home">
            <global-header />
        </div>
        <div class="patient-schedule-appointment">
            <schedule-appointment v-bind:doctorAvailableTimes="doctorAvailableTimes" />
        </div>
        
        
    </body>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import ScheduleAppointment from '../components/ScheduleAppointment.vue';

export default {
    components: {
        GlobalHeader,
        ScheduleAppointment
    },
    data() {
        return {
            doctorAvailableTimes: [],
        };
    },
    // methods: {
    //     getAllTimeBlocks() {
    //         doctorAvailabilityService.listAllTimeBlocks()
    //             .then(response => {
    //                 this.timeBlocks = response.data;
    //                 })
    //             .catch(error => {
    //             this.handleErrorResponse();
    //             })
    //     },
    //     getTimeBlocksByOfficeHours(startTimeId, endTimeId) {
    //         doctorAvailabilityService.listTimeBlocksByOfficeHours(startTimeId, endTimeId)
    //             .then(response => {
    //                 this.officeTimeBlocks = response.data;
    //                 })
    //             .catch(error => {
    //                 this.handleErrorResponse();
    //                 })
    //     },
    //     // getOffices(doctorId) {
    //     //     officesService.listOfficesByDoctorId(doctorId)
    //     //         .then(response => {
    //     //         this.offices = response.data;
    //     //             // this.officeHours.officeHoursStartTime = 
    //     //             // TODO: Determine how to get this working properly
    //     //         })
    //     //         .catch(error => {
    //     //         this.handleErrorResponse();
    //     //         })
    //     // },
    //     getScheduleStatuses() {
    //         doctorAvailabilityService.listScheduleStatuses()
    //             .then(response => {
    //                 this.scheduleStatuses = response.data;
    //                 })
    //             .catch(error => {
    //             this.handleErrorResponse();
    //             })
    //         // getOfficeHours(doctorId)
    //         }
    //     },
    // created() {
    //     this.getAllTimeBlocks();
    //     this.getScheduleStatuses();
    //     // this.getOffices(1);
    //     // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    // }
};
</script>

<style scoped>
@import '../css/styles.css';
</style>