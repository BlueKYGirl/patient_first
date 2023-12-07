<template>
    <body>
        <div class="home">
    <global-header />
    
  </div>
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
import GlobalHeader from '../components/GlobalHeader.vue';

export default {
    components: {
        GlobalHeader,
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
@import '../css/styles.css';

</style>