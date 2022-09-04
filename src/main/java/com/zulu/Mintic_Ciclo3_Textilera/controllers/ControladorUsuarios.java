package com.zulu.Mintic_Ciclo3_Textilera.controllers;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControladorUsuarios {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping
    public List<Empleado> getUsuarios() {
       return empleadoServicio.getEmpleados();
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
    public void updateUsuario(@RequestBody Empleado empleado) {
        empleadoServicio.updateEmpleado(empleado);

    }

    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        empleadoServicio.deleteEmpleado(id);

    }


}
