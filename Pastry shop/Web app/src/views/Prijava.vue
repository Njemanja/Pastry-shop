<template>
    <div class="container-fluid">
      <div class="row naslov">
        <div class="col-4">
          <div >
            <p>Slatki zalogaj</p>
          </div>
        </div>
      </div>
     
      <div class="row" style="display: flex; flex-direction: row;align-items: center; background-color: rgb(230, 230, 230);">
       
        <div class="col-md-12" style="display: flex; justify-content: center; align-items: center;">
          <div class="main">
          
            <table cellpadding="15px">
              <tr>
                <td>
                  <h1>Prijava</h1>
                </td>
              </tr>
              <tr>
                <td><input type="text" placeholder="Naziv" v-model="naziv"></td>
              </tr>
              
              <tr>
                <td><input type="password" placeholder="Lozinka" v-model="lozinka"></td>
              </tr>
             
              
              <tr style="border-top: solid black 5px;">
                <td><button @click="prijava">Prijavi se</button></td>
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
    justify-content: center;
    padding-bottom: 20px;
    padding-top: 20px;
    background-color: rgb(230, 230, 230);
  }


  button{
    font-size: 20px;
    background-color: rgb(0, 0, 0);
    margin-top: 20px;
    border-radius: 5%;
    padding: 15px;
    color: white;
  }


  button:hover{
    font-size: 20px;
    background-color: rgb(255, 67, 67);
    margin-top: 20px;
    border-radius: 5%;
    color: white;
  }
  </style>
  

  
<script>
import proizvodi from '@/data/proizvodi';
import korisnici from '../data/korisnici.js';

export default{
    name: 'Prijava',
    data(){
        return{
            naziv: '',
            lozinka : '',
            korisnici: []
        }
    },
    methods: {
       prijava(){
            
            if(!JSON.parse(localStorage.getItem("proizvodi") )){
              let p=[...proizvodi];
              localStorage.setItem('proizvodi',JSON.stringify(p) );
            }
            
            this.korisnici=JSON.parse(localStorage.getItem("korisnici") );
            if(!this.korisnici){
              this.korisnici=[...korisnici];
            }
            let korisnik= this.korisnici.find(kor=> kor.korisnickoIme==this.naziv && 
            kor.lozinka==this.lozinka)
            if(!korisnik){
                alert("Podaci nisu uneti ili nisu tačni!")
                return;
            }
            else{
              localStorage.setItem('kIme', JSON.stringify(korisnik.korisnickoIme));
              localStorage.setItem('status', JSON.stringify(korisnik.status));
                if(korisnik.status=="0"){
                    this.$router.push('/zaposleni'); 
                }else{
                    this.$router.push('/kupac'); 
                }
            }
       }
  },
  created() {
    
  },
}
</script>