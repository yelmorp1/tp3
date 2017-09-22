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
public class articuloProducto implements Serializable{
    // la cantidad es cuanto se va utilizar de ese insumo por producto
    @Expose
    public int codArticulo;                //BIGINT          NOT NULL,
    @Expose
    public int codProducto;               // BIGINT          NOT NULL,
    @Expose
    public double costo;                 //    DECIMAL (10, 2) NULL,
    
    @Expose
    public double cantidad;                 //DECIMAL (10, 3) NULL,
    
    public articuloProducto(){}
    
    public articuloProducto(int codArticulo, int codProducto, double costo, double cantidad) {
        this.codArticulo = codArticulo;
        this.codProducto = codProducto;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
