package com.zulu.Mintic_Ciclo3_Textilera.services;

import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.EmpresaRepositorio;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.MovimientoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServicio {
    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    private MovimientoRepo movimientoRepo;

    public List<Empresa> getEmpresas(){
        return empresaRepositorio.findAll();
    }

    public Empresa getEmpresa(Long id) {
        return empresaRepositorio.findById(id).get();
    }

    public void addEmpresas(Empresa listElement) {
        empresaRepositorio.save(listElement);

    }
    public void updateEmpresa(Empresa empresa) {
       empresaRepositorio.save(empresa);
    }

    public void deleteEmpresa(Long id) {
        empresaRepositorio.deleteById(id);
    }

    public List<MovimientoDinero> findMovimientoDineroByEnterpriseId(Long id){
        return movimientoRepo.findMovimientoDineroByEnterpriseId(id);
    }

}
