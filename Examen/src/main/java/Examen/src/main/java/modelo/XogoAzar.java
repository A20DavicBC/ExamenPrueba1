/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author A20DavidBC
 */
public abstract class XogoAzar implements Comprobable {
    
    public static final Random XERADOR = new Random();
    
    private String nome;

    public XogoAzar(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        if (nome != null) {
            return nome.toUpperCase();
        }
        
        return "";
    }

    
    
}
