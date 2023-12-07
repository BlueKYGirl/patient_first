<template>
    <h2> Office Details </h2>
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

</template>

<script>
export default {
    props: {
        offices: {
            type: Array,
            required: true
        }
    },
};

</script>

<style>


</style>