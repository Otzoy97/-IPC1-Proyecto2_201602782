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
public class RentaAutos {
    String id, id_cliente, max_ocupantes;
    String tipo_terreno, dias_rentado, precio;
    String fecha_entrega, fecha_devolucion, detalle;
    /**
     * Establece los datos necesarios para guardar un instancia de RentaAutos
     * @param id
     * @param id_cliente
     * @param max_ocupantes
     * @param tipo_terreno
     * @param dias_rentado
     * @param precio
     * @param fecha_entrega
     * @param fecha_devolucion
     * @param detalle 
     */
    public RentaAutos(String id, String id_cliente, String max_ocupantes, String tipo_terreno, String dias_rentado, String precio, String fecha_entrega, String fecha_devolucion, String detalle) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.max_ocupantes = max_ocupantes;
        this.tipo_terreno = tipo_terreno;
        this.dias_rentado = dias_rentado;
        this.precio = precio;
        this.fecha_entrega = fecha_entrega;
        this.fecha_devolucion = fecha_devolucion;
        this.detalle = detalle;
    }

    public RentaAutos() {
    }
    
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(RentaAutos claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.id_cliente;
                    break;
                case 2:
                    referencia = claseReferencia.max_ocupantes;
                    break;
                case 3:
                    referencia = claseReferencia.tipo_terreno;
                    break;
                case 4:
                    referencia = claseReferencia.dias_rentado;
                    break;
                case 5: 
                    referencia = claseReferencia.precio;
                    break;
                case 6:
                    referencia = claseReferencia.fecha_entrega;
                    break;
                case 7:
                    referencia = claseReferencia.fecha_devolucion;
                    break;
                case 8:
                    referencia = claseReferencia.detalle;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
}
