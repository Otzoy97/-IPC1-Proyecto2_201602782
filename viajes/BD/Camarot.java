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
    
}
