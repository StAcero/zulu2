package com.zulu.Mintic_Ciclo3_Textilera.controllers;

import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;

import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoService;
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
    private EmpleadoService empleadoServicio;



    @GetMapping
    public List<MovimientoDinero> getMovimientoDinero() {
        return movimientoServicio.getAllMovimiento();
    }

   /* @PostMapping
    public RedirectView addMovimientoDinero(@ModelAttribute MovimientoDinero movimientoDinero, Model model, RedirectAttributes redirectAttrs){
        model.addAttribute(movimientoDinero);
        this.movimientoServicio.addMovimientoDinero(movimientoDinero);
        redirectAttrs
                .addFlashAttribute("mensaje", "Transacción efectiva")
                .addFlashAttribute("clase", "success");

        return new RedirectView("/inicio/qtran/tran");*/
    @PostMapping
    public void addMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero) {
       movimientoServicio.saveOrUpdateMovimiento(movimientoDinero);
    }

    @GetMapping("{id}")
    public MovimientoDinero getMovimientoDineroById(@PathVariable("id") int id) {
        return movimientoServicio.getMovimientoById(id);
    }
    @PatchMapping("{id}")

    public ResponseEntity<String> updateEnterprisePartially(
            @PathVariable(value = "id") int id, @RequestBody MovimientoDinero movimientoDinero
    ){
        // Filtrando el Empleado a actualizar en variable
        movimientoDinero = movimientoServicio.getMovimientoById(id);

        // Actualizando campos deseados.
        movimientoDinero.setConceptoMovimiento(movimientoDinero.getConceptoMovimiento());
        movimientoDinero.setMontoDinero(movimientoDinero.getMontoDinero());
        movimientoDinero.setEmpleado(movimientoDinero.getEmpleado());
        movimientoDinero.getEmpleado().setEmpresa(movimientoDinero.getEmpleado().getEmpresa());


        // Guardando Actualizaciones
        movimientoServicio.saveOrUpdateMovimiento(movimientoDinero);

        //Retornando mensaje "Actualizado"
        return ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("{id}")
    public void deleteMovimientoDinero(@PathVariable("id") int id) {
        movimientoServicio.deleteMovimiento(id);
    }
/*
    @GetMapping("enterprises/{id}")
    public List<MovimientoDinero> findMovimientoDineroByEnterpriseId(@PathVariable("id") Long id){
        return movimientoServicio.findMovimientoDineroByEnterpriseID(id);
    }*/
}