package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControladorUsuarios {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping
    public List<Empleado> getUsuarios() {
       return empleadoServicio.getAllEmpleados();
    }
    @PostMapping
    public void addUsuario(@RequestBody Empleado empleado) {

        empleadoServicio.addEmpleado(empleado);
    }

    @GetMapping("{id}")
    public Empleado getUsuario(@PathVariable("id") Long id) {
        return empleadoServicio.getEmpleado(id);
    }


    @PatchMapping("{id}")

    public ResponseEntity<String> updateEnterprisePartially(
            @PathVariable(value = "id") Long idUser, @RequestBody Empleado empleado
    ){
        // Filtrando el Empleado a actualizar en variable
        Empleado emple = empleadoServicio.getEmpleado(idUser);

        // Actualizando campos deseados.
        emple.setNombres(empleado.getNombres());
        emple.setApellidos(empleado.getApellidos());
        emple.setCorreo(empleado.getCorreo());
        emple.setRol(empleado.getRol());
        emple.setEmpresa(empleado.getEmpresa());



        // Guardando Actualizaciones
        empleadoServicio.updateEmpleado(emple);

        //Retornando mensaje "Actualizado"
        return ResponseEntity.ok("Actualizado");
    }



    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        empleadoServicio.deleteEmpleado(id);

    }

    @GetMapping("/ent/{id}")
    public List<Empleado> getUsers(@PathVariable(value = "id") Long id){
        return empleadoServicio.findUserByEnterpriseId(id);
    }


}
