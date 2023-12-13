import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000",
    headers: {'Authorization' : 'Bearer ' + localStorage.getItem('token')}
});


export default {
    listAvailableAppointments(doctorId) {
        return http.get(`/appointments/available/${doctorId}`);
    },

    listAppointmentReasons () {
        return http.get('/appointments/appointmentreason');
    },


    listDoctorAgenda(doctorId) {
        return http.get(`/appointments/agenda/${doctorId}`);
    },
}