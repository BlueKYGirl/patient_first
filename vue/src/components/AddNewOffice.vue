<template>
    <!-- Finish adjustment from the register form over to add new office form -->
    <div class="logo-register-page">
      <global-header />
    </div> 
  <!-- TODO: Reform the register method into a "schedule" method -->
    <div id="register" class="text-center">
      <form v-on:submit.prevent="register" >
        <h1>Create Account</h1>
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="form-input-group">
          <label for="practice-name">Practice Name: </label>
        </div>
            <div class="input-box">
                <input type="text" id="practice-name" v-model="office.practiceName" required autofocus />
            </div>
        <div class="form-input-group">
          <label for="street-address">Street Address: </label>
        </div>
            <div class="input-box">
                <input type="text" id="street-address" v-model="office.streetAddress" required />
            </div>
        <div class="form-input-group">
          <label for="city">City: </label>
        </div>
            <div class="input-box"> 
                <input type="text" id="city" v-model="office.city" required />
            </div>
        <div class="form-input-group">
          <label for="state-abbreviation">State: </label>
        </div>
            <div class="input-box">
                <select id="state-abbreviation" v-model="office.stateAbbreviation" required>
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
        <div class="form-input-group">
          <label for="zipcode">Zip Code (5 digit): </label>
        </div>
            <div class="input-box">
                <input type="number" id="zipcode" v-model="office.zipcode" required />
            </div>
        <div class="form-input-group">
          <label for="phone">Phone Number: </label>
        </div>
            <div class="input-box">
                <input type="text" id="phone" v-model="office.phone" required />
            </div>
        <div class="form-input-group">
          <label for="office-hours-start">Office Hours Start Time: </label>
        </div>
            <div class="input-box">
                <input type="text" id="office-hours-start" v-model="office.officeHoursStart" required />
            </div>
        <div class="form-input-group">
          <label for="office-hours-end">Office Hours End Time: </label>
        </div>
            <div class="input-box">
                <input type="text" id="office-hours-end" v-model="office.officeHoursEnd" required />
            </div>
        <div class="doctors" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
            <div class="doctor-list">
                <img class="doctor-headshot" src="../assets/PF-doctor-headshot-MG.jpg" />
                {{ doctor.firstName }} {{ doctor.lastName }}
            </div>
        </div>
        <!-- Add a method here to add doctors to the office object to be passed back...Also need to adjust back-end -->
        <button type="create-office" v-on:click="createOffice()">Create Office</button>
      </form>
        <p style="text-align: center;"><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
  
      <f1 class="footer-text">Having trouble? Please contact us at:</f1>
      <f2 class="footer-text">1-888-8888</f2>
    </div>
    <div class="footer">
      <global-footer/>
    </div>
  </template>

<script>
  export default {
      data() {
          return {
          office: {
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

      }
}   
</script>

<style>

</style>