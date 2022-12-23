/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;


/**
 *
 * @author aleja
 */
public class Conexion {

    private static Conexion instancia;
    private Conexion(){

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
            ex.printStackTrace();
        }
        return cn;
    }
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public void insertarPeli(String nombre, LocalDate anno, Double duracion, String genero, Integer ingresos, String banda) throws ParseException {

        try{
            //SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
            // Date fecha = (Date) format.parse("09-08-2011");
            Connection c = conectar();
            PreparedStatement pst = c.prepareStatement("INSERT INTO peliculas VALUES (?,?,?,?,?,?)");
            pst.setString(1, nombre);
            pst.setObject(2, anno);
            pst.setDouble(3, duracion);
            pst.setString(4, genero);
            pst.setDouble(5, ingresos);
            pst.setString(6, banda);

            pst.execute();
        }catch(SQLException ex ){
            System.out.println("Fallo");
            ex.printStackTrace();
        //}catch (ParseException ex){
          //  ex.printStackTrace();
        }
    }

    public ResultSet seleccionarPeli(String nombre){
        PreparedStatement pst;
        ResultSet rs = null;
        try{
            pst = conectar().prepareStatement("SELECT * FROM peliculas WHERE nombrePelicula = ?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet buscarInterpretacion(String nombre){
        PreparedStatement pst;
        ResultSet rs = null;
        try{
            pst = conectar().prepareStatement("select nombrePeli from interpretación inner join actor on interpretación.id_actor = actor.id_actor inner join peliculas on interpretación.nombrePeli = peliculas.nombrePelicula where nombre = ?;");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return rs;
    }
    public ResultSet buscarDireccion(String nombre){
        PreparedStatement pst;
        ResultSet rs = null;
        try{
            pst = conectar().prepareStatement("select nombrePeli from DireccionPelicula inner join Director on DireccionPelicula.codigoDir = Director.codigoDir inner join peliculas on DireccionPelicula.nombrePeli = peliculas.nombrePelicula where nombreDir = ?;");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return rs;
    }
}
