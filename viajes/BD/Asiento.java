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
public class Asiento {
    public String id_transporte;
    public String id_reservacion;
    public String no_asignado;
    public String clase;
    public String monto_pasaje;
    /**
     * Establece los datos necesarios para guardar un instancia de Asiento
     * @param Id_transporte
     * @param Id_reservacion
     * @param no_asignado
     * @param clase
     * @param monto_pasaje 
     */
    public Asiento(String Id_transporte, String Id_reservacion, String no_asignado, String clase, String monto_pasaje) {
        this.id_transporte = Id_transporte;
        this.id_reservacion = Id_reservacion;
        this.no_asignado = no_asignado;
        this.clase = clase;
        this.monto_pasaje = monto_pasaje;
    }   
}
