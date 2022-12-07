package Ventanas;

import BaseDatos.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Inico{

    JButton consultar;
    JButton insertar;
    public Inico(){
        initComponents();

    }

    private void initComponents(){
        JFrame frame = new JFrame("Inicio");


        class OyenteBoton1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){

                try {

                    VentanaInsert vi = new VentanaInsert();
                    vi.setVisible(true);


                }catch(Exception exx){

                }
            }
        }

        insertar = new JButton("Inserción");
        insertar.addActionListener(new OyenteBoton1());
        insertar.setBounds(800,380,10,20);
        frame.add(insertar);





        class OyenteBoton2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){

                try {

                    VentanaPrincipal vp = new VentanaPrincipal();
                    vp.setVisible(true);

                }catch(Exception exx){

                }
            }
        }


        consultar = new JButton("Consultas");
        consultar.addActionListener(new OyenteBoton2());
        consultar.setBounds(800,240,10,20);
        frame.add(consultar);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }


    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
