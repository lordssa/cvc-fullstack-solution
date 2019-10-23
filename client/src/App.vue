<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">CVC Hoteis</a>
      </div>
    </nav>

    <div class="container" style="width:35%;">

       <ul>
        <li v-for="(erro, index) of errors" :key="index">
          campo <b>{{erro.field}}</b> - {{erro.defaultMessage}}
        </li>
      </ul>

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
            <th>NOME</th>
            <th>QTD</th>
            <th>VALOR</th>
            <th>DETALHE</th>
          </tr>

        </thead>

        <tbody>

          <tr>

            <td>Arduino</td>
            <td>100</td>
            <td>50.00</td>
            <td>
              <button class="waves-effect btn-small blue darken-1"><i class="material-icons">description</i></button>              
            </td>

          </tr>

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
        cityCode: 0,
        checkin: '',
        checkout: '',
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
    pesquisar(){
      this.reservation.checkin = this.formatarData(this.reservation.checkin);
      this.reservation.checkout = this.formatarData(this.reservation.checkout);
      /* eslint-disable no-console */
          console.log(this.reservation); 
      HotelService.listarPorCidade(this.reservation).then(response => {
        /* eslint-disable no-console */
          console.log(response); 
      });
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