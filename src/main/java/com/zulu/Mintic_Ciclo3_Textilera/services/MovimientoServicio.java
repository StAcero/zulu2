package com.zulu.Mintic_Ciclo3_Textilera.services;


import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.MovimientoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServicio {

    @Autowired
    private MovimientoRepo movimientoRepo;

    public List<MovimientoDinero> getMovimientoDinero(){
        return movimientoRepo.findAll();
    }

    public MovimientoDinero getMovimientoDinero(Long id) {
        return movimientoRepo.findById(id).get();
    }

    public void addMovimientoDinero(MovimientoDinero listElement) {
        movimientoRepo.save(listElement);

    }
    public void updateMovimientoDinero(MovimientoDinero movimientoDinero) {
        movimientoRepo.save(movimientoDinero);
    }

    public void deleteMovimientoDinero(Long id) {
        movimientoRepo.deleteById(id);
    }


}
