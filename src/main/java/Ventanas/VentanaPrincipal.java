/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;


/**
 * @author: Sergio Díaz, Roberto Cinos, Alejandro García y Miguel Gamboa
 */

import BaseDatos.Conexion;

import java.awt.*;
import java.awt.event.*;
import java.nio.MappedByteBuffer;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class VentanaPrincipal {
    public VentanaPrincipal(){
        initComponents();
    }
    public static String valor;
    public static String busPeli;
    public static String busPeli2;
    public static String titString;
    public static String genString;
    public static String durString;
    public static String anoString;
    public static String ingString;
    public static String dirString;
    public static String banString;

    public static final Color COLORLOGO = new Color(103,210,255,255);
    public static final Color COLORFONDO = new Color(176, 208, 234,255);
    public static final Font FUENTE= new Font("Serif", Font.BOLD, 20);

    public  void initComponents(){

        int bloque1 = 140;
        int bloque2 = -170;

        //Fuentes
        Font fuente1 = FUENTE;

        //Colores
        Color colorFondo = COLORFONDO;
        Color colorLogo = COLORLOGO;
        //Inicialización base
        JFrame frame = new JFrame("TruFilms");

        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(colorFondo);

        //icono imagen
        Image icono = Toolkit.getDefaultToolkit().getImage("TruFilmsIcono.png");
        frame.setIconImage(icono);

        //quitar maximizar
        frame.setResizable(false);
        //si pulsas el icono "X" se cierra el programa
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //permite que se pueden distribuir los elementos en el frame
        frame.setLayout(null);

        //_______
        //ELEMENTOS

        //TextFiled
        JTextField cajaTexto = new JTextField("Titanic 1997 James Cameron");
        cajaTexto.setBounds(100,200,800,30);
        frame.add(cajaTexto);


        class OyenteBoton implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){
                String busqueda = cajaTexto.getText();
                Ventana1 ventana = new Ventana1();

                Conexion conexion = new Conexion();

                ResultSet rs = conexion.seleccionarPeli(busqueda);
                JTextArea resultado = new JTextArea();
                try {

                    while (rs.next()) {

                        resultado.append(rs.getString("nombrePelicula"));

                        resultado.append(",");
                        String fechaString = rs.getString("fechaEstreno");

                        // = fecha.toString();
                        resultado.append(fechaString);
                        //DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        //String text = df.format(fecha);
                        //resultado.append(text);
                        resultado.append(", ");
                        resultado.append(String.valueOf(rs.getDouble("duracion")));
                        resultado.append(", ");
                        resultado.append(rs.getString("genero"));
                        resultado.append(" ,");
                        resultado.append(String.valueOf(rs.getDouble("ingresos")));
                        resultado.append(" ,");
                        resultado.append(rs.getString("nombreBanda"));

                    }
                    String pasar = resultado.getText();
                    ventana.initComponents(pasar);
                }catch(Exception exx){
                    throw new RuntimeException(exx);
                }
            }
        }

        JButton botonBusqueda = new JButton("Buscar");
        botonBusqueda.addActionListener(new OyenteBoton());
        botonBusqueda.setBounds(800,240,100,20);
        frame.add(botonBusqueda);

        //Label
        JLabel titulo = new JLabel("TruFilms");
        titulo.setBounds(100,116,600, 100);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Serif", Font.BOLD, 100));
        frame.add(titulo);


        //Logo
        JLabel logo = new JLabel(); //JLabel Creation
        logo.setIcon(new ImageIcon("TruFilmsIcono.png"));
        logo.setBounds(640,100,300,100);
        frame.add(logo);

        //Slogan
        JLabel sloLabel = new JLabel("Descubre algo más que la historia...");
        sloLabel.setFont(new Font("Serif", Font.BOLD, 25));
        sloLabel.setForeground(Color.white);
        sloLabel.setBounds(121,230,800, 30);
        frame.add(sloLabel);



        JTextField actTexto = new JTextField("Begoña Vargas");
        actTexto.setBounds(100,600 + bloque2,800,30);
        frame.add(actTexto);

        class OyenteBotonAct implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){
                String busqueda = actTexto.getText();
                Ventana2 ventana = new Ventana2();
                Conexion conexion = new Conexion();
                ResultSet rs = conexion.buscarInterpretacion(busqueda);
                StringBuilder resultado = new StringBuilder();
                try {
                    while(rs.next()){
                        resultado.append(rs.getString("nombrePeli"));
                        resultado.append('\n');
                    }
                    ventana.initComponents(resultado.toString());
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        }

        JButton botonBusquedaAct = new JButton("Buscar");
        botonBusquedaAct.addActionListener(new OyenteBotonAct());
        botonBusquedaAct.setBounds(800,640 + bloque2,100,20);;
        frame.add(botonBusquedaAct);







        frame.setVisible(true);

    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
