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

      <div class="row" style="display: flex; flex-direction: row;align-items: center; background-color: rgb(230, 230, 230);">
        <div class="col-md-6" style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
            <div class="blurred-image">
                    <img src="../assets/torta3.png" class="blurred">
                    <div class="image-text">
                        <p @click="torte">Torte</p>
                    </div>
            </div>
            <div class="blurred-image">
                    <img src="../assets/kolac4.png" class="blurred">
                    <div class="image-text">
                        <p  @click="kolaci">Kolači</p>
                    </div>
            </div>

            <div class="blurred-image">
                    <img src="../assets/kolac6.png" class="blurred">
                    <div class="image-text">
                        <p  @click="promocije" class="">Promocije</p>
                    </div>
            </div>
        </div>
        <div class="col-md-6" style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
          <div class="main2">
             <p>
                
                Dobrodošli u čarobni svet ukusa i slasti - Prodavnica Slatki Zalogaj!<br> Naša poslastičarnica pruža vrhunski doživljaj za ljubitelje torti i kolača. Slatki Zalogaj se ponosi bogatom ponudom ručno izrađenih torti, pažljivo birajući najkvalitetnije sastojke za savršen ukus.<br><br>
        Nezavisno od vaših preferencija - bilo da volite klasične čokoladne torte, voćne torte s svežim voćem ili sofisticirane kreativne kreacije, u našoj prodavnici ćete pronaći nešto posebno. Pored torti, u Slatkom Zalogaju možete uživati u raznolikim kolačima - od tradicionalnih poslastica do modernih inovacija.<br><br>
Posetite nas i dozvolite nam da vas odvedemo na put slatkih zadovoljstava. U Prodavnici Slatki Zalogaj ne samo da prodajemo torte i kolače, već stvaramo nezaboravne trenutke slasti koje ćete deliti sa svojim najdražima.
             </p>     
          </div>
          <div class="row footer" style="border-radius: 5%;">
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
       
      </div>
      <div class="row" style="background-color: rgb(230, 230, 230);">
        
      <div class="col-md-12" style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
        

        <h1 class='s'>Promocije</h1>
      </div>  
    
    </div>
    <div class="row" style="background-color: rgb(230, 230, 230);">
      <div class="col-md-4" style="display: flex; justify-content: center; align-items: center; flex-direction: column; ">
            <div >
                    <img :src="this.slika1" style="filter: blur(0px); height: 70%; border-radius: 5%;">
                    <div style="width: 100%; word-wrap: break-word;font-size: 20px;" >
                        <b><p >{{ this.tekst1 }}</p></b>
                    </div>
            </div>
      </div>
      <div class="col-md-4" style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
            <div >
                    <img :src="this.slika2" style="filter: blur(0px);  height: 70%;border-radius: 5%;">
                    <div style="width: 100%; word-wrap: break-word;font-size: 20px;" >
                       <b> <p >{{ this.tekst2 }}</p></b>
                    </div>
            </div>
      </div>
      <div class="col-md-4" style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
            <div >
                    <img :src="this.slika3" style="filter: blur(0px);  height: 70%;border-radius: 5%;">
                    <div style="width: 100%; word-wrap: break-word; font-size: 20px;" >
                        <b> <p >{{ this.tekst3 }}</p></b>
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
.zeleno{
  background: rgb(45, 188, 23);
}
.crveno{
  background: rgb(185, 20, 20);
}

.obavestenja-lista li {
  padding: 10px;
  border-bottom: 1px solid #ccc;
}


.main2{
    text-align: left;
}
.main2 p{

    background-color: rgb(81, 81, 81);
    color: white;
    border-radius: 5%;
    padding: 20px;
    font-size: 20px;
    margin: 20px;
}
.s{
  font-family: "Lucida Handwriting", "Courier New", monospace;
  padding-top: 100px;

}
.row img{
   
    margin-top: 20px;
    margin-bottom: 20px;

}

.blurred-image {
    position: relative;
}

.blurred {
    filter: blur(8px); 
    height: 100%;
    width: 100%;
}
@media only screen and (max-width: 767px) {
  .naslov p{
    font-size: 30px; 
  }
  .o {
    font-size: 20px;
  }
  .dot {
    height: 5px;
    width: 20px;
    
    display: inline-block;
    background-color: red;
  }

  .menu a {
    font-size: 20px; 
  }
}

.naslov p{
  background-color: rgb(183, 183, 183);
  color: rgb(255, 67, 67);
  border-radius: 20%;
}


.image-text {
    position: absolute;
    top: 50%;
    left: 50%;
    font-family: "Lucida Handwriting", "Courier New", monospace;

    transform: translate(-50%, -50%);
    text-align: center;
    color: white;
    font-size: 30px;
}
.image-text:hover {
    color: rgb(81,81,81);
}

</style>

  
<script>
export default{
    name: 'Kupac',
    data(){
        return{
          proizvodi: [],
          slika1: '',
          tekst1: '',
          slika2: '',
          tekst2: '',
          slika3: '',
          tekst3: '',
          index1:0,
          index2:1,
          index3: 2,
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
        promeniProizvode() {
          try {
            this.slika1=this.proizvodi[this.index1].slika;
            this.slika2=this.proizvodi[this.index2].slika;
            this.slika3=this.proizvodi[this.index3].slika;
            this.tekst1=this.proizvodi[this.index1].opis;
            this.tekst2=this.proizvodi[this.index2].opis;
            this.tekst3=this.proizvodi[this.index3].opis;
            this.index1= (this.index1+1)%this.proizvodi.length;
            this.index2= (this.index2+1)%this.proizvodi.length;
            this.index3= (this.index3+1)%this.proizvodi.length;
            
          } catch (error) {
            
          }
          

        },
        torte(){
            this.$router.push('/torte'); 
        },
        promocije(){
            this.$router.push('/promocije'); 

        },
        kolaci(){
            this.$router.push('/kolaci'); 

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
    ,
      
  },
  created() {
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
    if(JSON.parse(localStorage.getItem("status")) !=  "1"){
      this.$router.push('/prijava'); 
      return;
    }

    let status=JSON.parse(localStorage.getItem("status") );
    if(status=="-1" || !status){
      this.$router.push('/prijava'); 
      return;
    }
    const s = localStorage.getItem('proizvodi');
    if (s) {
        this.proizvodi = JSON.parse(s);
    } else {
        this.proizvodi = []; 
    }
    this.proizvodi = this.proizvodi.filter(proizvod => proizvod.promocija === true);
    this.promeniProizvode();
    setInterval(this.promeniProizvode, 7000);
  },
}
</script>