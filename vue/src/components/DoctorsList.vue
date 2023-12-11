<template>
    <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
        <router-link v-bind:to ="{ name: 'offices', params: { doctorId: doctor.doctorId } }" >
        <div class="doctor-list">
            <img class="doctor-headshot" src="../assets/PF-doctor-headshot-MG.jpg" />
            {{ doctor.firstName }} {{ doctor.lastName }}
    </div>
        <div class="specialty">{{ doctor.specialty }}</div>
      </router-link>
       <!-- <div class="doctorList"> 
            {{ doctor.firstName }} {{ doctor.lastName }}: {{ doctor.specialty }} -->
        </div>

    
  </template>

<script>
export default {

    props: {
        doctors: {
            type: Array,
            required: true
        }
    },
};

</script>

<style>
@import '../css/styles.css';
.doctor-list {
    font-weight: bold;
    padding-top: 2%;
    padding-left: 2%;
    vertical-align: middle;
}

.doctor-headshot{
    display: block;
   height: 200px;
   margin-bottom: 10px;
   border-style: solid;
   border-radius: 10px;
   border-color: black;
   border-width: 2px;
}

.specialty{
    font-weight: 100;
    font-size: medium;
    padding-left: 4%;
    line-height: 2;
    padding-bottom: 1%;
}

.doctors{
    border-style: solid;
    border-color: #614BC3;
    border-width: 2px;
    border-radius: 15px;
    box-shadow: 0 0px 1px #33BBC5, inset 0 0 2px #33BBC5;
    margin-left: 30%;
    margin: 2%;
}
</style>