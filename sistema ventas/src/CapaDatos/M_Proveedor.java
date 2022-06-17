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
public class M_Proveedor {
    private String idprovedor;
    private String razonsocial;
    private String ruc;
    private String telefono;
    private String direccion;

    public M_Proveedor() {
    }

    public M_Proveedor(String idprovedor, String razonsocial, String ruc, String telefono, String direccion) {
        this.idprovedor = idprovedor;
        this.razonsocial = razonsocial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getIdprovedor() {
        return idprovedor;
    }

    public void setIdprovedor(String idprovedor) {
        this.idprovedor = idprovedor;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
