package Ventanas;


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
        frame.setSize(500,500);
        frame.setLayout(null);


        class OyenteBoton1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){

                try {

                    VentanaInsert vi = new VentanaInsert();
                    vi.setVisible(true);


                }catch(Exception exx){
                    exx.printStackTrace();

                }
            }
        }

        insertar = new JButton("Inserción");
        insertar.addActionListener(new OyenteBoton1());
        frame.add(insertar);
        insertar.setBounds(50,180,400,100);






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
        frame.add(consultar);
        consultar.setBounds(50,300,400,100);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }


    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
