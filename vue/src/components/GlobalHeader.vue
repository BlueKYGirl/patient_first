<template>
  <body>
    <div id="nav">
      <img class="logo" src="../assets/smallTransparent.png" style="float: left; margin-right: 15px;"/>
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp; |
    <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
  </div>
</body>
</template>

<style>
.logo {
  display: block;
  width: 10%;
  text-align: left;
  padding-bottom: 5px;
  margin-bottom: 5px;
  position: absolute;

}
#nav {
  text-align: right;
}
</style>

