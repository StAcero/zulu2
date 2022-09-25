package com.zulu.Mintic_Ciclo3_Textilera.entities;


import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoServicio;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "empleado_id")
    public List<Empleado> empleado = new ArrayList<>();

    public Empresa (){}

    public Empresa(String nombreEmpresa, String direccionEmpresa, Long telefono, Long nit, List<Empleado> empleado) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefono = telefono;
        this.nit = nit;
        this.empleado = empleado;
    }
    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
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
