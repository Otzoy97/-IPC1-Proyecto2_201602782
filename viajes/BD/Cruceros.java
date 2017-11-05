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
    String id, fecha_salida, fecha_llegada;
    int max_viajero, max_duracion;
    String detalle, id_destino;
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
    public Cruceros(String id, String fecha_salida, String fecha_llegada, int max_viajero, int max_duracion, String detalle, String id_destino) {
        this.id = id;
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.max_viajero = max_viajero;
        this.max_duracion = max_duracion;
        this.detalle = detalle;
        this.id_destino = id_destino;
    }
    
}
