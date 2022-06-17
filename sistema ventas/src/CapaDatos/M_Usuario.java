/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Edgard
 */
public class M_Usuario {
   private int idusuario;
   private String idempleado;
   private String usuario;
   private String password;
   private String acceso;
   private String estado;

    public M_Usuario() {
    }

    public M_Usuario(int idusuario, String idempleado, String usuario, String password, String acceso, String estado) {
        this.idusuario = idusuario;
        this.idempleado = idempleado;
        this.usuario = usuario;
        this.password = password;
        this.acceso = acceso;
        this.estado = estado;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
   
    
}
