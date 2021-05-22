/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioWeb;

import DAO.MesaDAO;
import DAO.ReservaDAO;
import Modelo.Mesa;
import Modelo.Reserva;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author dsaez
 */
@WebService(serviceName = "WSServicios")
public class WSServicios {

    MesaDAO mdao = new MesaDAO();
    ReservaDAO rdao = new ReservaDAO();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListarMesa")
    public List<Mesa> ListarMesa() {
        List dato = mdao.listar();
        return dato;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListarReserva")
    public List<Reserva> ListarReserva() {
        List info = rdao.listaReservas();
        return info;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarReserva")
    public String AgregarReserva(@WebParam(name = "id") int id, @WebParam(name = "inicio") String inicio, @WebParam(name = "termino") String termino,@WebParam(name = "idCliente") int idCliente) {
        String add = rdao.reservar(id, inicio, termino,idCliente);
        return add;
    }
}
