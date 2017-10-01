/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.controller;

import com.polleria.conexion.conexionSql;
import com.polleria.model.articuloProducto;
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
public class articuloProductoController {
     Connection cn = null;// conexion a la clase base datos
    Statement stm = null;//
    PreparedStatement ps, ps2 = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    String sql = null;
    int ok;
    List<Integer> lista;
    articuloProducto productoXArticulo = null;
    List<articuloProducto> listaProductoXArticulo = null;

    public List<articuloProducto> findAllProductoByArticulo(int idArticulo) throws Exception {
        listaProductoXArticulo = new ArrayList<>();
        try {

            cn = conexionSql.getConnection();
            sql = "select * from GRP.tb_articuloProducto where codArticulo= ? ;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(idArticulo));
            //ps.setString(2,  (String)p);           
            rs = ps.executeQuery();
            while (rs.next()) {
                productoXArticulo = new articuloProducto();
                productoXArticulo.setCodArticulo(rs.getInt(1));
                productoXArticulo.setCodProducto(rs.getInt(2));
                productoXArticulo.setCosto(rs.getDouble(3));
                productoXArticulo.setCantidad(rs.getDouble(4));
                
                listaProductoXArticulo.add(productoXArticulo);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally  {
            // cn.close();
        }
        return listaProductoXArticulo;
    }
    
    public String update(articuloProducto artChange) throws Exception {
        listaProductoXArticulo = new ArrayList<>();
        String resultado = "bad";
        try { 

            cn = conexionSql.getConnection();
            sql= "UPDATE GRP.tb_articuloProducto SET cantidad = ? WHERE codArticulo = ? AND codProducto = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(artChange.getCantidad()));
            ps.setString(2, String.valueOf(artChange.getCodArticulo()));
            ps.setString(3, String.valueOf(artChange.getCodProducto()));
            ps.execute();
            resultado = "ok";
            
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return resultado;
        } finally  {
            // cn.close();
        }
        return resultado;
    }
    
    
    
}
