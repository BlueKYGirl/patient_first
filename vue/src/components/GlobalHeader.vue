<template>
  <body>
    <div id="header">
      <img class="logo" src="../assets/smallTransparent.png" />
      <div class="nav">

    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp; |&nbsp;&nbsp;
    <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''"> Logout</router-link></div>
   
  </div>
  
</body>
</template>

<style>


#header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 2%;
}

.logo {
  width: 12%;
  height: auto;
}



.nav {
  display: flex;
  flex-direction: row;
  margin-top: 1%;
  font-size: xx-large;
  
}
a {
  text-decoration: none;
  color: #614BC3;
}
a.active {
  color: #33BBC5;
}

/*.logo {
  display: block;
  width: 10%;
  text-align: left;
  padding-bottom: 5px;
  margin-bottom: 5px;
  position: absolute;

}*/
/*#nav {
  text-align: right;
}*/
</style>

