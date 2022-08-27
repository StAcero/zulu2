package com.zulu.Mintic_Ciclo3_Textilera;

public class Empresa {
    String nombreEmpresa, direccionEmpresa;
    long telefono, nit;

    public Empresa(String nombreEmpresa, String direccionEmpresa, long telefono, long nit) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefono = telefono;
        this.nit = nit;
    }






    public String getnombreEmpresa() {
        return nombreEmpresa;
    }

    public void setnombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getdireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setdireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }
}
