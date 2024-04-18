<template>
    <div class="container-fluid">
      <div class="row naslov">
        <div class="col-4">
          <div >
            <p>Slatki zalogaj</p>
          </div>
        </div>
      </div>
      <div class="row" style="background-color: rgb(81, 81, 81);
">
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
      <div class="row" style="display: flex; flex-direction: row;align-items: center; background-color: rgb(230, 230, 230);">
       
        <div class="col-md-12" style="display: flex; justify-content: center; align-items: center;">
          <div class="main">
          
            <table cellpadding="15px">
              <tr>
                <td>
                  <h2>Novi proizvod</h2>
                </td>
              </tr>
              <tr>
                <td><input type="text" placeholder="Naziv" v-model="naziv"></td>
              </tr>
              <tr>
                <td> <textarea placeholder="Opis" cols="50" rows="15" v-model="opis"></textarea> </td>
              </tr>
              <tr>
                <td> <textarea placeholder="Sastav" cols="50" rows="15" v-model="sastav"></textarea> </td>
              </tr>
              <tr>
                <td><input type="number" placeholder="Cena" v-model="cena"></td>
              </tr>
              <tr>
                <td style="width:100%;">
                <div style="display: flex; justify-content: space-evenly; align-items: center;">
                    <div>
                        <label style="font-size: 20px;">Kolač &nbsp;</label>
                        <input type="radio" name="tip" value="k" v-model="tip">
                    </div>
                    <div>
                        <label style="font-size: 20px;">Torta  &nbsp</label>
                        <input type="radio" name="tip" value="t"  v-model="tip">
                    </div>
                </div>
                </td>

              </tr>
              <tr style="font-size: 20px;">
                <td>Promocija &nbsp;<input type="checkbox" v-model="ch"></td>
               
              </tr>

              <tr>
                <td>

                    <img  v-bind:src="this.trenutnaSlika" style="max-width: 400px; max-height: 400px; border-radius: 5%; filter: blur(0px);" />
                    <br>
                    <button @click="prikaziSledecuSliku">Naredna slika</button>

                </td>
              </tr>
              <tr style="border-top: solid black 5px;border-bottom: solid black 5px;">
                <td><button @click="dodaj">Dodaj</button></td>
              </tr>
            </table>
           
          </div>
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
  .container {
    position: relative;
  
  }
 
  
  
  .naslov {
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    height: 300px;
    overflow: hidden; 
  }
  
  .naslov::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url('../assets/pozadina.png');
    background-size: cover;
    background-position: center;
    filter: blur(4px);
    z-index: -1; 
  }
  
  .naslov p {
    z-index: 1;
    background-color: white;
    color: black;
    font-family: "Lucida Handwriting", "Courier New", monospace;
    font-size: 50px;
    font-weight: bold;
    text-align: center;
    padding: 20px;
    border-radius: 5px;
  }

  .menu{
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    font-family: 'Times New Roman', Times, serif;
    font-size: 30px;
    width: 100%;
    background-color: rgb(81, 81, 81);
    color: white;
    padding-top: 10px;
    padding-bottom: 10px;
  }

  .menu a{
    text-decoration: none;
    color: white;

  }
  .menu a:hover{
    color: rgb(255, 67, 67);

    
  }

  .footer{

    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    font-size: 20px;
    background-color: rgb(81, 81, 81);
    color: white;
    padding-top: 20px;

  }

  .footer a{
    text-decoration: none;
    color: white;
    
  }

  .footerItem {
    margin-bottom: 10px;
    display: flex;
    flex-direction: column;
   justify-content: center;
   align-items: left;
}

.footer a:hover{
   color: rgb(255, 67, 67);
    
  }

  input, textarea{
    padding: 10px;
    border-radius: 5%;
  }
  

  .main{
    display: flex;
    flex: row;
    padding-bottom: 20px;
    padding-top: 20px;
    justify-content: space-between;
    align-items: center;
    background-color: rgb(230, 230, 230);
  }


  button{
    font-size: 25px;
    background-color: rgb(0, 0, 0);
    margin-top: 20px;
    border-radius: 5%;
    padding: 15px;
    color: white;
  }


  button:hover{
    font-size: 25px;
    background-color: rgb(255, 67, 67);
    margin-top: 20px;
    border-radius: 5%;
    color: white;
  }

  @media only screen and (max-width: 767px) {
    .naslov p{
    font-size: 20px;
  }
  }
  </style>
  

  
<script>
import proizvodi from '../data/proizvodi.js';
export default{
    name: 'Zaposleni',
    data(){
        return{
        proizvodi: [],
        torte: [
            'torta1.png',
            'torta2.png',
            'torta3.png',
            'torta4.png',
            'torta5.png',
            'torta6.png',
            'torta7.png',
            'torta8.png',
            'torta9.png',
            'torta10.png'
            ],
        kolaci: [
            'kolac1.png',
            'kolac2.png',
            'kolac3.png',
            'kolac4.png',
            'kolac5.png',
            'kolac6.png',
            'kolac7.png',
            'kolac8.png',
            'kolac9.png',
            'kolac10.png'
        ]
        ,
            naziv: '',
            cena: '',
            opis: '',
            sastav: '',
            tip: 't',
            kolacIndeks: 0,
            tortaIndeks: 0,
            trenutnaSlika: '',
            ch: false

        }
    },
    methods: {
        odjava(){
          localStorage.setItem('status', JSON.stringify("-1"));
          localStorage.setItem('korpa', JSON.stringify([]));
          this.$router.push('/prijava'); 
        },
        prikaziSledecuSliku() {
        if (this.tip === 'k') {
            this.kolacIndeks = (this.kolacIndeks + 1) % this.kolaci.length;
            this.trenutnaSlika = require(`@/assets/${this.kolaci[this.kolacIndeks]}`);
        } else if (this.tip === 't') {
            this.tortaIndeks = (this.tortaIndeks + 1) % this.torte.length;
            this.trenutnaSlika = require(`@/assets/${this.torte[this.tortaIndeks]}`);
        }
        },
        zameni(){
            if(this.tip=='k'){
              this.trenutnaSlika = require(`@/assets/${this.kolaci[0]}`);

            }else{
              this.trenutnaSlika = require(`@/assets/${this.torte[0]}`);

            }
        },
        dodaj(){
            if(!this.naziv || !this.opis || this.cena<=0 || !this.sastav){
                alert("Niste uneli sve podatke!");
                return;
            }
            let data= {
                'naziv' : this.naziv,
                'opis' : this.opis,
                'cena' : this.cena,
                'sastav': this.sastav,
                'slika' : this.trenutnaSlika,
                'tip' :this.tip,
                'komentari' : [],
                'promocija': this.ch
                
            }
            this.proizvodi.push(data)
            // Čuvajte ažurirane proizvode u lokalnom skladištu
            localStorage.setItem('proizvodi', JSON.stringify(this.proizvodi));
            alert("Uspesno ste dodali proizvod!");
            this.naziv ='';
            this.opis ='';
            this.cena ='';
            this.sastav ='';
            this.trenutnaSlika = require(`@/assets/${this.torte[0]}`);
            this.tip='t';
        }
  },
  watch: {
    tip: 'zameni',
  },
  created() {
    if(JSON.parse(localStorage.getItem("status")) !=  "0"){
      this.$router.push('/prijava'); 
      return;
    }
    let status=JSON.parse(localStorage.getItem("status") );
    if(status=="-1" || !status){
      this.$router.push('/prijava'); 
      return;
    }

    const storedProizvodi = localStorage.getItem('proizvodi');
    if (storedProizvodi) {
        this.proizvodi = JSON.parse(storedProizvodi);
    } else {
        this.proizvodi = []; 
    }
    this.trenutnaSlika = require(`@/assets/${this.torte[0]}`);
  },
}
</script>