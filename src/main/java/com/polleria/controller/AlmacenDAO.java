
package com.polleria.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDAO {
    /*
 Connection cn = null;// conexion a la clase base datos
  Statement stm = null;//
  PreparedStatement ps,ps2 = null;
  ResultSet rs = null;
  CallableStatement cs = null;
  String sql = null;
  String mysql= "asd";
  int ok;
  List<AlmacenTO> lista;
  AlmacenTO cat = null; 
    @Override
    public int create(AlmacenTO t) throws Exception {
       int ok;
         
    try {
         cn = AccesoBD.getConnection();
           
      sql = "insert into almacen (nombre_almace,direccion_almacen,telefono_almacen)Values(?,?,?);";
      ps = cn.prepareStatement(sql);
      
      ps.setString(1, t.getNombreAlmacen());
      ps.setString(2, t.getDireccionAlmacen());
      ps.setString(3, String.valueOf(t.getTelefonoLocal()));
               
      ok = ps.executeUpdate() == 1 ? 1 : 0;
      ps.close();
    } catch (Exception e) {
      throw e;
    } finally {
      try {
       cn.rollback();// deshace la transaccion
      } catch (Exception e) {
      }
    }
    return ok;
    }

    @Override
    public int update(AlmacenTO t) throws Exception {
    int ok = 0;
    try {
      cn = AccesoBD.getConnection();
      sql = "update almacen set nombre_almace=?,direccion_almacen=?,telefono_almacen=? where id_almacen = ?;";
      ps = cn.prepareStatement(sql);
         
      
      ps.setString(1, t.getNombreAlmacen());
      ps.setString(2, t.getDireccionAlmacen());
      ps.setString(3, String.valueOf(t.getTelefonoLocal()));
      ps.setString(4, String.valueOf(t.getId_almacen()));
      ok = ps.executeUpdate() == 1 ? 1 : 0;
      ps.close();
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        // cn.close();
      } catch (Exception e) {
      }
    }
    return ok;
     
    }

    @Override
    public int delete(AlmacenTO t) throws Exception {
     int ok = 0;
    try {
      cn = AccesoBD.getConnection();
      sql = " delete from almacen where id_almacen=?;";
      ps = cn.prepareStatement(sql);
      ps.setString(1, String.valueOf(t.getId_almacen()));
      ok = ps.executeUpdate() == 1 ? 1 : 0;
      ps.close();
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        //cn.close();
      } catch (Exception e) {
      }
    }
    return ok;
    }

    @Override
    public AlmacenTO find(Object t, Object p) throws Exception {
    
         AlmacenTO ok = new AlmacenTO();
        
         
        if (t.equals("may") && p.equals("hola"))
    {
         cn= AccesoBD.getConnection();
         stm = cn.createStatement();
         sql= "select MAX(id_almacen)from almacen;";
         rs = stm.executeQuery(sql);
         rs.next();
         ok.setId_almacen(rs.getInt(1));
         rs.close();
        stm.close();
         
    }
        if(p== "hola")
      {
          try { 
            cn = AccesoBD.getConnection();  
            sql = "select id_almacen,nombre_almace, direccion_almacen,telefono_almacen from almacen where id_almacen= ? ;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, (String) t);
            //ps.setString(2,  (String)p);           
            rs = ps.executeQuery();
            if (rs.next()) {
                
                ok.setId_almacen(rs.getInt(1));
                ok.setNombreAlmacen(rs.getString(2));
                ok.setDireccionAlmacen(rs.getString(3));
                ok.setTelefonoLocal(rs.getInt(4));
            }
            rs.close();
            ps.close();
            
            
   } catch (Exception e) {
      throw e;
    }   
      }     
        
        
        
         return ok;      
    }

    @Override
    public List<AlmacenTO> readAll() throws Exception {
    lista = new ArrayList<>();
    try {
      cn = AccesoBD.getConnection();
      stm = cn.createStatement();
      rs = stm.executeQuery("select * from almacen;");
      while (rs.next()) {
         cat = new AlmacenTO();
         cat.setId_almacen(rs.getInt(1));
         cat.setNombreAlmacen(rs.getString(2));
         cat.setDireccionAlmacen(rs.getString(3));
         cat.setTelefonoLocal(Integer.valueOf(rs.getString(4)));
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

    @Override
    public List<AlmacenTO> readAll(Object t, String op) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
       


*/
   
}