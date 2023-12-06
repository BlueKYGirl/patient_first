import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    listOfficesByDoctorId(doctorId) {
        return http.get('/doctors/:doctorId/offices');
    }
}