/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BLANCO
 */
public class ConnectionManager {
    
    private static final String JBDC_DRIVER = "org.sqlite.JBDC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\BLANCO\\Documents\\NetBeansProjects\\Examen\\utilidades"
            +"palabrasPatron.sqlite3";
    
    public static Connection conexion;
    
    public static Connection getConnection() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName(JBDC_DRIVER);
                conexion = DriverManager.getConnection(DB_URL);  
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Excepción; "+ ex.toString());
        }
        
        return conexion;
    }
    
}
