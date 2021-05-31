/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author dsaez
 */
public class Mesa_ReservaDAO {

    PreparedStatement ps;
    OracleResultSet ors;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;
    int res;
    String msj;

    public String asignarMesa(int idMesa, int idReserva) {

        String sql = "insert into mesa_reserva(mesa_id_mesa, reserva_id_reserva) values(?,?)";

        int res;
        String msj = "";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ps.setInt(2, idReserva);
            //el metodo ve la cantides de filas que fueron afectadas
            res = ps.executeUpdate();
            if (res == 1) {

                msj = "La reserva se realizo correctamente";

            } else {
                msj = "Error no se pudo agregar";
            }

        } catch (SQLException e) {
            System.out.print("loloololo ");
        }
        return msj;
    }

}
