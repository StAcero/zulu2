package com.zulu.Mintic_Ciclo3_Textilera.repositories;

import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepo extends JpaRepository<Empleado, Long> {
   @Query("SELECT empleado FROM Empleado empleado where empresa_id=:empresaId")
   List<Empleado> findUserByEnterpriseId(@Param("empresaId") Long empresaId);
}
