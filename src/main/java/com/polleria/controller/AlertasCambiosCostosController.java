/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.controller;

import com.polleria.conexion.conexionSql;
import com.polleria.model.alertasCambiosCostos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author W7
 */
@Service(value = "ProductServicesImp")
public class AlertasCambiosCostosController {

    Connection cn = null;// conexion a la clase base datos
    Statement stm = null;//
    PreparedStatement ps, ps2 = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    String sql = null;
    String mysql = "asd";
    int ok;
    List<Integer> lista;
    Integer cat = null;

    public List<Integer> readAll() throws Exception {
        lista = new ArrayList<>();
        try {
            cn = conexionSql.getConnection();
            stm = cn.createStatement();
            rs = stm.executeQuery("select * from GRP.tb_alertasCambiosCostos;");
            while (rs.next()) {
                cat = rs.getInt(1);
                lista.add(cat);
            }
            rs.close();
            stm.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            // cn.close();
        }
        return lista;

    }

    public alertasCambiosCostos find(Integer idArticulo) throws Exception {
        alertasCambiosCostos articuloCambiado = new alertasCambiosCostos();
        try {
            cn = conexionSql.getConnection();
            sql = "select * from GRP.tb_alertasCambiosCostos where codArticulo= ? ;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(idArticulo));
            rs = ps.executeQuery();
            while (rs.next()) {
                articuloCambiado.setCodAlerta(rs.getInt(1));
                articuloCambiado.setTipoVariacion(rs.getString(2));
                articuloCambiado.setFechaAlerta(rs.getString(3));
                articuloCambiado.setNuevoCosto(rs.getDouble(4));
                articuloCambiado.setEstado(rs.getString(5));
                articuloCambiado.setCodArticulo(rs.getInt(6));
            }
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            rs.close();
        }
        return articuloCambiado;

    }

    public void delete(int idArticulo) throws Exception {
       cn = conexionSql.getConnection();
       sql = "delete from GRP.tb_alertasCambiosCostos where codArticulo= ? ;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(idArticulo));
            rs = ps.executeQuery();
    }
}
