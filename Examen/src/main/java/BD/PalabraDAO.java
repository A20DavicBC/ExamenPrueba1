/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BLANCO
 */
public class PalabraDAO {
    
    private Connection conexion;

    public PalabraDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<String> getAll() {
        ArrayList<String> palabras = new ArrayList<>();
        
        Statement st = null;
        try {
            // 1. Crear sentencia
            st = conexion.createStatement();
            // 2. ResultSet
            ResultSet rs = st.executeQuery("SELECT palabra from palabra");
            // 3. Recorrer consulta
            while (rs.next()) {
                String palabra = rs.getString(1);
                palabras.add(palabra);
            }
        } catch (SQLException ex) {
            
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {}
            }
        }
        
        
        return palabras;
    }

    // LEMA
    public String get(String palabra) {
        PreparedStatement ps = null;
        String lema = null;
        
        try {
            ps = conexion.prepareStatement("SELECT lema from palabra where "
                    + "palabras=?");
            ps.setString(1, palabra);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                lema = rs.getString(1);
            }
        } catch (SQLException ex) {}
        
        return lema;
    }
    
    // DEFINICION
    public String getDefinicion(String palabra) {
        PreparedStatement ps = null;
        String definicion = null;
        
        try {
            ps = conexion.prepareStatement("SELECT definicion from palabra where "
                    + "palabras=?");
            ps.setString(1, palabra);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                definicion = rs.getString(1);
            }
        } catch (SQLException ex) {}
        
        return definicion;
    }
    
    // INSERTAR PALABRAS NOVAS NA BASE DE DATOS
    public int insert(String palabra) {
        PreparedStatement ps = null;
        int insertadas = 0;
        
        try {
            ps = conexion.prepareStatement("INSERT into palabra (palabra) VALUES (?)");
            ps.setString(1, palabra);
            insertadas = ps.executeUpdate();
            if (insertadas != 0) {
                    System.out.println("A palabra engadiuse correctamente.");
                }
            else {
                System.out.println("Erro ao insertar a palabra");
            }
        } catch (SQLException ex) {}
        
        return insertadas;
    }
    
    // ELIMINAR PALABRAS DA BASE DE DATOS
    private int delete(String palabra) {
        PreparedStatement ps = null;
        int borradas = 0;
        try {
            ps = conexion.prepareStatement("DELETE FROM palabra WHERE palabra =?");
            ps.setString(1, palabra);
            borradas = ps.executeUpdate();
            
            if (borradas != 0) {
                System.out.println("Palabra borrada correctamente.");
            } else {
                System.out.println("A palabra introducida non se atopa na Base de Datos");
            }
        } catch (SQLException ex) {}
        
        return borradas;
    }
    
}
