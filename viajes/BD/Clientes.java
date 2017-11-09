/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.BD;

import viajes.listas.ListaSimple;

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
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(Clientes claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.nombre;
                    break;
                case 2:
                    referencia = claseReferencia.apellido;
                    break;
                case 3:
                    referencia = claseReferencia.notarjeta;
                    break;
                case 4:
                    referencia = claseReferencia.fecnacimiento;
                    break;
                case 5: 
                    referencia = claseReferencia.telefono;
                    break;
                case 6:
                    referencia = claseReferencia.celular;
                    break;
                case 7:
                    referencia = claseReferencia.domicilio;
                    break;
                case 8:
                    referencia = claseReferencia.cpfrecuencia;
                    break;
                case 9:
                    referencia = claseReferencia.cpmonto;
                    break;
                default:
                    return null;
            }
        return referencia;
    }

    public Clientes() {
    }
}
   
    /**
     * Consulta la existencia de un objeto 'Clientes' dado un String 'idCliente',
     * alojado en una lista Dominio 'ListaSimple'
     * @param expresion referencia a buscar dentro de un tipo Clientes
     * @param listaDominio dominio en el que se buscara la referencia 'idCliente', casteable a Clientes
     * @param posicionComa posición en la cual, según el Constructor, se encuentra la referencia 'idCliente'
     * @return tipo «Object», susceptible al casteo de tipo «Clientes»; o un «Object» 'null'.
     *//*
    public Object getClienteB(String expresion, ListaSimple listaDominio, int posicionComa){
        //Crea una copia de la lista que contiene los Objetos Clientes
        ListaSimple aux = listaDominio;
        //Crea una instancia de Clientes, en donde se guardará el casteo de listaDominio
        Clientes ref;
        //Variable que guardara el dato a comparar
        String referencia;
        //Se detendrá cuando el nodo de la lista sea nulo
        while(!aux.esVacia()){
            ref = (Clientes) aux.listar();
            //Según la posicionComa así buscara el dato en la posición del Constructor
            referencia = getBD(ref,posicionComa);
            //Verifica que la referencia coincida con la expresion deseada;
            if ( referencia.equals(expresion) ){
                return ref;
            }
        }
        return null;
    } */