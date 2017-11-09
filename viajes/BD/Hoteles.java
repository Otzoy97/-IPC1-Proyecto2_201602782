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
public class Hoteles {
    public String id, direccion, id_destino, max_pieza;
    /**
     * Establece los datos necesarios para guardar un instancia de Hoteles
     * @param id
     * @param direccion
     * @param max_pieza 
     * @param id_destino 
     */
    public Hoteles(String id, String direccion, String max_pieza, String id_destino) {
        this.id = id;
        this.direccion = direccion;
        this.max_pieza = max_pieza;
        this.id_destino = id_destino;
    }

    public Hoteles() {
    }
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Hoteles claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.direccion;
                    break;
                case 2:
                    referencia = claseReferencia.max_pieza;
                    break;
                case 3:
                    referencia = claseReferencia.id_destino;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
}
