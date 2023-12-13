<template>
    <body>
        <div class="home">
    <global-header />
    
        </div>
    <div class="add-new-office">
    <add-new-office/>
    <!-- <edit-office-info/> -->
        </div>
            <div class="footer">
                <global-footer />
        </div>
    </body>
</template>

<script>
    import GlobalHeader from '../components/GlobalHeader.vue';
    import GlobalFooter from '../components/GlobalFooter.vue';
    import AddNewOffice from '../components/AddNewOffice.vue';
    import officesService from '../services/OfficesService';
    // import EditOfficeInfo from '../components/EditOfficeInfo.vue';

    export default {
        components: {
            GlobalHeader,
            GlobalFooter,
            AddNewOffice,
            // EditOfficeInfo
        },
        methods: {
            createOffices() {
                officesService.createNewOffice()
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
    }
</script>

<style>
@import '../css/styles.css';

</style>