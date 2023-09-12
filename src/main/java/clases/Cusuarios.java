/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Gerardo Torres
 */
public class Cusuarios {
            String login; 
            String password;
            String nombre;
            String fechaalta;
            String fecha_vigencia;
            int codigo;
            
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getFecha_vigencia() {
        return fecha_vigencia;
    }

    public void setFecha_vigencia(String fecha_vigencia) {
        this.fecha_vigencia = fecha_vigencia;
    }
 
    
     public void Insertar_Alumno (JTextField login,JTextField password,JTextField nombre,JTextField fecha_vigencia){
         
  
     setLogin(login.getText());
     setPassword(password.getText());
     setNombre(nombre.getText());
     setFecha_vigencia(fecha_vigencia.getText());
     
         clases.CConexion objConexion= new clases.CConexion();
            String consulta="INSERT INTO usuario (login, password, nombre, fechaalta,fecha_vigencia) VALUES (?, ?, ?,NOW(), ?);";
            try {
                String contrasenia=Base64.getEncoder().encodeToString(getPassword().getBytes());
             CallableStatement cs = objConexion.establecerCoinexion().prepareCall(consulta);
        cs.setString(1, getLogin());
        cs.setString(2, contrasenia);
        cs.setString(3, getNombre());
        cs.setString(4, getFecha_vigencia());
        JOptionPane.showMessageDialog(null, cs);
        
        cs.execute();
        
        JOptionPane.showMessageDialog(null, "se inserto correctamente el usuario");
        
            
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Error al isertar"+e.toString());
        
         }
     }
     
     public void MostrarUsuarios (JTable paramTablaTotalUsuarios){
         clases.CConexion objConexion= new clases.CConexion();
         DefaultTableModel modelo = new DefaultTableModel();
         TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
         paramTablaTotalUsuarios.setRowSorter(OrdenarTabla);
         String sql="";
         modelo.addColumn("Id");
         modelo.addColumn("Login");
         modelo.addColumn("Password");
         modelo.addColumn("Nombre");
         modelo.addColumn("Fecha Vigencia");
         
         paramTablaTotalUsuarios.setModel(modelo);
         sql="Select * from usuario";
         
         String [] datos = new String [12];
         Statement st;
         
         try {
             st= objConexion.establecerCoinexion().createStatement();
             ResultSet rs=st.executeQuery(sql);
             
             while(rs.next()){
                            datos[0] = rs.getString(1);
                            datos[1] = rs.getString(2);
                            datos[2] = rs.getString(3);
                            datos[3] = rs.getString(4);
                            datos[4] = rs.getString(12);
                            
                            modelo.addRow(datos);
             }
             paramTablaTotalUsuarios.setModel(modelo);
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos"+e.toString());
         }
         
     
     }
     
     public void SeleccionarUsuarios(JTable paramTablaUusarios,JTextField paramId,JTextField paramlogin,JTextField parampassword,JTextField paramnombre,JTextField paramfecha_vigencia){
     
         try {
             int fila=paramTablaUusarios.getSelectedRow();
             if (fila>=0){
                 paramId.setText((String) (paramTablaUusarios.getValueAt(fila, 0)));
                paramlogin.setText((paramTablaUusarios.getValueAt(fila, 1).toString()));
                parampassword.setText((paramTablaUusarios.getValueAt(fila, 2).toString()));
                paramnombre.setText((paramTablaUusarios.getValueAt(fila, 3).toString()));
                paramfecha_vigencia.setText((paramTablaUusarios.getValueAt(fila, 4).toString()));
             }else{
             JOptionPane.showMessageDialog(null, "No se selecciono la fila");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error de seleccion"+e.toString());
         }
     }
     
      public void ModificarUsuarios (JTextField paramCodigo,JTextField login,JTextField password,JTextField nombre,JTextField fecha_vigencia) {
     setCodigo(Integer.parseInt(paramCodigo.getText()));
     setLogin(login.getText());
     setPassword(password.getText());
     setNombre(nombre.getText());
     setFecha_vigencia(fecha_vigencia.getText());
        
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE usuario SET login= ? ,password= ?,nombre= ? ,fecha_vigencia= ?  WHERE cve_usuario=?";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerCoinexion().prepareCall(consulta);
            String contrasenia=Base64.getEncoder().encodeToString(getPassword().getBytes());
                
            
            JOptionPane.showMessageDialog(null, contrasenia);
            cs.setString(1, getLogin());
            cs.setString(2, contrasenia);
            cs.setString(3, getNombre());
            cs.setString(4, getFecha_vigencia());
            cs.setInt(5, getCodigo());
           //  JOptionPane.showMessageDialog(null, cs);
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Modificación Exitosa");
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se modificó, error:"+ e.toString());
        }
    }
      
       public void EliminarAlumnos(JTextField paramCodigo){
    
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM usuario WHERE cve_usuario=?;";
        
        try {
             CallableStatement cs = objetoConexion.establecerCoinexion().prepareCall(consulta);
             cs.setInt(1, getCodigo());
             cs.execute();
             
             JOptionPane.showMessageDialog(null,"Se eliminó correctamente el Alumno");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo eliminar, error: "+ e.toString());
        }
        
    }

     
     
}
