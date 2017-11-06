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
public class DestinoTuristico {
    public String id, pais, ciudad, direccion, nombre_destino, detalle_seguridad;
    /**
     * Establece los datos necesarios para guardar un instancia de Destino
     * @param id
     * @param pais
     * @param ciudad
     * @param direccion
     * @param nombre_destino
     * @param detalle_seguridad 
     */
    public DestinoTuristico(String id, String pais, String ciudad, String direccion, String nombre_destino, String detalle_seguridad) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre_destino = nombre_destino;
        this.detalle_seguridad = detalle_seguridad;
    }
    
}
