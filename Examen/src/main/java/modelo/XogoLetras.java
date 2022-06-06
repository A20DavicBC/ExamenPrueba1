/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
        return true;
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
    
    
}
