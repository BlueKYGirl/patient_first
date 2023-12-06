<template>
    <h2> Office Details </h2>
    <div class = "offices" v-for="office in offices" v-bind:key="office.officeId">
        {{ office.practiceName }} <br>
        {{ office.streetAddress }}, {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
        Office Phone: {{ office.phone }} <br>
        Hours of Operation: {{ office.officeHoursStart }} - {{ office.officeHoursEnd }}


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