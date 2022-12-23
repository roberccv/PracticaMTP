package Ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Alejandro García, Roberto Cinos, Sergio Diaz y Miguel Gamboa
 */
public class Ventana1 {
  DefaultTableModel d = new DefaultTableModel();
  JTable tabla = new JTable();
    public Ventana1(){
        initComponents(d);
    }


    public void initComponents(DefaultTableModel d) {
        JFrame frame = new JFrame();
        frame.setSize(700,100);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        tabla.setModel(d);
        frame.add(tabla, BorderLayout.CENTER);
        frame.add(tabla.getTableHeader(), BorderLayout.NORTH);
        frame.setVisible(true);


    }


}

