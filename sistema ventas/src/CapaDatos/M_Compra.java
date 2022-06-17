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
public class M_Compra {
    private int idcompra;
    private Date fecha;
    private String hora;
    private String num_documento;
    private String tipo_documento;
    private Double subtotal;
    private Double igv;
    private Double total;
    private String estado;
    private int idusuario;
    private String idproveedor;

    public M_Compra() {
    }
    
    

    public M_Compra(int idcompra, Date fecha, String hora, String num_documento, String tipo_documento, Double subtotal, Double igv, Double total, String estado, int idusuario, String idproveedor) {
        this.idcompra = idcompra;
        this.fecha = fecha;
        this.hora = hora;
        this.num_documento = num_documento;
        this.tipo_documento = tipo_documento;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.estado = estado;
        this.idusuario = idusuario;
        this.idproveedor = idproveedor;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }
    
    
    
}
