<template>
    <div class="conditions">
        <div class="day-input">
            <label for="dayOfAvailability"> Select the day to schedule: </label> <br>
            <input type="date" >
        </div>
        <div class="all-offices" > Select for which office you are scheduling:
            <div class = "offices" v-for="office in offices" v-bind:key="office.officeId" v-on:click="clickBox()">
                <div>
                    {{ office.practiceName }}, {{ office.streetAddress }}, {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
                    Hours: {{ office.officeHoursStart }} - {{ office.officeHoursEnd }},
                </div>
            </div>
        </div>
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
        clickBox() {
            alert("Hello!!!  " );
        }
    },
    created() {
        this.getOffices(this.$store.state.user.doctorId);
        // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    }
};

</script>

<style>

.conditions {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 2px;
    
}

.all-offices {
    display: flex;
    flex-direction: column;
}

.offices {
    border: 2px solid #614BC3;
    padding: 2px;
    margin: 2px;

}

</style>