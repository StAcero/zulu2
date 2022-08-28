package com.zulu.Mintic_Ciclo3_Textilera;

import java.util.stream.Stream;

public class Empleado {
    String nombres, apellidos, correo;
    Long idUser;
    private Empresa empresa;
    private NombresDeRol rol;



    public Empleado(Long idUser, String nombres, String apellidos, String correo) {
        this.idUser = idUser;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public NombresDeRol getRol() {
        return rol;
    }

    public void setRol(NombresDeRol rol) {
        this.rol = rol;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }



    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
