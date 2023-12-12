import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000",
    headers: {'Authorization' : 'Bearer ' + localStorage.getItem('token')}
  });
export default {
    listOfficesByDoctorId(doctorId) {
        return http.get(`/doctors/${doctorId}/offices`);
    },
    createNewOffice(office) {
        return http.post('/offices', office);
    },
    updateOffice(officeId, office) {
        return http.put(`/office/${officeId}`, office);
    }
    // ...This needs to pass an office object...How do that..? -Tyler-
}