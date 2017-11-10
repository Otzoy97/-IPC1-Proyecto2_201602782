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
import java.util.logging.Level;
import java.util.logging.Logger;
import viajes.BD.*;
import viajes.listas.*;
/**
 * Controla el registro de las Reservaciones
 * Administra la información del Paquete reservado por el Cliente
 * @author HPBEATS
 */
public class MReservaciones {
    MCarga carga = new MCarga();
    /**
     * Estado anulada
     */
    String ANULADA = "Anulada";
    /**
     * 
     */
    String RESERVA = "Reserva";
    /**
     * 
     */
    String PAGADA = "Pagada";
    /**
     * 
     */
    String VENCIDA = "Vencida";
    /**
     * 
     */
    String ESPERA ="En espera";
    /**
     * Obtiene la información de todas las reservaciones que el cliente 
     * ,asociado a 'idCliente',  ha realizado 
     * 
     * El array que devuelve puede ser nulo
     * @param idCliente identificador del cliente
     * @param colaReservaciones cola dominio en dónde se buscara el 'idCliente'
     * @return 
     */
    public String[] getResBCliente(String idCliente, Cola colaReservaciones){
        //Array que guardará la información de las reservaciones 
        String[] fivelast;
        //Crea copias de la cola en donde se aloja las 'Reservaciones'
        Nodo aux = colaReservaciones.primero;
        Nodo temp = colaReservaciones.primero;
        //Variable que ayudara a llevar un conteo de la cantidad de reservaciones asociada
        //a 'idCliente'
        int contador = 0;
        //Servirá para castear el objeto del nodo
        Reservaciones reservaciones;
        //Verifica si se debe recorrer mas de 5 reservaciones de las necesesarias
        while (aux!=null){
            //Caste al objeto del nodo
            reservaciones = (Reservaciones) aux.objeto;
            //Verifica que la información de nodo se la del cliente 'idCliente'
            if (reservaciones.getBD(reservaciones, 2).equals(idCliente)){
                //Aumenta el contador
                contador++;
            }
            //Se mueve al siguiente nodo
            aux = aux.siguiente;
        }
        //Declara los espacios en el array
        fivelast = new String[contador];
        //Verifica que el contador no sea cero
        while (contador!=0){
            //Castea el objeto del nodo
            reservaciones = (Reservaciones) temp.objeto;
            //Verifica que la información de nodo se la del cliente 'idCliente'
            if (reservaciones.getBD(reservaciones, 2).equals(idCliente)){
                //Guarda la informacion del 'idCliente'
                //Desde el último espacio, hasta el primero
                //De atrás para adelante
                fivelast[contador-1] = reservaciones.id_paquete + "&&" + 
                        reservaciones.fecha_reserva + "&&" + 
                        reservaciones.fecha_partida + "&&"+
                        reservaciones.max_dias + "&&" + 
                        reservaciones.estado + "&&" + 
                        reservaciones.adeudo;
                //Diminuye el contador
                contador--;
            }
            //Se mueve al siguiente nodo
            temp = temp.siguiente;
        }
        return fivelast;
    }
    /**
     * Devuelve diferencias entre fechas
     * @param fechaMayor
     * @param fechaMenor
     * @return 
     */
    public int verifyRangeDate(java.util.Date fechaMayor , java.util.Date fechaMenor){
        return Math.round( ( fechaMayor.getTime() - fechaMenor.getTime() ) / (1000*60*60*24)  ) ;
    }
    /**
     * Provee la opcion de ANULAR una reservacion en particular que se encuentre en "Reserva"
     * Si se ANULA dentro de los 15 días siguientes se desembolsará el  50% del pago realizado, caso contrario
     * no se desembolsa nada
     * 
     * @param expresion id de la Reservacion a ANULAR
     * @param colaReservacion cola en donde se cuentra las reservaciones
     * @param listaPaquetes lista en donde se aloja la información de los paquetes
     * @param listaEntidadFinanciera lista en donde se aloja la información de las entidades financieras
     */
    public void cancelarReserva(String expresion , Cola colaReservacion, ListaSimple listaPaquetes, ListaSimple listaEntidadFinanciera){
        //
        Reservaciones ref = (Reservaciones) colaReservacion.buscar(expresion, 0);
        //
        Paquetes aux = (Paquetes) listaPaquetes.buscar(ref.id_paquete,0);
        //
        EntidadFinanciera expr = (EntidadFinanciera) listaEntidadFinanciera.buscar(ref.id_cliente, 0);
        //
        float adicionSaldo = Float.parseFloat(aux.precio) - Float.parseFloat(ref.adeudo);
        //
        if ( ref.estado.equals("Reserva") ){
            //
            MClientes mm = new MClientes();
            //
            DateFormat input = new SimpleDateFormat(mm.tryParse(ref.fecha_reserva));
            //obtiene la fecha actual
            Date ff = new Date();
            try {
                if (verifyRangeDate(ff,input.parse(ref.fecha_reserva)) <= 15){
                    expr.saldo = ""+ ( Float.parseFloat(expr.saldo) - adicionSaldo*0.5 );    
                }
            } catch (ParseException ex) {
                Logger.getLogger(MReservaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            //
            ref.estado = ANULADA;
            //
            ref.adeudo = "0";
        }
    }
    /**
     * Busca el número de asientos y el último asiento ocupado
     * @param expresion debe ser "dd/MM/yyyy"+idAHC <- de referencia
     * @param idAHC id del transporte a buscar
     * @param colaReservaciones 
     * @param listaAHC
     * @return 
     */
    public String[] obtenerUltimoAHC(String expresion ,String idAHC,  Cola colaReservaciones, ListaSimple listaAHC){
        //Castea MClientes para lograr acceder a sus metodos
        MClientes mm = new MClientes();
        //Declara el array que servirá para alojar la información solicitada
        String[] retorno = new String[2];
        //Llevará la cuenta de los asientos asignados
        int cuenta = 0;
        //Realiza una copia de la lista
        Nodo temp = listaAHC.inicio;
        //Guardará el último asiento asignado
        String ultimo = "";
        //Servirá para castear los objeto de los nodos de la colaReservaciones
        Reservaciones refReservas;
        //Servira para alojar el formato adecuado a las fechas obtendas
        DateFormat auxFecha;
        //Dará el formato deseado a comparar
        SimpleDateFormat auxFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Cuidado con los errores
        //try{
            //Crea una variable temporal que servira para compara con expresion
            String referencia;
            //Segun el objeto guardado en la lista se procederá con el mismo procedimiento
            switch(listaAHC.getId()){
                case "asiento":
                    //Aquí se alojaran los casteos de <-asiento
                    Asiento refAsiento;
                    //Seguirá hasta que el nodo sea nulo
                    while (temp!=null){
                        //Castea el objeto del nodo
                        refAsiento = (Asiento) temp.objeto;
                        //Obtiene el id de la reservaciono
                        String getId = refAsiento.id_reservacion;
                        //Busca la Reservacion asociada al valor encontrado anteriormente
                        refReservas = (Reservaciones) colaReservaciones.buscar(getId, 0);
                        //Busca el formato adecuado a la fecha de partida de reservacion anterior
                        auxFecha = new SimpleDateFormat(mm.tryParse(refReservas.fecha_partida));
                        //
                        referencia = refReservas.fecha_partida + idAHC;
                        try {
                            //Acopla la referencia -> dd/MM/yyyy + idAHC
                            referencia = auxFormat.format(auxFecha.parse(refReservas.fecha_partida)) + idAHC;
                        } catch (ParseException ex) {
                            Logger.getLogger(MReservaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //Verifica que la referencia y la expresion dada sean iguales
                        if (expresion.equals(referencia)){
                            //Aumenta el contador
                            cuenta++;
                            //Devuelve el asiento asignado relacionado al nodo asiento
                            ultimo = refAsiento.no_asignado;
                        }
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                    }
                    //Cuando el nodo sea nulo, saldrá del switch
                    break;
                case "habitacion":
                    //
                    Habitacion refHabitacion = (Habitacion) listaAHC.buscar(idAHC,0);
                    ultimo = refHabitacion.no_pieza;
                    //
                    while (temp!=null){
                        //
                        refHabitacion = (Habitacion) temp.objeto;
                        String getId = refHabitacion.id_reservacion;
                        refReservas = (Reservaciones) colaReservaciones.buscar(getId, 0);
                        auxFecha = new SimpleDateFormat(mm.tryParse(refReservas.fecha_partida));
                        referencia = refReservas.fecha_partida + idAHC;
                        try {
                            referencia = auxFormat.format(auxFecha.parse(refReservas.fecha_partida)) + idAHC;
                        } catch (ParseException ex) {
                            Logger.getLogger(MReservaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //
                        if (expresion.equals(referencia)){
                            cuenta++;
                            ultimo = refHabitacion.no_pieza;
                        }
                        //
                        temp = temp.siguiente;
                    }
                    break;
                case "camarot":
                    //
                    Camarot refCamarot = (Camarot) listaAHC.buscar(idAHC,0);
                    ultimo = refCamarot.c_asignado;
                    //
                    while (temp!=null){
                        //
                        refCamarot = (Camarot) temp.objeto;
                        String getId = refCamarot.id_reservacion;
                        refReservas = (Reservaciones) colaReservaciones.buscar(getId, 0);
                        auxFecha = new SimpleDateFormat(mm.tryParse(refReservas.fecha_partida));
                        referencia = refReservas.fecha_partida + idAHC;
                        try {
                            referencia = auxFormat.format(auxFecha.parse(refReservas.fecha_partida)) + idAHC;
                        } catch (ParseException ex) {
                            Logger.getLogger(MReservaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //
                        if (expresion.equals(referencia)){
                            cuenta++;
                            ultimo = refCamarot.c_asignado;
                        }
                        //
                        temp = temp.siguiente;
                    }
                    break;
            }
        //}catch(Exception e){
      //  }
        retorno[0] = ultimo;
        retorno[1] = cuenta+"";
        return retorno;
    }
    /**
     * Devuelve la cantidad de asientos, habitaciones y camarotes 
     * @param asientosAsignados asientos, habitaciones y camarotes que ya están asignados
     * @param idTransporte identificador del Transporte, Hotel, Crucero
     * @param listaTransportes lista en donde sea alojan los objetos Transporte, Hotel, Crucero
     * @return 
     */
    public int disponiblesAHC(int asientosAsignados, String idTransporte, ListaSimple listaTransportes){
        switch(listaTransportes.getId()){
            case "transporte":
                //Obtiene el objeto transporte deseado 
                Transporte refTrans = (Transporte) listaTransportes.buscar(idTransporte, 0);
                //Determina el numero de asientos disponibles
                return Integer.parseInt(refTrans.max_pasajeros) - asientosAsignados;
            case "hoteles":
                //Obtiene el objeto transporte deseado 
                Hoteles refHotel = (Hoteles) listaTransportes.buscar(idTransporte, 0);
                //Determina el numero de asientos disponibles
                return Integer.parseInt(refHotel.max_pieza) - asientosAsignados;
            case "cruceros":
                //Obtiene el objeto transporte deseado 
                Cruceros refCruc = (Cruceros) listaTransportes.buscar(idTransporte, 0);
                //Determina el numero de asientos disponibles
                return Integer.parseInt(refCruc.max_viajero) - asientosAsignados;
        }
        return -1;
    }
}
