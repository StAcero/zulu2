package com.zulu.Mintic_Ciclo3_Textilera.repositories;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimientoRepo extends JpaRepository<MovimientoDinero, Long> {


    //Selecciona todas los movientos de una empresa basado en empresaID
    @Query(value = "SELECT * FROM movimiento_dinero where empleado_id = (SELECT id_user from empleado where empresa_id = :empresaId)", nativeQuery = true)
    List<MovimientoDinero> findMovimientoDineroByEnterpriseId(@Param("empresaId") Long empresaId);
}
