import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Zaposleni from '../views/Zaposleni.vue'
import Narudzbine from '../views/Narudzbine.vue'
import Prijava from '../views/Prijava.vue'
import Kupac from '../views/Kupac.vue'
import Torte from '../views/Torte.vue'
import Kolaci from '../views/Kolaci.vue'
import jedanProizvod from '../views/jedanProizvod.vue'
import Korpa from '../views/Korpa.vue'
import Profil from '../views/Profil.vue'
import Promocija from '../views/Promocija.vue'
import sviProizvodi from '../views/sviProizvodi.vue'
import jedanProizvod1 from '../views/jedanProizvod1.vue'
import Index from '../views/Index.vue'



const routes = [
  
  {
    path: '/zaposleni',
    name: 'zaposleni',
    component: Zaposleni
  },
  {
    path: '/narudzbine',
    name: 'narudzbine',
    component: Narudzbine
  },
  {
    path: '/prijava',
    name: 'prijava',
    component: Prijava
  },
  {
    path: '/kupac',
    name: 'kupac',
    component: Kupac
  },
  {
    path: '/torte',
    name: 'torte',
    component: Torte
  },
  {
    path: '/kolaci',
    name: 'kolaci',
    component: Kolaci
  },
  {
    path: '/jedanProizvod1',
    name: 'jedanProizvod1',
    component: jedanProizvod1
  },
  {
    path: '/jedanProizvod',
    name: 'jedanProizvod',
    component: jedanProizvod
  },
  {
    path: '/korpa',
    name: 'korpa',
    component: Korpa
  },
  {
    path: '/profil',
    name: 'profil',
    component: Profil
  },
  {
    path: '/promocije',
    name: 'promocije',
    component: Promocija
  }
  ,
  {
    path: '/sviProizvodi',
    name: 'sviProizvodi',
    component: sviProizvodi
  },
  {
    path: '',
    name: 'index',
    component: Index
  },

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
