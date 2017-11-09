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
import viajes.listas.Cola;
import viajes.listas.Pila;
/**
 * Controla la forma de registrar la información relacionada con 'viajes.BD.Clientes'
 * @author HPBEATS
 */
public class MClientes {
    /**
     * 
     */
    String[] formateDate = {"dd/MM/yy","dd-MM-yy","dd/MM/yyyy","dd-MM-yyyy"};
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
     * Instancia 'Clientes' para acceder a sus métodos;
     */
    private Clientes clientes;
    /**
     * Consulta el identificador del Modulo
     * @return el identificadod el módulo
     */
    public String getId(){
        return "Módulo Clientes";
    }
    /**
     * Consulta la cantidad de viajes (por año o total) que el Cliente ha realizado en Reservaciones
     * @param idCliente referencia a buscar dentro de Reservaciones
     * @param colaDominio dominio en el que se buscara la referencia 'idCliente', casteable a Reservaciones
     * @param porAnio true devuelve el numero de viajes realizados en el año en curso, false el numero de viajes total
     * @return el número de viajes que ha realizado el Cliente
     * @throws java.text.ParseException
     */
    public int getNoViajesClientes(String idCliente, Cola colaDominio, boolean porAnio) throws ParseException{
        //Variable en donde se guardará el numero de viajes que el Cliente ha realizado
        int cant_viajes = 0;
        //Crea una copia de la pilaDominio
        Nodo aux = colaDominio.primero;
        //Crea una instancia de Reservaciones, en donde se guardará el casteo de pilaDominio
        Reservaciones ref;
        //-----------------------------------------------------
        //Determina el formato de año que se le dará a un Date
        DateFormat getAnio = new SimpleDateFormat("yyyy");
        //Da formato dia/mes/año
        DateFormat getFecha;
        //Guarda el año en curso
        int Anio = Integer.parseInt(getAnio.format(new Date()));
        //Crea variables en donde se alojarán las referencia a comparar
        String refCliente;
        String refEstado;
        int Anio_partida;
        //-----------------------------------------------------
        //Se detendrá cuando el nodo de la pila sea nulo
        while(aux!=null){
            //Castea el objeto a Reservaciones
            ref = (Reservaciones) aux.objeto;
            //Determina el valor a comparar
            refCliente = ref.getBD(ref, 2);
            refEstado = ref.getBD(ref, 6);
            //Verifica si el «id_cliente» en reservaciones es igual al «idCliente» de referencia
            if (  ( refCliente.equals(idCliente) ) && ( refEstado.equals("Pagada") ||  refEstado.equals("Reserva") ) ){
                //Verifica si se ordena por fecha
                if ( porAnio ) {
                    //Obtiene el año de la fecha guardada en 'fecha_partida'
                    //Obtiene el formato adecuado para la fecha ingresada
                    getFecha = new SimpleDateFormat( tryParse( ref.getBD(ref, 4) ) );
                    //Guarda el año de la fecha de partida
                    Anio_partida = Integer.parseInt( getAnio.format( getFecha.parse(ref.getBD(ref, 4)) ) );
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
            //Se mueve al siguiete nodo
            aux = aux.siguiente;
        }
        return cant_viajes;
    }
    /**
     * Da un formato válido a la fecha ingresada
     * @param dateString
     * @return 
     */
    public String tryParse(String dateString){
        DateFormat getFecha;
        for (String formato : formateDate){
            try{
                getFecha = new SimpleDateFormat(formato);
                getFecha.parse(dateString);
                return formato;
            } catch (ParseException e){
            }
        }
       return null;
    }
    /**
     * Determina la «clasificación por monto» al Cliente según promedio del saldo (saldoCliente) que el cliente 
     * posee -asociado- en EntidadFinanciera
     * @param idCliente referencia a buscar dentro de un tipo Clientes
     * @param listaClientes lista en donde se encuentra la referencia buscar
     * @param saldoCliente saldo total que posee Clientes en EntidadFinanciera
     * @param cantViajesClientes numero de viajes que el Cliente ha pagado
     */
    public void setCPMonto(String idCliente, ListaSimple listaClientes ,float saldoCliente, int cantViajesClientes){
        int promedio = Math.round(saldoCliente/cantViajesClientes);
        //Castea el objeto que retorna getCliente
        Clientes refClientes = (Clientes) listaClientes.buscar(idCliente, 0);
        //Guarda el valor la clasificacion por monto en nuevoCPMonto
        String nuevoCPMonto  = refClientes.cpmonto;
        //Según el valor de promedio se elige un MONTO        
        if ( promedio < 1000 ){
            nuevoCPMonto = "";
        }
        if ( promedio >= 1000 || promedio <= 5000 ){
            nuevoCPMonto = MONTO_UNO;
        }
        if ( promedio >= 5001 || promedio <= 10000){
            nuevoCPMonto = MONTO_DOS;
        }
        if ( promedio >= 10001){
            nuevoCPMonto = MONTO_TRES;
        }
        //Crea un nuevo cliente, con los mismos atributos
        //Solo con el monto cambiado
        Clientes nuevo = new Clientes(refClientes.id,
            refClientes.nombre,
            refClientes.apellido,
            refClientes.notarjeta,
            refClientes.fecnacimiento,
            refClientes.telefono,
            refClientes.celular,
            refClientes.domicilio,
            refClientes.cpfrecuencia,
            nuevoCPMonto);
        //Actualiza el Objeto alojado en la lista
        listaClientes.editarPorReferencia(refClientes,nuevo);
    }
    /**
     * Determina la «clasificación por frecuencia» al Cliente según la cantidad de viajes (cantViajesClientes) que el cliente 
     * haya realizado durante el año en curso
     * @param idCliente identificador del Cliente
     * @param listaClientes lista dominio en donde se buscará 'idClientes'
     * @param cantViajesClientes  numero de viajes realizado durante el año en curso
     * @param noAniosdeServicio numero de años en los que se a prestado el servicio
     */
    public void setCPFrecuecia(String idCliente, ListaSimple listaClientes, int cantViajesClientes, int noAniosdeServicio){
        int promedio = Math.round( (float) (cantViajesClientes/noAniosdeServicio) );
        //Castea el objeto que retorna getCliente
        Clientes refClientes = (Clientes) listaClientes.buscar(idCliente, 0);
        //Guarda el valor la clasificacion por monto en nuevoCPMonto
        String nuevoCPFrecuencia  = refClientes.cpfrecuencia;
        //Según la cantidad de viajes por año se elige una FRECUENCIA
        if ( promedio == 1 ){
            nuevoCPFrecuencia = FRECUENCIA_UNO;
        }
        if ( promedio == 12 ){
            nuevoCPFrecuencia = FRECUENCIA_DOS;
        }
        if ( promedio >= 13 || cantViajesClientes <= 24){
            nuevoCPFrecuencia = FRECUENCIA_TRES;
        }
        if ( promedio >= 25 ){
            nuevoCPFrecuencia = FRECUENCIA_CUATRO;
        }
        //Crea un nuevo cliente, con los mismos atributos
        //Solo con el monto cambiado
        Clientes nuevo = new Clientes(refClientes.id,
            refClientes.nombre,
            refClientes.apellido,
            refClientes.notarjeta,
            refClientes.fecnacimiento,
            refClientes.telefono,
            refClientes.celular,
            refClientes.domicilio,
            nuevoCPFrecuencia,
            refClientes.cpmonto);
        //Actualiza el Objeto alojado en la lista
        listaClientes.editarPorReferencia(refClientes,nuevo);
    }
}
