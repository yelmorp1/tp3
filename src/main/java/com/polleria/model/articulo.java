/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author W7
 */
@Entity
public class articulo implements Serializable{

    @Id
    @Expose
    public String codArticulo;             //     BIGINT          NOT NULL IDENTITY(1,1),
    
    @Expose
    public String nombre;               //           VARCHAR (120)   NULL,
    
    @Expose
    public String descripcion;          //      VARCHAR (120)   NULL,
    
    @Expose
    public String costoXUM;             //        DECIMAL (10, 2) NOT NULL,
    
    @Expose
    public String codTipoArticulo;       //INT             NOT NULL,
    
    @Expose
    public String unidadMedida;         //  VARCHAR (10)    NOT NULL,
    
    @Expose
    public String estado;                       //       BIT             NULL,
    
    @Expose
    public String categoría;           //    VARCHAR (20)    NULL,
    
    public articulo(){}
    public articulo(String codArticulo, String nombre, String descripcion, String costoXUM, String codTipoArticulo, String unidadMedida, String estado, String categoría) {
        this.codArticulo = codArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoXUM = costoXUM;
        this.codTipoArticulo = codTipoArticulo;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
        this.categoría = categoría;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
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

    public String getCostoXUM() {
        return costoXUM;
    }

    public void setCostoXUM(String costoXUM) {
        this.costoXUM = costoXUM;
    }

    public String getCodTipoArticulo() {
        return codTipoArticulo;
    }

    public void setCodTipoArticulo(String codTipoArticulo) {
        this.codTipoArticulo = codTipoArticulo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    @Override
    public String toString() {
        return "articulo{" + "codArticulo=" + codArticulo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", costoXUM=" + costoXUM + ", codTipoArticulo=" + codTipoArticulo + ", unidadMedida=" + unidadMedida + ", estado=" + estado + ", categor\u00eda=" + categoría + '}';
    }

}
