<template>
    <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
      <router-link v-bind:to="{ name: 'DoctorsListView', params: { doctorId: doctor.doctorId } }">
        {{ doctor.firstName }} {{ doctor.lastName }}
      </router-link>
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