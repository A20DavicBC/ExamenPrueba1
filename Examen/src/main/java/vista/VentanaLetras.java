/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.XogoLetras;

/**
 *
 * @author A20DavidBC
 */
public class VentanaLetras extends JFrame implements ActionListener {
    
    public static final String DEFAULT_PATH =
    public static final ImageIcon ICONA = new ImageIcon("c:\\image.png");
    
    private JMenuItem mnuNovoXogo,
            mnuCargarFromFile,
            mnuCargarFromBD,
            mnuSalir;
    private panelLetras panelLetras; //Falta esta clase
    private JButton btComprobar,
            btLimpar,
            btNovoXogo;
    private JTextField tfPalabra;
    
    private XogoLetras xogo;
    private PalabraDAO palabraDAO; //Falta esta clase
    
    public VentanaLetras() throws HeadlessException {
        xogo = new XogoLetras();
        crearGUI();
    }
    
    private void crearGUI(){ //interfaz gráfica
        
        setTitle("Ventá Letras");
        setIconImage(ICONA.getImage());
        
        JMenuBar mb = new JMenuBar();
        JMenu mnArquivo = new JMenu("Arquivo");
        mnuNovoXogo = new JMenuItem("Novo xogo",ICONA);
        mnArquivo.add(mnuNovoXogo);
        mnuCargarFromFile = new JMenuItem("Cargar desde arquivo");
        mnArquivo.add(mnuCargarFromFile);
        mnuCargarFromBD = new JMenuItem("Cargar desde BD");
        mnArquivo.add(mnuCargarFromBD);
        mnuSalir = new JMenuItem("Sair");
        mnArquivo.addSeparator();
        mnArquivo.add(mnuSalir);
        
        mb.add(mnArquivo);
        
        setJMenuBar(mb);
        
        //Crear panel
        
        panelLetras = new PanelLetras();
        panelLetras.setBorder(BorderFactory.createTitledBorder(border));
        add(panelLetras,BorderLayout.PAGE_START);
        
        //Panel central
        
        tfPalabra = new JTextField(10);
        tfPalabra.setFont(new Font("Lucida Console", Font.BOLD,35));
        tfPalabra.setEnabled(false);
        JPanel pCentral = new JPanel();
        pCentral.add(tfPalabra);
        add(pCentral, BorderLayout.CENTER);
        
        // Panel sur
        JPanel pSur = new JPanel();
        btComprobar = new JButton("Comprobar");
        btComprobar.setEnabled(false);
        pSur.add(btComprobar);
        btLimpar = new JButton("Limpar");
        pSur.add(btLimpar);
        btNovoXogo = new JButton("Novo xogo",ICONA);
        pSur.add(btNovoXogo);
        
        add(pSur, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    
}
