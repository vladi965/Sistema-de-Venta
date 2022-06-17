/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edgard
 */
public class Conexion {
    
    static Connection conn =null;
    
    public static Connection conectar(){
        String url="jdbc:sqlserver://localhost\\DESKTOP-5VJKBJT\\SQLEXPRESS:1433;databaseName=db_ventas";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("error de sql " + e.getMessage());
        }
        
        try {
            conn=DriverManager.getConnection(url,"sa","1234");
        } catch (SQLException e) {
            System.out.println("herror de conexion del  driver "+ e.getMessage());
        }
        return conn;
    }
}
 