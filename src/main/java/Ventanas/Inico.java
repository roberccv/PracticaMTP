package Ventanas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inico{

    JButton consultar;
    JButton insertar;
    public Inico(){
        initComponents();

    }

    private void initComponents(){
        JFrame frame = new JFrame("Inicio");
        frame.setSize(500,500);
        frame.setLayout(null);




        insertar = new JButton("Inserción");
        insertar.addActionListener(new OyenteBoton1());
        frame.add(insertar);
        insertar.setBounds(50,180,400,100);









        consultar = new JButton("Consultas");
        consultar.addActionListener(new OyenteBoton2());
        frame.add(consultar);
        consultar.setBounds(50,300,400,100);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }
    private class OyenteBoton1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){

            try {

                VentanaInsert vi = new VentanaInsert();



            }catch(Exception exx){
                exx.printStackTrace();

            }
        }
    }

    private class OyenteBoton2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){

            try {

                VentanaPrincipal vp = new VentanaPrincipal();


            }catch(Exception exx){
                throw new RuntimeException(exx);
            }
        }
    }



}
