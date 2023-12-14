<template>
  <body>
  <div class="header">
    <global-header/>
  </div> 
    
  <main>
 <div class="patient-features">
    <ul class="patient-list">
      <li class="feature-label">Patient Features:</li>
      <figure><li class="icons"><img src="../assets/medicalStaff.png"/>
          <figcaption>Find a Doctor</figcaption></li></figure>
      <figure><li class="icons"><img src="../assets/Calendar.png"><figcaption>Schedule an Appointment</figcaption></li>
      </figure>
      <figure><li class="icons"><img src="../assets/checkForReviews.png"><figcaption>Read and Leave Reviews</figcaption></li>

      </figure>
      
    </ul>

 </div>
 
    <!--<img src="../assets/helpingHand.jpg" class="main-image"/>--> 
  

  <div class="get-started">

  

  <div id="login">
    <div class="text"> <h1>Welcome!<br>We're glad you're here.</h1></div>
    <form class="form-template" v-on:submit.prevent="login">
      <h1 style="font-size:large; font-weight: 150;">Please Log In:</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
      </div>
      <div class="input-box">  
        <input type="text" id="username" v-model="user.username" required autofocus autocomplete="off" />
      </div>
      <div class="form-input-group">
        <label for="password">Password: &nbsp;</label> 
      </div>
      <div class="input-box">
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button class="sign-in-button" type="submit" style="margin-top: 2%;">Sign in</button>
      <f1 class="footer-text" style="margin-top: 2%;">Having trouble? Please contact us at:</f1>
    <f2 class="footer-text">1-888-8888</f2>
    </form>
    <div class="register">
    <p><img src="../assets/transparentText.png" class="text-logo"/></p>
    <p>Need an account? Sign up.</p>
    <router-link to="/register"><a href="#" class="button">Get Started</a></router-link></div>
  </div>
</div>
 <div class="doctor-features">
    <ul class="doctor-list">
      
      <li class="feature-label">Doctor Features:</li>
      <figure><li class="icons"><img src="../assets/office.png"/>
          <figcaption>Manage Your Offices</figcaption></li></figure>
      <figure><li class="icons"><img src="../assets/schedule.png"><figcaption>Set Your Schedule</figcaption></li>
      </figure>
      <figure><li class="icons"><img src="../assets/stethoscope.png"><figcaption>See Your Daily Schedule <br>and Patients</figcaption></li>

      </figure>
      <figure><li class="icons"><img src="../assets/edit2.png"><figcaption>Check Reviews</figcaption></li>

</figure>
      
   
    </ul>
 </div>
  
</main>
</body>
<div>
    
  </div>
  <div class="footer"> 
      <global-footer />
  </div>
</template>

<script>
import authService from "../services/AuthService";
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";


export default {
  components: {
    GlobalHeader,
    GlobalFooter
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped >
/* <rel="stylesheet" href="../css/styles.css" /> */
@import '../css/styles.css';
main {
  display: flex;
  flex-direction: row;
  justify-content:center;
  align-content: center;
  padding-bottom: 5%;
  a {
      text-decoration: none;
      &:hover {
        color: #614BC3;
      }
    }
}
.get-started {
  display: flex;
  flex-direction: column;
  
  
}
.patient-features {
  display: flex;
  flex-direction: column;
  margin-top: 8%;
  padding-right: 3%;
}
.patient-list {
  display: flex;
  flex-direction: column;
}
.doctor-features {
  display: flex;
  flex-direction: column;
  margin-top: 4%;
  padding-left: 3%;
}
.doctor-list {
  display: flex;
  flex-direction: column;
  font-weight: normal;
}

.icons > img {
  height: 40px;

}
.feature-label {
  text-align: center;
  margin-bottom: 5%;
  font-weight: bold;
  font-size: large;
}
ul {
  list-style-type: none;
}


.button {
  font-size: large;
  background-color: #33BBC5;
  color: white;
  display: inline-block;
  padding-left: 50px;
  padding-right: 50px;
  text-align: center;
  font-size: 18px;
  border-radius: 6px;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 25%;
  text-align: center;
  padding-bottom: 3%;
  padding-top: 3%;
  
  a {
      text-decoration: none;
      &.router-link-exact-active {
        text-decoration: none;
      }
      &:hover {
        color: #614BC3;
      }
    }
}
.register {
  padding-bottom: 5%;
}
label {
  display: flex;
  margin-right: 0.5rem;
}

.sign-in-button{
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-left: 35%;
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

button:hover {
    background-color: #85E6C5;
}
.form-template{
  margin-left: 20%;
  margin-right: 20%;
}
#login{
  display: flex;
  flex-direction: column;
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
  margin-left: 5%;
  margin-right: 5%;
  text-align: center;
  width:400px;

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

h2 {
  text-align: center;
  padding: 10px;
  margin-top: 20px;
  
}
.header{
  margin-bottom: 58px;
}
.graphic {
  align-items: center;
  margin-top: 5%;
  margin-right: 42%;
  margin-left: 42%;
}

.footer-text{
  display: block;
  font-size: small;
  text-align: center;
}
.text {
  font-size: small;
  text-align: center;
}
a {
  text-decoration: none;
  color: #614BC3;
}
a:hover {
  color: #85E6C5;
}
@media only screen and (max-width: 768px){
  img {
    display: none;
  }
}
</style>