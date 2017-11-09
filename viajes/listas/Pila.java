/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.listas;

import viajes.BD.Reservaciones;

/**
 * Define la forma en la que se almacenan los Nodos, apilandolos.
 * @author HPBEATS
 */
public class Pila {
    /**
     * Indica el inicio de la pila
     */
    public Nodo primero;
    /**
     * Guarda el tamaño de la pila
     */
    private int size; 
    /**
     * Devuelve el identificador de la pila
     */
    private final String id;
    /**
     * Consulta cuántos (nodos) elementos tiene la pila
     * @return 
     */
    public int getSize(){
        return size;
    }
    /**
     * Consulta el identificador de la pila
     * @return identificador o nombre asignado a la pila
     */
    public String getId(){
        return id;
    }
    /**
     * Constructor por defecto
     * @param nombre o identificador de la pila
     */
    public Pila(String nombre){
        this.primero = null;
        this.size = 0;
        this.id = nombre;
        //primero = new Nodo(dato);
    }
    /**
     * Consulta si la pila esta vacía
     * @return true si el primero nodo (primero), no apunta a otro nodo 
     */
    public boolean esVacia(){
        return primero == null;
    }
    /**
     * Apila un nuevo nodo al ya existente en la pila
     * @param obj Objeto a almacenar en el nodo
     */
    public void Apilar(Object obj){
        Nodo nuevo = new Nodo(obj);
        nuevo.siguiente = primero;
        primero = nuevo;
        size++;
    }
    /**
     * Desapila el nodo en la 'superficie' de la pila
     * @return Object
     */
    public Object Desapilar(){
        Object obj = primero.objeto;
        primero = primero.siguiente;
        size--;
        return obj;
    }
    /**
     * Devuelve el objeto que se encuentra en la cima
     * @return 
     */
    public Object Ver(){
        if (!esVacia()){
            return primero.objeto;  
        }
        return null;
    }
    /**
     * Verifica la existencia de un objeto a lojado en la
     * pila al hacerlo coincideir con 'referencia'
     * @param referencia con la que se buscara coincidencia en la pila
     * @return 
     */
    public boolean buscar(Object referencia){
        //Crea una copia de la pila
        Nodo aux = primero;
        //Bandera para verificar si existe el elemento a buscar
        boolean existe = false;
        //Recorre la pila hasta encontrar el nodo o llegar al final 
        //de la pila
        while(existe!=true && aux!=null){
            //Compara si el valor del nodo
            //es igual al de la referencia
            if (referencia==aux.objeto){
                //Cambia el valor de la bandera
                existe = true;
            } else {
                aux = aux.siguiente;
            }
        }
        return existe;
    }
    /**
     * Devuelve un objeto según una 'expresion' a comparar, 
     * dicha 'expresion' se aloja en la 'posicionComa' del 
     * objeto guardado en el nodo
     * @param expresion valor a comparar con la información que guarda el objeto del nodo de la pila
     * @param posicionComa poisicion en la que se encuentra la expresion a comparar
     * @return 
     */
    public Object buscar(String expresion, int posicionComa){
        //Crea una copia de la pila
        Nodo aux = primero;
        //Crea otra copia de la lista
        Nodo temp = primero;
        //Variable en donde se guardará la referencia a comparar con 'expresion
        String referencia;
        //Tipo de objeto guardado
        String objeto = getId();
        //System.out.println(objeto);
        //Elegi cómo va a castear los objetos
        try {
            //switch(objeto){
            //    case "reservaciones"://Castea el objeto del nodo aux
                    Reservaciones reservaciones = (Reservaciones) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = reservaciones.getBD(reservaciones, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        reservaciones = (Reservaciones) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = reservaciones.getBD(reservaciones,posicionComa);
                    }
                    return reservaciones;
            ///}
        } catch (Exception e){
            return null;
        }
    }
}
