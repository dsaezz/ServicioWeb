/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Diego
 */
public class Conexion {
     String url="jdbc:oracle:thin:@localhost:1521:ORCL";
    String user="ANGEL";
    String pass="123";
    Connection con;
    public Connection conectar (){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,user,pass);
             return con;
        } catch (Exception ex) {
            System.out.println(ex);
        }
       return con;
        
    }
}

