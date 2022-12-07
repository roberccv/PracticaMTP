/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.logging.*;
import java.awt.*;


/**
 *
 * @author aleja
 */
public class Conexion {
    
    public Conexion(){

    }
   
    public Connection conectar(){
        Connection cn = null;
        String driver = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:bbdd/practica.db";
        try{
             Class.forName(driver);
             cn = DriverManager.getConnection(url);
        }catch (Exception ex){
            System.out.println("No se ha conectado");
        }
        return cn;
    }

    public void insertarPeli(String nombre, LocalDate anno, Double duracion, String genero, Integer ingresos, String banda, Integer codDir  /*, Date frodaje*/) throws ParseException {

        try{
            //SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
            // Date fecha = (Date) format.parse("09-08-2011");
            Connection c = conectar();
            PreparedStatement pst = c.prepareStatement("INSERT INTO peliculas VALUES (?,?,?,?,?,?,?,'2011-08-09')");
            pst.setString(1, nombre);
            System.out.println(duracion);
            pst.setObject(2, anno);
            pst.setDouble(3, duracion);
            pst.setString(4, genero);
            pst.setDouble(5, ingresos);
            pst.setString(6, banda);
            pst.setInt(7, codDir);
            //pst.setDate(8, frodaje);
            
            pst.execute();
        }catch(SQLException ex ){
            System.out.println("Fallo");
            ex.printStackTrace();
        //}catch (ParseException ex){
          //  ex.printStackTrace();
        }
    }

    public ResultSet seleccionarPeli(String nombre){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = conectar().prepareStatement("SELECT * FROM peliculas WHERE nombrePelicula = ?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
        }catch(Exception e){

        }
        return rs;
    }
 
    
}
