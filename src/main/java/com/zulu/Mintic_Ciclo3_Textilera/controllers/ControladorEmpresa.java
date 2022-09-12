package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEmpresa {
    @Autowired
    private EmpresaServicio empresaServicio;
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

    public ResponseEntity<Empresa> updateEnterprisePartially(
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

        //Retornando Entidad actualizada
        return ResponseEntity.ok(empre);
    }


    @DeleteMapping("/enterprises/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id) {
        empresaServicio.deleteEmpresa(id);
    }
}



