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
public class Clientes {
    public String id, nombre, apellido, notarjeta, 
            fecnacimiento, telefono, celular,
            domicilio, cpfrecuencia, cpmonto;
    /**
     * Establece los datos necesarios para guardar un instancia de Clientes
     * @param id
     * @param nombre
     * @param apellido
     * @param notarjeta
     * @param fecnacimiento
     * @param telefono
     * @param celular
     * @param domicilio
     * @param cpfrecuencia
     * @param cpmonto 
     */
    public Clientes(String id, String nombre, String apellido, String notarjeta, String fecnacimiento, String telefono, String celular, String domicilio, String cpfrecuencia, String cpmonto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notarjeta = notarjeta;
        this.fecnacimiento = fecnacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.domicilio = domicilio;
        this.cpfrecuencia = cpfrecuencia;
        this.cpmonto = cpmonto;
    }    
}
