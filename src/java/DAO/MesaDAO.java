/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author dsaez
 */
public class MesaDAO {
     PreparedStatement ps;
    OracleResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;

    public List listar() {
        List<Mesa> lista = new ArrayList<>();
        //String sql = "SELECT * FROM MESA";//"exe LISTARMESA";
        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARMESA(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            rs = (OracleResultSet) cst.getObject(1);
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setId(rs.getInt(1));
                m.setNr_mesa(rs.getInt(2));
                
                String variable;
                variable = rs.getString(3);
                char caracter = variable.charAt(0);
                m.setEstado(caracter);
                
                String ac;
                ac = rs.getString(4);
                char activo = ac.charAt(0);
                m.setActivo(activo);
                
                lista.add(m);
            }
        } catch (Exception e) {

        }
        return lista;

    }
}
