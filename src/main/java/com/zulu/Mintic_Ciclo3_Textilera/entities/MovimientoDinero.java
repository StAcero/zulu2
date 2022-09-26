package com.zulu.Mintic_Ciclo3_Textilera.entities;


import javax.persistence.*;

@Entity
@Table(name = "movimientos")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int transactionID; // ID de la transacción.

    private String conceptoMovimiento;      // Descripción del movimiento.

    float montoDinero = 0.0f;      // Montos positivos y negativos de x movimiento.


    @ManyToOne
    @JoinColumn(name = "empleado_id")
    public Empleado empleado; // Id del perfil del usuario que realizó el movimiento del dinero.



    public MovimientoDinero(){
    }

    public MovimientoDinero(int transactionID, String conceptoMovimiento, float montoDinero, Empleado empleado) {
        this.transactionID = transactionID;
        this.conceptoMovimiento = conceptoMovimiento;
        this.montoDinero = montoDinero;
        this.empleado = empleado;
    }



    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
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