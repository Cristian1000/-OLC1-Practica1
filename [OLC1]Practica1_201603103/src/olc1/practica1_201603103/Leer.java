/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.practica1_201603103;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author crist
 */
public class Leer {
    
    public String Texto(){
        String linea = null;
        JFileChooser direccion = new JFileChooser();
        int estado = direccion.showOpenDialog(null);
        if(estado == JFileChooser.APPROVE_OPTION){
            File ruta;
            ruta = direccion.getSelectedFile();
            try {
                linea = buscar(ruta.getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return linea;
    }
    
    public String buscar(String ar) throws FileNotFoundException{
        
        File archivo=null;
        FileReader fr=null;
        BufferedReader br;
        String texto = "";
        try {
            archivo = new File (ar);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
               texto+=linea+"\n";
         }
         catch(Exception e){
            e.printStackTrace();
         }finally{
            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
         }
        
        return texto;
    }
}
