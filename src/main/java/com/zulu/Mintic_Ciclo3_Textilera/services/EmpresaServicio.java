package com.zulu.Mintic_Ciclo3_Textilera.services;


import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServicio {
    @Autowired
    EmpresaRepository empresaRepository;

    //Metodo para ver todos las empresas registrados
    public List<Empresa> getAllEmpresa(){
        List<Empresa> empresaList= new ArrayList<>();
        empresaRepository.findAll().forEach(empleado -> empresaList.add(empleado));
        return empresaList;
    }

    //Metodo para buscar empresa por ID
    public Empresa getEmpresaById(Integer id){ //Existe optional y asi se podria usar

        return empresaRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar registros en Empresa
    public boolean saveOrUpdateEmpresa(Empresa empr){
        Empresa empre=empresaRepository.save(empr);
        if (empresaRepository.findById(empre.getId())!=null){
            return true;
        }
        return false;
    }

    //Metodo para eliminar un registro de Empresa por Id
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        if(this.empresaRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }
}
