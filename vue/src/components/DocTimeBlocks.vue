<template>
<body>
    <h2> Set Your Availability </h2>
    <div class="time-block" v-for="timeBlock in timeBlocks" v-bind:key="timeBlock.timeBlockId">
       
        {{ formattedTime(timeBlock.startTime) }} &nbsp;
               
        
        <select class="status-list">
            <option v-for="status in scheduleStatuses" v-bind:value="status.scheduleStatus" v-bind:key="status.scheduleStatusId" >{{ status.scheduleStatus }}</option>
        </select>

        
    </div>
    
    
    <div class = "offices" v-for="office in offices" v-bind:key="office.officeId">
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


    </div>
</body>
</template>

<script>
export default{
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
        }
    
    }
};
</script>

<style>
@import '../css/styles.css';

.time-block {
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
    width: 40%;
}

</style>