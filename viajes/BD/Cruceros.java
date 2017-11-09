/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.BD;

/**
 *
 * @author HPBEATS
 */
public class Cruceros {
    public String id, fecha_salida, fecha_llegada, max_viajero, max_duracion, detalle, id_destino;
    /**
     * Establece los datos necesarios para guardar un instancia de Cruceros
     * @param id
     * @param fecha_salida
     * @param fecha_llegada
     * @param max_viajero
     * @param max_duracion
     * @param detalle
     * @param id_destino 
     */
    public Cruceros(String id, String fecha_salida, String fecha_llegada, String max_viajero, String max_duracion, String detalle, String id_destino) {
        this.id = id;
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.max_viajero = max_viajero;
        this.max_duracion = max_duracion;
        this.detalle = detalle;
        this.id_destino = id_destino;
    }
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Cruceros claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.fecha_salida;
                    break;
                case 2:
                    referencia = claseReferencia.fecha_llegada;
                    break;
                case 3:
                    referencia = claseReferencia.max_viajero;
                    break;
                case 4:
                    referencia = claseReferencia.max_duracion;
                    break;
                case 5: 
                    referencia = claseReferencia.detalle;
                    break;
                case 6:
                    referencia = claseReferencia.id_destino;
                    break;
                default:
                    return null;
            }
        return referencia;
    }

    public Cruceros() {
    }
}
