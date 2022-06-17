/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

import java.sql.Date;

/**
 *
 * @author Edgard
 */
public class M_Producto {
    private String idproducto;
    private int idcategoria;
    private String serie;
    private String nombre;
    private Date f_ingreso;
    private Date f_vencimiento;
    private Double p_venta;
    private Double p_compra;

    public M_Producto() {
    }

    public M_Producto(String idproducto, int idcategoria, String serie, String nombre, Date f_ingreso, Date f_vencimiento, Double p_venta, Double p_compra) {
        this.idproducto = idproducto;
        this.idcategoria = idcategoria;
        this.serie = serie;
        this.nombre = nombre;
        this.f_ingreso = f_ingreso;
        this.f_vencimiento = f_vencimiento;
        this.p_venta = p_venta;
        this.p_compra = p_compra;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(Date f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public Date getF_vencimiento() {
        return f_vencimiento;
    }

    public void setF_vencimiento(Date f_vencimiento) {
        this.f_vencimiento = f_vencimiento;
    }

    public Double getP_venta() {
        return p_venta;
    }

    public void setP_venta(Double p_venta) {
        this.p_venta = p_venta;
    }

    public Double getP_compra() {
        return p_compra;
    }

    public void setP_compra(Double p_compra) {
        this.p_compra = p_compra;
    }
    
    
    
    
}
