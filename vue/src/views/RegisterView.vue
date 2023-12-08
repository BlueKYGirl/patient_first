<template>
  <div class="logo-register-page">
    <global-header />
  </div> 

  <div id="register" class="text-center">
    <form v-on:submit.prevent="register" >
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username: </label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password: </label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password: </label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="form-input-group">
        <label for="firstName">First Name: </label>
        <input type="text" id="firstName" v-model="user.firstName" required />
      </div>
      <div class="form-input-group">
        <label for="lastName">Last Name: </label>
        <input type="text" id="lastName" v-model="user.lastName" required />
      </div>
      <div class="form-input-group">
        <label for="email">Email Address: </label>
        <input type="email" id="email" v-model="user.email" required />
      </div>
      <div class="form-input-group">
        <label for="dateOfBirth">Date of Birth: </label>
        <input type="date" id="dateOfBirth" v-model="user.dateOfBirth" required />
      </div>
      <button type="submit" style="margin-left: 30%;">Create Account</button>
      <p style="text-align: center;"><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
  <div>
    <f1 class="footer-text">Having trouble? Please contact us at:</f1>
    <f2 class="footer-text">1-888-8888</f2>
  </div>
</template>

<script>
import authService from '../services/AuthService';
import GlobalHeader from '../components/GlobalHeader.vue';


export default {
  components:{
    GlobalHeader
  },

  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        firstName: '',
        lastName: '',
        email: '',
        dateOfBirth: ''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
@import '../css/styles.css';
.form-input-group {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
  font-size: small;
}

h1{
  text-align: center;
  font-weight: 100;
}

button{
  background-color: #614BC3;
  color: white;
  padding: 3px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 3px 2px #0000001f, inset 0 0 1px #00000052;
}

form{
  display: inline-block;
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
  text-align: left;
  margin-left: 40%;
  margin-right: 40%;
}
label {
  margin-right: 0.5rem;
}

.logo-register-view{
  margin-bottom: 2%;
}

.text-center{
  border-color: gray;
  border-width: .5px;
  margin-top: 5%;
}

.footer-text{
  display: block;
  margin-top: 15px;
  text-align: center;
}
</style>
