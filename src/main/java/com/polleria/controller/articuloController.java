/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.controller;

import com.polleria.conexion.conexionSql;
import com.polleria.model.articulo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author W7
 */
public class articuloController {

    Connection cn = null;// conexion a la clase base datos
    Statement stm = null;//
    PreparedStatement ps, ps2 = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    String sql = null;
    String mysql = "asd";
    int ok;
    List<Integer> lista;
    articulo cat = null;

    public articulo find(int idArticulo) throws Exception {
        lista = new ArrayList<>();
        try {   

            cn = conexionSql.getConnection();
            sql = "select * from GRP.tb_articulo where codArticulo= ? ;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(idArticulo));
            //ps.setString(2,  (String)p);           
            rs = ps.executeQuery();
            if (rs.next()) {
                cat = new articulo();
                cat.setCodArticulo(rs.getString(1));
                cat.setNombre(rs.getString(2));
                cat.setDescripcion(rs.getString(3));
                cat.setCostoXUM(rs.getString(4));
                cat.setCodTipoArticulo(rs.getString(5));
                cat.setUnidadMedida(rs.getString(6));
                cat.setEstado(rs.getString(7));
                cat.setCategoría(rs.getString(8));

            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            // cn.close();
        }
        return cat;
    }
}
