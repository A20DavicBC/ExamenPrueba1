/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.List;
import modelo.XogoAzar;
import modelo.XogoLetras;

/**
 *
 * @author A20DavidBC
 */
public class AppXogoLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        XogoLetras xogo = new XogoLetras();
        
        List<String> palabras = new ArrayList<>();
        
        if (!xogo.setPalabras(palabras)) {
            System.out.println("Está vacía o es nula");
        }
        
        /*for (int i = 0; i < 10; i++) {
            char c = xogo.getConsoante();
            System.out.println(c);*/
            
        }
    }
    
}
