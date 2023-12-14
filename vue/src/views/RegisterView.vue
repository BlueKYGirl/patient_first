<template>
  <div class="logo-register-page">
    <global-header />
  </div> 

  <div id="register" class="text-center">
    <form class="form-template" v-on:submit.prevent="register" >
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username: </label>
      </div>
      <div class="input-box">
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password: </label>
        </div>
        <div class="input-box">
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password: </label>
      </div>
      <div class="input-box"> 
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="form-input-group">
        <label for="firstName">First Name: </label>
        </div>
        <div class="input-box">
        <input type="text" id="firstName" v-model="user.firstName" required />
      </div>
      <div class="form-input-group">
        <label for="lastName">Last Name: </label>
        </div>
        <div class="input-box">
        <input type="text" id="lastName" v-model="user.lastName" required />
      </div>
      <div class="form-input-group">
        <label for="email">Email Address: </label>
        </div>
        <div class="input-box">
        <input type="email" id="email" v-model="user.email" required />
      </div>
      <div class="form-input-group">
        <label for="dateOfBirth">Date of Birth: </label>
        </div>
        <div class="input-box">
        <input type="date" id="dateOfBirth" v-model="user.dateOfBirth" required />
      </div>
      <button class="create-account-button" type="submit">Create Account</button>
      <p style="text-align: center;"><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    
    </form>

    <f1 class="footer-text">Having trouble? Please contact us at:</f1>
    <f2 class="footer-text">1-888-8888</f2>
  </div>
  <div class="footer">
    <global-footer/>
  </div>
</template>

<script>
import authService from '../services/AuthService';
import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';


export default {
  components:{
    GlobalHeader,
    GlobalFooter
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


h1{
  text-align: center;
  font-weight: 100;
}

button:hover {
    background-color: #85E6C5;
}
.create-account-button{
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-left: 43%;
  margin-right: auto;
  background-color: #614BC3;
  color: white;
  margin-top: 4%;
  margin-bottom: 4%;
  padding: 3px;
  padding-left: 5px;
  padding-right: 5px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 1px 2px #0000001f, inset 0 0 1px #00000052;
}
.form-template{
  margin-left: 20%;
  margin-right: 20%;
}
.form-input-group{
  display: flex;
  flex-direction: column;
  align-content: center;
}

.input-box{
  margin-bottom: 1%;
 display: flex;
 flex-direction: column;
 position: relative;
  
}

form{
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
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
  font-size: small;
  margin-top: 15px;
  text-align: center;
}
a {
  text-decoration: none;
  
  color: #614BC3;
  &:hover {
    color: #85E6C5;
  }
}
p {
  text-align: center;
}
</style>
