/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import javax.swing.JFrame;
import modelo.XogoAzar;
import modelo.XogoLetras;
import BD.ConnectionManager;
import BD.PalabraDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import vista.PanelLetras;
import vista.VentanaLetras;

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
        
        Connection con = ConnectionManager.getConnection();
        
        PalabraDAO palabraDAO = new PalabraDAO(con);
        
        List<String> palabras = palabraDAO.getAll();
        
        palabraDAO.insert("int insertadas");
        
        palabras.forEach(palabra -> {
            System.out.println(palabra);
        });

        String descripcion = palabraDAO.getDefinicion("Vigo");
        
        System.out.println("Vigo: " + descripcion);
        XogoLetras xogo = new XogoLetras();
        
        VentanaLetras v = new VentanaLetras();
        
        JFrame venta = new JFrame("Ventana panel");
        PanelLetras panel = new PanelLetras();
        
        venta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        venta.add(panel);
        venta.pack();
        venta.setLocationRelativeTo(null);
        
        venta.setVisible(true);
        
        List<String> palabras1 = new ArrayList<>();
        if (!xogo.setPalabras(palabras)) {
            System.out.println("Está vacía o es nula");
        }
        for (int i = 0; i < 10; i++) {
            char c = xogo.getConsoante();
            System.out.println(c);
        }
            
    }
}
    
