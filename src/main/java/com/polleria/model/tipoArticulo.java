/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.model;

/**
 *
 * @author W7
 */
public class tipoArticulo {
    // unidad de medida del producto 
    // costo por unidad de medida 
    // con esto te ayudas a saber cuanto cuesta por articulo
    public int codTipoArticulo; // INT             IDENTITY (1, 1) NOT NULL,
    public String nombre;       //  VARCHAR (120)   NULL,
    public String descripcion;  //    VARCHAR (120)   NULL,
    public double costoXUM;      //        DECIMAL (10, 2) NOT NULL,
    public String tipoArticulo;  //    VARCHAR (35)    NOT NULL,
    public String unidadMedida; //    VARCHAR (10)    NOT NULL,

    public tipoArticulo(int codTipoArticulo, String nombre, String descripcion, double costoXUM, String tipoArticulo, String unidadMedida) {
        this.codTipoArticulo = codTipoArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoXUM = costoXUM;
        this.tipoArticulo = tipoArticulo;
        this.unidadMedida = unidadMedida;
    }

    public int getCodTipoArticulo() {
        return codTipoArticulo;
    }

    public void setCodTipoArticulo(int codTipoArticulo) {
        this.codTipoArticulo = codTipoArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoXUM() {
        return costoXUM;
    }

    public void setCostoXUM(double costoXUM) {
        this.costoXUM = costoXUM;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
    
}
