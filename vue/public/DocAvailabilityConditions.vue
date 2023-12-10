<template>
    <div class="conditions">
        <div class="day-input">
            <label for="dayOfAvailability"> Select the day to schedule: </label> <br>
            <input type="date" class="calendar">
        </div>
        <div class="all-offices" > Select office:
            <div class = "offices" v-for="office in offices" v-bind:key="office.officeId" v-on:click="clickBox()">
                <div>
                    <p>{{ office.practiceName }}</p> {{ office.streetAddress }} {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
                    Hours: {{ office.officeHoursStart }} - {{ office.officeHoursEnd }}
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
@import '../css/styles.css';

.conditions {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 2px;
    
}

.all-offices {
    display: flex;
    flex-direction: column;
    font-size: x-large;
    font-weight: bold;
    padding-top: 4%;
}

.offices {
    border: 2px solid black;
    width: 120%;
    padding: 5px;
    padding-top: 1%;
    margin-top: 3px;
    background-color: #C8FFE0;
    font-weight:normal;
    font-size: normal;
    color: black;
    border-radius: 7px;
    box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;

}
.day-input {
    font-size: x-large;
    font-weight: bold;
    padding-top: 5%;
    padding-bottom: 2%;
    margin-left: -8%;
    gap: 10%
   
}
.calendar {
    font-weight: bold;
    
}

</style>