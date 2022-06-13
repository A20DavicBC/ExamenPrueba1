/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author A20DavidBC
 */
public class PanelLetras extends JPanel {

    public static final int PANEL_DEFAULT_WIDTH = 450;
    public static final int PANEL_DEFAULT_HEIGHT = 60;

    private String letras;

    public PanelLetras() {
        letras = "";
        setPreferredSize(new Dimension(PANEL_DEFAULT_WIDTH, PANEL_DEFAULT_HEIGHT));

    }

    public void clear() {
        letras = "";
        repaint();
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd2 = (Graphics2D) g;
        gd2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gd2.setFont(new Font("Lucida Console", Font.BOLD, 35));
        g.drawString(letras, 28, 40);
    }

}
