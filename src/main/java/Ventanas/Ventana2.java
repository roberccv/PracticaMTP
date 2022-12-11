package Ventanas;

import javax.swing.*;
import java.sql.ResultSet;

public class Ventana2 {

    ResultSet rs;
    public Ventana2(){
        initComponents("");
    }


    public void initComponents(String pasar) {

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //JTextArea resul = new JTextArea();
        //JLabel probar = new JLabel(nombre );
        //JLabel dur = new JLabel(String.valueOf(duracion));
        JTextField texto = new JTextField(pasar);
        frame.add(texto);
        frame.setVisible(true);


    }

}
