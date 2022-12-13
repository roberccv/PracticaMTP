package Ventanas;

import javax.swing.*;
import java.sql.ResultSet;

public class Adapter {
    public static void adaptar(ResultSet rs){
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
            Ventana1 ventana = new Ventana1();
            ventana.initComponents(pasar);
        }catch(Exception exx){
            throw new RuntimeException(exx);
        }

    }
}
