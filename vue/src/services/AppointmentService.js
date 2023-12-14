import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000",
    headers: {'Authorization' : 'Bearer ' + localStorage.getItem('token')}
});


export default {
    listAvailableAppointments(doctorId) {
        return http.get(`/appointments/available/${doctorId}`);
    },

    listAppointmentsByPatientId(patientId) {
        return http.get(`/appointments/myappointments/${patientId}`);
    },

    updateBookedAppointment(apptId, appointmentObject) {
        return http.put(`/appointments/available/${apptId}`, appointmentObject);
    },

    listAppointmentReasons () {
        return http.get('/appointments/appointmentreason');
    },


    listDoctorAgenda(doctorId) {
        return http.get(`/appointments/agenda/${doctorId}`);
    },
}