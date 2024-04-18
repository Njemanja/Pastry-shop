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
            <p @click="prikaziObavestenja" class="o" style="display: flex; flex-direction: row;">Obaveštenja &nbsp; <p class="dot" v-if="brojObavestenja>0">{{ brojObavestenja }}</p> </p>
            <a href="#/kupac">Početna strana</a>
            <a href="#/torte">Torte</a>
            <a href="#/kolaci">Kolači</a>
            <a href="#/promocije">Promocije</a>
            <a href="#/korpa">Korpa</a>
            <a href="#/profil">Profil</a>

            <a @click="odjava" href="#/prijava">Odjava</a>

          </div>
        </div>
      </div>
      <div v-if="prikaziListaObavestenja" class="row obavestenja-container">
  <div class="col-12">
    <ul class="obavestenja-lista" style="display: flex; flex-direction: column; right: 0;">
      <li v-for="(obavestenje, index) in obavestenja" :key="index" class="obavestenje-item" :class="{ 'zeleno': obavestenje.tekst[0] === 'P', 'crveno':  obavestenje.tekst[0] === 'O'  }">
        {{ obavestenje.tekst }}
      </li>
    </ul>
  </div>
</div>
      <div class="row" style="padding-top:50px;display: flex; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px; padding-bottom: 50px;">
        <div class="col-12" style="display: flex; flex-direction: column; justify-content: left;">
            <div style="display: flex; justify-content: space-evenly;">
               <button @click="sort1" style="font-size: 15px;">Sortiraj po ceni (prvo veća cena)</button>
               <button  @click="sort2" style="font-size: 15px;">Sortiraj po ceni (prvo niža cena)</button>
               <input type="text" placeholder="Naziv torte" style="width: 20%;"
               v-on:input="ime" v-model="tekst">
               
            </div>
        </div>
      </div>

      <div class="row" style="display: flex; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
      <div v-for="torta in prikazaniProizvodi" :key="torta.naziv" class="torta col-md-3 col-sm-12">
        <div class="torta-content">
          <img :src="torta.slika" alt="Slika torte" class="blurable">
          <div class="overlay">
            <h3>{{ torta.naziv }}</h3>
            <a href="#/jedanProizvod" @click="jedanProizvod(torta)" class="show-details">Prikazi više detalja</a>
          </div>
        </div>
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
      <div class="row" style="display: flex; justify-content: center;  background-color: rgb(230, 230, 230);">
      <div v-for="stranica in brojeviStranica" :key="stranica"  style="padding: 20px;font-size: 30px;">
        <b>        <p @click="postaviStranicu(stranica)" :class="{ active: stranica === trenutnaStranica }">{{ stranica }}</p>
</b>
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

<style>
.row img:hover {
  filter: blur(8px);
  transition: filter 0.5s;
  width: 100%;
}

.torta-content {
  position: relative;
  overflow: hidden;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(255, 255, 255, 0.8);
  text-align: center;
  opacity: 0;
  transition: opacity 0.5s;
  padding-top: 20%;
}

.overlay h3,
.overlay p,
.overlay a {
  margin: 10px;
}

.show-details {
  text-decoration: none;
  color: black;
  cursor: pointer;
  
}

.show-details:hover {
    color: black;
  text-decoration: none;
  border-bottom: solid rgb(255, 67, 67) 5px;
}

.torta:hover .overlay {
  opacity: 1;
}

</style>

  
<script>

export default{
    name: 'Torte',
    data(){
        return{
            proizvodi: [],
            tekst: '',
            obavestenja: [],  
            prikaziListaObavestenja: false,
            brojObavestenja: 0,
            trenutnaStranica: 1,
            proizvodiPoStranici: 3,
        }
    },
    computed: {
    ukupnoStranica() {
      return Math.ceil(this.proizvodi.length / this.proizvodiPoStranici);
    },
    brojeviStranica() {
      return Array.from({ length: this.ukupnoStranica }, (_, i) => i + 1);
    },
    prikazaniProizvodi() {
      const pocetak = (this.trenutnaStranica - 1) * this.proizvodiPoStranici;
      return this.proizvodi.slice(pocetak, pocetak + this.proizvodiPoStranici);
    },
  },
    methods: {
      postaviStranicu(stranica) {
      this.trenutnaStranica = stranica;
      const pocetak = (this.trenutnaStranica - 1) * this.proizvodiPoStranici;
        return this.proizvodi.slice(pocetak, pocetak + this.proizvodiPoStranici);
    },
      odjava(){
        localStorage.setItem('status', JSON.stringify("-1"));
        localStorage.setItem('korpa', JSON.stringify([]));
        this.$router.push('/prijava'); 
        },
        prikaziObavestenja() {
     
     this.prikaziListaObavestenja = !this.prikaziListaObavestenja;
     let n;
     const s1 = localStorage.getItem('narudzbine');
     if (s1) {
         n = JSON.parse(s1);
     } else {
         n = []; 
     }
     for(let i=0;i<n.length; i++){
       if(n[i].seen==0 && n[i].korisnickoIme== JSON.parse(localStorage.getItem("kIme"))){
           n[i].seen=1;
       }
     }
     for(let i=0;i<this.narudzbine.length; i++){
       if(this.narudzbine[i].seen==0){
         this.narudzbine[i].seen=1;
       }
     }
     localStorage.setItem("narudzbine", JSON.stringify(n));
     this.brojObavestenja=0;

   },
        jedanProizvod(torta){
           localStorage.setItem("jedanProizvod", JSON.stringify(torta));  
        },
        sort2(){
            this.proizvodi.sort(function(a,b){
              return a.cena - b.cena;
            })
        },sort1(){
          this.proizvodi.sort(function(a,b){
              return b.cena - a.cena;
            })
        },
        ime(){
          if(this.tekst==''){
            this.proizvodi = JSON.parse(localStorage.getItem('proizvodi'))
            this.proizvodi = this.proizvodi.filter(proizvod => proizvod.tip === 't');

          }else{
            this.proizvodi = this.proizvodi.filter(proizvod => proizvod.naziv.toLowerCase().includes(this.tekst.toLocaleLowerCase()));

          }

        }
    
  },
  created() {
    if(JSON.parse(localStorage.getItem("status")) != "1"){
      this.$router.push('/prijava'); 
    }
    const s = localStorage.getItem('proizvodi');
    if (s) {
        this.proizvodi = JSON.parse(s);
    } else {
        this.proizvodi = []; 
    }
    this.proizvodi = this.proizvodi.filter(proizvod => proizvod.tip === 't');
    const s1 = localStorage.getItem('narudzbine');
    if (s1) {
        this.narudzbine = JSON.parse(s1);
    } else {
        this.narudzbine = []; 
    }
    this.brojObavestenja=0;
    this.narudzbine=this.narudzbine.filter(n => n.korisnickoIme == JSON.parse(localStorage.getItem("kIme")));
    for(let i=0;i<this.narudzbine.length; i++){
      if(this.narudzbine[i].seen==0){
       this.brojObavestenja++;
      }
       let tekst="";
       if(this.narudzbine[i].status==-1){
          tekst= "Odbijena je narudzbina za "+this.narudzbine[i].naziv+".";
       }else if(this.narudzbine[i].status==1){
          tekst= "Prihvaćena je narudzbina za "+this.narudzbine[i].naziv+".";
       }
       if(this.narudzbine[i].status!=0){
        this.obavestenja.push({
          tekst: tekst
       })
       }
    }
    //this.obavestenja.reverse();

    this.korpa=  JSON.parse(localStorage.getItem('korpa'));
    if(!this.korpa){
        this.korpa=[];
    }
  },
}
</script>