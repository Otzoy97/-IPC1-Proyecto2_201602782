/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.listas;
/**
 *
 * @author HPBEATS
 */
public class ListaSimple {
    public Nodo inicio;
    //Llevará el conteo de Objetos
    private int size; 
    //Identifica a la lista
    private String id;
    /**
     * Consulta cuántos (nodos) elementos tiene la lista
     * @return número entero
     */
    public int getSize() {
        return size;
    }
    /**
     * Consulta el identificador de la lista
     * @return identificador o nombre de lista asignado
     */
    public String getId(){
        return id;
    }
    
    /**
     * Constructor por defecto
     * @param nombre o identificador de la lista
     */
    public ListaSimple(String nombre){
        this.inicio = null;
        this.size = 0;
        this.id = nombre;
    }
    /**
     * Consulta si la lista esta vacía
     * @return true si el primer nodo (inicio), no apunta a otro nodo
     */
    public boolean esVacia(){
        return inicio == null;
    }
    /**
     * Agrega un nuevo nodo al final de la lista
     * @param clase objeto a almacenar en el nodo
     */
    public void agregarAlFinal(Object clase){
        Nodo nuevo = new Nodo(clase);
        if (esVacia()){
            inicio = nuevo;
        } else {
            /**
             * El objeto  a insertar  no es el «inicio»
             * de la lista, por lo que recorre la lista
             * hasta llegar al último nodo y agrega el 
             * objeto
             */
            Nodo aux = inicio;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        size++;
    }
    /**
     * Busca si existe un Objeto en la lista
     * @param referencia (Objeto) a buscar
     * @return true si existe el Objeto en la lista
     */
    public boolean buscar(Object referencia){
        Nodo aux = inicio;//Crea una copia de la lista
        boolean existe = false;//Servirá para indicar si el objeto existe o no
        //Realiza un recorrido, muy parecido a la mecánica for each, 
        //hasta encontrar el Objeto o hasta llegar al final de la lista
        while(aux != null && existe != true){
            if(referencia == aux.objeto){
                //Referencia encontrada!
                existe = true;
            } else {
                //Avanza al siguiente nodo
                aux = aux.siguiente;
            }
        }
        return existe;
    }
    /**
     * Actualiza el valor de un nodo que se encuentre en la lista
     * ubicado por un Objeto de referencia
     * @param referencia,Objeto del nodo que se desea actualizar 
     * @param clase, nuevo Objeto para el nodo.
     */
    public void editarPorReferencia(Object referencia, Object clase){
        //Consulta si el objeto existe
        if(buscar(referencia)){
            //Crea una copia de la lista
            Nodo aux = inicio;
            while(aux.objeto != referencia){
                aux = aux.siguiente;
            }
            //Actualiza la lista
            aux.objeto = clase;
        }
    }
    /**
     * Elimina un nodo que se encuentre en la lista
     * según un Objeto de referencia 
     * @param referencia, Objeto del nodo que se desea eliminar
     */
    public void removerPorReferencia(Object referencia){
        //Verifica si existe el Objeto en la lista
        if(buscar(referencia)){
            //Verifica sí el nodo a eliminar es el primero
            if(inicio.objeto==referencia){
                //Arregla el apuntador hacia el siguiente
                inicio = inicio.siguiente;
            } else {
                //Crea una copia de la lista
                Nodo aux = inicio;
                //Recorre la lista y se detiene 
                //justo antes del Nodo que contiene el 
                //Objeto referencia
                while(aux.siguiente.objeto!=referencia){
                    aux = aux.siguiente;
                }
                //Guarda el nodo siguiente del nodo a eliminar.
                Nodo siguiente = aux.siguiente.siguiente;
                //Enlaza el nodo anterior al de eliminar con 
                //el siguiente despues de el.
                aux.siguiente = siguiente;
            }
            //Disminuye el contador
            size--;
        }
    }
    /**
     * Imprimir en pantalla 
     */
    public void listar(){
        //Verifica si la lista contiene elementos
        if(!esVacia()){
            //Crea una copia de la lista
            Nodo aux = inicio;
            //Posicion de los elementos de la lista
            int i = 0;
            //Recorre la lista hasta el final
            while(aux != null){
                //Imprime en pantalla el valor del nodo
                System.out.print(i + ".-[" + aux.objeto + "]" + " ► ");
                //Avanza ►►►
                aux = aux.siguiente;
                i++;
            }
        }
    }
}
