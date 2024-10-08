package Ventanas;

import javax.swing.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Adapter {
    public static DefaultTableModel adaptar(ResultSet rs){

        JTable jTable = new JTable();
        DefaultTableModel dfm = new DefaultTableModel();
        jTable.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Pelicula", "Fecha Estreno", "Duración", "Género", "Ingresos", "Banda Sonora"});
        try {
            dfm.addRow(new Object[]{rs.getString("nombrePelicula"), rs.getString("fechaEstreno"), rs.getDouble("duracion"), rs.getString("genero"), rs.getDouble("ingresos"), rs.getString("nombreBanda")});
            while (rs.next()) {
                dfm.addRow(new Object[]{rs.getString("nombrePelicula"), rs.getString("fechaEstreno"), rs.getDouble("duracion"), rs.getString("genero"), rs.getDouble("ingresos"), rs.getString("nombreBanda")});
            }
            return dfm;
        }catch(Exception exx){
            throw new RuntimeException(exx);
        }

    }
}
