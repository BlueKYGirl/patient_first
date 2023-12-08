<template>
    <body>
        <div class="home">
            <global-header />
        </div>
        <div class="doc-time-blocks">
            <doc-time-blocks v-bind:timeBlocks="timeBlocks" v-bind:scheduleStatuses="scheduleStatuses" />
        </div>
        <div class="offices">
            <office-details v-bind:offices="offices" />
        </div>
    </body>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import doctorTimeService from '../services/DoctorTimeService';
import DocTimeBlocks from '../components/DocTimeBlocks.vue';
import officesService from '../services/OfficesService';
import OfficeDetails from '../components/OfficeDetails.vue';

export default {
    components: {
        GlobalHeader,
        DocTimeBlocks,
        OfficeDetails
    },
    data() {
        return {
            timeBlocks: [],
            officeTimeBlocks: [],
            offices: [],
            officeHours: {
                officeHoursStartTime: '',
                officeHoursEndTime: ''
            },
            scheduleStatuses: [],
        };
    },
    methods: {
        getAllTimeBlocks() {
            doctorTimeService.listAllTimeBlocks()
                .then(response => {
                    this.timeBlocks = response.data;
                    })
                .catch(error => {
                this.handleErrorResponse();
                })
        },
        getTimeBlocksByOfficeHours(startTimeId, endTimeId) {
            doctorTimeService.listTimeBlocksByOfficeHours(startTimeId, endTimeId)
                .then(response => {
                    this.officeTimeBlocks = response.data;
                    })
                .catch(error => {
                    this.handleErrorResponse();
                    })
        },
        getOffices(doctorId) {
            officesService.listOfficesByDoctorId(doctorId)
                .then(response => {
                this.offices = response.data;
                    // this.officeHours.officeHoursStartTime = 
                    // TODO: Determine how to get this working properly
                })
                .catch(error => {
                this.handleErrorResponse();
                })
        },
        getScheduleStatuses() {
            doctorTimeService.listScheduleStatuses()
                .then(response => {
                    this.scheduleStatuses = response.data;
                    // This is returning the object array, but is not displaying in the vue/view/whatever
                    alert("ARE YOU FIRING?" + this.scheduleStatuses)
                    })
                .catch(error => {
                this.handleErrorResponse();
                })
            // getOfficeHours(doctorId)
            }
        },
    created() {
        this.getAllTimeBlocks();
        this.getScheduleStatuses();
        this.getOffices(1);
        // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    }
};
</script>

<style scoped>
@import '../css/styles.css';
</style>