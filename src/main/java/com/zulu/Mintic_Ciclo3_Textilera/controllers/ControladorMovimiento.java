package com.zulu.Mintic_Ciclo3_Textilera.controllers;

import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;

import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpresaServicio;
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
    @Autowired
    private EmpresaServicio empresaServicio;

    @Autowired
    private EmpleadoServicio empleadoServicio;



    @GetMapping
    public List<MovimientoDinero> getMovimientoDinero() {
        return movimientoServicio.getMovimientoDinero();
    }

    @PostMapping
    public void addMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero) {
       movimientoServicio.addMovimientoDinero(movimientoDinero);
    }

    @GetMapping("{id}")
    public MovimientoDinero getMovimientoDineroById(@PathVariable("id") Long id) {
        return movimientoServicio.getMovimientoDinero(id);
    }
    @PatchMapping("{id}")

    public ResponseEntity<String> updateEnterprisePartially(
            @PathVariable(value = "id") Long id, @RequestBody MovimientoDinero movimientoDinero
    ){
        // Filtrando el Empleado a actualizar en variable
        MovimientoDinero movDine = movimientoServicio.getMovimientoDinero(id);

        // Actualizando campos deseados.
        movDine.setConceptoMovimiento(movimientoDinero.getConceptoMovimiento());
        movDine.setMontoDinero(movimientoDinero.getMontoDinero());
        movDine.setEmpleado(movimientoDinero.getEmpleado());
        movDine.getEmpleado().setEmpresa(movimientoDinero.getEmpleado().getEmpresa());


        // Guardando Actualizaciones
        movimientoServicio.updateMovimientoDinero(movDine);

        //Retornando mensaje "Actualizado"
        return ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("{id}")
    public void deleteMovimientoDinero(@PathVariable("id") Long id) {
        movimientoServicio.deleteMovimientoDinero(id);
    }

    @GetMapping("enterprises/{id}")
    public List<MovimientoDinero> findMovimientoDineroByEnterpriseId(@PathVariable("id") Long id){
        return movimientoServicio.findMovimientoDineroByEnterpriseID(id);
    }
}