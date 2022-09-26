package com.zulu.Mintic_Ciclo3_Textilera.services;


import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServicio {

    @Autowired
    MovimientoRepository movimientoRepository;

    //Metodo para ver todos las transacciones registrados
    public List<MovimientoDinero> getAllMovimiento() {
        List<MovimientoDinero> movimientoList = new ArrayList<>();
        movimientoRepository.findAll().forEach(movimiento -> movimientoList.add(movimiento));
        return movimientoList;
    }

    //Metodo para buscar transacciones por ID
    public MovimientoDinero getMovimientoById(Integer id) {

        return movimientoRepository.findById(id).get();
    }

    //Metodo para buscar transaciones por empleado
    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
        return movimientoRepository.findByEmpleado(id);
    }

    //Metodo para guardar o actualizar registros en transacciones
    public boolean saveOrUpdateMovimiento(MovimientoDinero movim) {
        MovimientoDinero movi = movimientoRepository.save(movim);
        if (movimientoRepository.findById(movi.getTransactionID()) != null) {
            return true;
        }
        return false;
    }

    //Metodo para eliminar un registro de trasacciones por Id
    public boolean deleteMovimiento(int id) {
        movimientoRepository.deleteById(id);
        if (this.movimientoRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }
}
