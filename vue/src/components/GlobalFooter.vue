<template>
    <body>
      <div id="footer">
        <img class="footer-logo" src="../assets/crossLogo.png" />
      </div>
      <div class="follow-pf">Follow Patient First</div>
      <div>  
        <img class="social-media" src="../assets/PF-facebook.png"/>
        <img class="social-media"  src="../assets/PF-instagram.png" />
        <img class="social-media" src="../assets/PF-linkedin.png" />
    </div>
    
  </body>
  </template>
  
  <style>
  
  
  #footer {
    display: flex;
    flex-direction: row-reverse;
    margin-top: 10%;
  }

  .follow-pf{
    font-size: small;
  }
  
  .footer-logo {
    position: absolute;
    width: 60px;
    opacity: 0.2;
  }

  .social-media {
    margin-bottom: 10px;
    width: 55px;
    height: auto;
      
  }
  .social-media:hover {
    color: #33BBC5;
  }

  

</style>  
