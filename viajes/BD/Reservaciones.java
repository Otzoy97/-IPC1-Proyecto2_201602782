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
public class Reservaciones {
    String id, id_paquete, id_cliente, fecha_reserva, fecha_partida;
    int max_dias;
    String estado;
    float adeudo;
    /**
     * Establece los datos necesarios para guardar un instancia de Reservaciones
     * @param id
     * @param id_paquete
     * @param id_cliente
     * @param fecha_reserva
     * @param fecha_partida
     * @param max_dias
     * @param estado
     * @param adeudo 
     */
    public Reservaciones(String id, String id_paquete, String id_cliente, String fecha_reserva, String fecha_partida, int max_dias, String estado, float adeudo) {
        this.id = id;
        this.id_paquete = id_paquete;
        this.id_cliente = id_cliente;
        this.fecha_reserva = fecha_reserva;
        this.fecha_partida = fecha_partida;
        this.max_dias = max_dias;
        this.estado = estado;
        this.adeudo = adeudo;
    }
    
}
