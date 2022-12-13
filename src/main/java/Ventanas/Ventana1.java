/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;



import javax.swing.*;


/**
 *
 * @author Rober
 */
public class Ventana1 {

    public Ventana1(){

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

