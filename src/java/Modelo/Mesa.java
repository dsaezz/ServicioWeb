/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author dsaez
 */
public class Mesa {

    public Mesa() {
    }

    int id;
    int nr_mesa;
    char estado, activo;
    String UsuarioRut, UsuarioRol_ID_ROL;

    public Mesa(int id, int nr_mesa, char estado, char activo, String UsuarioRut, String UsuarioRol_ID_ROL) {
        this.id = id;
        this.nr_mesa = nr_mesa;
        this.estado = estado;
        this.activo = activo;
        this.UsuarioRut = UsuarioRut;
        this.UsuarioRol_ID_ROL = UsuarioRol_ID_ROL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNr_mesa() {
        return nr_mesa;
    }

    public void setNr_mesa(int nr_mesa) {
        this.nr_mesa = nr_mesa;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public String getUsuarioRut() {
        return UsuarioRut;
    }

    public void setUsuarioRut(String UsuarioRut) {
        this.UsuarioRut = UsuarioRut;
    }

    public String getUsuarioRol_ID_ROL() {
        return UsuarioRol_ID_ROL;
    }

    public void setUsuarioRol_ID_ROL(String UsuarioRol_ID_ROL) {
        this.UsuarioRol_ID_ROL = UsuarioRol_ID_ROL;
    }

}
