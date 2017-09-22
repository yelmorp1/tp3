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
public class carta {
    public int codCarta;             //NOT NULL,
    public String fechaCreacion;     // DATETIME NULL,
    public String fechaModificacion; // DATETIME NULL,
    public char estado;              //  BIT      NOT NULL,

    public carta(int codCarta, String fechaCreacion, String fechaModificacion, char estado) {
        this.codCarta = codCarta;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
    }

    public int getCodCarta() {
        return codCarta;
    }

    public void setCodCarta(int codCarta) {
        this.codCarta = codCarta;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
}
