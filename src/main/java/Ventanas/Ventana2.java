package Ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ventana2 {

    DefaultTableModel d = new DefaultTableModel();
    JTable tabla = new JTable();
    
    public Ventana2(){
        initComponents(d);
    }
    
    public void initComponents(DefaultTableModel d) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tabla.setModel(d);
        frame.add(tabla, BorderLayout.CENTER);
        frame.add(tabla.getTableHeader(), BorderLayout.NORTH);
        frame.setVisible(true);
    }

}
