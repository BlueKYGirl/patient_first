<template>
  <!-- Finish adjustment from the register form over to add new office form -->
  <div class="logo-register-page">
    <global-header />
  </div>
<!-- TODO: Reform the register method into a "schedule" method -->
  <div id="schedule" class="text-center">
    <form class="form-template" v-on:submit.prevent="register" >
      <h1>Office Details:</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input">
        <label for="practice-name">Practice Name: </label>
      </div>
          <div class="input-box">
              <input type="text" id="practice-name" v-model="editOffice.practiceName" required autofocus />
          </div>
      <div class="form-input">
        <label for="street-address">Street Address: </label>
      </div>
          <div class="input-box">
              <input type="text" id="street-address" v-model="editOffice.streetAddress" required />
          </div>
      <div class="form-input">
        <label for="city">City: </label>
      </div>
          <div class="input-box">
              <input type="text" id="city" v-model="editOffice.city" required />
          </div>
      <div class="form-input">
        <label for="state-abbreviation">State: </label>
      </div>
          <div class="input-box">
              <select id="state-abbreviation" v-model="editOffice.stateAbbreviation" required>
                  <option>AL</option>
                  <option>AK</option>
                  <option>AZ</option>
                  <option>AR</option>
                  <option>CA</option>
                  <option>CO</option>
                  <option>CT</option>
                  <option>DE</option>
                  <option>FL</option>
                  <option>GA</option>
                  <option>HI</option>
                  <option>ID</option>
                  <option>IL</option>
                  <option>IN</option>
                  <option>IA</option>
                  <option>KS</option>
                  <option>KY</option>
                  <option>LA</option>
                  <option>ME</option>
                  <option>MD</option>
                  <option>MA</option>
                  <option>MI</option>
                  <option>MN</option>
                  <option>MS</option>
                  <option>MO</option>
                  <option>MT</option>
                  <option>NE</option>
                  <option>NV</option>
                  <option>NH</option>
                  <option>NJ</option>
                  <option>NM</option>
                  <option>NY</option>
                  <option>NC</option>
                  <option>ND</option>
                  <option>OH</option>
                  <option>OK</option>
                  <option>OR</option>
                  <option>PA</option>
                  <option>RI</option>
                  <option>SC</option>
                  <option>SD</option>
                  <option>TN</option>
                  <option>TX</option>
                  <option>UT</option>
                  <option>VT</option>
                  <option>VA</option>
                  <option>WA</option>
                  <option>WV</option>
                  <option>WI</option>
                  <option>WY</option>
              </select>
          </div>
      <div class="form-input">
        <label for="zipcode">Zip Code (5 digit): </label>
      </div>
          <div class="input-box">
              <input type="text" id="zipcode" v-model="editOffice.zipcode" required />
          </div>
      <div class="form-input">
        <label for="phone">Phone Number: </label>
      </div>
          <div class="input-box">
              <input type="text" id="phone" v-model="editOffice.phone" required />
          </div>
      <div class="form-input">
        <label for="office-hours-start">Office Hours Start Time: </label>
      </div>
          <div class="input-box">
              <input type="time" id="office-hours-start" v-model="editOffice.officeHoursStart" required />
          </div>
      <div class="form-input">
        <label for="office-hours-end">Office Hours End Time: </label>
      </div>
          <div class="input-box">
              <input type="time" id="office-hours-end" v-model="editOffice.officeHoursEnd" required />
          </div>
      <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
          <div class="doctor-list">
              <img class="doctor-headshot" src="../assets/PF-doctor-headshot-MG.jpg" />
              {{ doctor.firstName }} {{ doctor.lastName }}
          </div>
      </div>
      <!-- Add a method here to add doctors to the office object to be passed back...Also need to adjust back-end -->
      <button class="create-office-button" type="submit" v-on:click.prevent="createOffice()">Create Office</button>
      <router-link class="update-office-button" to="/doctors/:doctorId/offices">Update Office</router-link>
    </form>
  </div>
  <div class="footer">
    <global-footer/>
  </div>
</template>
<script>
import OfficesService from '../services/OfficesService';
export default {
  props: {
    office: {
      type: Object,
      required: true
    }
  },
  data() {
        return {
        editOffice: {
            officeId: 0,
            practiceName: '',
            streetAddress: '',
            city: '',
            stateAbbreviation: '',
            zipcode: '',
            phone: '',
            officeHoursStart: '',
            officeHoursEnd: '',
            doctorsInOffice: [],
        }
        }
    },
    methods: {
      createOffice() {
        alert("CHECKCHECKCHECK"); // MAKE SURE TO REMOVE THIS ALERT!!! @@@@@@@@@@@@@@@@@@
        if (!this.validateForm()) {
          //Form isn't valid, user must update and submit again.
          return;
        }
        // Check for add or edit
        if (this.editOffice.officeId === 0) {
          OfficesService.createNewOffice(this.editOffice)
            .then ( response => {
              if (response.status === 201) {
                this.$router.push({ name: 'AddOfficeView'});
              }
            })
            .catch ( error => {
              this.handleErrorResponse(error, 'creating');
            })
        } else {
          // TODO - Determine how to point this at a specific office as this adaptation from the message exercise doesn't translate 1-1.
          OfficesService.updateOffice(this.office.officeId, this.editOffice)
            .then ( response => {
              if (response.status === 200) {
                alert("Does this work? Bottom.");
                this.$router.push({ name: 'AddOfficeView'});
              }
            })
            .catch ( error => {
              this.handleErrorResponse(error, 'updating');
            })
        }
      },
  cancelForm() {
    this.$router.back();
  },
  handleErrorResponse(error, verb) {
    if (error.response) {
      if (error.response.status == 404) {
        this.$router.push({name: 'NotFoundView'});
      } else {
        this.$store.commit('SET_NOTIFICATION',
        `Error ${verb} message. Response received was "${error.response.statusText}".`);
      }
    } else if (error.request) {
      this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Server could not be reached.`);
    } else {
      this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Request could not be created.`);
    }
  },
  validateForm() {
    let msg = '';
    this.editOffice.practiceName = this.editOffice.practiceName.trim();
    if (this.editOffice.practiceName.length === 0) {
      msg += 'The new office must have a name. ';
    }
    this.editOffice.streetAddress = this.editOffice.streetAddress.trim();
    if (this.editOffice.streetAddress.length === 0) {
      msg += 'The new office must have an address. ';
    }
    this.editOffice.city = this.editOffice.city.trim();
    if (this.editOffice.city.length === 0) {
      msg += 'The new office must have a city. ';
    }
    // Have this one validate State Abbreviation @@@@@@@@@@@
    this.editOffice.city = this.editOffice.city.trim();
    if (this.editOffice.city.length === 0) {
      msg += 'The new office must have a city. ';
    }
    this.editOffice.zipcode = this.editOffice.zipcode.trim();
    if (this.editOffice.zipcode.length === 0 || this.editOffice.zipcode.length > 5) {
      msg += 'The new office must have a zip code (5 digit). ';
    }
    this.editOffice.phone = this.editOffice.phone.trim();
    if (this.editOffice.phone.length === 0) {
      msg += 'The new office must have a phone number. ';
    }
    this.editOffice.officeHoursStart = this.editOffice.officeHoursStart.trim();
    if (this.editOffice.officeHoursStart.length === 0) {
      msg += 'The new office must have a opening time. ';
    }
    this.editOffice.officeHoursEnd = this.editOffice.officeHoursEnd.trim();
    if (this.editOffice.officeHoursEnd.length === 0) {
      msg += 'The new office must have a closing time. ';
    }
    if (msg.length > 0) {
      this.$store.commit('SET_NOTIFICATION', msg);
      return false;
    }
    return true;
  },
    }
}
</script>
<style scoped>
h1{
  text-align: center;
  font-weight: 100;
}
.form-input{
  display: flex;
  flex-direction: column;
  align-content:center;
}
.input-box{
  margin-bottom: 1%;
 display: flex;
 flex-direction: column;
 position: relative;
}
.create-office-button{
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-left: 47%;
  margin-right: auto;
  background-color: #614BC3;
  color: white;
  margin-top: 4%;
  margin-bottom: 0%;
  padding: 3px;
  padding-left: 5px;
  padding-right: 5px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 1px 2px #0000001f, inset 0 0 1px #00000052;
}
.update-office-button {
  display: flex;
  flex-direction: column;
  justify-content: center;
  text-align: center;
  margin-left: 43%;
  margin-right: auto;
  background-color: #614BC3;
  color: white;
  margin-top: 0%;
  margin-bottom: 4%;
  padding: 3px;
  padding-left: 5px;
  padding-right: 5px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 1px 2px #0000001f, inset 0 0 1px #00000052;
  font-size: small;
}
button:hover {
    background-color: #85E6C5;
}
.update-office-button:hover {
  background-color: #85E6C5;
}
form{
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
}
.form-template{
  margin-left: 20%;
  margin-right: 20%;
}
.text-center{
  border-color: gray;
  border-width: .5px;
  margin-top: 5%;
}
a {
  text-decoration: none;
}
.buttons {
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
}
</style>







