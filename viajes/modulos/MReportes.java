/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.modulos;
import viajes.listas.*;
import viajes.BD.*;
/**
 *
 * @author HPBEATS
 */
public class MReportes {
    /**
     * Copia la informacion de reservaciones a un array
     * @param colaACopiar
     * @return 
     */
    public String[][] copiarPilaReservaciones(Cola colaACopiar){
        //Crea el array a devolver
        String[][] array = new String[colaACopiar.getSize()][8];
        //Crea una copia de la cola
        Nodo aux = colaACopiar.primero;
        //Crea los contadores para controlar la entrada al vector
        int aux1 = 0 ;
        //Recorrerá la cola, hasta que el nodo sea nulo
        while(aux!=null){
            //Castea reservaciones
            Reservaciones tempRes = (Reservaciones) aux.objeto;
            //Guarda en array
            for (int i = 0; i < array[0].length ; i++){
                array[aux1][i] = tempRes.getBD(tempRes, i);
            }
            //Aumenta el contador
            aux1++;
            //Se mueve al siguiente nodo
            aux = aux.siguiente;
        }
        return array;
    }
    /**
     * 
     * @param array 
     */
    public void ordenarArrayReservaciones(String[][] array){
        
    }
}
