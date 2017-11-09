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
public class Habitacion {
    public String id_hoteles, no_pieza, id_reservacion, clase, max_ocupante, precio;
    /**
     * Establece los datos necesarios para guardar un instancia de Habitacion
     * @param id_hoteles
     * @param no_pieza
     * @param id_reservacion
     * @param clase
     * @param max_ocupante
     * @param precio 
     */
    public Habitacion(String id_hoteles, String no_pieza, String id_reservacion, String max_ocupante, String precio, String clase) {
        this.id_hoteles = id_hoteles;
        this.no_pieza = no_pieza;
        this.id_reservacion = id_reservacion;
        this.clase = clase;
        this.max_ocupante = max_ocupante;
        this.precio = precio;
    }

    public Habitacion() {
    }
    
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Habitacion claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id_hoteles;
                    break;
                case 1:
                    referencia = claseReferencia.no_pieza;
                    break;
                case 2:
                    referencia = claseReferencia.id_reservacion;
                    break;
                case 3:
                    referencia = claseReferencia.clase;
                    break;
                case 4:
                    referencia = claseReferencia.max_ocupante;
                    break;
                case 5: 
                    referencia = claseReferencia.precio;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
    
}
