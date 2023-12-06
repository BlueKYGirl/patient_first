<template>
    <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
      
        {{ doctor.firstName }} {{ doctor.lastName }} -- {{ doctor.specialty }}
      
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


</style>