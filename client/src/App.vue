<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">CVC Hoteis</a>
      </div>
    </nav>

    <div class="container" style="width:35%;">

        <p v-if="errors.length">
          <b>Por favor, corrija o(s) seguinte(s) erro(s):</b>
          <ul>
            <li v-for="error in errors" :key="error">{{ error }}</li>
          </ul>
        </p>


      <form @submit.prevent="pesquisar">

          <label>Cidade</label>
          <autocomplete
            :source="cities"
            @selected="citySelected">
          </autocomplete>
          <label>Ida</label>
          <datepicker v-model="reservation.checkin" name="checkin" :format="'dd/MM/yyyy'" :language="ptBR"></datepicker> 
          <label>Volta</label>
          <datepicker v-model="reservation.checkout" name="checkout" :format="'dd/MM/yyyy'" :language="ptBR"></datepicker>      
          <label>Adultos</label>
          <select v-model="reservation.adults" style="display:block;">
             <option
                  v-for="n in 9"
                  :key="n" 
                  :value="n">
                  {{ n }} 
            </option>
          </select>         
          <label>Crianças</label>
          <select v-model="reservation.children" style="display:block;">
             <option value="0" selected>0</option>
             <option
                  v-for="n in 9"
                  :key="n" 
                  :value="n">
                  {{ n }} 
            </option>
          </select>  
          <br/><br/>
          <button class="waves-effect waves-light btn-small">Pesquisar<i class="material-icons left">search</i></button>

      </form>
</div>
<br/><br/>
 <div class="container">
      <table>

        <thead>

          <tr>
            <th>Categoria</th>
            <th>Preço Adulto</th>
            <th>Preço Criança</th>
            <th>Valor Total</th>
          </tr>

        </thead>
        <tbody>
          <template v-for="hotel of hoteis"  >
            <tr :key="hotel.id">
              <td colspan="4"><b>Hotel {{hotel.id}} - {{hotel.cityName}}</b></td>
            </tr>
            <tr v-for="room of hotel.rooms" :key="room.roomID">

              <td>{{room.categoryName}}</td>
              <td>{{room.priceDetail.pricePerDayAdult}}</td>
              <td>{{room.priceDetail.pricePerDayChild}}</td>
              <td>{{room.totalPrice}}</td>
            </tr>
          </template>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

import HotelService from './services/hoteis'
import Autocomplete from '../node_modules/vuejs-auto-complete'
import Datepicker from '../node_modules/vuejs-datepicker'
import {ptBR} from 'vuejs-datepicker/dist/locale'

export default{
  name: 'app',
  data () {
    return {
      ptBR: ptBR,
      reservation:{
        cityCode: null,
        checkin: null,
        checkout: null,
        adults: 1,
        children: 0
      },
      cities:[{id:1032,name:'Porto Seguro'},{id:7110,name:'Rio de Janeiro'}, {id:9626,name:'São Paulo'}],
      hoteis: [],
      errors: []
    }
  },
  components: {
    Autocomplete,
    Datepicker
  },   
  methods:{
    checkForm(){
      if (this.reservation.cityCode 
          && this.reservation.checkin
          && this.reservation.checkout) {

            if(this.reservation.checkin > this.reservation.checkout){
               this.errors = [];
               this.errors.push('A data de ida não pode ser maior que a data de volta');
               return false;
            }
        return true;
      }

      this.errors = [];

      if (!this.reservation.cityCode) {
        this.errors.push('O campo cidade é obrigatório.');
      }
      if (!this.reservation.checkin) {
        this.errors.push('A data de ida é obrigatória.');
      }
      if (!this.reservation.checkout) {
        this.errors.push('A data de volta é obrigatória.');
      }
      return false;
    },
    pesquisar(){
      if(this.checkForm()){
        this.reservation.checkin = this.formatarData(this.reservation.checkin);
        this.reservation.checkout = this.formatarData(this.reservation.checkout);
        /* eslint-disable no-console */
            console.log(this.reservation); 
        HotelService.listarPorCidade(this.reservation).then(response => {        
            this.hoteis = response.data;
            this.errors = [];
        }).catch(e => {
            this.errors = e.response.data.errors
        });
      }
    },
    citySelected (city) {
      this.reservation.cityCode = city.value;
      HotelService.carregar(city.value).then({}); 
    },
    formatarData(data){
       var dataFormatada = ("0" + data.getDate()).substr(-2) + "/" 
        + ("0" + (data.getMonth() + 1)).substr(-2) + "/" + data.getFullYear();

        return dataFormatada;
    }
  }

}
</script>