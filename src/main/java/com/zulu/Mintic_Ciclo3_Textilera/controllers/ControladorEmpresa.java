package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpresaServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.MovimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ControladorEmpresa {
    @Autowired
    private EmpresaServicio empresaServicio;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private MovimientoServicio movimientoServicio;



    @GetMapping("/enterprises")
    public List<Empresa> getEmpresas() {
        return empresaServicio.getEmpresas();
    }
    @PostMapping("/enterprises")
    public void addEmpresa(@RequestBody Empresa empresa) {

        empresaServicio.addEmpresas(empresa);
    }
   @GetMapping("/enterprises/{id}")
    public Empresa getEmpresa(@PathVariable("id") Long id) {
        return empresaServicio.getEmpresa(id);
    }

    @PatchMapping("/enterprises/{id}")

    public ResponseEntity<String> updateEnterprisePartially(
            @PathVariable(value = "id") Long idEmpresa, @RequestBody Empresa empresa
    ){
        // Filtrando la empresa a actualizar en variable
        Empresa empre = empresaServicio.getEmpresa(idEmpresa);

        // Actualizando campos deseados.
        empre.setnombreEmpresa(empresa.getnombreEmpresa());
        empre.setdireccionEmpresa(empresa.getdireccionEmpresa());
        empre.setTelefono(empresa.getTelefono());
        empre.setNit(empresa.getNit());

        // Guardando Actualizaciones
        empresaServicio.updateEmpresa(empre);

        //Retornando mensaje "Actualizado"
        return ResponseEntity.ok("Actualizado");
    }


    @DeleteMapping("/enterprises/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id) {
        empresaServicio.deleteEmpresa(id);
    }




}



