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
    String id, id_clientes, tipo, codigo;
    float saldo, limite;
    /**
     * Establece los datos necesarios para guardar un instancia de EntidadFinanciera
     * @param id
     * @param id_clientes
     * @param tipo
     * @param codigo
     * @param saldo
     * @param limite 
     */
    public EntidadFinanciera(String id, String id_clientes, String tipo, String codigo, float saldo, float limite) {
        this.id = id;
        this.id_clientes = id_clientes;
        this.tipo = tipo;
        this.codigo = codigo;
        this.saldo = saldo;
        this.limite = limite;
    }
    
    
}
