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

      
      <div class="row" style="display: flex; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
        
        <div v-for="(torta, index) in prikazaniProizvodi" :key="torta.naziv" class="torta col-md-3 col-sm-12">
          <div class="torta-content">
            <img :src="torta.slika" alt="Slika torte" class="blurable">
            <div class="overlay">
              <h3>{{ torta.naziv }}</h3>
              <a href="#/jedanProizvod" @click="jedanProizvod(torta)" class="show-details">Prikazi više detalja</a>
            </div>
          </div>
          <i @click="ukloniIzKorpe(index)" class="fa fa-trash" aria-hidden="true" style="font-size: 50px; margin-bottom: 20px;"></i>
          <div>
            <i @click="smanjiBrojProizvoda(index)" class="fa fa-minus" aria-hidden="true" style="font-size: 24px; margin-bottom: 5px;"></i>
            {{ torta.brojProizvoda ? torta.brojProizvoda  : torta.brojProizvoda = 1 }}
            <i @click="povecajBrojProizvoda(index)" class="fa fa-plus" aria-hidden="true" style="font-size: 24px; margin-bottom: 5px;"></i>
          </div>
        </div>



      </div>
      <div class="row" style="display: flex; justify-content: center;  background-color: rgb(230, 230, 230);">
      <div v-for="stranica in brojeviStranica" :key="stranica"  style="padding: 20px;font-size: 30px;">
        <b>        <p @click="postaviStranicu(stranica)" :class="{ active: stranica === trenutnaStranica }">{{ stranica }}</p>
</b>
      </div>
    </div>



      <div v-if="this.korpa.length > 0 " class="row" style="display: flex; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
        <div class="col-12">
            <button @click="naruci()">Poruci</button>
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

<style>

.obavestenja-container {
  position: absolute;
  z-index: 1;
  overflow-y: auto; 
  max-height: 150px; 
}

.obavestenja-lista {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.obavestenja-lista .obavestenje-item {
  border-bottom: 1px solid #ffffff;
  width: 100%;
  margin-right: 10px; 
  color: white;
}

.obavestenja-lista li {
  padding: 10px;
  border-bottom: 1px solid #ccc;
}



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
.dot {
  height: 40px;
  width: 40px;
  border-radius: 50%;
  display: inline-block;
  background-color: red;
}
@media only screen and (max-width: 767px) {

  .dot {
    height: 30px;
    width: 30px;
    
    display: inline-block;
    background-color: red;
  }


}
</style>

  
<script>

export default{
    name: 'Torte',
    data(){
        return{
            proizvodi: [],
            korpa: [],
            obavestenja: [],  
            prikaziListaObavestenja: false,
            brojObavestenja: 0,
            trenutnaStranica: 1,
            proizvodiPoStranici: 3,
        }
    },
    computed: {
      ukupnoStranica() {
        return Math.ceil(this.korpa.length / this.proizvodiPoStranici);
      },
      brojeviStranica() {
        return Array.from({ length: this.ukupnoStranica }, (_, i) => i + 1);
      },
      prikazaniProizvodi() {
        const pocetak = (this.trenutnaStranica - 1) * this.proizvodiPoStranici;
        return this.korpa.slice(pocetak, pocetak + this.proizvodiPoStranici);
      },
    },
    methods: {
      postaviStranicu(stranica) {
        this.trenutnaStranica = stranica;
      },
      odjava(){
        localStorage.setItem('status', JSON.stringify("-1"));
        localStorage.setItem('korpa', JSON.stringify([]));
        this.$router.push('/prijava'); 
        },
        jedanProizvod(torta){
           localStorage.setItem("jedanProizvod", JSON.stringify(torta));
        },
        ukloniIzKorpe(index) {
          this.korpa.splice((this.trenutnaStranica-1)*3+index, 1);
          localStorage.setItem('korpa', JSON.stringify(this.korpa));
        },
        smanjiBrojProizvoda(index) {
          if (this.korpa[(this.trenutnaStranica-1)*3+index].brojProizvoda && this.korpa[(this.trenutnaStranica-1)*3+index].brojProizvoda > 1) {
            this.korpa[(this.trenutnaStranica-1)*3+index].brojProizvoda--;
          }
        },
        povecajBrojProizvoda(index) {
          this.korpa[(this.trenutnaStranica-1)*3+index].brojProizvoda = (this.korpa[(this.trenutnaStranica-1)*3+index].brojProizvoda || 0) + 1;
        },naruci(){
            let narudzbine=JSON.parse(localStorage.getItem('narudzbine'));
            if(!narudzbine){
              narudzbine=[];
            }
            for(let i=0;i<this.korpa.length;i++){
              let korisnici = JSON.parse(localStorage.getItem("korisnici"));
              let ime=JSON.parse(localStorage.getItem('kIme'));
              korisnici=korisnici.filter(k=> k.korisnickoIme==ime);
              let korisnik=korisnici[0];



              let data={
                'kolicina' : this.korpa[i].brojProizvoda,
                'korisnickoIme':  JSON.parse(localStorage.getItem("kIme")),
                'broj' :  korisnik.telefon,
                'naziv' : this.korpa[i].naziv,
                'status': 0,
                'email' : korisnik.email,
                'adresa' : korisnik.adresa,
                'datum': new Date(),
                'seen' : 0
              }
             
              narudzbine.push(data);
            }
            localStorage.setItem("narudzbine", JSON.stringify(narudzbine))
            this.korpa=[];
            alert("Uspesno ste porucili proizvode.")
            localStorage.setItem("korpa", JSON.stringify([]));
          

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

    }
    
  },
  created() {
    if(JSON.parse(localStorage.getItem("status")) !=  "1"){
      this.$router.push('/prijava'); 
      return;
    }
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