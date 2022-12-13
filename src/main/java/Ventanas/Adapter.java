package Ventanas;

import javax.swing.*;
import java.sql.ResultSet;

public class Adapter {
    public static String adaptar(ResultSet rs){

        JTextArea resultado = new JTextArea();
        try {

            while (rs.next()) {

                resultado.append(rs.getString("nombrePelicula"));

                resultado.append("\n");
                String fechaString = rs.getString("fechaEstreno");

                // = fecha.toString();
                resultado.append(fechaString);
                //DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                //String text = df.format(fecha);
                //resultado.append(text);
                resultado.append("\n ");
                resultado.append(String.valueOf(rs.getDouble("duracion")));
                resultado.append("\n ");
                resultado.append(rs.getString("genero"));
                resultado.append(" \n");
                resultado.append(String.valueOf(rs.getDouble("ingresos")));
                resultado.append(" \n");
                resultado.append(rs.getString("nombreBanda"));

            }
            String pasar = resultado.getText();
            return pasar;
        }catch(Exception exx){
            throw new RuntimeException(exx);
        }

    }
}
