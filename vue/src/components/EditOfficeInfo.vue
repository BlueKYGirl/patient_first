// *************************************************
// NOTE: THIS NEEDS TO BE ADJUSTED - I AM JUST USING THE DOC AVAILABILITY CONDITIONS AS A TEMPLATE TO START FROM
// *************************************************
<template>
        <div class="all-offices" > Select office:
            <div class="office" v-for="office in offices" v-bind:key="office.officeId"  v-bind:class="{selected: this.selectedOfficeId===office.officeId }">
                <div class="office2" v-on:click="clickOffice(office.officeId, office.officeHoursStart, office.officeHoursEnd)">
                    <p>{{ office.practiceName }}</p> {{ office.streetAddress }} {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
                    Hours: {{ formattedTime(office.officeHoursStart) }} - {{ formattedTime(office.officeHoursEnd) }}
                </div>
            </div>
        </div>
</template>

<script>
    import officesService from '../services/OfficesService';
    import doctorAvailabilityService from '../services/DoctorAvailabilityService';

    export default {
    props: {

    },
    data() {
        return {
            timeBlocks: [],
            officeTimeBlocks: [],
            offices: [],
            officeHours: {
                officeHoursStartTime: '',
                officeHoursEndTime: ''
            },
            scheduleStatuses: [],
            selectedOfficeId: 0,
            dayToBeScheduled: '',
        };
    },
    methods: {
        formattedTime(time) {
            let hours = time.substr(0, 2);
            let amHours = 'PM';
            let minutes = time.substr(3, 2)
                       
                if (hours < 10 && hours > 0) {
                    hours = time.substr(1, 1);
                    amHours = 'AM';
                }
                    
                    
                if (hours >= 10 && hours < 12) {
                    amHours = 'AM';
                }
                   
                    
                if (hours > 12) {
                    hours -= 12;
                }
                if (hours == 0) {
                    hours = '12';
                    amHours = 'AM';
                }

            return hours + ":" + minutes + amHours;
        },
        getOffices(doctorId) {
            officesService.listOfficesByDoctorId(doctorId)
                .then(response => {
                this.offices = response.data;
                    // this.officeHours.officeHoursStartTime = 
                    // TODO: Determine how to get this working properly
                })
                .catch(error => {
                
                })
        },
   
        translateStartTimeToTimeBlockID(time) {
            this.timeBlocks.forEach( (timeBlock) => {
                if (timeBlock.startTime === time){
                    this.officeHours.officeHoursStartTime = timeBlock.timeBlockId;
                }
            });
        },
        translateEndTimeToTimeBlockID(time) {
            this.timeBlocks.forEach( (timeBlock) => {
                if (timeBlock.startTime === time){   // note:  "startTime" is the only parameter in the timeBlock JSON
                    this.officeHours.officeHoursEndTime = timeBlock.timeBlockId;
                }
            });
        },
        getAllTimeBlocks() {
            doctorAvailabilityService.listAllTimeBlocks()
                .then(response => {
                    this.timeBlocks = response.data;
                    })
                .catch(error => {
                
                })
        },
        getTimeBlocksByOfficeHours(startTimeId, endTimeId) {
            doctorAvailabilityService.listTimeBlocksByOfficeHours(startTimeId, endTimeId)
                .then(response => {
                    this.officeTimeBlocks = response.data;
                    this.$store.commit("SET_OFFICE_TIMEBLOCKS", this.officeTimeBlocks);
                    })
                .catch(error => {
                    
                    })
        },
        clickOffice(officeId, officeStart, officeEnd) {
            this.selectedOfficeId = officeId;
            this.translateStartTimeToTimeBlockID(officeStart);
            this.translateEndTimeToTimeBlockID(officeEnd);
            this.getTimeBlocksByOfficeHours(this.officeHours.officeHoursStartTime, this.officeHours.officeHoursEndTime-1)
            this.$store.commit("SET_SELECTED_OFFICE_ID", this.selectedOfficeId);

        },


    },
    created() {
        this.getOffices(this.$store.state.user.doctorId);
        this.getAllTimeBlocks();
        // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    }
};

</script>

<style scoped>
@import '../css/styles.css';

.conditions {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 2px;
}

.all-offices {
    display: flex;
    flex-direction: column;
    font-size: large;
    font-weight: bold;
    margin-top: 5%;
  
}

.office {
    box-shadow: 0 2px 5px white,  inset 0 0 6px whitesmoke;
    border: 2px solid whitesmoke;
    width: 120%;
    padding: 5px;
    padding-top: 0%;
    margin-top: 2px;
    background-color: #85E6C5;    
    font-weight:normal;
    font-size: normal;
    color: black;
    border-radius: 7px;
    box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
    

}
.office:hover {
    border: 2px solid black;
}

p{
    font-weight: bold;
    margin-top: 2%;
    margin-bottom: 1%;
}

.selected {
    border: 2px solid black;
    opacity: 80%;
    box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
    background-color: #C8FFE0;
}

.day-input {
    font-size: x-large;
    font-weight: bold;
    padding-top: 5%;
    padding-bottom: 2%;
    margin-left: -8%;
    gap: 5%;
   
}
.calendar {
    font-weight: bold;
    font-size: large;
}

</style>