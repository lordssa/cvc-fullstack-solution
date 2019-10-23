import { http } from './config'

export default {

    listar:() => {
        return http.get('hoteis/consultar?codHotel='+44344);
    }
}