/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.BD;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import viajes.modulos.MClientes;

/**
 *
 * @author HPBEATS
 */
public class Reservaciones {
    public String id, id_paquete, id_cliente, fecha_reserva, fecha_partida, max_dias;
    public String estado, adeudo;
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
    public Reservaciones(String id, String id_paquete, String id_cliente, String fecha_reserva, String fecha_partida, String max_dias, String estado, String adeudo) {
        this.id = id;
        this.id_paquete = id_paquete;
        this.id_cliente = id_cliente;
        this.fecha_reserva = fecha_reserva;
        this.fecha_partida = fecha_partida;
        this.max_dias = max_dias;
        this.estado = estado;
        this.adeudo = adeudo;
    }
    /**
     * Constructor por defecto
     */
    public Reservaciones() {
    }
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Reservaciones claseReferencia, int posicionComa){
        //Crea una copia de la claseReferencia
        Reservaciones ref = claseReferencia;
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = ref.id;
                    break;
                case 1:
                    referencia = ref.id_paquete;
                    break;
                case 2:
                    referencia = ref.id_cliente;
                    break;
                case 3:
                    referencia = ref.fecha_reserva;
                    break;
                case 4:
                    referencia = ref.fecha_partida;
                    break;
                case 5: 
                    referencia = ref.max_dias;
                    break;
                case 6:
                    referencia = ref.estado;
                    break;
                case 7:
                    referencia = ref.adeudo;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
    /**
     * Actualiza el estado o adeudo de las reservaciones
     * @param diasRestantes indica la diferencia entre la fecha de partida y la fecha actual
     */
    public void actualizarEstadoOAdeudo(int diasRestantes){
        if (estado.equals("Reserva") || estado.equals("En espera")){
            if (diasRestantes < 3 || diasRestantes > 0 ){
                adeudo = "" + ( Float.parseFloat(adeudo) * 1.05);
            }
            if (diasRestantes <= 0 ){
                estado = "Vencida";
            }
        }
    }
    /**
     * Verifica si la reservacion está en espera
     * si lo esta y la reservacion lleva más de 5 días así,
     * la Anula
     */
    private void cancelarEnEspera(){
        if (estado == "En espera"){
            //Instancia para acceder a los metodos de MClientes
            MClientes mm = new MClientes();
            //Instancia para dar encontrar un formato
            //adecuado para la fecha de reserv
            DateFormat input = new SimpleDateFormat(mm.tryParse(fecha_reserva));
            //obtiene la fecha actual
            Date ff = new Date();
            try {
                //Guarda la diferencia entre fechas
                int diferencia = verifyRangeDate(input.parse(fecha_reserva),ff);
                //Verifica si la diferencia es mayor a cinco
                if (diferencia> 5){
                    //Anulada la reservacion
                    estado = "Anulada";
                }
            } catch (ParseException ex) {
                Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Copia de verifyRangeDate de MReservaciones
     * @param fechaMayor
     * @param fechaMenor
     * @return 
     */
    public int verifyRangeDate(java.util.Date fechaMayor , java.util.Date fechaMenor){
        return Math.round( ( fechaMayor.getTime() - fechaMenor.getTime() ) / (1000*60*60*24)  ) ;
    }
}
