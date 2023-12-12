<template>
    <body>
        <div class="header">
            <global-header/>
        </div>
        <section class="welcome">
            <img class = "main-image" src="../assets/DoctorAndBaby.jpg"/>
            <div class="message">
            <h1>Welcome! We're glad you're here.</h1> 
            
            <img class="text-logo" src="../assets/transparentText.png"/>
            <!--<a href="#" class="button">Get Started</a>-->
        </div>

        </section>
        <section class="menu">
            <div class="subfooter">
  
<figure>
  <img src="../assets/Calendar.png" class="icons"/><figcaption>Edit Appointments</figcaption>
</figure>

<figure>
  <img class="icons" src="../assets/stethoscope.png"/><figcaption>Edit Offices</figcaption>
</figure>
<figure>
  <img class="icons" src="../assets/medicalStaff.png"/><figcaption>Edit Users</figcaption>
</figure>
</div>
        </section>


        <div class="footer">
            <global-footer/>
        </div>
        <div class="portals">
      <router-link class="test" to="/">Patient Portal | </router-link>
      <router-link class="test" to="/docportal">Doctor Portal</router-link>

    </div> 
    </body>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';

export default {
    components: {
        GlobalHeader,
        GlobalFooter
    }
};
</script>

<style scoped>
@import '../css/styles.css';
.welcome {    
    display: flex;
    
    flex-direction: row;
    justify-content:space-between;
    
    
      
    
}
.main-image {
  display: flex;  
   height: auto;
   width: 100vh;
   max-width: 50%;
    border-radius: 5%;  
}
.message {
  
    text-align: center;
    font-weight: bold;
    font-size: x-large;
    margin-right: 10%;
    margin-top: 10%;
    padding-left: 0%;
   
   
   
   
}
h1 {
    
  
  text-align: center;
  padding-bottom: 0%;
  font-weight: bold;
}
.text-logo {
  display: flex;
  justify-content: flex-start;
  align-content: center;
  margin-left: 25%;
  padding-bottom: 2%;  
  width:25vh;
  height: auto;    
    padding-bottom: 3%;
}
.subfooter {
  
  display: flex;
  justify-content: space-around;
  padding-top: 1%;
  padding-bottom: 1%;
  
}
.icons {
  width: 25%;
}
figcaption {
  font-weight: bold;
  font-size: larger;
}
.portals {
    color: black;
    margin-left: 85%;
      a {
        text-decoration: none;
        &:hover {
          color: #614BC3;
        }
      }
  }
  .test {
    color: #33BBC5;
  }
</style>