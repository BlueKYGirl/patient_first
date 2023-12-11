import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000",
    headers: {'Authorization' : 'Bearer ' + localStorage.getItem('token')}
});
export default {
    listAllAvailableTimeBlocks() {
        return http.get('');
    },
    listTimeBlocksByOfficeHours(startTimeId, endTimeId) {
        return http.get(`/appointments/${startTimeId}/${endTimeId}`);
    },
    listScheduleStatuses () {
        return http.get('/appointments/schedulestatus');
    }
}