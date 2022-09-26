package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControladorUsuarios {
    @Autowired
    private EmpleadoService empleadoServicio;

    @GetMapping
    public List<Empleado> getUsuarios() {
       return empleadoServicio.getAllEmpleado();
    }
    @PostMapping
    public void addUsuario(@RequestBody Empleado empleado) {

        empleadoServicio.saveOrUpdateEmpleado(empleado);
    }

    @GetMapping("{id}")
    public Empleado getUsuario(@PathVariable("id") int id) {

        return empleadoServicio.getEmpleadoById(id);
    }


    @PatchMapping("{id}")

    public ResponseEntity<String> updateEnterprisePartially(
            @PathVariable(value = "id") int id, @RequestBody Empleado empleado
    ){
        // Filtrando el Empleado a actualizar en variable
        empleado = empleadoServicio.getEmpleadoById(id);

        // Actualizando campos deseados.
        empleado.setNombre(empleado.getNombre());
        empleado.setApellido(empleado.getApellido());
        empleado.setCorreo(empleado.getCorreo());
        empleado.setRol(empleado.getRol());
        empleado.setEmpresa(empleado.getEmpresa());



        // Guardando Actualizaciones
        empleadoServicio.saveOrUpdateEmpleado(empleado);

        //Retornando mensaje "Actualizado"
        return ResponseEntity.ok("Actualizado");
    }



    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable(value = "id") int id) {
        empleadoServicio.deleteEmpleado(id);

    }
/*
    @GetMapping("/ent/{id}")
    public List<Empleado> getUsers(@PathVariable(value = "id") int id){
        return empleadoServicio.findUserByEnterpriseId(id);
    }
*/

}
