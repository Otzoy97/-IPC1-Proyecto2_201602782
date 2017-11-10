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
public class LugarEntretenimiento {
    public String id, nombre, detalle, pais, ciudad, direccion, edad_requerida;
    public String hora_inicio, horarios, detalle_seguridad, id_destino;
    /**
     * Establece los datos necesarios para guardar un instancia de LugarEntretenimiento
     * @param id
     * @param nombre
     * @param detalle
     * @param pais
     * @param ciudad
     * @param direccion
     * @param edad_requerida
     * @param hora_inicio
     * @param horarios
     * @param detalle_seguridad 
     * @param id_destino 
     */
    public LugarEntretenimiento(String id, String nombre, String detalle, String pais, String ciudad, String direccion, String edad_requerida, String hora_inicio, String horarios, String detalle_seguridad, String id_destino) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.edad_requerida = edad_requerida;
        this.hora_inicio = hora_inicio;
        this.horarios = horarios;
        this.detalle_seguridad = detalle_seguridad;
        this.id_destino = id_destino;
    }

    public LugarEntretenimiento() {
    }
    
        /**
     * Devuelve la cadena de texto alojada en 'claseReferencia' en la 'posicionComa'
     * @param claseReferencia dominio en donde se cuentra la información solicitada
     * @param posicionComa posición de "columna" donde se cuentra la informacion solicitada
     * @return
     */
    public String getBD(LugarEntretenimiento claseReferencia, int posicionComa){
        //Variable que alojará el texto en a posicionComa de claseReferencia
        String referencia;
        //Según sea la posiciónComa, se guarda en referencia
        switch(posicionComa){
                case 0:
                    referencia = claseReferencia.id;
                    break;
                case 1:
                    referencia = claseReferencia.nombre;
                    break;
                case 2:
                    referencia = claseReferencia.detalle;
                    break;
                case 3:
                    referencia = claseReferencia.pais;
                    break;
                case 4:
                    referencia = claseReferencia.ciudad;
                    break;
                case 5: 
                    referencia = claseReferencia.direccion;
                    break;
                case 6:
                    referencia = claseReferencia.edad_requerida;
                    break;
                case 7:
                    referencia = claseReferencia.hora_inicio;
                    break;
                case 8:
                    referencia = claseReferencia.horarios;
                    break;
                case 9:
                    referencia = claseReferencia.detalle_seguridad;
                    break; 
                case 10:
                    referencia = claseReferencia.id_destino;
                    break;
                default:
                    return null;
            }
        return referencia;
    }
}
