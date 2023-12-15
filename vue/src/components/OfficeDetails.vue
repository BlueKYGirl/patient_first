<template>
    <div class="office-details-header">
        <h2> Office Details </h2>
        
    </div>

    <div class = "office-details" v-for="office in offices" v-bind:key="office.officeId">
        <div class="office-name">{{ office.practiceName }} <br></div>
        <div style="margin-top: 1%; margin-bottom: 4%;">
        {{ office.streetAddress }} {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>   
        Office Phone: {{ office.phone }} <br>
        Hours of Operation: {{ office.officeHoursStart.substr(1,4) }}AM - {{ office.officeHoursEnd.substr(1,4) }}PM <br><br></div>
        <h4 style="font-size: medium; margin-bottom: 2%;">Doctors located in this office: {{ office.doctorsInOffice.length }}</h4>
        <div class="doctorsInOffice" v-for="doctor in office.doctorsInOffice" v-bind:key="doctor.doctorId">
            {{ doctor.firstName }} {{ doctor.lastName }}: {{ doctor.specialty }}
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

<style scoped>
@import '../css/styles.css';

.office-name{
    margin-top: 4%;
    font-size: large;
    font-weight: bold;
}

.office-details-header{
    display: flex;
    justify-content: center;
    text-align: center;
    margin-top: 2%;
    
}

.office-details{
    font-size: larger;
    display: flex;
    flex-direction: column; 
    align-content: center;
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
  margin-top: 2%;
  text-align: center;
  width:400px; 
  margin-left: 35%;
  margin-right: 35%
}

h3{
    margin-top: 5%;
    margin-bottom: 3px;
}

.doctorsInOffice{
    font-size: medium;
    text-align: left;
    margin-left: 2%;
    margin-bottom: 2%;
}


</style>