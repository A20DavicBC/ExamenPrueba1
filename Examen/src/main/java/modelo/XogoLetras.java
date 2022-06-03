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
    
    private Character[] letras;
    private List<String> palabras;

    public XogoLetras() {
        super(NOME_XOGO);
        
        letras = new Character[NUM_LETRAS];
        palabras = new ArrayList<>();
        
    }

    public static int getVocal() {
        return Random.nextInt(5);
    }
    
    @Override
    public boolean comprobar(Object obj) {
        return true;
    }
    
    
}
