<template>
    <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
        <router-link v-bind:to ="{ name: 'offices', params: { doctorId: doctor.doctorId } }" >
        <div class="doctorList">
            {{ doctor.firstName }} {{ doctor.lastName }}: {{ doctor.specialty }}
        </div>
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
.doctorList {
    border: 1px;
    border-style: solid;
    font-weight: bold;
    line-height: 300%;
  padding: 2%;
  border-radius: 6px;
  margin: 10px;
  vertical-align: middle;
}
</style>