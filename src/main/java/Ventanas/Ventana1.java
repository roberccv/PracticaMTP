/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import BaseDatos.*;


import javax.swing.*;
import java.sql.ResultSet;

/**
 *
 * @author aleja
 */
public class Ventana1 {
  ResultSet rs;
    public Ventana1(){
        initComponents("");
    }


    public void initComponents(String nombre) {
        int i = 0;

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //JTextArea resul = new JTextArea();
        //JLabel probar = new JLabel(nombre );
        //JLabel dur = new JLabel(String.valueOf(duracion));
        JTextField texto = new JTextField(resultado);
        frame.add(texto);
        frame.setVisible(true);


    }


}

