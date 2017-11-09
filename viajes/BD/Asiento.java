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
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Asiento claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id_transporte;
                    break;
                case 1:
                    referencia = claseReferencia.id_reservacion;
                    break;
                case 2:
                    referencia = claseReferencia.no_asignado;
                    break;
                case 3:
                    referencia = claseReferencia.clase;
                    break;
                case 4:
                    referencia = claseReferencia.monto_pasaje;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
}
