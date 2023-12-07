<template>
    <body>
    <div class = "offices">
        <office-details v-bind:offices="offices" />
    </div>
</body>

</template>


<script>
import OfficeDetails from '../components/OfficeDetails.vue'
import officesService from '../services/OfficesService'
import DoctorsList from '../components/DoctorsList.vue';
import doctorsService from '../services/DoctorsService';

export default {
    components: {
        OfficeDetails
    },
    data() {
        return {
            offices: [],


        };
    },
    methods: {
        getOffices(doctorId) {
            officesService.listOfficesByDoctorId(doctorId)
                .then(response => {
                this.offices = response.data;

                })
                .catch(error => {
                this.handleErrorResponse();
                })
    },
    handleErrorResponse() {

    }
  },
  created() {
    this.getOffices(this.$route.params.doctorId);
  }
  
    
    }

</script>


<style>


</style>