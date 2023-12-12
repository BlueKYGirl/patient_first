<template>
<body>
    <div class="time-block-header">
        <h2> Set Your Availability </h2>
        <div class="default-duration">
            <label>Default Duration (mins): </label>
            <select v-model=this.defaultDuration v-on:change="updateDurations(this.defaultDuration)">
                <option>15</option>
                <option>30</option>
                <option>45</option>
                <option>60</option>
                <option>75</option>
                <option>90</option>
            </select>
        </div>
        <div>&nbsp;</div>
        <div>&nbsp;</div>
    </div>

    <div class="time-block" v-for="timeBlock in officeTimeBlocks" v-bind:key="timeBlock.timeBlockId" >
        <div class="each-time-block">
            <div class="time">
                {{ formattedTime(timeBlock.startTime) }} &nbsp;
            </div>
            <div class="duration" >
                <label>Duration: </label>
                <select v-model="timeBlock.duration" style="background-color: #C8FFE0;" 
                        v-bind:disabled="!timeBlock.enabled"
                        v-on:change="timeBlock.scheduleStatusId=0; enableTimeBlocks(timeBlock.startTime)">
                    <option>15</option>
                    <option>30</option>
                    <option>45</option>
                    <option>60</option>
                    <option>75</option>
                    <option>90</option>
                </select>
            </div>
            <div class="status-list-container">
                <label for="status-list">Purpose: </label>
                <select class="status-list" name="status-list" id="status-list" 
                        v-model="timeBlock.scheduleStatusId" 
                        v-bind:disabled="!timeBlock.enabled" 
                        v-on:change="disableTimeBlocks(timeBlock.startTime, timeBlock.duration)">
                    <option v-for="status in scheduleStatuses" v-bind:value="status.scheduleStatusId" v-bind:key="status.scheduleStatusId" >{{ status.scheduleStatus }}</option>
                </select>
            </div>                
        </div>
    </div>
    
    
    <div class="button">
        <button type="submit" v-on:click="createAvailabilityRecords">Submit</button>
        <button type="reset" v-on:click="resetOfficeTimeBlocks">Reset</button>
    </div>    
</body>

<div class="footer">
    <global-footer />
</div>
</template>



<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import doctorAvailabilityService from '../services/DoctorAvailabilityService';


export default{
    components:{
        GlobalFooter
    },

    data() {
        return {
            defaultDuration: 0,
            officeTimeBlocks: [],
            // timeBlocks: [],
            availabilityRecords: [],
        }
    },
    props: {
        // officeTimeBlocks: {
        //     type: Array,
        //     required: true
        // },
        // offices: {
        //     type: Array,
        //     required: true
        // },
        scheduleStatuses: {
            type: Array,
            required: true
        }
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
        updateDurations(newDurationValue) {
            this.officeTimeBlocks.forEach( (timeBlock) => {
                timeBlock.duration = newDurationValue;
            });
        },
        disableTimeBlocks(currentTime, duration) {
            // function to add minutes to time -- got this from http://www.java2s.com/example/javascript/date-operation/add-30-minutes-to-time-as-hours-and-minutes.html
                function z(n){ return (n<10? '0':'') + n;}
                var bits = currentTime.split(':');
                var mins = bits[0]*60 + +bits[1] + +duration;
                //alert(z(mins%(24*60)/60 | 0) + ':' + z(mins%60));
            const endTime = z(mins%(24*60)/60 | 0) + ':' + z(mins%60);
        
            // actually update the "enabled" property
            this.officeTimeBlocks.forEach( (timeBlock) => {
                if (timeBlock.startTime > currentTime && timeBlock.startTime < endTime){
                        timeBlock.enabled = false;
                        timeBlock.duration = 0;
                        timeBlock.scheduleStatusId = 0;
                }
            });
        },

        enableTimeBlocks(currentTime) {
        
            // change 'enabled' properties from 'false' to 'true' starting at current startTime, break when next 'true' occurs.
            for (let i=0; i<this.officeTimeBlocks.length; i++) {
                if (this.officeTimeBlocks[i].startTime > currentTime){
                    if (this.officeTimeBlocks[i].enabled === false) {
                        this.officeTimeBlocks[i].enabled = true;
                    } else {
                        break;
                    }
                }
            }
        },
        resetOfficeTimeBlocks() {
             this.officeTimeBlocks.forEach( (timeBlock) => {
                timeBlock.duration = 0;
                timeBlock.scheduleStatusId = 0;
                timeBlock.enabled = true;
            });
        },

        createAvailabilityRecords() {
            
            const availabilityRecs = [];
            this.officeTimeBlocks.forEach((timeBlock) => {
                const appt = {};
                appt.doctorId = this.$store.state.user.doctorId;
                appt.patientId = 0;
                appt.date = this.$store.state.dayToBeScheduled;
                appt.timeBlockId = timeBlock.timeBlockId;
                appt.officeId = this.$store.state.selectedOfficeId;
                appt.appointmentReasonId = 1;          // ******** NOTE, THIS WILL HAVE TO BE CHANGED WHEN WE DECIDE WHAT TO DO IN THE DB ******
                appt.appointmentStatusId = 1;
                appt.scheduleStatusId = timeBlock.scheduleStatusId;
                if (timeBlock.scheduleStatusId > 0) {       // ONLY send records that have an assigned status
                    availabilityRecs.push(appt);
                }
                //alert(appt)
            });
            
            this.availabilityRecords = availabilityRecs;

            // Call HTTP PUT 
            doctorAvailabilityService.createAvailability(this.availabilityRecords) 
                .then(response => {
                    if (response.status === 201) {
                        alert("Schedule successfully submitted!!")
                    } else {
                        alert("Something went wrong.  :-( ")
                    }
                });

        },


        alert(value) {
            alert(value);
        },
    },
    watch: {
        '$store.state.officeTimeBlocks' (newVal, oldVal) {
            this.officeTimeBlocks = [];
            newVal.forEach( (timeBlock) => {
                timeBlock.enabled = true;
                this.officeTimeBlocks.push(timeBlock);
            });
        }
    }
    // computed: {
    //      getOfficeTimeBlocksFromState() {
    //         return this.$store.state.officeTimeBlocks;
    //     }
    // }
    
};
</script>

<style>
@import '../css/styles.css';

h2{
    position: relative;
    font-size: x-large;
    font-weight: bold;
    padding-top: 8%;
    margin-left: 20%;

}

.time-block-header {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;

}
.time {
    font-size: large;
}
.each-time-block {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
}

.time-block {
    flex-wrap: wrap;   
    background-color: #85E6C5;
    border: black;
    border-style: groove;
    border-radius: 6px;
    padding-left: 1%;
    padding-top: 1%;
    padding-bottom: 1%;
    padding-right: 1%;
    margin: 1%;
    margin-left: 10%;
    margin-right: auto;
    color: black;
    text-align: center;
    width: 80%;
    box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
    font-weight: bold;
}
.status-list {
    font-weight: bold;
    background-color: #C8FFE0;
}

.default-duration{
    margin-top: 11%;
    align-items: end;
    font-size: small;
}

.button{
    display: flex;
    justify-content: space-around;
    margin-bottom: 10%;
}

button{
  background-color: #614BC3;
  color: white;
  width: 100px;
  padding: 3px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 3px 2px #0000001f, inset 0 0 1px #00000052;
}


</style>