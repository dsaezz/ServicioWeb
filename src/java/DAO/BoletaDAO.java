/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Modelo.Mesa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlElement;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Victor Angel
 */
public class BoletaDAO {
    PreparedStatement ps;
    OracleResultSet ors;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    OracleCallableStatement cst;
    int res;
    String msj;
    public String addBoleta(int TOTALPAGAR,int MONTOPAGADO, String FECHABOLETA,int CAMBIO, int IDPEDIDO, int IDMESA) {

       /*SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
       String ini = formato.format(inicio);*/
        try {
            con = c.conectar();
                       
            CallableStatement cmd = con.prepareCall("{call AGREGARBOLETA(?,?,?,?,?,?)}");

            cmd.setInt(1, TOTALPAGAR);
            cmd.setInt(2, MONTOPAGADO);
            cmd.setDate(3, java.sql.Date.valueOf(FECHABOLETA));
            cmd.setInt(4, CAMBIO);
            cmd.setInt(5, IDPEDIDO);
            cmd.setInt(6, IDMESA);
            //el metodo ve la cantides de filas que fueron afectadas
            res = cmd.executeUpdate();
            
            if(res == 1){
                
                msj = "El pago se realizo correctamente";
                
            }
            else{
                msj = "No se pudo realizar el pago";
            }
            
        } catch (SQLException e) {
            System.out.print("Error: " + e);
        }
         return msj;
    }
    public List ListBoleta(){
        
        
        List<String> lista = new ArrayList<>();
        
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Nro Mesa");
        /*tabla.addColumn("Precio Plato");
        tabla.addColumn("Nombre plato");
        tabla.addColumn("Nombre Bebestible");
        tabla.addColumn("Precio Bebestible");
        tabla.addColumn("Cantidad Bebestible");
        tabla.addColumn("Cantidad Plato");*/
         
        try {
            int i = 1;
            con = c.conectar();
            cst = (OracleCallableStatement) con.prepareCall("{call DETALLEORDEN(?,?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setInt(2, i);

            cst.execute();
            rs = (OracleResultSet) cst.getObject(1);
            
            while (rs.next()) {
                
                
                tabla.addRow(new Object[]{rs.getString("NOMBRE_BEBESTIBLE")});
                lista.add(rs.getString("NOMBRE_BEBESTIBLE"));
                lista.add(new String (rs.getString("NOMBRE_PLATO")));
            }
            return lista;
           
        } catch (Exception e) {
            System.out.print("ERROROROR " + e);
               return null;

        }
        
    }
}
