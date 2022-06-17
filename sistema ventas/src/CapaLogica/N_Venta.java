/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.M_Venta;
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
public class N_Venta {
     private Conexion SQL = new Conexion();
    private Connection cn =SQL.conectar();
    String sql="";
    ResultSet rs;
    
    
     public DefaultTableModel mostrar(){
        DefaultTableModel modelo;
        
        String[] titulos={"ID Producto","Descripcion","Cantidad","Precio","Igv","Total"};
       modelo=new DefaultTableModel(null,titulos);
       String[] registro =new String[6];
       return modelo;
     }
    
    public DefaultTableModel mostrar1(String buscar){
        DefaultTableModel modelo;
        
        String[] titulos={"ID Venta","Cliente","Fecha","Empleado","Comprobante","Numero","Estado","Sub Total","Impuesto","Total"};
       modelo=new DefaultTableModel(null,titulos);
       String[] registro =new String[10];
       
       sql=("sp_listar_ventas'"+buscar+"'");
        try {
            Statement st =cn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            
            while (rs.next()) {
               registro[0]=rs.getString(1);
               registro[1]=rs.getString(2);
               registro[2]=rs.getString(3);
               registro[3]=rs.getString(4);
               registro[4]=rs.getString(5);
               registro[5]=rs.getString(6);
               registro[6]=rs.getString(7);
               registro[7]=rs.getString(8);
               registro[8]=rs.getString(9);
               registro[9]=rs.getString(10);
               modelo.addRow(registro);
            }
            return modelo;
  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean InsertarVentas (M_Venta dts){
        String fecha,hora;
        fecha = Funciones.getFechaHactual();
        hora=Funciones.getHoraHactual();
        
        sql=("{call sp_guardar_venta (?,?,?,?,?,?,?,?,?,?,?)}");
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,fecha);
            pst.setString(2,hora);
            pst.setString(3,dts.getSerie());
            pst.setString(4,dts.getNum_documento());
            pst.setString(5,dts.getTipo_documento());
            pst.setDouble(6,dts.getSubtotal());
            pst.setDouble(7,dts.getIgv());
            pst.setDouble(8,dts.getTotal());
            pst.setString(9,dts.getEstado());
            pst.setInt(10,dts.getIdusuario());
            pst.setString(11,dts.getIdcliente());
            
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
    
  public String IdVentas(){
      String idv="";
             sql =("select max(idventa)  from ventas");
            
            
            try {
                PreparedStatement pst =cn.prepareStatement(sql);
               rs=pst.executeQuery();
               
                while (rs.next()) {
                    idv=rs.getString(1);
                    
                }
               
               
            } catch (SQLException e1) {
               
            }
            
            return idv;
        }   
  
  
   public int Gnerarcomprobantefactura(){
            String sql =("select max(num_documento) as id from ventas where tipo_documento='Factura'");
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
   
   
    public int Gnerarcomprobanteboleta(){
            String sql =("select max(num_documento) as id from ventas where tipo_documento='Boleta'");
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


