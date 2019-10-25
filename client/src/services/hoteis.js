import { http } from './config'

export default {

    carregar:(cityCode) => {
        return http.get('hoteis/carregar?cityCode='+cityCode);
    },
    listarPorCidade:(reservation) => {
        return http.get('hoteis/porCidade?cityCode='+reservation.cityCode+'&checkin='+reservation.checkin+'&checkout='+reservation.checkout+'&adults='+reservation.adults+'&children='+reservation.children);
    }
}