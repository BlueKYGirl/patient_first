<template>
    
    <div class="day-input">
        <label for="dayOfAvailability"> Select your day of availability: </label>
        <input type="date" >
    </div>
    <div class = "offices" v-for="office in offices" v-bind:key="office.officeId">
        {{ office.practiceName }}, {{ office.streetAddress }}, {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
        Hours: {{ office.officeHoursStart }} - {{ office.officeHoursEnd }},
    </div>

</template>

<script>
    import officesService from '../services/OfficesService';

    export default {
    props: {

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
    },
    created() {
        this.getOffices(this.$store.state.user.doctorId);
        // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    }
};

</script>

<style>

</style>