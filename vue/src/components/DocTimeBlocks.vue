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

    <div class="time-block" v-for="timeBlock in timeBlocks" v-bind:key="timeBlock.timeBlockId">
        <div class="each-time-block">
            <div class="time">
                {{ formattedTime(timeBlock.startTime) }} &nbsp;
            </div>
            <div class="duration" >
                <label>Duration (min): </label>
                <select v-model="timeBlock.duration">
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
                <select class="status-list" name="status-list" id="status-list" v-model="timeBlock.scheduleStatusId">
                    <option v-for="status in scheduleStatuses" v-bind:value="status.scheduleStatusId" v-bind:key="status.scheduleStatusId" >{{ status.scheduleStatus }}</option>
                </select>
            </div>

        </div>
    </div>
    
    
    <!-- <div class = "offices" v-for="office in offices" v-bind:key="office.officeId">
        {{ office.practiceName }} <br>
        {{ office.streetAddress }}, {{ office.city }}, {{ office.stateAbbreviation }} {{ office.zipcode }} <br>
        Office Phone: {{ office.phone }} <br>
        Hours of Operation: {{ office.officeHoursStart }} - {{ office.officeHoursEnd }} <br><br>

        Doctors in this office: {{ office.doctorsInOffice.length }}
        <div class="doctorsInOffice" v-for="doctor in office.doctorsInOffice" v-bind:key="doctor.doctorId">
            <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Doctors in this office: </h3>
            <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ doctor.firstName }} {{ doctor.lastName }} :  {{ doctor.specialty }}
            </div>
        </div>
    </div> -->
</body>
</template>

<script>
export default{
    data() {
        return {
            defaultDuration: 0,
        }
    },
    props: {
        timeBlocks: {
            type: Array,
            required: true
        },
        offices: {
            type: Array,
            required: true
        },
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
            this.timeBlocks.forEach( (timeBlock) => {
                timeBlock.duration = newDurationValue;
            });
        },
        alert(value) {
            alert(value);
        }

        
    
    }
};
</script>

<style>
@import '../css/styles.css';

.time-block-header {
    display: flex;
    flex-direction: row;
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
    padding-top: .5%;
    padding-bottom: .5%;
    padding-right: 1%;
    margin: 1%;
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

</style>