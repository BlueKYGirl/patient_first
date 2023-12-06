<template>
    <div id="nav">
      
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
    <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
  </div>
  <img class="logo" src="../assets/smallTransparent.png" style="float: left; margin-right: 15px;"/>
</template>

<style>
.logo {
  display: block;
  width: 10%;
  text-align: left;
  padding-bottom: 5px;
  margin-bottom: 5px;
  position: fixed;

}
#nav {
  text-align: right;
}
</style>

