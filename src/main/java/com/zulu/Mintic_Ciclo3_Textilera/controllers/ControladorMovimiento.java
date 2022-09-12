package com.zulu.Mintic_Ciclo3_Textilera.controllers;

import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;

import com.zulu.Mintic_Ciclo3_Textilera.services.MovimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class ControladorMovimiento {

    @Autowired
    private MovimientoServicio movimientoServicio;


    @GetMapping
    public List<MovimientoDinero> getMovimientoDinero() {
        return movimientoServicio.getMovimientoDinero();
    }
    @PostMapping
    public void addMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero) {

        movimientoServicio.addMovimientoDinero(movimientoDinero);
    }
    @GetMapping("{id}")
    public MovimientoDinero getMovimientoDinero(@PathVariable("id") Long id) {
        return movimientoServicio.getMovimientoDinero(id);
    }
    @PatchMapping("{id}")

    public ResponseEntity<MovimientoDinero> updateEnterprisePartially(
            @PathVariable(value = "id") Long idMovimiento, @RequestBody MovimientoDinero movimientoDinero
    ){
        // Filtrando el Empleado a actualizar en variable
        MovimientoDinero movDine = movimientoServicio.getMovimientoDinero(idMovimiento);

        // Actualizando campos deseados.
        movDine.setConceptoMovimiento(movimientoDinero.getConceptoMovimiento());
        movDine.setMontoDinero(movimientoDinero.getMontoDinero());



        // Guardando Actualizaciones
        movimientoServicio.updateMovimientoDinero(movDine);

        //Retornando Entidad actualizada
        return ResponseEntity.ok(movDine);
    }




    @DeleteMapping("{id}")
    public void deleteMovimientoDinero(@PathVariable("id") Long id) {
        movimientoServicio.deleteMovimientoDinero(id);
    }
}