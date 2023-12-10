<template>
    <div class="office-details-header">
        <h2> Office Details </h2>
        
    </div>

    <div class = "office-details" v-for="office in offices" v-bind:key="office.officeId">
        <div class="office-name">{{ office.practiceName }} <br></div>
        {{ office.streetAddress }} {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>   
        Office Phone: {{ office.phone }} <br>
        Hours of Operation: {{ office.officeHoursStart.substr(1,4) }}AM - {{ office.officeHoursEnd.substr(1,4) }}PM <br><br>
        Doctors located in this office: {{ office.doctorsInOffice.length }}
        <div class="doctorsInOffice" v-for="doctor in office.doctorsInOffice" v-bind:key="doctor.doctorId">
            <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Doctors in this office: </h3>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ doctor.firstName }} {{ doctor.lastName }} :  {{ doctor.specialty }}
        
        </div>
    </div>
</template>

<script>
export default {
    props: {
        offices: {
            type: Array,
            required: true
        }
    }
};

</script>

<style>
@import '../css/styles.css';

.office-name{
    font-size: large;
    font-weight: bold;
}


.office-details{
    margin-left: 5%;
    margin-right: 5%;
}

h3{
    margin-top: 5%;
    margin-bottom: 3px;
}

.doctorsInOffice{
    border-radius: 10px;
    box-shadow: 0 3px 2px #0000001f, inset 0 0 1px #00000052;
    }
</style>