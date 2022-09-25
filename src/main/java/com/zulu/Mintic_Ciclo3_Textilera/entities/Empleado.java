package com.zulu.Mintic_Ciclo3_Textilera.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idUser;

    @Column(name = "nombres", length = 50)
    String nombres;

    @Column(name = "apellidos", length = 50)
    String apellidos;

    @Column(name = "correo", length = 50)
    String correo;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;




    @Enumerated(EnumType.STRING)
    private NombresDeRol rol;

    public Empleado(){}

    public Empleado(String nombres, String apellidos, String correo, Empresa empresa, NombresDeRol rol ) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public NombresDeRol getRol() {
        return rol;
    }

    public void setRol(NombresDeRol rol) {
        this.rol = rol;
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
