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
public class alertasCambiosCostos implements Serializable{
    @Expose
    public int codAlerta;           //     BIGINT          NOT NULL,
    @Expose
    public String tipoVariacion;    //  VARCHAR (20)    NULL,
    @Expose
    public String fechaAlerta;      // DATETIME        NULL,
    @Expose
    public double nuevoCosto;       // DECIMAL (10, 2) NULL,
    @Expose
    public String estado;           //        VARCHAR (20)    NULL,
    @Expose
    public int codArticulo;         //   BIGINT          NOT NULL,
    
    public alertasCambiosCostos(){}
    
    public alertasCambiosCostos(int codAlerta, String tipoVariacion, String fechaAlerta, double nuevoCosto, String estado, int codArticulo) {
        this.codAlerta = codAlerta;
        this.tipoVariacion = tipoVariacion;
        this.fechaAlerta = fechaAlerta;
        this.nuevoCosto = nuevoCosto;
        this.estado = estado;
        this.codArticulo = codArticulo;
    }

    public int getCodAlerta() {
        return codAlerta;
    }

    public void setCodAlerta(int codAlerta) {
        this.codAlerta = codAlerta;
    }

    public String getTipoVariacion() {
        return tipoVariacion;
    }

    public void setTipoVariacion(String tipoVariacion) {
        this.tipoVariacion = tipoVariacion;
    }

    public String getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(String fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    public double getNuevoCosto() {
        return nuevoCosto;
    }

    public void setNuevoCosto(double nuevoCosto) {
        this.nuevoCosto = nuevoCosto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }
    
}
