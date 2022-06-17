/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.M_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgard
 */
public class N_Usuario {
     private Conexion SQL= new Conexion();
     private Connection cn = SQL.conectar();
     String sql="";
     
     public int totalregistros;
     
     public DefaultTableModel mostrar(String buscar){
         DefaultTableModel modelo;
         
         String[] titulos ={"ID Usuario","Id Empleado","Nombre","Apellios","Usuario","Password","Acceso","Estado"};
         modelo=new DefaultTableModel(null, titulos);
         String[] registro = new String[8];
         
         sql=("sp_listar_usuario'"+buscar+"'");
         
         try {
             Statement st=cn.createStatement();
             ResultSet rs= st.executeQuery(sql);
             while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                modelo.addRow(registro);
                
                 
             }
             return modelo;
         } catch (Exception e) {
             JOptionPane.showConfirmDialog(null, e);
             return null;
         }
     }
     
     public boolean insertar(M_Usuario dts){
       sql=("{call sp_guardar_usuarios (?,?,?,?,?)}");
         try {
             PreparedStatement pst = cn.prepareStatement(sql);
             pst.setString(1,dts.getIdempleado());
             pst.setString(2,dts.getUsuario());
             pst.setString(3,dts.getPassword());
             pst.setString(4,dts.getAcceso());
             pst.setString(5,dts.getEstado());
             
             int n = pst.executeUpdate();
             if (n!=0) {
                 return true;
             }else{
                 return false;
             }
         } catch (Exception e) {
             JOptionPane.showConfirmDialog(null, e);
             return false;
         }
     }
     
      public boolean editar(M_Usuario dts){
       sql=("{call sp_editar_usuarios (?,?,?,?,?)}");
         try {
             PreparedStatement pst = cn.prepareStatement(sql);
             pst.setString(1,dts.getIdempleado());
             pst.setString(2,dts.getUsuario());
             pst.setString(3,dts.getPassword());
             pst.setString(4,dts.getAcceso());
             pst.setString(5,dts.getEstado());
             
             int n = pst.executeUpdate();
             if (n!=0) {
                 return true;
             }else{
                 return false;
             }
         } catch (Exception e) {
             JOptionPane.showConfirmDialog(null, e);
             return false;
         }
     }
      
       public boolean eliminar(M_Usuario dts){
       sql=("{call sp_eliminar_usuarios (?)}");
         try {
             PreparedStatement pst = cn.prepareStatement(sql);
             pst.setInt(1,dts.getIdusuario());
             
             int n = pst.executeUpdate();
             if (n!=0) {
                 return true;
             }else{
                 return false;
             }
         } catch (Exception e) {
             JOptionPane.showConfirmDialog(null, e);
             return false;
         }
     }
       
       
       public DefaultTableModel logeo(String usuario , String password){
         DefaultTableModel modelo;
         
         String[] titulos ={"ID Usuario","Id Empleado","Nombre","Apellios","Usuario","Password","Acceso","Estado"};
         String[] registro = new String[8];
         modelo=new DefaultTableModel(null, titulos);
         
         
         sql=("sp_sesion'" + usuario + "','" + password + "'");
         totalregistros = 0;
         
         try {
             Statement st=cn.createStatement();
             ResultSet rs= st.executeQuery(sql);
             while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                totalregistros=totalregistros + 1;
                modelo.addRow(registro);
                
                 
             }
             return modelo;
         } catch (Exception e) {
             JOptionPane.showConfirmDialog(null, e);
             return null;
         }
     }
}
