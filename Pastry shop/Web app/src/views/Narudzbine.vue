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
          
          
            
            <table style="width: 80%;" cellpadding="10px" class="tNar">
                <tr>
                    <td colspan="7">
                    <h2>Porudžbine</h2>
                    </td>
                </tr>
                <tr>
                    <th>Ime</th>
                    <th>Email</th>
                    <th>Adresa</th>
                    <th>Telefon</th>
                    <th>Naziv</th>
                    <th>Količina</th>
                    <th>Datum</th>
                    <th>Akcije</th>
                </tr>
                <tr v-for="(n, index) in narudzbine.slice(0, prikaziJosRedova * 3)" :key="index" :class="{ 'siv-red': n.status === 0, 'zeleni-red': n.status === 1, 'crveni-red': n.status === -1 }">
                    <td>{{ n.korisnickoIme }}</td>
                    <td>{{ n.email }}</td>
                    <td>{{ n.adresa }}</td>
                    <td>{{ n.broj }}</td>
                    <td>{{ n.naziv }}</td>
                    <td>{{ n.kolicina }}</td>
                    <td>
                        {{
                          new Date(n.datum).toLocaleDateString('en-CA', {
                            year: 'numeric',
                            month: '2-digit',
                            day: '2-digit'
                          }) + ' ' +
                          new Date(n.datum).toLocaleTimeString( {
                            hour: '2-digit',
                            minute: '2-digit'
                          })
                        }}
                      </td>                    
                      <td v-if="n.status==0">
                        <button class="b1" @click="prihvati(index)">Prihvati</button>
                        <button class="b2" @click="odbij(index)">Odbij</button>
                    </td>
                    <td v-if="n.status!=0">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td colspan="7">
                        <button @click="prikaziJos" class="vise">Prikaži više</button>

                    </td>
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
 
.siv-red {
    background-color: #ccc; 
}

.zeleni-red {
    background-color: #aaffaa; 
}

.crveni-red {
    background-color: #ffaaaa;
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
    justify-content: center;
    align-items: center;
    background-color: rgb(230, 230, 230);
    width: 100%;
  }

  th{
    background-color: rgb(81, 81, 81);
    color: white;
;
  }

.b1 {
    margin-right: 20px;
  background-color: white; 
  color: black; 
  border: 2px solid #04AA6D;
}

.b1:hover {
  background-color: #04AA6D;
  color: white;
}

.b2 {
  background-color: white; 
  color: black; 
  border: 2px solid #f44336;
}

.b2:hover {
  background-color: #f44336;
  color: white;
}

.tNar td {
  word-wrap: break-word;
  max-width: 150px; 
}
.vise{
    background-color: rgb(81, 81, 81);
    font-size: 20px;
}
.vise:hover{
    font-size: 20px;

    background-color: rgb(193, 193, 193);
}

  </style>
  

  
<script>
export default{
    name: 'Narudzbine',
    data(){
        return{
            narudzbine : [],
            prikaziJosRedova: 1
        }
    },
    methods: {
      odjava(){
          localStorage.setItem('status', JSON.stringify("-1"));
          localStorage.setItem('korpa', JSON.stringify([]));
          this.$router.push('/prijava'); 
        },
        prihvati(index){
            this.narudzbine[index].status=1;
            this.narudzbine[index].seen=0;
            localStorage.setItem('narudzbine', JSON.stringify(this.narudzbine));

        },

        odbij(index){
            this.narudzbine[index].status=-1;
            this.narudzbine[index].seen=0;
            localStorage.setItem('narudzbine', JSON.stringify(this.narudzbine));

        },
        prikaziJos() {
            this.prikaziJosRedova += 1;
        },
      
  },
  watch: {
    
  },
  created() {
    if(JSON.parse(localStorage.getItem("status")) !=  "0"){
      this.$router.push('/prijava'); 
      return;
    }
    /*this.narudzbine.push({
        'kolicina' :5,
        'korisnickoIme': 'Nemanja',
        'broj' : '064853385',
        'naziv' : 'torta1',
        'status': 0,
        'email' : 'neca@etf.rsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
        'datum': '05/05/2023',
        'seen' : 0

    },
    {
        'kolicina' :7,
        'korisnickoIme': 'Nemanja',
        'broj' : '064853385',
        'naziv' : 'torta2',
        'status': -1,
        'email' : 'neca@etf.rdasdasdasdadas',
        'datum': '01/01/2023',
         'seen' : 0
    },
    {
        'kolicina' :7,
        'korisnickoIme': 'Nemanja',
        'broj' : '064853385',
        'naziv' : 'torta2',
        'status': 1,
        'email' : 'neca@etf.rs',
        'datum': '04/04/2023',
         'seen' : 0
    }
    )*/

    let status=JSON.parse(localStorage.getItem("status") );
    if(status=="-1" || !status){
      this.$router.push('/prijava'); 
      return;
    }
    const s = localStorage.getItem('narudzbine');
    if (s) {
        this.narudzbine = JSON.parse(s);
    } else {
        this.narudzbine = []; 
    }
    this.narudzbine.sort((a, b) => {
        const datumA = new Date(a.datum);
        const datumB = new Date(b.datum);
        return datumB - datumA;
    });
  },
}
</script>