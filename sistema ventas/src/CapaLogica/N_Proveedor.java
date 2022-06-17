/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.M_Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgard
 */
public class N_Proveedor {
    private Conexion SQL=new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String[] titulos={"ID","Razon Social","Ruc","Telefono","Direccion"};
        modelo = new DefaultTableModel(null,titulos);
        String[] registro = new String[5];
        
        sql=("sp_buscar_proveedor'"+buscar+"'");
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
               registro[0] = rs.getString(1);
               registro[1] = rs.getString(2);
               registro[2] = rs.getString(3);
               registro[3] = rs.getString(4);
               registro[4] = rs.getString(5);
               modelo.addRow(registro);
               
                
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
    }
    
   public boolean insertar(M_Proveedor dts){
      sql=("{call sp_guardar_proveedor (?,?,?,?,?)}");
       try {
           PreparedStatement pst = cn.prepareStatement(sql);
           pst.setString(1,dts.getIdprovedor());
           pst.setString(2,dts.getRazonsocial());
           pst.setString(3,dts.getRuc());
           pst.setString(4,dts.getTelefono());
           pst.setString(5,dts.getDireccion());
           
           int n =pst.executeUpdate();
           
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
   
    public boolean editar(M_Proveedor dts){
      sql=("{call sp_editar_proveedor (?,?,?,?,?)}");
       try {
           PreparedStatement pst = cn.prepareStatement(sql);
           pst.setString(1,dts.getIdprovedor());
           pst.setString(2,dts.getRazonsocial());
           pst.setString(3,dts.getRuc());
           pst.setString(4,dts.getTelefono());
           pst.setString(5,dts.getDireccion());
           
           int n =pst.executeUpdate();
           
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
   
    public boolean eliminar(M_Proveedor dts){
        sql=("{call sp_eliminar_proveedor(?)}");
        try {
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getIdprovedor());
            
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
    
      public int gernerarIdProveedor(){
            String sql =("select max(idproveedor) as id from proveedor");
            int cod =0;
            
            try {
                Statement st =cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if (rs.next()) {
                    cod=rs.getInt("id")+1;
                    
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null,"herror sql:"+ e1.getMessage());
            }
            
            return cod;
        }    
    
    
}
 