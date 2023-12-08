<template>
<body>
    <h2> Set Your Availability </h2>
    <div class="time-block" v-for="timeBlock in timeBlocks" v-bind:key="timeBlock.timeBlockId">
       
       
        <select class="status-list">
            <option v-for="status in scheduleStatuses" v-bind:value="status.scheduleStatus" v-bind:key="status.scheduleStatusId" >{{ status.scheduleStatus }}</option>
        </select>

        {{ timeBlock.timeBlockId }} : {{ timeBlock.startTime }}
    </div>
    
    
    <div class = "offices" v-for="office in offices" v-bind:key="office.officeId">
        {{ office.practiceName }} <br>
        {{ office.streetAddress }}, {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
        Office Phone: {{ office.phone }} <br>
        Hours of Operation: {{ office.officeHoursStart }} - {{ office.officeHoursEnd }} <br><br>

        Doctors in this office: {{ office.doctorsInOffice.length }}
        <div class="doctorsInOffice" v-for="doctor in office.doctorsInOffice" v-bind:key="doctor.doctorId">
            <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Doctors in this office: </h3>
            <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ doctor.firstName }} {{ doctor.lastName }} :  {{ doctor.specialty }}
            </div>
        </div>


    </div>
</body>
</template>

<script>
export default{
    props: {
        timeBlocks: {
            type: Array,
            required: true
        },
        offices: {
            type: Array,
            required: true
        },
        scheduleStatuses: {
            type: Array,
            required: true
        }
    },
};
</script>

<style>
@import '../css/styles.css';

</style>