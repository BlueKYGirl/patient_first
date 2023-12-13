<template>
    <body>
        <div class="home">
    <global-header />
    
        </div>
    <div class="add-new-office">
    <add-new-office/>
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

    export default {
        components: {
            GlobalHeader,
            GlobalFooter,
            AddNewOffice
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
        created() {
            this.createOffices();
        }
    }
</script>

<style>
@import '../css/styles.css';

</style>