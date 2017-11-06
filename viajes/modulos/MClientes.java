/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.modulos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import viajes.listas.ListaSimple;
import viajes.listas.Nodo;
import viajes.BD.Clientes;
import viajes.BD.Reservaciones;
/**
 * Controla la forma de registrar la información relacionada con 'viajes.BD.Clientes'
 * @author HPBEATS
 */
public class MClientes {
    /**
     * Para Clientes que viajen UNA vez al año
     * Esta debe ser el dato por defecto en cp_frecuencia
     */
    public String FRECUENCIA_UNO = "Anual";
    /**
     * Para Clientes que viajen DOCE veces al año
     */
    public String FRECUENCIA_DOS = "Mensual";
    /**
     * Para Clientes que viajen de TRECE a VEINTICUATRO veces al año
     */
    public String FRECUENCIA_TRES = "Regular";
    /**
     * Para Clientes que viajen de VEINTICINCO veces o MÁS por año
     */
    public String FRECUENCIA_CUATRO = "Frecuente";
    /**
     * Para Clientes con «saldo promedio» entre 1,000 y 5,000
     */
    public String MONTO_UNO = "Básico";
    /**
     * Para Clientes con «saldo promedio» entre 5,001 y 10,000
     */
    public String MONTO_DOS = "Premium";
    /**
     * Para Clientes con «saldo promedio» de 10,001 en adelante
     */
    public String MONTO_TRES = "Platino";
    /**
     * Consulta el identificador del Modulo
     * @return el identificadod el módulo
     */
    public String getId(){
        return "Clientes";
    }
    /**
     * Consulta la existencia de un objeto 'Clientes' dado un String 'idCliente',
     * alojado en una lista Dominio 'ListaSimple'
     * @param idCliente referencia a buscar dentro de un tipo Clientes
     * @param listaDominio dominio en el que se buscara la referencia 'idCliente', casteable a Clientes
     * @return tipo «Object», susceptible al casteo de tipo «Clientes»; o un «Object» 'null'.
     */
    public Object getCliente(String idCliente, ListaSimple listaDominio){
        //Crea una copia de la lista que contiene los Objetos Clientes
        ListaSimple aux = listaDominio;
        //Crea una instancia de Clientes, en donde se guardará el casteo de listaDominio
        Clientes ref;
        //Se detendrá cuando el nodo de la lista sea nulo
        while( aux.inicio != null ){
            ref = (Clientes) aux.inicio.objeto ;
            if ( ref.id.equals(idCliente) ){
                return (Object) ref;
            } else {
                aux.inicio = aux.inicio.siguiente;
            }
        }
        return null;
    }
    /**
     * Consulta la cantidad de viajes (por año o total) que el Cliente ha realizado en Reservaciones
     * @param idCliente referencia a buscar dentro de Reservaciones
     * @param listaDominio dominio en el que se buscara la referencia 'idCliente', casteable a Reservaciones
     * @param porAnio true devuelve el numero de viajes realizados en el año en curso, false el numero de viajes total
     * @return el número de viajes que ha realizado el Cliente
     */
    public int getNoViajesClientes(String idCliente, ListaSimple listaDominio, boolean porAnio) throws ParseException{
        //Variable en donde se guardará el numero de viajes que el Cliente ha realizado
        int cant_viajes = 0;
        //Crea una copia de la listaDominio
        ListaSimple aux = listaDominio;
        //Crea una instancia de Clientes, en donde se guardará el casteo de listaDominio
        Reservaciones ref;
        //-----------------------------------------------------
        //Determina el formato de año que se le dará a un Date
        SimpleDateFormat getAnio = new SimpleDateFormat("yyyy");
        //Da formato dia/mes/año
        DateFormat getFecha = new SimpleDateFormat("dd/MM/yyyy");
        //Guarda el año en curso
        int Anio = Integer.parseInt(getAnio.format(new Date()));
        //-----------------------------------------------------
        //Se detendrá cuando el nodo de la lista sea nulo
        while(aux.inicio != null){
            //Casete el objeto del nodo de la lista a un tipo Reservaciones
            ref = (Reservaciones) aux.inicio.objeto;
            //Verifica si el «id_cliente» en reservaciones es igual al «idCliente» de referencia
            if (  ( ref.id_cliente.equals(idCliente) ) && ( ref.estado.equals("Pagada") )  ){
                //Verifica si se ordena por fecha
                if ( porAnio ) {
                    //Obtiene el año de la fecha guardada en 'fecha_partida'
                    int Anio_partida = Integer.parseInt(getAnio.format(getFecha.parse(ref.fecha_partida)));
                    //Verifica si el año de la fecha guardada (fecha_partida) es el año en curso
                    if ( Anio == Anio_partida  ){
                        //Aumenta el contador
                        cant_viajes++;
                    }
                } else {
                    //Aumenta el contador
                    cant_viajes++;
                }
            }
            aux.inicio = aux.inicio.siguiente;
        }
        return cant_viajes;
    }
    /**
     * Determina la «clasificación por monto» al Cliente según promedio del saldo (saldoCliente) que el cliente 
     * posee -asociado- en EntidadFinanciera
     * @param idCliente referencia a buscar dentro de un tipo Clientes
     * @param listaClientes lista en donde se encuentra la referencia buscar
     * @param saldoCliente saldo total que posee Clientes en EntidadFinanciera
     * @param cantViajesClientes numero de viajes que el Cliente ha realizado
     */
    public void setCPMonto(String idCliente, ListaSimple listaClientes ,float saldoCliente, int cantViajesClientes){
        int promedio = Math.round(saldoCliente/cantViajesClientes);
        //Castea el objeto que retorna getCliente
        Clientes refClientes = (Clientes) getCliente(idCliente,listaClientes);
        //Según el valor de promedio se elige un MONTO
        if ( promedio >= 1000 || promedio <= 5000 ){
            refClientes.cpmonto = MONTO_UNO;
        }
        if ( promedio >= 5001 || promedio <= 10000){
            refClientes.cpmonto = MONTO_DOS;
        }
        if ( promedio >= 10001){
            refClientes.cpmonto = MONTO_TRES;
        }
        //Actualiza el Objeto alojado en la lista
        listaClientes.editarPorReferencia(getCliente(idCliente,listaClientes), (Object) refClientes);
    }
    /**
     * Determina la «clasificación por frecuencia» al Cliente según la cantidad de viajes (cantViajesClientes) que el cliente 
     * haya realizado durante el año en curso
     * @param idClientes identificador del Cliente
     * @param listaClientes lista dominio en donde se buscará 'idClientes'
     * @param cantViajesClientes  numero de viajes realizado durante el año en curso
     */
    public void setCPFrecuecia(String idClientes, ListaSimple listaClientes, int cantViajesClientes){
        //Castea el objeto que retorna getCliente
        Clientes refClientes = (Clientes) getCliente(idClientes,listaClientes);
        //Según la cantidad de viajes por año se elige una FRECUENCIA
        if ( cantViajesClientes == 1 ){
            refClientes.cpfrecuencia = FRECUENCIA_UNO;
        }
        if ( cantViajesClientes == 12 ){
            refClientes.cpfrecuencia = FRECUENCIA_DOS;
        }
        if ( cantViajesClientes >= 13 || cantViajesClientes <= 24){
            refClientes.cpfrecuencia = FRECUENCIA_TRES;
        }
        if ( cantViajesClientes >= 25 ){
            refClientes.cpfrecuencia = FRECUENCIA_CUATRO;
        }
    }
}
