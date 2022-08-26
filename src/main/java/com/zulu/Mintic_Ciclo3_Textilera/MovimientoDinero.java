package com.zulu.Mintic_Ciclo3_Textilera;

public class MovimientoDinero {
    float montoDinero = 0.0f;       // Montos positivos y negativos de x movimiento.
    String conceptoMovimiento;      // Descripción del movimiento.
    String idUser;                  // Id del perfil del usuario que realizó el movimiento del dinero.

    public MovimientoDinero(){
    }

    public MovimientoDinero (float montoDinero, String conceptoMovimiento, String idUser){
        this.montoDinero = montoDinero;
        this.conceptoMovimiento = conceptoMovimiento;
        this.idUser = idUser;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}