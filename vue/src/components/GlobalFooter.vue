<template>
    <body>
      <div id="footer">
        <img class="footer-logo" src="../assets/crossLogo.png" />
        <img class="social-media" style="width: 28px height: auto;" src="../assets/instagram.png" />
        <img class="social-media"  src="../assets/facebook.png" />
    </div>
    
  </body>
  </template>
  
  <style>
  
  
  #footer {
    display: flex;
    align-items: baseline;
    flex-direction: row-reverse;
  }
  
  .footer-logo {
    width: 10%;
    opacity: 0.2;
  }

  .social-media {
    width: 34px;
    height: auto;

  }

  a {
    text-decoration: none;
    color: #614BC3;
  }
  a.active {
    color: #33BBC5;
  }

</style>  
