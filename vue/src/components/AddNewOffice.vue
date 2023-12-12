<template>
    <!-- Finish adjustment from the register form over to add new office form -->
    <div class="logo-register-page">
      <global-header />
    </div> 
  <!-- TODO: Reform the register method into a "schedule" method -->
    <div id="schedule" class="text-center">
      <form v-on:submit.prevent="register" >
        <h1>Office Details:</h1>
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
h1{
  text-align: center;
  font-weight: 100;
}

.form-input-group{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 0fr 0fr 0fr 0fr;
  margin-left: 40%;
  margin-right: auto;
  text-align: left;
}

.input-box{
  margin-bottom: 2%;
  display: flex;
 justify-content: space-around;
}

button{
  background-color: #614BC3;
  color: white;
  margin-top: 2%;
  margin-bottom: 5%;
  margin-left: 45%;
  margin-right: 45%;
  padding: 5px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 3px 2px #0000001f, inset 0 0 1px #00000052;
}

form{
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
}

.text-center{
  border-color: gray;
  border-width: .5px;
  margin-top: 5%;
}


</style>