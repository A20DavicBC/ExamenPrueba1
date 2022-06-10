/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A20DavidBC
 */
public final class XogoLetras extends XogoAzar {
    
    public static final String NOME_XOGO="Xogo de letras";
    public static final String CONSOANTES="QWRTPSDFGHJKLÑZXCVBNM";
    public static final String VOGAIS="AEIOU";
    public static final int NUM_LETRAS=9;
    
    private char[] letras;
    private List<String> palabras;

    public XogoLetras() {
        super(NOME_XOGO);
        
        letras = new char[NUM_LETRAS];
        palabras = new ArrayList<>();
        
    }

   
    @Override
    public boolean comprobar(Object obj) {
        String palabra = obj.toString();
        
        if (palabras == null || !palabras.contains(palabra)) 
            return false;
        
        
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            
        }
        
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letras.length; i++) {
            char letra = letras[i];
            
        }
        
        for (char letra : letras) {
            sb.append(letra).append(" ");
        }
        return sb.toString();
    }
    
    
    
    public static char getVocal() {
        return VOGAIS.charAt(XERADOR.nextInt(VOGAIS.length()));
    }
    
    public static char getConsoante() {
        return CONSOANTES.charAt(XERADOR.nextInt(CONSOANTES.length()));
    }

    public char[] getLetras() {
        return letras;
    }

    public void setLetras(char[] letras) {
        this.letras = letras;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public boolean setPalabras(List<String> palabras) {
        if (palabras != null && !palabras.isEmpty()) {
            this.palabras = palabras;
            return true;
        }
        return false;
    }
    
    public int getSize(){
        if (letras != null) {
            return letras.length;
        }
        return 0;
    }
    
    public boolean addLetra(char letra){
        for (int i = 0; i < letras.length; i++) {
            if (letras[i]==0){
                letras[i] = letra;
                return true;
            }
            
        }
        return false;
    }
    
    public void removeLetras(){
        for (int i = 0; i < letras.length; i++) {
            char letra = letras[i];
            
        }
    }
    
    public void setLetras() {
        for (int i = 0; i < letras.length; i++) {
            int v = XERADOR.nextInt(2);
            if (v==0) {
                letras[i] = getVocal();
            }
            else {
                letras[i] = getConsoante();
            }
        }
    }
}