import axios from 'axios';

export default {
    personalizations: [
      {
        to: [
          {
            email: 'tylerdix8@gmail.com'
          }
        ],
        subject: 'Hello, World!'
      }
    ],
    from: {
      email: 'patientfirst2023@gmail.com'
    },
    content: [
      {
        type: 'text/plain',
        value: 'Hello, World!'
      }
    ],
    options: {
        method: 'POST',
        url: 'https://rapidprod-sendgrid-v1.p.rapidapi.com/mail/send',
        headers: {
          'content-type': 'application/json',
          'X-RapidAPI-Key': 'c6771459aamshf2b2b4161aff747p1cb2b4jsn92f6c946119c',
          'X-RapidAPI-Host': 'rapidprod-sendgrid-v1.p.rapidapi.com'
        },
  },
  sendMail() {
    try {
        const response = axios.request(this.options);
        console.log(response.data);
    } catch (error) {
        console.error(error);
  }
}
};