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
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal {
    public VentanaPrincipal() {
        initComponents();
    }
    JTextField actTexto;
    JTextField cajaTexto;
    JFrame frame;
    JTextField dirTexto;
    int bloque1 = 150;
    int bloque2 = -170;



    public static String busPeli;
    public static String busPeli2;

    public static final Color COLORLOGO = new Color(103, 210, 255, 255);
    public static final Color COLORFONDO = new Color(176, 208, 234, 255);
    public static final Font FUENTE = new Font("Serif", Font.BOLD, 20);

    public static void setState(String dato) {
        busPeli2 = dato;
    }

    public static String getState() {
        return busPeli2;
    }

    public void initComponents() {



        //Fuentes
        Font fuente1 = FUENTE;

        //Colores
        Color colorLogo = COLORLOGO;

        //Inicialización base
        JFrame frame = new JFrame("TruFilms");


        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(COLORFONDO);

        //icono imagen
        Image icono = Toolkit.getDefaultToolkit().getImage("media/TruFilmsIcono.png");
        frame.setIconImage(icono);

        //quitar maximizar
        frame.setResizable(false);
        //si pulsas el icono "X" se cierra el programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //permite que se pueden distribuir los elementos en el frame
        frame.setLayout(null);

        //_______
        //ELEMENTOS

        //TextFiled
        cajaTexto = new JTextField("Titanic");
        cajaTexto.setBounds(100, 200 + bloque1, 800, 30);
        frame.add(cajaTexto);




        JButton botonBusqueda = new JButton("Buscar");
        botonBusqueda.addActionListener(new OyenteBoton());
        botonBusqueda.setBounds(800, 240 + bloque1, 100, 20);
        frame.add(botonBusqueda);

        JButton deshacer = new JButton("Búsqueda anterior");
        deshacer.addActionListener(new deshacer());
        deshacer.setBounds(650, 240 + bloque1, 140, 20);
        frame.add(deshacer);

        //Label
        JLabel titulo = new JLabel("TruFilms");
        titulo.setBounds(100, 116 + bloque1, 600, 100);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Serif", Font.BOLD, 100));
        frame.add(titulo);


        //Logo
        JLabel logo = new JLabel(); //JLabel Creation
        logo.setIcon(new ImageIcon(icono));
        logo.setBounds(640, 100 + bloque1, 300, 100);
        frame.add(logo);

        //Slogan
        JLabel sloLabel = new JLabel("Descubre algo más que la historia...");
        sloLabel.setFont(new Font("Serif", Font.BOLD, 25));
        sloLabel.setForeground(Color.white);
        sloLabel.setBounds(121, 630, 800, 30);
        frame.add(sloLabel);

        JLabel actLabel = new JLabel("Actor/actriz:");
        actLabel.setFont(fuente1);
        actLabel.setForeground(Color.white);
        actLabel.setBounds(100, 570 + bloque2, 200, 30);
        frame.add(actLabel);


        actTexto = new JTextField("Begoña Vargas");
        actTexto.setBounds(100, 600 + bloque2, 800, 30);
        frame.add(actTexto);



        JButton botonBusquedaAct = new JButton("Buscar");
        botonBusquedaAct.addActionListener(new OyenteBotonAct());
        botonBusquedaAct.setBounds(800, 640 + bloque2, 100, 20);
        frame.add(botonBusquedaAct);

        // Director desplegable
        JLabel dirLabel = new JLabel("Director/directora:");
        dirLabel.setFont(fuente1);
        dirLabel.setForeground(Color.white);
        dirLabel.setBounds(100, 650 + bloque2, 200, 30);
        frame.add(dirLabel);

        dirTexto = new JTextField("David Yates");
        dirTexto.setBounds(100, 680 + bloque2, 800, 30);
        frame.add(dirTexto);



        JButton botonBusquedaDir = new JButton("Buscar");
        botonBusquedaDir.addActionListener(new OyenteBotonDir());
        botonBusquedaDir.setBounds(800, 720 + bloque2, 100, 20);
        frame.add(botonBusquedaDir);


        frame.setVisible(true);

    }
    private class OyenteBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setState(busPeli);
            busPeli = cajaTexto.getText();

            String busqueda = cajaTexto.getText();


            Conexion conexion = Conexion.getInstance();

            ResultSet rs = conexion.seleccionarPeli(busqueda);
            try {
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(frame,
                            "La película que está buscando no se encuentra en nuestra base de datos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

                } else {

                    Ventana1 ventana = new Ventana1();
                    ventana.initComponents(Adapter.adaptar(rs));

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
    private class deshacer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (busPeli2 == null) {
                System.out.println("No existe búsqueda anterior`");
            } else {
                System.out.println("La busqueda anterior es" + getState());
                cajaTexto.setText(getState());
                cajaTexto.setBounds(100, 200 + bloque1, 800, 30);
                frame.add(cajaTexto);
            }
        }
    }
    private class OyenteBotonDir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String busqueda = dirTexto.getText();
            Conexion conexion = Conexion.getInstance();
            ResultSet rs = conexion.buscarDireccion(busqueda);
            try {
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(frame,
                            "El/la director/directora que está buscando no se encuentra en nuestra base de datos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Ventana2 ventana = new Ventana2();
                    JTable jTable1 = new JTable();
                    DefaultTableModel dfmbuscar = new DefaultTableModel();
                    jTable1.setModel(dfmbuscar);
                    dfmbuscar.setColumnIdentifiers(new Object[]{"Películas que dirije este director"});

                    try {
                        dfmbuscar.addRow(new Object[]{rs.getString("nombrePeli")});
                        while (rs.next()) {
                            dfmbuscar.addRow(new Object[]{rs.getString("nombrePeli")});
                        }
                        ventana.initComponents(dfmbuscar);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        }
    }
    private class OyenteBotonAct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String busqueda = actTexto.getText();
            Conexion conexion = Conexion.getInstance();
            ResultSet rs = conexion.buscarInterpretacion(busqueda);
            try {
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(frame,
                            "El/la actor/actriz que está buscando no se encuentra en nuestra base de datos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Ventana2 ventana = new Ventana2();
                    JTable jTable1 = new JTable();
                    DefaultTableModel dfmbuscar = new DefaultTableModel();
                    jTable1.setModel(dfmbuscar);
                    dfmbuscar.setColumnIdentifiers(new Object[]{"Películas que interpreta este actor"});

                    try {
                        dfmbuscar.addRow(new Object[]{rs.getString("nombrePeli")});
                        while (rs.next()) {
                            dfmbuscar.addRow(new Object[]{rs.getString("nombrePeli")});
                        }
                        ventana.initComponents(dfmbuscar);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }


    }

}


