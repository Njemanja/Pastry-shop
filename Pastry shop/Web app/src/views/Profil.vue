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
            <a v-if="status==1" href="#/kupac">Početna strana</a>
            <a v-if="status==0" href="#/zaposleni">Početna strana</a>
            <a @click="odjava" href="#/prijava">Odjava</a>

          </div>
        </div>
      </div>
      <div v-if="prikaziListaObavestenja" class="row obavestenja-container">
        <div class="col-12">
          <ul class="obavestenja-lista" style="display: flex; flex-direction: column; right: 0;">
            <li v-for="(obavestenje, index) in obavestenja" :key="index" class="obavestenje-item">
              {{ obavestenje.tekst }}
            </li>
          </ul>
        </div>
      </div>
      <div class="row" style="display: flex;flex-direction: row; justify-content: space-evenly; align-items: center; background-color: rgb(230, 230, 230); padding-right: 20px;">
        <div class="col-12" style="display: flex; justify-content: center; margin: 50px">
            <table cellpadding="10px">
                <tr>
                    <td colspan="2">
                        <h2>Profil</h2>
                    </td>
                </tr>
               <tr>
                 <td>Korisnicko ime</td>
                 <td><input type="text"  v-model="korisnickoIme"></td>
               </tr>
               <tr>
                 <td>Ime</td>
                 <td><input type="text"  v-model="ime"></td>
               </tr>
               <tr>
                 <td>Prezime</td>
                 <td><input type="text"  v-model="prezime"></td>
               </tr>
               <tr>
                 <td>Email</td>
                 <td><input type="text" v-model="email"></td>
               </tr>
               <tr>
                 <td>Adresa</td>
                 <td><input type="text" v-model="adresa"></td>
               </tr>
               <tr>
                 <td>Telefon</td>
                 <td><input type="text" v-model="telefon"></td>
               </tr>
               <tr>
                 <td>Lozinka I</td>
                 <td><input type="password" v-model="lozinka1"></td>
               </tr>
               <tr>
                 <td>Lozinka II</td>
                 <td><input type="password" v-model="lozinka2"></td>
               </tr>
               <tr>
                <td colspan="2">
                  <button @click="izmeni">Izmeni</button>
                </td>
               </tr>
            </table>
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
  import korisnici from '../data/korisnici.js';

  export default{
    name: 'Profil',
    data(){
        return{
            korisnik: '',
            korisnickoIme: '',
            kIme: '',
            ime: '',
            prezime: '',
            adresa: '',
            email: '',
            telefon: '',
            lozinka1: '',
            lozinka2: '',
            korisnici: '',
            index: -1,
            obavestenja: [],  
            prikaziListaObavestenja: false,
            brojObavestenja: 0,
            status : -1,
        }
    },
    methods: {
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

   }
    ,
        izmeni(){
          
          if (this.korisnici && this.korisnici.length > 0) {
             this.index = -1;
             for(let i=0;i<this.korisnici.length; i++){
                if(this.korisnici[i].korisnickoIme==this.kIme){
                  this.index=i;

                }
             }
            
          } else {
            console.error("Niz korisnika je prazan ili nije definisan.");
            return;
          }          
          let copy=this.korisnici[this.index];

          if (this.index !== -1) {
            this.korisnici.splice(this.index, 1);
          }
          if(this.korisnickoIme == '' || 
          this.ime == '' || 
          this.prezime == '' || 
          this.email == '' || 
          !this.adresa ||  
          this.telefon == '' ||
          this.lozinka1 == '' || 
          this.lozinka2 == ''  
          ){
            alert("Niste popunili sva polja!");
            this.korisnici.push(copy);
            return;
          }
          if(this.lozinka1!=this.lozinka2){
            alert("Lozinke moraju biti iste!");
            this.korisnici.push(copy);
            return;
          }
          if(this.lozinka1.length<6){
            alert("Lozinka mora imati barem 6 karaktera!");
            this.korisnici.push(copy);
            return;
          }
          let k = this.korisnici.find(kor=> kor.email==this.email)
          if(this.kIme!=k.korisnickoIme){
            alert("Email vec postoji!");
            this.korisnici.push(copy);
            return;
          }
          
          if(this.korisnici.find(kor=> kor.telefon==this.telefon && kor.korisnickoIme!=this.kIme)){
            alert("Telefon vec postoji!");
            this.korisnici.push(copy);
            return;
          }
          k=this.korisnici.find(kor=> kor.korisnickoIme==this.korisnickoIme)
          if(k && copy.korisnickoIme!=this.kIme){
            alert("Korisnicko ime vec postoji!");
            this.korisnici.push(copy);
            return;
          }
         
          this.korisnik.korisnickoIme=this.korisnickoIme;
          this.korisnik.ime=this.ime;
          this.korisnik.prezime=this.prezime;
          this.korisnik.adresa=this.adresa;
          this.korisnik.telefon=this.telefon;
          this.korisnik.email=this.email;
          this.korisnici.push(this.korisnik);
          localStorage.setItem("korisnici", JSON.stringify(this.korisnici))
          alert("Uspesno ste promenili podatke!")
          localStorage.setItem('kIme', JSON.stringify(this.korisnik.korisnickoIme));









        }
  
    
  },
    created() {
      this.status=JSON.parse(localStorage.getItem("status"));
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
            tekst= "Odbijena je narudzbina za "+this.narudzbine[i].naziv+".";
          }else{
            tekst= "Narudzbina je na cekanju za "+this.narudzbine[i].naziv+".";

          }
          this.obavestenja.push({
            tekst: tekst
          })
      }
      this.obavestenja.reverse();

      this.korpa=  JSON.parse(localStorage.getItem('korpa'));
      if(!this.korpa){
          this.korpa=[];
      }
        
        this.korisnickoIme= JSON.parse(localStorage.getItem('kIme'));
        this.korisnici= JSON.parse(localStorage.getItem('korisnici'));
        if(!this.korisnici){
           localStorage.setItem("korisnici", JSON.stringify(korisnici))
           this.korisnici= [... korisnici]
        }
        this.korisnik= this.korisnici.find(kor=> kor.korisnickoIme==this.korisnickoIme);
        this.ime=this.korisnik.ime;
        this.prezime=this.korisnik.prezime;
        this.email=this.korisnik.email;
        this.telefon=this.korisnik.telefon;
        this.adresa=this.korisnik.adresa;
        this.lozinka1=this.korisnik.lozinka;
        this.lozinka2=this.korisnik.lozinka;
        this.kIme=this.korisnik.korisnickoIme;

    },
  }
  </script>