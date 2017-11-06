/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.listas;

/**
 * Define la forma en la que se almacenan los Nodos, apilandolos.
 * @author HPBEATS
 */
public class Pila {
    public Nodo primero;
    //Llevará el conteo de Objetos
    private int size; 
    //Identifica a la pila
    private String id;
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
     * Despila el nodo en la 'superficie' de la pila
     * @return Object
     */
    public Object Desapilar(){
        Object obj = primero.objeto;
        primero = primero.siguiente;
        size--;
        return obj;
    }
}
