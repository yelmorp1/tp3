/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.controller;

import com.polleria.conexion.conexionSql;
import com.polleria.model.articulo;
import com.polleria.model.producto;
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
public class productoController {
    Connection cn = null;// conexion a la clase base datos
    Statement stm = null;//
    PreparedStatement ps, ps2 = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    String sql = null;
    String mysql = "asd";
    int ok;
    List<Integer> lista;

    public producto find(Integer idProducto) throws Exception {
        lista = new ArrayList<>();
        producto ok = new producto();
        try {

            cn = conexionSql.getConnection();
            sql = "select * from GRP.tb_producto where codProducto= ? ;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(idProducto));
            //ps.setString(2,  (String)p);           
            rs = ps.executeQuery();
            if (rs.next()) {
                ok.setCodProducto(rs.getInt(1));
                ok.setNombre(rs.getString(2));
                ok.setUmbralCosto(rs.getString(3));
                ok.setCosto(rs.getString(4));
                ok.setElaboracion(rs.getString(5));
                ok.setEstado(rs.getString(6));
                ok.setPrecio(rs.getString(7));
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            // cn.close();
        }
        return ok;
    }
}
