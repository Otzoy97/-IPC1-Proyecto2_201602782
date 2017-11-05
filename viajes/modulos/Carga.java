/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes.modulos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import viajes.BD.Transporte;
import viajes.listas.ListaSimple;

/**
 *
 * @author HPBEATS
 */
public class Carga {
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
            System.exit(0);
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
        if(file != null){
            BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
            while((texto = fileBuffer.readLine())!=null){
                //Agrega la información proporcionada en 'linea' a una 'lista'
                lista.agregarAlFinal(getObject(texto,lista.getId()));
            }
            fileBuffer.close();
        }
    }
    public void writeFile(){
        
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
            case "transportes":
                Transporte t = new Transporte(atributos[0],atributos[1],atributos[2],atributos[3],atributos[4]);
                return (Object) t;
        }
        return null;
    }
}
