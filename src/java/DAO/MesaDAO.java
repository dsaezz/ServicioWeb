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
import java.sql.ResultSet;
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
    OracleResultSet ors;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;

    ResultSet rs;

    public List listar() {
        List<Mesa> lista = new ArrayList<>();
        //String sql = "SELECT * FROM MESA";//"exe LISTARMESA";
        try {
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call LISTARMESA(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            ors = (OracleResultSet) cst.getObject(1);
            while (ors.next()) {
                Mesa m = new Mesa();
                m.setId(ors.getInt(1));
                m.setNr_mesa(ors.getInt(2));

                String variable;
                variable = ors.getString(3);
                char caracter = variable.charAt(0);
                m.setEstado(caracter);

                String ac;
                ac = ors.getString(4);
                char activo = ac.charAt(0);
                m.setActivo(activo);

                lista.add(m);
            }
        } catch (Exception e) {

        }
        return lista;

    }

    public Mesa MesaId(int id) {
        String sql = "select * from mesa where id_mesa=" + id;
        Mesa m = new Mesa();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ors = (OracleResultSet)ps.executeQuery();

            while (ors.next()) {

                m.setId(ors.getInt(1));
                m.setNr_mesa(ors.getInt(2));

                String variable;
                variable = ors.getString(3);
                char caracter = variable.charAt(0);
                m.setEstado(caracter);

                String ac;
                ac = ors.getString(4);
                char activo = ac.charAt(0);
                m.setActivo(activo);

            }

        } catch (Exception e) {
        }
        return m;
    }
}
