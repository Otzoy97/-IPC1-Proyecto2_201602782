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
public class Paquetes {
    String id, tipo, clasificacion, max_pasajeros;
    String id_transporte, id_hospedaje ,id_crucero, 
            id_autos_renta, id_destino, id_lugar, precio;
    /**
     * Establece los datos necesarios para guardar un instancia de Paquetes
     * @param id
     * @param tipo
     * @param clasificacion
     * @param max_pasajeros
     * @param id_transporte
     * @param id_hospedaje
     * @param id_crucero
     * @param id_autos_renta
     * @param id_destino
     * @param id_lugar
     * @param precio 
     */
    public Paquetes(String id, String tipo, String clasificacion, String max_pasajeros, String id_transporte, String id_hospedaje, String id_crucero, String id_autos_renta, String id_destino, String id_lugar, String precio) {
        this.id = id;
        this.tipo = tipo;
        this.clasificacion = clasificacion;
        this.max_pasajeros = max_pasajeros;
        this.id_transporte = id_transporte;
        this.id_hospedaje = id_hospedaje;
        this.id_crucero = id_crucero;
        this.id_autos_renta = id_autos_renta;
        this.id_destino = id_destino;
        this.id_lugar = id_lugar;
        this.precio = precio;
    }
    
}
