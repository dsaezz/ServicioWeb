/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Reserva;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author dsaez
 */
public class ReservaDAO {

    Mesa_ReservaDAO mrdao = new Mesa_ReservaDAO();
    PreparedStatement ps;
    OracleResultSet ors;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;
    int res;
    String msj;

    public List listaReservas() {

        List<Reserva> datos = new ArrayList<>();
        String sql = "select * from reserva";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setID(rs.getInt(1));
                r.setfInicio(rs.getDate(2));
                r.setfTermino(rs.getDate(3));

                String es;
                es = rs.getString(4);
                char estado = es.charAt(0);
                r.setEstado(estado);
                r.setClienteid(rs.getInt(5));

                String ac;
                ac = rs.getString(6);
                char activo = ac.charAt(0);
                r.setActivo(activo);

                datos.add(r);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public String reservar(String inicio, String termino, int cliente) {

        //int idReserva;
        int res;
        String msj = "";
        try {
            con = c.conectar();
            //String sql = "{call AGREGARRESERVA(?,?,?,?,?)}";
            CallableStatement cmd = con.prepareCall("{call AGREGARRESERVA(?,?,?,?,?)}");

            cmd.setDate(1, java.sql.Date.valueOf(inicio));
            cmd.setDate(2, java.sql.Date.valueOf(termino));
            cmd.setString(3, "D");
            cmd.setInt(4, cliente);
            cmd.setString(5, "1");
            //el metodo ve la cantides de filas que fueron afectadas
            res = cmd.executeUpdate();
            /*ResultSet este = cmd.getGeneratedKeys();
            if (este.next()) {
                // aquí está el id generado para esta reserva
                idReserva = este.getInt(1);
                mrdao.asignarMesa(idMesa, idReserva);

            }*/
            if (res == 1) {

                msj = "La reserva se realizo correctamente";

            } else {
                msj = "Error no se pudo agregar";
            }

        } catch (SQLException e) {
            System.out.print("lol " + inicio + e);
        }
        return msj;
    }

}
