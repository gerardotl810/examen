/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.ResultSet;
import java.sql.Statement;
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
public class CBusqueda {
String login; 
            String password;
            String nombre;
            String fechaalta;
            String fecha_vigencia;
            int codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void MostrarActivos (JTable paramTablaTotalUsuarios){
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
         sql="Select * from usuario  WHERE status=1";
         
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
      
    
        public void MostrarInctivos (JTable paramTablaTotalUsuarios){
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
         sql="Select * from usuario  WHERE status!=1";
         
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
        
         public void MostrarRevocados (JTable paramTablaTotalUsuarios){
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
         sql="Select * from usuario  WHERE fecharevocado is not null";
         
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
         
         
         public void MostrarNombre (JTable paramTablaTotalUsuarios,JTextField nombre){
             setNombre(nombre.getText());
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
         sql="Select * from usuario  WHERE nombre like '%"+getNombre()+"%'";
         
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
        
         
         public void MostrarFecha (JTable paramTablaTotalUsuarios,JTextField fecha){
             setFechaalta(fecha.getText());
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
         sql="Select * from usuario  WHERE fechaalta like '%"+getFechaalta()+"%'";
         
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

public void MostrarFechaVigencia (JTable paramTablaTotalUsuarios,JTextField fecha){
             setFecha_vigencia(fecha.getText());
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
         sql="Select * from usuario  WHERE fecha_vigencia like '%"+getFecha_vigencia()+"%'";
         
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
}
