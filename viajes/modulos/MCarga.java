/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.modulos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import viajes.BD.*;
import viajes.listas.Cola;
import viajes.listas.ListaSimple;
import viajes.listas.Pila;

/**
 * Controla la carga y lectura de archivos '.csv'
 * Llena las listas con la informacion proporcionada en los archivos '.csv'
 * 
 * @author HPBEATS
 */
public class MCarga {
    public Transporte transporte;
    public Asiento asiento;
    public Hoteles hoteles;
    public Habitacion habitacion;
    public Cruceros cruceros;
    public Camarot camarot;
    public RentaAutos renta;
    public DestinoTuristico destino;
    public LugarEntretenimiento lugar;
    public Clientes clientes;
    public EntidadFinanciera entidad;
    public Paquetes paquetes;
    public Reservaciones reservaciones;
    /**
     * Consulta el identificador del modulo;
     * @return Identificador de clase
     */
    public String getId(){
        return "Carga";
    }
    /**
     * Despliega un JFileChooser, permitiendóle al usuario seleccionar un archivo '.csv'
     * @return Archivo.csv que se seleccionó para cargar
     */
    public File openFile(){
        //Prepara la ventana para elegir el archivo a cargar
        JFileChooser mFileChooser = new JFileChooser();
        //Limita los archivos que se pueden cargar a CSV
        FileNameExtensionFilter ExtensionFilter = new FileNameExtensionFilter("CSV","csv");
        //Evita que el usuario eliga 'All Files'
        mFileChooser.setAcceptAllFileFilterUsed(false);
        //Aplica el filtro para archivos CSV
        mFileChooser.setFileFilter(ExtensionFilter);
        //Declara la variable en donde se guardará la decisión del usuario
        int resultFileC = mFileChooser.showDialog(null, "Aceptar");
        //Si el usuario ACEPTA se devuelve un Archivo.CSV
        if (resultFileC==JFileChooser.APPROVE_OPTION){
            //Retorna el archivo con la ruta completa según sea el SO
            mFileChooser.getSelectedFile().getAbsolutePath();
            //System.out.print("en OpenFile()" + "\n");
            return mFileChooser.getSelectedFile();
        } else {
            //Sale del programa
            JOptionPane.showMessageDialog(null, "Carga Abortada","MODULO DE CARGA",JOptionPane.WARNING_MESSAGE);
        }
        //Si no existe archivo válido no retorna nada
        return null;
    }
    /**
     * Llena una lista (lista) con 'una' línea leída del archivo (file) '.csv'
     * 
     * @method getObject Crea una clase segun sea el identificador (nombre); separa y almacena los atributos que se proporcionan en 'linea'
     * @param file archivo a leer
     * @param lista a llenar con la línea deseada
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void fillList(File file, ListaSimple lista) throws FileNotFoundException, IOException{
        //Variable en donde se almacena la línea leída
        String texto;
        //Verifica si el archivo es válido 
        //boolean status = true;
        if(file != null){
            BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
            while((texto = fileBuffer.readLine())!=null){
            //    if (status){
            //        status = false;
            //    } else {              
                    lista.agregarAlFinal(getObject(texto,lista.getId()));
            //    }
            }
            fileBuffer.close();
        }
    }
    /**
     * Llena una pila (pila) con 'una' línea leída del archivo (file) '.csv'
     * @method getObject Crea una clase segun sea el identificador (nombre); separa y almacena los atributos que se proporcionan en 'linea'
     * @param cola se llena con la linea deseada
     * @param file archivo a leer
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void llenarCola(File file, Cola cola) throws FileNotFoundException, IOException{
        //Variable en donde se almacena la línea leída
        String texto;
        //Verifica si el archivo es válido 
        //boolean status = true;
        if(file != null){
            BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
            while((texto = fileBuffer.readLine())!=null){
                //if (status){
                //    status = false;
                //} else {
                    cola.Encolar(getObject(texto,cola.getId()));
                //}
            }
            fileBuffer.close();
        }
    }
    public void writeFile(String ruta, ListaSimple lista) throws IOException{
        File csv = new File(ruta);
        //
        PrintWriter pw = new PrintWriter(new FileWriter(csv));
        while(!lista.esVacia()){
          //  if (status){
            //    status = false;
            //}
            pw.println(getLinea(lista.listar(),lista.getId()));
        }
        pw.close();   
    }
    public void writeFile(String ruta, Cola cola) throws IOException{
        File csv = new File(ruta);
        //
        PrintWriter pw = new PrintWriter(new FileWriter(csv));
        while(!cola.esVacia()){
          //  if (status){
            //    status = false;
            //}
            pw.println(getLinea(cola.Desencolar(),cola.getId()));
        }
        pw.close();
    }
    public String getLinea(Object objeto, String nombre){
        //Segun sea la lista, se llenará con los datos que contiene la linea del archivo '.csv' cargado
        switch(nombre){
            case "transporte":
                Transporte temp = (Transporte) objeto;
                return temp.id + "," + temp.hora_salida + "," + temp.hora_llegada+ "," +temp.max_pasajeros+ "," +temp.id_destino;
            case "asiento":
                Asiento temp0 = (Asiento) objeto;
                return temp0.id_transporte+","+temp0.id_reservacion+","+temp0.no_asignado+","+temp0.clase+","+temp0.monto_pasaje;
            case "hoteles":
                Hoteles temp1 = (Hoteles) objeto;
                return temp1.id+","+temp1.direccion+","+temp1.max_pieza+","+temp1.id_destino;
            case "habitacion":
                Habitacion temp2 = (Habitacion) objeto;
                return temp2.id_hoteles+","+temp2.no_pieza+","+temp2.id_reservacion+","+temp2.max_ocupante+","+temp2.precio+","+temp2.clase;
            case "cruceros":
                Cruceros temp3 = (Cruceros) objeto;
                return temp3.id+","+temp3.fecha_salida+","+temp3.fecha_llegada+","+temp3.max_viajero+","+temp3.max_duracion+","+temp3.detalle+","+temp3.id_destino;
            case "camarot":
                Camarot temp4 = (Camarot) objeto;
                return temp4.id_crucero+","+temp4.id_reservacion+","+temp4.c_asignado+","+temp4.precio;
            case "renta_autos":
                RentaAutos temp5 = (RentaAutos) objeto;
                return temp5.id+","+temp5.id_cliente+","+temp5.max_ocupantes+","+temp5.tipo_terreno+","+temp5.dias_rentado+","+temp5.precio+","+temp5.fecha_entrega+","+temp5.fecha_devolucion+","+temp5.detalle;
            case "destinos":
                DestinoTuristico temp6 = (DestinoTuristico) objeto;
                return temp6.id+","+temp6.pais+","+temp6.ciudad+","+temp6.direccion+","+temp6.nombre_destino+","+temp6.detalle_seguridad;
            case "lugares":
                LugarEntretenimiento temp7 = (LugarEntretenimiento) objeto;
                return temp7.id+","+temp7.nombre+","+temp7.detalle+","+temp7.pais+","+temp7.ciudad+","+temp7.direccion+","+temp7.edad_requerida+","+temp7.hora_inicio+","+temp7.horarios+","+temp7.detalle_seguridad+","+temp7.id_destino;
            case "clientes":
                Clientes temp8 = (Clientes) objeto;
                return temp8.id+","+temp8.nombre+","+temp8.apellido+","+temp8.notarjeta+","+temp8.fecnacimiento+","+temp8.telefono+","+temp8.celular+","+temp8.domicilio+","+temp8.cpfrecuencia+","+temp8.cpmonto;
            case "entidad":
                EntidadFinanciera temp9 = (EntidadFinanciera) objeto;
                return temp9.id+","+temp9.id_clientes+","+temp9.tipo+","+temp9.codigo+","+temp9.saldo+","+temp9.limite;
            case "paquetes":
                Paquetes temp10 = (Paquetes) objeto;
                return temp10.id+","+temp10.tipo+","+temp10.clasificacion+","+temp10.max_pasajeros+","+temp10.id_transporte+","+temp10.id_hospedaje+","+temp10.id_crucero+","+temp10.id_autos_renta+","+temp10.id_destino+","+temp10.id_lugar+","+temp10.precio;
            case "reservaciones":
                Reservaciones temp11 = (Reservaciones) objeto;
                return temp11.id+","+temp11.id_paquete+","+temp11.id_cliente+","+temp11.fecha_reserva+","+temp11.fecha_partida+","+temp11.max_dias+","+temp11.estado+","+temp11.adeudo;
        }       
        return null;
    }
    /**
     * Crea una clase segun sea el identificador (nombre); separa y almacena los atributos que se proporcionan en 'linea'
     * @param linea que contiene los atributos a guardar
     * @param nombre o identificador de la clase en donde se desea guardar la 'linea' de informacion
     * @return Object a guardar en una lista
     */
    public Object getObject(String linea, String nombre){
        String[] atributos = linea.split(",");
        //Segun sea la lista, se llenará con los datos que contiene la linea del archivo '.csv' cargado
        switch(nombre){
            case "transporte":
                transporte = new Transporte(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4]);
                return transporte;
            case "asiento":
                asiento = new Asiento(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4]);
                return asiento;
            case "hoteles":
                hoteles = new Hoteles(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3]);
                return hoteles;
            case "habitacion":
                habitacion = new Habitacion(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5]);
                return habitacion;
            case "cruceros":
                cruceros = new Cruceros(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6]);
                return cruceros;
            case "camarot":
                camarot = new Camarot(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3]);
                return camarot;
            case "renta_autos":
                renta = new RentaAutos(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8]);
                return renta;
            case "destinos":
                destino = new DestinoTuristico(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5]);
                return destino;
            case "lugares":
                lugar = new LugarEntretenimiento(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8],
                    atributos[9],
                    atributos[10]);
                return lugar;
            case "clientes":
                clientes = new Clientes(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8],
                    atributos[9]);
                return clientes;
            case "entidad":
                entidad = new EntidadFinanciera(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5]);
                return entidad;
            case "paquetes":
                paquetes = new Paquetes(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8],
                    atributos[9],
                    atributos[10]);
                return paquetes;  
            case "reservaciones":
                reservaciones = new Reservaciones(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7]);
                return reservaciones;                
        }       
        return null;
    }
}
