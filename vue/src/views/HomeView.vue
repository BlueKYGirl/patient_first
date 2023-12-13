<template>
  <body>
    
    <header class="home">
      <div id="header">
      <img class="logo" src="../assets/smallTransparent.png" />
      <div class="nav">

    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp; |&nbsp;&nbsp;
    <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''"> Logout</router-link></div>
   
  </div>
    
  </header>
  <img src="../assets/helpingHand.jpg" class="main-image"/>
  <main>
    <div class="text">
    <h1>Welcome! We're glad you're here.</h1>
    
  </div>
    <p><img src="../assets/transparentText.png" class="text-logo"/></p>
    <router-link to="/register"><a href="#" class="button">Get Started</a></router-link>
    
</main>
<div class="subfooter">
  <figure>
  <router-link to="/doctors"><img class="icons" src="../assets/medicalStaff.png"/>
  <figcaption>Find a Doctor</figcaption></router-link>
</figure>
<figure>
  <router-link to="/mydoctors"><img src="../assets/Calendar.png" class="icons"/><figcaption>See Your Doctors<br>Schedule Visits</figcaption></router-link>
</figure>
<figure>
  <router-link to="/docportal/reviews"><img class="icons" src="../assets/checkForReviews.png" alt="Check reviews" /><figcaption>Leave Reviews</figcaption></router-link>
</figure>

  
    
 
  


</div>
<footer>
  <div id="footer">
        <img class="footer-logo" src="../assets/crossLogo.png" />
      </div>
      <div class="follow-pf">Follow Patient First</div>
      <div>  
        <img class="social-media" src="../assets/PF-facebook.png"/>
        <img class="social-media"  src="../assets/PF-instagram.png" />
        <img class="social-media" src="../assets/PF-linkedin.png" />
    </div>
    <div class="portals">
      <router-link class="test" to="/docportal">Doctor Portal | </router-link>
      <router-link class="test" to="/admin">Admin Portal</router-link>

    </div>

</footer>

    
  
</body>

</template>

<script>
// import SendMail from '../services/SendMail.js'; --> Axios Email Service



// import SendEmail from '../components/SendEmail.vue';

//*********************************************************************
//ADDED THE FOOTER ON HERE FOR YOU, IF YOU DON'T NEED IT, JUST DELETE :) -Shianne
//**********************************************************************


//import GlobalHeader from '../components/GlobalHeader.vue';
//import GlobalFooter from '../components/GlobalFooter.vue';

//import FileUpload from '../components/FileUpload.vue';
//import ImageViewer from '../components/ImageViewer.vue';

export default {
  components: {
    //GlobalHeader,
    //GlobalFooter
    
  },
  // created(){             --> Axios Email Service
  //   SendMail.sendMail();
  // }
};
</script>

<style scoped>
@import '../css/styles.css';
body {
  display: grid;
  grid-template-areas: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
    "header header header header"
    "image image main main"
    "subfooter subfooter subfooter subfooter"
    "footer footer footer footer";
    gap: 10px;
}
header {
  grid-area: header;
  padding: 2%;
  
  
}

.main-image {
  grid-area: image;
  width: 90%;
  height: auto;
  border-radius: 10px;
}
main {
  grid-area: main; 
  font-size: x-large; 
  align-content: center;
  margin-left: 10%;
    a {
      text-decoration: none;
      &:hover {
        color: #614BC3;
      }
    }
  
  
}
.subfooter {
  grid-area: subfooter;
  display: flex;
  justify-content: space-around;
  padding-top: 5%;
  padding-bottom: 1%;
    a {
      text-decoration: none;
      color:#614BC3;
      &:hover {
        color: #33BBC5;
      }
      &:link {
        color:#614BC3;
      }
  
}
}
footer {
  grid-area: footer;
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
  
  a {
      text-decoration: none;
      &.router-link-exact-active {
        text-decoration: none;
      }
    }
}
.welcome {
  justify-content: end;
  margin-left: 76%;
}
.text {
  text-align: center;
  padding-bottom: 4%;
}
.text-logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
.icons {
  width: 25%;
    a {
      text-decoration: none;
      color: #614BC3;
      &:hover {
        color: #33BBC5;
        opacity: 40%;
      }
      &.router-link-exact-active {
        color: #614BC3;
      }
      &:visited {
        color: #614BC3;
      }
      &:link {
        color: #614BC3;
      }

    }
}
.icons:hover {
  opacity: 100%;
}
figcaption {
  font-weight: bold;
    a {
      color:#614BC3;
      text-decoration: none;
      &:hover {
        color: #33BBC5;
        
      }
    }
  
}
#footer {
    display: flex;
    flex-direction: row-reverse;
    margin-top: 2%;
    
  }
  .follow-pf{
    font-size: medium;
  }
  .footer-logo {
    position: absolute;
    width: 60px;
    opacity: 0.2;
  }
  .social-media {
    margin-bottom: 10px;
    width: 75px;
    height: auto;
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
