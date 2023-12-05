import axios from 'axios'
import { mapActions } from 'vuex';

export default {
    addImage(file) {
        const form = new FormData();
        form.append("data", file);
        return axios.post("/images", form, {
            headers: {
                "content-type": 'multipart/form-data'
            }
        });
    },
    getImageIds(){
        return axios.get('/images/imageids');
    }

}