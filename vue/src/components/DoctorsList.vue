<template>
    <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
      
        <div class="doctorList"> 
            {{ doctor.firstName }} {{ doctor.lastName }}: {{ doctor.specialty }} </div>
      
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
    border: 3px;
    border-style: solid;
    font-weight: bold;
    line-height: 300%;
  
  padding: 2%;
  
  border-radius: 6px;
  margin: 10px;
  vertical-align: middle;
}


</style>