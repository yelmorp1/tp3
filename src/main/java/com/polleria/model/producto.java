/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/**
 *
 * @author W7
 */
public class producto implements Serializable{
    @Expose
    public int codProducto;             // BIGINT          NOT NULL,
    @Expose
    public String umbralCosto;          // DECIMAL (10, 2) NULL,
    @Expose
    public String elaboracion;           // VARCHAR (MAX)   NOT NULL,
    @Expose
    public String estado;                     //           BIT             NULL,
    @Expose
    public String precio;               //      DECIMAL (10, 2) NULL,
    @Expose
    public String costo;                //     DECIMAL (10, 2) NULL,
    @Expose
    public String nombre;               //      VARCHAR (40)    NOT NULL,

    public producto(){}
    
    public producto(int codProducto, String umbralCosto, String elaboracion, String estado, String precio, String costo, String nombre) {
        this.codProducto = codProducto;
        this.umbralCosto = umbralCosto;
        this.elaboracion = elaboracion;
        this.estado = estado;
        this.precio = precio;
        this.costo = costo;
        this.nombre = nombre;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getUmbralCosto() {
        return umbralCosto;
    }

    public void setUmbralCosto(String umbralCosto) {
        this.umbralCosto = umbralCosto;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
