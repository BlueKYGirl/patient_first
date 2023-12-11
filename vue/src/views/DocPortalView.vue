<template>
    <body>      
        <div class="header">
            <global-header class="global"/>
        </div>
        
        <section class="welcome">
            <img class = "main-image" src="../assets/doctorAndMale.jpg"/>
            <div class="message">
            <h1>Welcome!</h1> 
            <h3>We're glad you're here.</h3>
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
  <img class="icons" src="../assets/stethoscope.png"/><figcaption>See Appointments</figcaption>
</figure>
</div>
        </section>

        
        <div class="footer">
            <global-footer/>
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
   height: 100%;
   width: auto;
    border-radius: 5%;
  
}
.message {
    text-align: center;
    font-weight: bold;
    font-size: large;
    margin-right: 30%;
    padding-left: 3%;
}
h1 {
    text-align: center;
    padding-bottom: 0%;
}
h3 {
    text-align: center;
    padding-bottom: 20%;
    padding-top: 0%;
}

.text-logo {
    
    padding-bottom: 3%;
}

.subfooter {
  grid-area: subfooter;
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


</style>