/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.conexion;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author W7
 */
public class conexionSql {

    private static Connection cn = null;

    public static Connection getConnection() throws Exception {

        try {
            if (cn == null) {

                String path = System.getProperty("java.library.path");
                path = "C:\\Users\\UserTBS1\\Downloads\\sqljdbc_6.0.8112.100_enu\\sqljdbc_6.0\\enu\\auth\\x64" + ";" + path;
                System.setProperty("java.library.path", path);

                try {

                    final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
                    sysPathsField.setAccessible(true);
                    sysPathsField.set(null, null);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                // carga driver en memoria   
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                // url de la base de datos                                          
                String connectionUrl = "jdbc:sqlserver://54.177.48.68:50009;database=db_pardos_dev;integratedSecurity=false;";
                // obtener la conexion a la base de datos
                //cn = DriverManager.getConnection(connectionUrl, "usr_grp_rpaucar", "9Z1wRWTodgsQu2k4dzo9");
                cn = DriverManager.getConnection(connectionUrl,"usr_grp_ymoreno" ,"Y4XXvKvc9ZDVWTHHQCFY");  
                int cont = 1;
            }
        } catch (Exception e) {
            throw e;
        }
        return cn;
    }

    public static void main(String[] args) throws Exception {
        conexionSql.getConnection();
    }
}
