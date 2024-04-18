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

    <div class="row" style="display: flex;flex-direction: row; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
       <div style="display: flex; flex-direction: column;">
          <h1 style="margin-top: 20px;    font-family: 'Lucida Handwriting', 'Courier New', monospace;">{{ proizvod.naziv }}</h1>
          <img :src="proizvod.slika" alt="Slika torte" style="height: 500px;width: 500px;   filter: blur(0px);
">
          <b>
          <label style="font-size: 40px;">
            {{ proizvod.cena }} dinara
            <i @click="klikniNaSrce" class="fa fa-heart" :class="{ 'crveno-srce': srce, 'sivo-srce': !srce }"></i>
          </label>
        </b>
        </div>
      

    
    
    </div>
    <div class="row" style="display: flex; flex-direction: row; justify-content: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
  <div style="display: flex; flex-direction: column; text-align: left;">
    <b><h2 style="color: #f44336;">Opis</h2></b>
    <p style="border: solid black 5px; word-wrap: break-word; padding: 10px; max-width: 600px;">{{ proizvod.opis }}</p>
    <b><h2>Sastojci</h2></b>
    <p style="border: solid #f44336 5px; word-wrap: break-word; padding: 10px; max-width: 600px;">{{ proizvod.sastav }}</p>
  </div>
</div>

    
    <div class="row" style="    background-color: rgb(230, 230, 230);
">
  <div class="col-12" >
    <div class="debeli-hr"></div>
    <h2 style="text-align: center; font-weight: bold; margin-top: 40px;">Komentari</h2>
    
    <div v-for="(komentar, index) in visibleComments" :key="index" class="komentar" >
      <div class="ime-datum">
        <b>{{ komentar.korisnickoIme }} - {{ formatDate(komentar.datum) }}</b>
      </div>
      <div class="tekst-komentara">
        <p>{{ komentar.tekstKomentara }}</p>
      </div>
    </div>

    <div style="margin-top: 20px;">
      <input v-model="noviKomentar" placeholder="Unesite komentar" style="padding: 5px; width: 30%;">
      <button @click="dodajKomentar" class="dodaj" >Dodaj komentar</button>
    </div>
    <button @click="prikaziJos" class="vise" >Prikaži više</button>
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
.debeli-hr {
    border: 2px solid black; /* Debljina i boja linije */
  }
.komentar {
  width: 50%;
  padding-left: 20px;
  margin: 0 auto; /* Dodaj marginu kako bi komentari bili centrirani */
  text-align: left; /* Postavi tekst unutar komentara uz levu ivicu */
  padding-bottom: 10px;
  background-color: rgb(81, 81, 81);
  color: white;
  margin-bottom: 2px;
  word-wrap: break-word;
  border-radius: 5%;
}

.ime-datum {
  text-align: right;
}

.ime-datum b {
  margin-right: 10px;
}

/* Dodaj boju pozadine na svaki drugi komentar (striped efekat) */
.komentar:nth-child(even) {
  color: black;
  background-color:    rgb(255, 67, 67);
}
.dodaj{
  margin-left: 10%;
  font-size: 15px;
}

.dodaj:hover{
  font-size: 15px;
}


.vise{
 
  font-size: 15px;
  margin-bottom: 40px;
}

.vise:hover{
  font-size: 15px;
  background-color: #cacaca;
}


.row img:hover {
  filter: blur(0px);
  width: 100%;
}

.fa-heart:hover{
  color: #f44336;
}

.crveno-srce{
  color: #f44336;
}

.sivo-srce{
  color: rgb(81,81,81);
}
</style>



<script>

export default{
  name: 'jedanProizvod',
  data(){
      return{
          proizvod: {
            naziv: "",
            obavestenja: [],  
            prikaziListaObavestenja: false,
            brojObavestenja: 0
        
          }
          ,
          srce: false,
          korpa: '',
          visibleComments: [],
          commentsToShow: 3,
          noviKomentar: '',
          obavestenja: [],  
          prikaziListaObavestenja: false,
          brojObavestenja: 0

      }
  },
  methods: {
    odjava(){
        localStorage.setItem('status', JSON.stringify("-1"));
        localStorage.setItem('korpa', JSON.stringify([]));
        this.$router.push('/prijava'); 
      },
      
      prikaziJos() {
        if (this.proizvod && this.proizvod.komentari) {
          const allComments = this.proizvod.komentari;
          allComments.sort((a, b) => {
            return new Date(b.datum) - new Date(a.datum);
          });

          const startIndex = this.visibleComments.length;
          const endIndex = startIndex + this.commentsToShow;
          const remainingComments = allComments.length - this.visibleComments.length;
          const nextBatchSize = Math.min(this.commentsToShow, remainingComments);

          if (nextBatchSize > 0) {
            const nextComments = allComments.slice(startIndex, startIndex + nextBatchSize);
            this.visibleComments = [...this.visibleComments, ...nextComments];
          }
        }
      },

      formatDate(dateString) {
        const options = { day: '2-digit', month: '2-digit', year: 'numeric', hour: '2-digit', minute: '2-digit' };
        const date = new Date(dateString);
        return date.toLocaleDateString('en-GB', options);
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
      dodajKomentar() {
        if (this.noviKomentar.trim() !== '') {
          const noviDatum = new Date().toISOString();
          const noviKomentarObj = {
            korisnickoIme: JSON.parse(localStorage.getItem("kIme")), 
            datum: noviDatum,
            tekstKomentara: this.noviKomentar,
          };
          this.proizvod.komentari.push(noviKomentarObj);
          let proizvodi=JSON.parse(localStorage.getItem("proizvodi"))
          for(let i=0; i<proizvodi.length; i++){
            if(proizvodi[i].naziv ==this.proizvod.naziv &&
              proizvodi[i].cena ==this.proizvod.cena &&
              proizvodi[i].slika ==this.proizvod.slika &&
              proizvodi[i].opis ==this.proizvod.opis &&
              proizvodi[i].sastav ==this.proizvod.sastav 

            ){
              proizvodi.splice(i, 1);
            }
          }
          proizvodi.push(this.proizvod);
          localStorage.setItem("jedanProizvod", JSON.stringify(this.proizvod));
          localStorage.setItem("proizvodi", JSON.stringify(proizvodi));

          this.noviKomentar = '';
          if (this.proizvod && this.proizvod.komentari) {
          const allComments = this.proizvod.komentari;
          allComments.sort((a, b) => {
            return new Date(b.datum) - new Date(a.datum);
          });

          const nextComments = allComments.splice(0,1);
          this.visibleComments = [ ...nextComments, ...this.visibleComments];
        }
      }
    },
      klikniNaSrce() {
        this.srce = !this.srce;

        if (this.srce) {
          this.korpa.push(this.proizvod);
        } else {
          const index = this.korpa.findIndex(item => (

          item.naziv ==this.proizvod.naziv &&
          item.cena ==this.proizvod.cena &&
          item.slika ==this.proizvod.slika &&
          item.opis ==this.proizvod.opis &&
          item.sastav ==this.proizvod.sastav 

          ));
          if (index !== -1) {
            this.korpa.splice(index, 1);
          }
      }
      localStorage.setItem('korpa', JSON.stringify(this.korpa));
}

  
},
created() {
  if(JSON.parse(localStorage.getItem("status")) !=  "1"){
    this.$router.push('/prijava'); 
    return;
  }


  this.korpa = JSON.parse(localStorage.getItem('korpa')) || [];
  this.proizvod = JSON.parse(localStorage.getItem('jedanProizvod')) || {};

  for (let i = 0; i < this.korpa.length; i++) {
    if (
      this.korpa[i].naziv == this.proizvod.naziv &&
      this.korpa[i].cena == this.proizvod.cena &&
      this.korpa[i].slika == this.proizvod.slika &&
      this.korpa[i].opis == this.proizvod.opis &&
      this.korpa[i].sastav == this.proizvod.sastav
    ) {
      this.srce = true;
    }
  }

  if (this.proizvod.komentari) {
    this.proizvod.komentari.sort((a, b) => {
      return new Date(b.datum) - new Date(a.datum);
    });
    this.visibleComments = this.proizvod.komentari.slice(0, this.commentsToShow);
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