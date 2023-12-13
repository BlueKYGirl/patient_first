<template>
    <div>
        <global-header />
    </div>
    <body>

        <h1>Reviews</h1>
        <div class="review">
        <img class="review-star-five" src="../assets/5star.png" />
            <p1 class="review-title">Dr. LovesChachi is awesome!</p1>
            <p2>"He is caring, listens to my concerns, and 
                always pleasant. Dr. Chachi's nursing staff is equally awesome
                and full of friendly faces!"</p2>
                <p3>- Patient of Dr. LovesChachi</p3>
        </div>

        <div class="review">
            <img style="margin-top: 5%;" src="../assets/4star.png" />
            <p1 class="review-title" style="margin-top: 5%;"> Perfect as always!</p1>
            <p2>"Dr. Patel has great bed side manner and a soft touch.
                I was able to get in and out in a timely manner. It is 
                always a pleasant experience."</p2>
                <p3>- Patient of Dr. Patel</p3>
        </div>

        <div class="review">
            <img style="margin-top: 5%;" src="../assets/4star.png" />
            <p1 class="review-title" style="margin-top: 5%;"> AMAZING office!</p1>
            <p2>"Overall, I had a pleasant experience. The receptionist, nursing staff, and Doctor
                were all very kind. Office was very clean and organized."</p2>
                <p3>- Patient of Dr. LovesChachi</p3>
        </div>
    </body>
    <div>
        <global-footer />
    </div>
</template>
<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';

export default{
    components: {
        GlobalHeader,
        GlobalFooter
    }
}
</script>


<style>
h1{
    margin-top: 4%;
    text-align: center;
}
.review{
  padding: 2%;
  padding-top: 1%;
  border-width: .5px;
  border-radius: 2%;

  box-shadow: 0 2px 2px #0000001f, inset 0 0 6px #00000052;
  background-color: white;
  margin-top: 5%;
  margin-left: 15%;
  margin-right: 15%;
}

.review-title{
    display: flex;
    flex-direction: column;
    font-size: large;
    font-weight: bold;
    margin-left: 5%;
    margin-right: 5%;
}

p2{
    display: flex;
    flex-wrap: wrap;
    margin-top: 1%;
    margin-left: 7%;
    margin-right: 7%;
}

p3{
    font-style: italic;
    display: flex;
    justify-content: flex-end;
    margin-right: 2%;
    margin-top: 1%;
}
</style>