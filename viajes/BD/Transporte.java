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
public class Transporte{
    public String id;
    public String hora_salida;
    public String hora_llegada;
    public String max_pasajeros;
    public String id_destino;
    /**
     * Establece los datos necesarios para guardar un instancia de Transporte
     * @param id
     * @param hora_salida
     * @param hora_llegada
     * @param max_pasajeros
     * @param id_destino 
     */
    public Transporte(String id, String hora_salida, String hora_llegada, String max_pasajeros, String id_destino) {
        this.id = id;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.max_pasajeros = max_pasajeros;
        this.id_destino = id_destino;
    }

    public Transporte() {
    }
    
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Transporte claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.hora_salida;
                    break;
                case 2:
                    referencia = claseReferencia.hora_llegada;
                    break;
                case 3:
                    referencia = claseReferencia.max_pasajeros;
                    break;
                case 4:
                    referencia = claseReferencia.id_destino;
                    break;
                default:
                    return null;
            }
        return referencia;
    }

}
