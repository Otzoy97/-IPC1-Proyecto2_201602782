/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import viajes.BD.*;
import viajes.listas.*;
import viajes.modulos.*;

/**
 *
 * @author HPBEATS
 */
public class VIAJES {
        protected Cola transportes = new Cola("reservaciones");
        protected ListaSimple entidad = new ListaSimple("entidad");
        protected ListaSimple asientos = new ListaSimple("asiento");
    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here
        VIAJES vij = new VIAJES();
        vij.VIAJES();
    }
    public void VIAJES(){

        viajes.modulos.Carga carga = new viajes.modulos.Carga();
        try {
            carga.llenarCola(new File("C:\\Users\\HPBEATS\\Desktop\\09 Reservaciones.csv"), transportes);
            carga.fillList(new File("C:\\Users\\HPBEATS\\Desktop\\04 EntidadFinanciera.csv"), entidad);
            carga.fillList(new File("C:\\Users\\HPBEATS\\Desktop\\11 Asientos.csv"), asientos);
        } catch (IOException ex) {
            Logger.getLogger(VIAJES.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat n = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        System.out.println(n.format(d));
        String dd =n.format(d);
    }
    /*public void imprimir(){
        ListaSimple aux = transportes;
        Transporte ref;
        while(aux.inicio.siguiente != null){
            aux.inicio = aux.inicio.siguiente;
            ref = (Transporte)aux.inicio.objeto;
            System.out.println(ref.id + " -- Destino : " + ref.id_destino + " Pasajeros: " + ref.max_pasajeros );
        }
        System.out.println("");
        transportes.listar();
    }*/
}