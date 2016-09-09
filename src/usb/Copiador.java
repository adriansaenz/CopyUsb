package usb;

import java.awt.Component;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Copiador {
    private String archO, archD, dirO, dirD;
    private File dir;
    
    public Copiador(File dir){
        this.dir = dir;
        buscar(dir);
    }
    
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
    
    private void buscar(File dir){
        File f;
        File[] lista = dir.listFiles();
        for (File elemento : lista){
            String name = elemento.getAbsolutePath().substring(3);
            if(elemento.isFile()) copiar(elemento.getAbsolutePath(),"C:\\Users\\Adrian\\Desktop\\asd\\"+name);
            else if(elemento.isDirectory()){
                f = new File("C:\\Users\\Adrian\\Desktop\\asd\\"+name+"\\");
                f.mkdir();
                buscar(elemento);
            }
        }
    }
    
}
