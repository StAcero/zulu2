package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorEmpresa {

    @GetMapping("/enterprises")
    public String getEmpresas() {
        return "GET Todas las Empresas";
    }
    @PostMapping("/enterprises")
    public String addEmpresa(Empresa empresa) {
        return "POST Todas las Empresas";
    }
    
   @GetMapping("/enterprises/{id}")
    public String getEmpresa(@PathVariable("id") Long id) {
        return "Get Empresa ID";
    }
    @PatchMapping("/enterprises/{id}")
    public String updateEmpresa(@PathVariable("id") Long id) {
        return "Update Empresa ID";
    }

    @DeleteMapping("/enterprises/{id}")
    public String deleteEmpresa(@PathVariable("id") Long id) {
        return "Delete Empresa ID";
    }
}



