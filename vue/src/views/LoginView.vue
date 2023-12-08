<template>
  <body>
  <div class="header">
    <global-header/>
  </div> 
    
  <div class="graphic">
    <img src="../assets/transparentText.png">
</div>
    
   
  <div id="login">
    
    <form v-on:submit.prevent="login">
      <h1 style="font-size:large; font-weight: 150;">Please Log In:</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</body>
</template>

<script>
import authService from "../services/AuthService";
import GlobalHeader from "../components/GlobalHeader.vue"


export default {
  components: {
    GlobalHeader
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
.form-input-group {
  display: flex;
  justify-content: space-between;
  text-align: left;
  font-size: small;
  margin-bottom: 1rem;
  background-color: white;
}
label {
  margin-right: 0.5rem;
}

button{
  background-color: #614BC3;
  color: white;
  padding: 3px;
  border-style: none;
  border-radius: 3px;
  box-shadow: 0 3px 2px #0000001f, inset 0 0 1px #00000052;
}

#login{
  position: fixed;
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;
  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
  margin-top: 2%;
  text-align: center;
  margin-left: 40%;
  margin-right: 40%;
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
  margin-top: 10%;
  margin-right: 42%;
  margin-left: 42%;
}


</style>