/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo Torres
 */
public class CConexion {
    Connection conectar;
    
    String usuario="root";
    String contrasenia="";
    String bd="examen";
    String ip="localhost";
    String puerto="3306";
    
    String cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerCoinexion(){
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
    //JOptionPane.showMessageDialog(null,"se conecto correctamente" );
    
    }catch (Exception e){
    JOptionPane.showMessageDialog(null,"Problemas de conexion"+e.toString() );
    }
    return conectar;
    }
    
}
