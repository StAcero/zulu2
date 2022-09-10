package com.zulu.Mintic_Ciclo3_Textilera.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idEmpresa;

    @Column(name = "nombre_empresa")
    String nombreEmpresa;
    @Column(name = "direccion_empresa")
    String direccionEmpresa;

    @Column(name = "telefono")
    Long telefono;

    @Column(name = "nit")
    Long nit;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> listaEmpleado;

    public Empresa(){}

    public Empresa(String nombreEmpresa, String direccionEmpresa, Long telefono, Long nit) {
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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }
}
