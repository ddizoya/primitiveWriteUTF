/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddizoya
 */
public class PrimitivosUTF {

    String fichero = "/datos/local/ddizoya/Desktop/texto3.txt";
    DataInputStream dis;
    DataOutputStream dos;
    int cantidad;

    public void proceder(String str) throws IOException {
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)));
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
        
            dos.writeUTF(str);
            dos.flush();
            //Con available guardamos la cantidad disponible a leerse por dis, y que
            //por tanto ocupa la linea escrita.
            cantidad = dis.available(); 
            System.out.println("writeUTF ha escrito: " + dis.readUTF());
            System.out.println("Cantidad escrita: " + cantidad + " bytes.\n\n");
            
    
            dos.writeUTF(str);
            dos.flush();
            cantidad = dis.available(); //Sobreescribimos la cantidad que vamos a leer y que ocupa la linea.
            System.out.println("writeUTF ha escrito: " + dis.readUTF());
            System.out.println("Cantidad escrita: " + cantidad + " bytes.\n\n");
         
            System.out.println("Bytes totales escritos: " + dos.size()); //Size nos da el tamaño TOTAL de las dos lineas leidas.
            
            
       

            //System.out.println("writeUTF ha escrito: "+ textoL);
        } catch (FileNotFoundException ex) {
            System.out.println("Error en el streaming de entrada.");
        } catch (IOException ex) {
            Logger.getLogger(PrimitivosUTF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dis.close();
            dos.close();
        }

    }

    
    

    public static void main(String[] args) {
        try {
            PrimitivosUTF obj = new PrimitivosUTF();
            obj.proceder("Esto es una cadena");
            
        } catch (IOException ex) {
            System.err.println("Error en el main.");
        }
        
    }

}
