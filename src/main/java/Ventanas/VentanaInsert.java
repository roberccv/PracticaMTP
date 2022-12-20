/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import BaseDatos.*;

/**
 *
 * @author aleja
 */
public class VentanaInsert{

    private javax.swing.JTextField cajaTexto;
    private javax.swing.JTextField cajaTexto2;
    private javax.swing.JTextField cajaTexto3;
    private javax.swing.JTextField cajaTexto4;
    private javax.swing.JTextField cajaTexto5;
    private javax.swing.JTextField cajaTexto6;
    private javax.swing.JTextField cajaTexto7;
    private javax.swing.JTextField cajaTexto8;


    public static final Color COLORFONDO = new Color(103, 210, 255, 255);
   
    public VentanaInsert(){
        initComponents();
    }
    
    private void initComponents(){   
        // Generar la ventana
        JFrame frame = new JFrame("Introducir película");
        
        JPanel scroll = new JPanel();
        scroll.setLayout(null);
        
        JScrollPane scrollpane = new JScrollPane(); 
        //scrollpane.setBounds(5, 10, 1000, 1000);
        scroll.setPreferredSize(new Dimension(1000,1000));
        scrollpane.setViewportView(scroll);
        
        // Editar el tamaño de la ventana
        frame.setSize(1000,1000);
        // Editar el color del fondo
        //frame.getContentPane().setBackground(COLORFONDO);
        // Deshabilitar el botón de maximizar
        frame.setResizable(true);
        // Habilitar el botón de cerrar ("X")

        //Cambiar para que no cierre la principal también
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // Habilita la distribución de los elementos en la ventana
        //frame.setLayout(null);

        
        // Fuentes
        Font fuente1= new Font("Serif", Font.BOLD, 25);
        Font fuente2= new Font("Serif", Font.BOLD, 16);    

        // Label
        JLabel titulo = new JLabel("Introducir película");
        titulo.setBounds(425, 20, 600, 100);
        titulo.setFont(fuente1);
        scroll.add(titulo);
        //frame.add(titulo);
        
        // TextField
        JLabel titulo1 = new JLabel("Título:");
        titulo1.setBounds(200, 150, 200, 30);
        titulo1.setFont(fuente2);
        scroll.add(titulo1);
        //frame.add(titulo1);
        cajaTexto = new JTextField("Introducir texto...");
        cajaTexto.setBounds(275,150,100,30);
        scroll.add(cajaTexto);
        //frame.add(cajaTexto);
        
        
        JLabel titulo2 = new JLabel("Duración:");
        titulo2.setBounds(200, 250, 200, 30);
        titulo2.setFont(fuente2);
        //scroll.add(titulo2);
        scroll.add(titulo2);
        cajaTexto2 = new JTextField("Introducir texto...");
        cajaTexto2.setBounds(275,250,100,30);
        scroll.add(cajaTexto2);
        //frame.add(cajaTexto2);

        JLabel titulo3 = new JLabel("Género:");
        titulo3.setBounds(200, 350, 200, 30);
        titulo3.setFont(fuente2);
        scroll.add(titulo3);
        //frame.add(titulo3);
        cajaTexto3 = new JTextField("Introducir texto...");
        cajaTexto3.setBounds(275,350,100,30);
        //frame.add(cajaTexto3);
        scroll.add(cajaTexto3);
        
        JLabel titulo4 = new JLabel("Fecha de estreno:");
        titulo4.setBounds(200, 450, 200, 30);
        titulo4.setFont(fuente2);
        scroll.add(titulo4);
        //frame.add(titulo4);
        cajaTexto4 = new JTextField("dd-MM-YYYY");
        cajaTexto4.setBounds(325,450,100,30);
        scroll.add(cajaTexto4);
        //frame.add(cajaTexto4);

        JLabel titulo5 = new JLabel("Ingresos generados:");
        titulo5.setBounds(200, 550, 200, 30);
        titulo5.setFont(fuente2);
        scroll.add(titulo5);
        //frame.add(titulo5);
        cajaTexto5 = new JTextField("Introducir texto...");
        cajaTexto5.setBounds(350,550,100,30);
        scroll.add(cajaTexto5);
        //frame.add(cajaTexto5);



        JLabel titulo7 = new JLabel("Banda Sonora:");
        titulo7.setBounds(200, 650, 200, 30);
        titulo7.setFont(fuente2);
        scroll.add(titulo7);
        //frame.add(titulo7);
        cajaTexto7 = new JTextField("Introducir texto...");
        cajaTexto7.setBounds(310,650,100,30);
        scroll.add(cajaTexto7);
        //frame.add(cajaTexto7);
        

        //frame.add(cajaTexto7);

        // Label
        // JLabel filtros = new JLabel("Filtros:");
        // filtros.setBounds(300,500,100, 100);
        // filtros.setFont(fuente1)       
        
        // frame.add(filtros);


        
        JButton btn_guardar = new JButton();
        btn_guardar.setBounds(100, 100, 10, 10);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        
                

        //PROCESOS FINALES
        // Permite visualizar la ventana 
        
        
        
        scroll.add(btn_guardar);
        
       
        frame.add(scrollpane);
        
       
        
        frame.setVisible(true);
        
        
    }

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {

        String nombre = cajaTexto.getText();
        Double dur =  Double.parseDouble(cajaTexto2.getText());
        String genero = cajaTexto3.getText();
        LocalDate anno = LocalDate.parse(cajaTexto4.getText() , DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Integer ingresos = Integer.parseInt(cajaTexto5.getText());
        //Integer director = Integer.parseInt(cajaTexto6.getText());
        String banda = this.cajaTexto7.getText();
       // Date frodaje = new Date(cajaTexto8.getText());
        
        Conexion cn = Conexion.getInstance();
        try {
            cn.insertarPeli(nombre, anno, dur, genero, ingresos, banda );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    

}