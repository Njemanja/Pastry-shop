<template>
    <div class="container-fluid">
        <div class="row naslov">
        <div class="col-4">
          <div >
            <p>Slatki zalogaj</p>
          </div>
        </div>
      </div>
      <div class="row" style="background-color: rgb(81, 81, 81);">
        <div class="col-12">
            <div class="menu">
            <a href="#/zaposleni">Dodaj proizvod</a>
            <a href="#/narudzbine">Porudžbine</a>
            <a href="#/sviProizvodi">Svi proizvodi</a>
            <a href="#/profil">Profil</a>

            <a @click="odjava" href="#/prijava">Odjava</a>
          </div>
        </div>
      </div>
      <div class="row" style="display: flex; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
      <div v-for="(torta, index) in proizvodi" :key="torta.naziv" class="torta">
        <div class="torta-content">
          <img :src="torta.slika" alt="Slika torte" class="blurable">
          <div class="overlay">
            <h3>{{ torta.naziv }}</h3>
            <a href="#/jedanProizvod1" @click="jedanProizvod1(torta)" class="show-details">Prikazi više detalja</a>
          </div>
        </div>
        <i @click="ukloniIzProizvoda(index)" class="fa fa-trash" aria-hidden="true" style="font-size: 50px; margin-bottom: 20px;"></i>

      </div>

    </div>
     
    <div class="row" style="display: flex;flex-direction: column; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
          <div class="col-sm-12">
            &nbsp;
          </div>
          <div class="col-sm-12">
            &nbsp;
          </div>
          <div class="col-sm-12">
            &nbsp;
          </div>
          <div class="col-sm-12">
            &nbsp;
          </div>
          <div class="col-sm-12">
            &nbsp;
          </div>
          <div class="col-sm-12">
            &nbsp;
          </div>
     
      </div>
      <div class="row footer">
        <div class="col-12">
          <div>
            <div class="footerItem">
            <i class="fa fa-phone"></i> &nbsp; Kontakt telefon - 0657896547
        </div>
        <div class="footerItem">
           <p>  <i class="fa fa-clock-o"></i> &nbsp;  Radno vreme <hr width="10%" color="white">
            Radni dan 08-20h
            <br>
            Subota 11-19h
            <br>
            Nedelja slobodan dan
        </p>  
        
        </div>
        <div class="footerItem">
           <a href="www.instagram.com" target="_blank"> <i class="fa fa-instagram"></i>&nbsp; Instagram</a>
        </div>
        <div class="footerItem">
          <a href="www.facebook.com" target="_blank">  <i class="fa fa-facebook"></i>&nbsp; Facebook</a>
        </div>
       
          </div>
        </div>
      </div>
    </div>
  </template>



  
<script>

export default{
    name: 'Torte',
    data(){
        return{
            proizvodi: []
        }
    },
    methods: {
    ukloniIzProizvoda(index) {
        this.proizvodi.splice(index, 1);
        localStorage.setItem('proizvodi', JSON.stringify(this.proizvodi));
    },
      odjava(){
        localStorage.setItem('status', JSON.stringify("-1"));
        localStorage.setItem('korpa', JSON.stringify([]));
        this.$router.push('/prijava'); 
        },
        jedanProizvod1(torta){
           localStorage.setItem("jedanProizvod", JSON.stringify(torta));
           
        }
    
  },
  created() {
    if(JSON.parse(localStorage.getItem("status")) !=  "0"){
      this.$router.push('/prijava'); 
      return;
    }
    const s = localStorage.getItem('proizvodi');
    if (s) {
        this.proizvodi = JSON.parse(s);
    } else {
        this.proizvodi = []; 
    }
  

  },
}
</script>