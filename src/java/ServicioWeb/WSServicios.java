/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioWeb;

import DAO.MesaDAO;
import DAO.Mesa_ReservaDAO;
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
    Mesa_ReservaDAO mrdao = new Mesa_ReservaDAO();

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
    @WebMethod(operationName = "asignarMesa")
    public String asignarMesa(@WebParam(name = "idMesa") int idMesa, @WebParam(name = "idReserva") int idReserva) {
        String datos = mrdao.asignarMesa(idMesa, idReserva);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerIDReserva")
    public int obtenerIDReserva() {
        int resultado = rdao.obtenerIDReserva();
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarReserva")
    public String agregarReserva(@WebParam(name = "inicio") String inicio, @WebParam(name = "termino") String termino, @WebParam(name = "cliente") int cliente) {
        String resultado = rdao.reservar(inicio, termino, cliente);
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MesaId")
    public Mesa MesaId(@WebParam(name = "id") int id) {
        Mesa mesa = mdao.MesaId(id);
        return mesa;
    }
}
