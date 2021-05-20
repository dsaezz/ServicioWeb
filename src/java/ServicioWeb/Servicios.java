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
import java.util.Date;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author dsaez
 */
@WebService(serviceName = "Servicios")
public class Servicios {
    MesaDAO mdao = new MesaDAO();
    ReservaDAO rdao = new ReservaDAO();
    
    
    
     @WebMethod(operationName = "ListaMesaWS")
    public List<Mesa> ListaMesaWS() {
        List dato = mdao.listar();
        return dato;
    }
    
     @WebMethod(operationName = "ListaReservaWS")
    public List<Reserva> ListaReservaWS() {
        List R = rdao.listar();
        return R;
    }
    
     @WebMethod(operationName = "ListaReserva")
    public List<Reserva> ListaReserva() {
        List info = rdao.listaReservas();
        return info;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarReserva")
    public String AgregarReserva(@WebParam(name = "id") int id, @WebParam(name = "inicio") String inicio, @WebParam(name = "termino") String termino) {
        
       String add = rdao.reservar(id, inicio, termino);
       return add;
    }
    
    
    
    
}
