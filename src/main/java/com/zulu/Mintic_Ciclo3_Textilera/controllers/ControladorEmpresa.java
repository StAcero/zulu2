package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void updateEmpresa(@PathVariable("id") Long id) {
        empresaServicio.updateEmpresa(id);
    }

    @DeleteMapping("/enterprises/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id) {
        empresaServicio.deleteEmpresa(id);
    }
}



