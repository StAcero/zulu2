package com.zulu.Mintic_Ciclo3_Textilera.repositories;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Integer> {


    //Selecciona todas los movientos de una empresa basado en empresaID
    @Query(value="SELECT * FROM empleado where empresa_id= ?1", nativeQuery=true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer id);;
}
