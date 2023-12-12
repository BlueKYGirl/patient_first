<template>
  <div>
    <button @click="sendPatientMail">Send Patient Mail</button>
    <button @click="sendDocMail">Send Doctor Mail</button>
  </div>
</template>
  
  <script>
    import nodemailer from 'nodemailer';
    import { google } from 'google-auth-library';

  export default {
    data() {
      return {
        CLIENT_ID: '264372228480-sbidumcr96tdj6afqni9r6guhmcfu3hn.apps.googleusercontent.com',
        CLIENT_SECRET: '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',
        REDIRECT_URI: 'https://developers.google.com/oauthplayground',
        REFRESH_TOKEN: '1//04NhLPAd5EFvuCgYIARAAGAQSNwF-L9IrJ30RuZNLmgXDdiCcw2RVyu7MbBD4fS3tYpZ_V7NSa5TxfCb5JXd_oZUNXkTuhEk8gT4',
        oAuth2Client: new google.auth.OAuth2(this.CLIENT_ID, this.CLIENT_SECRET, this.REDIRECT_URI),
      };
    },
    methods: {
      initOAuth2Client() {
        this.oAuth2Client = new google.auth.OAuth2(this.CLIENT_ID, this.CLIENT_SECRET, this.REDIRECT_URI);
        this.oAuth2Client.setCredentials({ refresh_token: this.REFRESH_TOKEN });
      },
      async sendMail(options) {
        try {
          const accessToken = await this.oAuth2Client.getAccessToken();
  
          const transport = nodemailer.createTransport({
            service: 'gmail',
            auth: {
              type: 'OAuth2',
              user: 'patientfirst2023@gmail.com',
              clientId: this.CLIENT_ID,
              clientSecret: this.CLIENT_SECRET,
              refreshToken: this.REFRESH_TOKEN,
              accessToken: accessToken,
            },
          });
  
          const mailOptions = {
            from: 'Patient First <patientfirst2023@gmail.com>',
            to: 'tylerdix8@gmail.com',
            ...options,
          };
  
          const result = await transport.sendMail(mailOptions);
          return result;
        } catch (error) {
          return error;
        }
      },
      async sendPatientMail() {
        return this.sendMail({
          subject: 'Testing Patient',
          text: 'Testing Patient',
          html: 'Testing Patient',
        });
      },
      async sendDocMail() {
        return this.sendMail({
          subject: 'Testing Doctor',
          text: 'Testing Doctor',
          html: 'Testing Doctor',
        });
      },
    },
  };
  </script>
  
  <style scoped>
    /* Add any scoped styles if necessary */
  </style>