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
public class Transporte{
    public String id;
    public String hora_salida;
    public String hora_llegada;
    public String max_pasajeros;
    public String id_destino;
    /**
     * Establece los datos necesarios para guardar un instancia de Transporte
     * @param id
     * @param hora_salida
     * @param hora_llegada
     * @param max_pasajeros
     * @param id_destino 
     */
    public Transporte(String id, String hora_salida, String hora_llegada, String max_pasajeros, String id_destino) {
        this.id = id;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.max_pasajeros = max_pasajeros;
        this.id_destino = id_destino;
    }
    public Transporte BuscarV(String expresion, Object dominio, String criterio ){
        Transporte transporte = (Transporte) dominio;
        
        return transporte;
    }

}
