package com.zulu.Mintic_Ciclo3_Textilera.services;

import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServicio {
    @Autowired
    private EmpleadoRepo empleadoRepo;

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepo.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;

    }

    public Empleado getEmpleado(Long id) {
        return empleadoRepo.findById(id).get();
    }

    public void addEmpleado(Empleado listElement) {
        empleadoRepo.save(listElement);

    }
    public void updateEmpleado(Empleado empleado) {
      empleadoRepo.save(empleado);
    }

    public void deleteEmpleado(Long id) {
        empleadoRepo.deleteById(id);
    }

    public List<Empleado> findUserByEnterpriseId(Long id){
        return empleadoRepo.findUserByEnterpriseId(id);
    }
}
