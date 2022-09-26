package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoService;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpresaServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.MovimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorEmpresa {
    @Autowired
    private EmpresaServicio empresaServicio;

    @Autowired
    private EmpleadoService empleadoServicio;

    @Autowired
    private MovimientoServicio movimientoServicio;



    @GetMapping("/enterprises")
    public List<Empresa> getEmpresas() {
        return empresaServicio.getAllEmpresa();
    }
    @PostMapping("/enterprises")
    public void addEmpresa(@RequestBody Empresa empresa) {

        empresaServicio.saveOrUpdateEmpresa(empresa);
    }
   @GetMapping("/enterprises/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id) {
        return empresaServicio.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")

    public ResponseEntity<String> updateEnterprisePartially(
            @PathVariable(value = "id") int id, @RequestBody Empresa empresa
    ){
        // Filtrando la empresa a actualizar en variable
        empresa = empresaServicio.getEmpresaById(id);

        // Actualizando campos deseados.
        empresa.setNombre(empresa.getNombre());
        empresa.setDireccion(empresa.getDireccion());
        empresa.setTelefono(empresa.getTelefono());
        empresa.setNit(empresa.getNit());

        // Guardando Actualizaciones
        empresaServicio.saveOrUpdateEmpresa(empresa);

        //Retornando mensaje "Actualizado"
        return ResponseEntity.ok("Actualizado");
    }


    @DeleteMapping("/enterprises/{id}")
    public void deleteEmpresa(@PathVariable("id") int id) {
        empresaServicio.deleteEmpresa(id);
    }




}



