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
public class EntidadFinanciera {
    public String id, id_clientes, tipo, codigo, saldo, limite;
    /**
     * Establece los datos necesarios para guardar un instancia de EntidadFinanciera
     * @param id
     * @param id_clientes
     * @param tipo
     * @param codigo
     * @param saldo
     * @param limite 
     */
    public EntidadFinanciera(String id, String id_clientes, String tipo, String codigo, String saldo, String limite) {
        this.id = id;
        this.id_clientes = id_clientes;
        this.tipo = tipo;
        this.codigo = codigo;
        this.saldo = saldo;
        this.limite = limite;
    }

    public EntidadFinanciera() {
    }
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(EntidadFinanciera claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.id_clientes;
                    break;
                case 2:
                    referencia = claseReferencia.tipo;
                    break;
                case 3:
                    referencia = claseReferencia.codigo;
                    break;
                case 4:
                    referencia = claseReferencia.saldo;
                    break;
                case 5: 
                    referencia = claseReferencia.limite;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
    /**
     * Verfica que la tarjeta tenga saldo suficiente, para efectuar un pago
     * @param costoReservacion cantidad a verificar
     * @return 
     */
    public boolean verifySaldo(float costoReservacion){
        return ( Float.parseFloat(limite) - Float.parseFloat(saldo) ) >= costoReservacion;
    }
}
