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
public class Camarot {
    public String id_crucero, id_reservacion, c_asignado, precio;
    /**
     * Establece los datos necesarios para guardar un instancia de Camarot
     * @param id_crucero
     * @param id_reservacion
     * @param c_asignado
     * @param precio 
     */
    public Camarot(String id_crucero, String id_reservacion, String c_asignado, String precio) {
        this.id_crucero = id_crucero;
        this.id_reservacion = id_reservacion;
        this.c_asignado = c_asignado;
        this.precio = precio;
    }

    public Camarot() {
    }
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Camarot claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id_crucero;
                    break;
                case 1:
                    referencia = claseReferencia.id_reservacion;
                    break;
                case 2:
                    referencia = claseReferencia.c_asignado;
                    break;
                case 3:
                    referencia = claseReferencia.precio;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
}
