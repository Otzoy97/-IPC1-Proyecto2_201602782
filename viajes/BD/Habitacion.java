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
    String no_pieza, id_reservacion, clase;
    int max_ocupante;
    float precio;
    /**
     * Establece los datos necesarios para guardar un instancia de Habitacion
     * @param no_pieza
     * @param id_reservacion
     * @param clase
     * @param max_ocupante
     * @param precio 
     */
    public Habitacion(String no_pieza, String id_reservacion, int max_ocupante, float precio, String clase) {
        this.no_pieza = no_pieza;
        this.id_reservacion = id_reservacion;
        this.clase = clase;
        this.max_ocupante = max_ocupante;
        this.precio = precio;
    }
    
}
