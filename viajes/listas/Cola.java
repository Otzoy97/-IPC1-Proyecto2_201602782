package viajes.listas;

import viajes.BD.Reservaciones;

/**
 * 
 * @author HPBEATS
 */
public class Cola{
    /**
     * Apunta a la cabeza de la 'cola'
     */
    public Nodo primero;
    /**
     * Apunta a la cola de la 'cola'
     */
    public Nodo ultimo;
    /**
     * Llevará el conteo de Objetos
     */
    private int size; 
    /**Identifica a la cola
     */
    private final String id;
    /**
     * Consulta cuántos (nodos) elementos tiene la cola
     * @return 
     */
    public int getSize(){
        return size;
    }
    /**
     * Consulta el identificador de la cola
     * @return identificador o nombre asignado a la pila
     */
    public String getId(){
        return id;
    }
    /**
     * Constructor por defecto
     * @param nombre identificador de la cola
     */
    public Cola(String nombre){
        this.primero = null;
        this.size = 0;
        this.id = nombre;
        ultimo = primero;
    }
    /**
     * Consulta si la cola esta vacía
     * @return 
     */
    public boolean esVacia(){
        return primero == null;
    }
    /**
     * Agrega nodos al final de la cola
     * @param dato 
     */
    public void Encolar(Object dato){
        Nodo nuevo = new Nodo(dato);
        if (esVacia()){    
            primero = nuevo;
            ultimo = primero;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        size++;
    }
    /**
     * Retira la cabeza de la cola
     * @return 
     */
    public Object Desencolar(){
        Object dato = primero.objeto;
        primero = primero.siguiente;
        size--;
        return dato;
    }
    /**
     * Devuelve el valor alojado al principio de la cola
     * @return 
     */
    public Object verPrimero(){
        return primero.objeto;
    }
    /**
     * Devuelve el objeto alojado al final de la cola
     * @return 
     */
    public Object verUltimo(){
        return ultimo.objeto;
    }
    /**
     * Devuelve un objeto según una 'expresion' a comparar, 
     * dicha 'expresion' se aloja en la 'posicionComa' del 
     * objeto guardado en el nodo, busca desde el principio
     * @param expresion valor a comparar con la información que guarda el objeto del nodo de la pila
     * @param posicionComa poisicion en la que se encuentra la expresion a compara
     * @return 
     */
    public Object buscar(String expresion, int posicionComa){
        //Crea dos copias de la cola
        Nodo aux = primero;
        Nodo temp = primero;
        //Variable en donde se guardará la referencia a comparar
        String referencia;
        //Tipo de objeto que guarda el nodo
        //String objeto = getId();
        //Elije cómo castear el objeto
        try {
            //switch(objeto){
            //  case "reservaciones"://Castea el objeto del nodo aux
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
            //}
        } catch (Exception e){
            return null;
        }
    }
}
