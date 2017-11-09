/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.listas;

/**
 * Define los elementos de un Nodo
 * @author HPBEATS
 */
public class Nodo {
    /**
     * Enlaza los nodos
     */ 
    public Nodo siguiente;
    /**
     * Enlaza los nodos
     */
    public Nodo anterior;
    /**
     * Guarda un valor entero
     */
    //public int dato;
    /**
     * Guarda un objeto
     */
    public Object objeto;
    /**
     * Guarda un String
     */
    public String cadena;
    /**
     * Constructor por defecto
     */
    public Nodo(){
    }
    /**
     * Inicializa el Nodo para que guarde tipos Object
     * @param objeto a almacenar 
     */
    public Nodo(Object objeto){
        this.objeto = objeto;
    }
    /**
     * Inicializa el Nodo para que guarda tipos int
     * @param dato entero a almacenar
     */
    //public Nodo(int dato){
    //    this.dato = dato;
    //}
    /**
     * Inicializar el Nodo para que gurde tipos String
     * @param cadena 
     */
    //public Nodo(String cadena){
    //    this.cadena = cadena;
    //}
}
