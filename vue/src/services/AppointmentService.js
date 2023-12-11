import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000",
    headers: {'Authorization' : 'Bearer ' + localStorage.getItem('token')}
});
export default {
    listAllAppointments(doctorId) {
        return http.get('');
    },
}