package com.zulu.Mintic_Ciclo3_Textilera.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "movimiento_dinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionID; // ID de la transacción.

    @Column(name = "concepto_movimiento")
    String conceptoMovimiento;      // Descripción del movimiento.

    @Column(name = "monto_dinero")
    float montoDinero = 0.0f;      // Montos positivos y negativos de x movimiento.


    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado; // Id del perfil del usuario que realizó el movimiento del dinero.



    public MovimientoDinero(){
    }

    public MovimientoDinero (Long transactionID, float montoDinero, String conceptoMovimiento){
        this.transactionID = transactionID;
        this.montoDinero = montoDinero;
        this.conceptoMovimiento = conceptoMovimiento;

    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public float getMontoDinero() {
        return montoDinero;
    }

    public void setMontoDinero(float montoDinero) {
        this.montoDinero = montoDinero;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}