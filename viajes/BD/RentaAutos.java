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
public class RentaAutos {
    String id, id_cliente;
    int max_ocupantes;
    String tipo_terreno;
    int dias_rentado;
    float precio;
    String fecha_entrega, fecha_devolucion, detalle;
    /**
     * Establece los datos necesarios para guardar un instancia de RentaAutos
     * @param id
     * @param id_cliente
     * @param max_ocupantes
     * @param tipo_terreno
     * @param dias_rentado
     * @param precio
     * @param fecha_entrega
     * @param fecha_devolucion
     * @param detalle 
     */
    public RentaAutos(String id, String id_cliente, int max_ocupantes, String tipo_terreno, int dias_rentado, float precio, String fecha_entrega, String fecha_devolucion, String detalle) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.max_ocupantes = max_ocupantes;
        this.tipo_terreno = tipo_terreno;
        this.dias_rentado = dias_rentado;
        this.precio = precio;
        this.fecha_entrega = fecha_entrega;
        this.fecha_devolucion = fecha_devolucion;
        this.detalle = detalle;
    }
    
}
