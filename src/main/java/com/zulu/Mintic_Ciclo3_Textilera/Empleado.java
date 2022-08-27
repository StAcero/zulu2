package com.zulu.Mintic_Ciclo3_Textilera;

public class Empleado {
    String nombres, apellidos, correo;
    private Empresa empresa;



    public Empleado(String nombres, String apellidos, String correo) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
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


}
