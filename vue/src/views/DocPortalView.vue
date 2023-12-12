<template>
    <body>      
        <div class="header">
            <global-header class="global"/>
        </div>
        
        <section class="welcome">
            <img class = "main-image" src="../assets/doctorAndMale.jpg"/>
            <div class="message">
            <h1>Welcome! We're glad you're here.</h1> 
            
            <img class="text-logo" src="../assets/transparentText.png"/>
            <!--<a href="#" class="button">Get Started</a>-->
        </div>

        </section>
        <section class="menu">
            <div class="subfooter">
  
<figure>
  <router-link to="/schedule"><img src="../assets/Calendar.png" class="icons"/><figcaption>Set Schedule</figcaption></router-link>
</figure>
<figure>
  <img class="icons" src="../assets/checkForReviews.png" alt="Check reviews" /><figcaption>Check Reviews</figcaption>
</figure>
<figure>
  <router-link to="/agenda"><img class="icons" src="../assets/stethoscope.png"/><figcaption>See Appointments</figcaption></router-link>
</figure>
<figure>
  <router-link to="/docportal/addoffices"><img class="icons" src="../assets/medicalStaff.png"/><figcaption>Set Office Information</figcaption></router-link>
</figure>
</div>
        </section>

        
        <div class="footer">
            <global-footer/>
        </div>
        <div class="portals">
      <router-link class="test" to="/">Patient Portal | </router-link>
      <router-link class="test" to="/admin">Admin Portal</router-link>

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
    justify-content: space-between;
   
    
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
    padding-left: 0%;
    margin-top: 10%;
}
h1 {
  
    text-align: center;
    padding-bottom: 0%;
    font-weight: bold;
}
h3 {
    text-align: center;
    padding-bottom: 0%;
    padding-top: 0%;
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
  grid-area: subfooter;
  display: flex;
  justify-content: space-around;
  padding-top: 1%;
  padding-bottom: 1%;
  a {
      text-decoration: none;
      &:hover {
        color: #33BBC5;
      }
  
}
  
}
.icons {
  width: 25%;
  a {
      text-decoration: none;
      &:hover {
        color: #33BBC5;
        opacity: 40%;
      }
    }
}
figcaption {
  font-weight: bold;
  font-size: larger;
    a {
      text-decoration: none;
      &:hover {
        color: #33BBC5;
    }
}
}
.button {
  background-color: #33BBC5;
  color: white;
  display: inline-block;
  padding: 20px 32px;
  text-align: center;
  font-size: 18px;
  border-radius: 6px;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 25%;
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