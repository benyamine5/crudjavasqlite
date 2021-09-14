/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasqlite.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author Benjamin
 */
public class Conexion {
    String strconexionDB = "jdbc:sqlite:C:/Users/Benjamin/Documents/Dbjavamysqlite/javacrud.s3db";
    Connection conn = null;
    
    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strconexionDB);
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion"+e);
        }   
    }
    // Enviara la informacion a la base de datos 
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    // Metodo para devolver informacion y saber si existe o no
    public ResultSet ConsultarRegistros(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
