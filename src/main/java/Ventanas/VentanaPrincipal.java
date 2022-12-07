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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class VentanaPrincipal {
    public VentanaPrincipal(){
        initComponents();
    }
    public static String valor;
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
               // valor = cajaTexto.getText();
                //System.out.println(valor);
                String busqueda = cajaTexto.getText();
                Ventana1 ventana = new Ventana1();

                Conexion conexion = new Conexion();

                ResultSet rs = conexion.seleccionarPeli(busqueda);
                try {
                    while (rs.next()) {
                        String nombre = rs.getString("nombrePelicula");
                        ventana.initComponents(nombre);
                    }
                }catch(Exception exx){

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

        //Label
        JLabel filtros = new JLabel("🔎 Búsqueda avanzada:");
        filtros.setForeground(Color.white);
        filtros.setBounds(100,400,300, 100);
        filtros.setFont(fuente1);
        frame.add(filtros);

        //Título textfield
        JLabel titLabel = new JLabel("Título:");
        titLabel.setFont(fuente1);
        titLabel.setForeground(Color.white);
        titLabel.setBounds(100,500,200, 30);
        frame.add(titLabel);

        JTextField titTexto = new JTextField("Titanic");
        titTexto.setBounds(100,530,200,30);
        frame.add(titTexto);

        // Género textfield
        JLabel genLabel = new JLabel("Género:");
        genLabel.setFont(fuente1);
        genLabel.setForeground(Color.white);
        genLabel.setBounds(400,500,200, 30);
        frame.add(genLabel);

        JTextField interTexto = new JTextField("Terror");
        interTexto.setBounds(400,530,200,30);
        frame.add(interTexto);

        //Duración desplegable
        JLabel durLabel = new JLabel("Duración:");
        durLabel.setFont(fuente1);
        durLabel.setForeground(Color.white);
        durLabel.setBounds(700,500,100, 30);
        frame.add(durLabel);

        String[] duraciones = {"30 min", "1h", "1h 30 min", "2h", "2h 30 min", "3h", "3h 30 min", "4h"};
        JComboBox durComBox = new JComboBox<String>(duraciones);
        durComBox.setBounds(700,530,200, 30);
        durComBox.setFont(fuente1);
        frame.add(durComBox);

        // Año de estreno
        JLabel anoLabel = new JLabel("Año de estreno:");
        anoLabel.setFont(fuente1);
        anoLabel.setForeground(Color.white);
        anoLabel.setBounds(100,650,200, 30);
        frame.add(anoLabel);

        JTextField anoTexto = new JTextField("2000");
        anoTexto.setBounds(100,680,200,30);
        frame.add(anoTexto);

        // Ingresos Generados
        JLabel ingLabel = new JLabel("Ingresos Generados:");
        ingLabel.setFont(fuente1);
        ingLabel.setForeground(Color.white);
        ingLabel.setBounds(400,650,200, 30);
        frame.add(ingLabel);

        JTextField ingTexto = new JTextField("Titanic");
        ingTexto.setBounds(400,680,200,30);
        frame.add(ingTexto);

        // Director desplegable
        JLabel dirLabel = new JLabel("Director:");
        dirLabel.setFont(fuente1);
        dirLabel.setForeground(Color.white);
        dirLabel.setBounds(700,650,200, 30);
        frame.add(dirLabel);

        JTextField dirTexto = new JTextField("Javi Martinez");
        dirTexto.setBounds(700,680,200,30);
        frame.add(dirTexto);

        // Banda sonora
        JLabel bandaLabel = new JLabel("Banda sonora:");
        bandaLabel.setFont(fuente1);
        bandaLabel.setForeground(Color.white);
        bandaLabel.setBounds(100,800,200,30);
        frame.add(bandaLabel);

        JTextField bandaTexto = new JTextField("Titanic");
        bandaTexto.setBounds(100,830,200,30);
        frame.add(bandaTexto);

        class OyenteBoton2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e2){
                titString = titTexto.getText();
                genString = genLabel.getText();
                durString = durLabel.getText();
                anoString = anoLabel.getText();
                ingString = ingLabel.getText();
                dirString = dirLabel.getText();
                banString = bandaTexto.getText();

            }
        }

        JButton botonBusquedaAvan = new JButton("Búsqueda avanzada");
        botonBusquedaAvan.addActionListener(new OyenteBoton2());
        botonBusquedaAvan.setBounds(700,840,200,20);;
        frame.add(botonBusquedaAvan);


        frame.setVisible(true);

    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
