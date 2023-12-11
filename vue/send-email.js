

const nodemailer = require('nodemailer')
const {google} = require('googleapis')
// const { oauth2 } = require('googleapis/build/src/apis/oauth2')

const CLIENT_ID = '264372228480-sbidumcr96tdj6afqni9r6guhmcfu3hn.apps.googleusercontent.com'
const CLIENT_SECRET = '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'
const REDIRECT_URI = 'https://developers.google.com/oauthplayground'
const REFRESH_TOKEN = '1//04NhLPAd5EFvuCgYIARAAGAQSNwF-L9IrJ30RuZNLmgXDdiCcw2RVyu7MbBD4fS3tYpZ_V7NSa5TxfCb5JXd_oZUNXkTuhEk8gT4'

const oAuth2Client = new google.auth.OAuth2(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI)

oAuth2Client.setCredentials({refresh_token: REFRESH_TOKEN})

async function sendDocMail() {

    try {
        const accessToken = await oAuth2Client.getAccessToken()

        const transport = nodemailer.createTransport({
            service: 'gmail',
            auth: {
                type: 'OAuth2',
                user: 'patientfirst2023@gmail.com',
                clientId: CLIENT_ID,
                clientSecret: CLIENT_SECRET,
                refreshToken: REFRESH_TOKEN,
                accessToken: accessToken
            }
        })

        const mailOptions = {
            from: 'Patient First <patientfirst2023@gmail.com>',
            to: 'tylerdix8@gmail.com',
            subject: 'Testing Doctor',
            text: 'Testing Doctor',
            html: 'Testing Doctor'
        }

        const result = transport.sendMail(mailOptions)
        return result

    } catch (error) {
        return error
    }
}

async function sendPatientMail() {

    try {
        const accessToken = await oAuth2Client.getAccessToken()

        const transport = nodemailer.createTransport({
            service: 'gmail',
            auth: {
                type: 'OAuth2',
                user: 'patientfirst2023@gmail.com',
                clientId: CLIENT_ID,
                clientSecret: CLIENT_SECRET,
                refreshToken: REFRESH_TOKEN,
                accessToken: accessToken
            }
        })

        const mailOptions = {
            from: 'Patient First <patientfirst2023@gmail.com>',
            to: 'tylerdix8@gmail.com',
            subject: 'Testing Patient',
            text: 'Testing Patient',
            html: 'Testing Patient'
        }

        const result = transport.sendMail(mailOptions)
        return result

    } catch (error) {
        return error
    }
}

sendPatientMail()
    .then(result => console.log('Scheduling Details Email Sent!', result))
    .catch(error => console.log(error.message));
sendDocMail()
    .then(result => console.log('Your doctor has been notified about the upcoming appointment.', result))
    .catch(error => console.log(error.message));
    