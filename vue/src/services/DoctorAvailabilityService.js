import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000",
    headers: {'Authorization' : 'Bearer ' + localStorage.getItem('token')}
});
export default {
    listAllTimeBlocks() {
        return http.get('/appointments/alltimes');
    },

    listTimeBlocksByOfficeHours(startTimeId, endTimeId) {
        return http.get(`/appointments/times/${startTimeId}/${endTimeId}`);
    },

    listScheduleStatuses () {
        return http.get('/appointments/schedulestatus');
    },

    createAvailability(appointments) {
        return http.post('/appointments/agenda/add', appointments);
    }

}