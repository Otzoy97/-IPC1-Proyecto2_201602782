/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.BD;

/**
 *
 * @author HPBEATS
 */
public class Hoteles {
    public String Id, direccion, Id_destino, max_pieza;
    /**
     * Establece los datos necesarios para guardar un instancia de Hoteles
     * @param Id
     * @param direccion
     * @param max_pieza
     * @param Id_destino 
     */
    public Hoteles(String Id, String direccion, String max_pieza, String Id_destino) {
        this.Id = Id;
        this.direccion = direccion;
        this.max_pieza = max_pieza;
        this.Id_destino = Id_destino;
    }
    
}
