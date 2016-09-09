/*
Esta clase contiene los metodos para buscar los archivos del pendrive 
y copiarlos en el escritorio.
------------------------------------------------------
This class includes the methods for search the pendrive files
and copy it in the desktop.
*/
package usb;

import java.io.*;

public class Copiador {
    
    private File dir;
    
    public Copiador(File dir){
        this.dir = dir;
        buscar(dir);
    }
    /*
    Esta funcion copia un archivo desde la direccion origen a la direccion destino.
    */
    private void copiar(String origen, String destino){
        try{
        File archivo = new File(destino);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        }catch(IOException e){ System.out.println("error: "+e.getMessage()); }
    }
    
    /*
    Esta funcion lista todo los ficheros que contiene el pendrive. 
    Si es archivo lo copia en la carpeta del escritorio. 
    Si es directorio vuelve a llamar a buscar con el nuevo directorio.
    */
    private void buscar(File dir){
        File f;
        File[] lista = dir.listFiles();
        for (File elemento : lista){
            String name = elemento.getAbsolutePath().substring(3);
            if(elemento.isFile()) copiar(elemento.getAbsolutePath(),"C:\\Users\\Adrian\\Desktop\\Archivos\\"+name);
            else if(elemento.isDirectory()){
                f = new File("C:\\Users\\Adrian\\Desktop\\Archivos\\"+name+"\\");
                f.mkdir();
                buscar(elemento);
            }
        }
    }
    
}
