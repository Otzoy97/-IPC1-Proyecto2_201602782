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
    
}
