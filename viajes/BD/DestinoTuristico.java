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
public class DestinoTuristico {
    public String id, pais, ciudad, direccion, nombre_destino, detalle_seguridad;
    /**
     * Establece los datos necesarios para guardar un instancia de Destino
     * @param id
     * @param pais
     * @param ciudad
     * @param direccion
     * @param nombre_destino
     * @param detalle_seguridad 
     */
    public DestinoTuristico(String id, String pais, String ciudad, String direccion, String nombre_destino, String detalle_seguridad) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre_destino = nombre_destino;
        this.detalle_seguridad = detalle_seguridad;
    }

    public DestinoTuristico() {
    }
    
    /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(DestinoTuristico claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.pais;
                    break;
                case 2:
                    referencia = claseReferencia.ciudad;
                    break;
                case 3:
                    referencia = claseReferencia.direccion;
                    break;
                case 4:
                    referencia = claseReferencia.nombre_destino;
                    break;
                case 5: 
                    referencia = claseReferencia.detalle_seguridad;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
}
