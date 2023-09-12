/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.mycompany.examen.MenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gerardo Torres
 */
public class CLogin {
    public void validaUsuario(JTextField usuario,JPasswordField contrasenia){
    
        try{
            ResultSet rs=null;
            PreparedStatement ps=null;
            clases.CConexion objConexion= new clases.CConexion();
            String consulta="SELECT * FROM usuario WHERE login = (?) AND PASSWORD=(?);";
            ps=objConexion.establecerCoinexion().prepareStatement(consulta);
        
    String contra= String.valueOf(contrasenia.getPassword());
    
             String contrasenia1=Base64.getEncoder().encodeToString(contra.getBytes());
            ps.setString(1, usuario.getText());
            ps.setString(2, contrasenia1);
      rs = ps.executeQuery();
     

      if(rs.next()){
      JOptionPane.showMessageDialog(null, "Usuario y contraseña Correcta");
      MenuPrincipal objMenu = new MenuPrincipal();
      objMenu.setVisible(true);
      }else{
         JOptionPane.showMessageDialog(null, "Usuario o contraseña Incorrecta");
     
      }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error"+e.toString());
     
        }
        
    }
}
