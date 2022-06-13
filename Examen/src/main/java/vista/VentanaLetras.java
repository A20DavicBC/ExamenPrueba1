/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import BD.PalabraDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.XogoLetras;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BLANCO
 */
public class VentanaLetras extends JFrame implements ActionListener,
        WindowListener {

    public static final String DEFAULT_PATH = "h:\\";
    public static final ImageIcon ICONA = new ImageIcon(
            VentanaLetras.class.getResource("/imaxes/abc24.png")
    );

    private JMenuItem mnuNovoXogo,
            mnuCargarFromFile,
            mnuCargarFromDB,
            mnuSalir;
    private PanelLetras panelLetras;
    private JButton btComprobar,
            btLimpar,
            btNovoXogo;
    private JTextField tfPalabra;

    private XogoLetras xogo;
    private PalabraDAO palabraDAO;

    public VentanaLetras(PalabraDAO palabraDAO) {
        this.palabraDAO = palabraDAO;
        crearGUI();
    }

    public VentanaLetras() {
        crearGUI();
    }

    private void crearGUI() {
        xogo = new XogoLetras();
        setIconImage(ICONA.getImage());
        setTitle("Venta Letras");
        JMenuBar mb = new JMenuBar();
        JMenu mnArquivo = new JMenu("Arquivo");
        mnuNovoXogo = new JMenuItem("Novo Xogo", ICONA);
        mnuNovoXogo.addActionListener(this);
        mnArquivo.add(mnuNovoXogo);
        mnArquivo.addSeparator();
        mnuCargarFromFile = new JMenuItem("Cargar palabras dende arquivo");
        mnuCargarFromFile.addActionListener(this);
        mnArquivo.add(mnuCargarFromFile);
        mnuCargarFromDB = new JMenuItem("Cargar palabras dende BD");
        mnuCargarFromDB.addActionListener(this);
        mnArquivo.add(mnuCargarFromDB);
        mnuSalir = new JMenuItem("Saír");
        mnuSalir.addActionListener(this);
        mnArquivo.addSeparator();
        mnArquivo.add(mnuSalir);

        mb.add(mnArquivo);

        setJMenuBar(mb);

        // NORTE
        panelLetras = new PanelLetras();
        panelLetras.setBorder(BorderFactory.createTitledBorder("Letras"));
        add(panelLetras, BorderLayout.PAGE_START);

        // panel central:
        tfPalabra = new JTextField(10);
        tfPalabra.setFont(new Font("Lucida Console", Font.BOLD, 35));
        JPanel pCentral = new JPanel();
        pCentral.add(tfPalabra);
        tfPalabra.setEnabled(false);
        add(pCentral, BorderLayout.CENTER);

        // al sur
        JPanel pSur = new JPanel();
        btComprobar = new JButton("Comprobar");
        btComprobar.setEnabled(false);
        btComprobar.addActionListener(this);
        pSur.add(btComprobar);
        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(this);
        pSur.add(btLimpar);
        btNovoXogo = new JButton("Novo xogo", ICONA);
        btNovoXogo.addActionListener(this);
        pSur.add(btNovoXogo);

        add(pSur, BorderLayout.PAGE_END);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public final void sair() {
        int resultado = JOptionPane.showConfirmDialog(this, "Queres saír?");
        if (resultado == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == mnuNovoXogo || obj == btNovoXogo) {
            xogo.setLetras();
            panelLetras.setLetras(xogo.toString());
        } else if (obj == mnuCargarFromFile) {
            JFileChooser fc = new JFileChooser(DEFAULT_PATH);
            int resultado = fc.showOpenDialog(this);
            if(resultado==JFileChooser.APPROVE_OPTION){
                xogo.setPalabras(loadWordsFromFile(fc.getSelectedFile()));
            }
            btComprobar.setEnabled(true);
            tfPalabra.setEnabled(true);
        } else if (obj == mnuCargarFromDB) {
            xogo.setPalabras(palabraDAO.getAll());
            btComprobar.setEnabled(true);
            tfPalabra.setEnabled(true);
        } else if (obj == btComprobar) {
            String definicion = palabraDAO.getDefinicion(tfPalabra.getText());
            if(definicion!=null)
                JOptionPane.showMessageDialog(this, 
                        String.format("%100s", definicion));
            else
                JOptionPane.showMessageDialog(this, "Non atopada");
        } else if (obj == btLimpar) {
            tfPalabra.setText("");
        } else if (obj == mnuSalir) {
            sair();
        }

    }

    public ArrayList<String> loadWordsFromFile(File f) {
        ArrayList<String> palabras = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
            String lina;
            while ((lina = br.readLine()) != null) {
              palabras.add(lina);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {

        } finally {
            if(br!=null)
                try {
                    br.close();
            } catch (IOException ex) {
            }
        }
        return palabras;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        sair();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
