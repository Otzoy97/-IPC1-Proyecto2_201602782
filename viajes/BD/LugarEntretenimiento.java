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
public class LugarEntretenimiento {
    String id, nombre, detalle, pais, ciudad, direccion, edad_requerida;
    String hora_inicio, horarios, detalle_seguridad;
    /**
     * Establece los datos necesarios para guardar un instancia de LugarEntretenimiento
     * @param id
     * @param nombre
     * @param detalle
     * @param pais
     * @param ciudad
     * @param direccion
     * @param edad_requerida
     * @param hora_inicio
     * @param horarios
     * @param detalle_seguridad 
     */
    public LugarEntretenimiento(String id, String nombre, String detalle, String pais, String ciudad, String direccion, String edad_requerida, String hora_inicio, String horarios, String detalle_seguridad) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.edad_requerida = edad_requerida;
        this.hora_inicio = hora_inicio;
        this.horarios = horarios;
        this.detalle_seguridad = detalle_seguridad;
    }
    
}
