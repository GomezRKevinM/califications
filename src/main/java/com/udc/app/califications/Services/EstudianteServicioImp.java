package com.udc.app.califications.Services;

import com.udc.app.califications.Dao.IEstudianteCrud;
import com.udc.app.califications.Models.Estudiante;
import com.udc.app.califications.Services.InterfaceServices.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EstudianteServicioImp implements IEstudianteServicio {
    @Autowired
    IEstudianteCrud crudEstudiante;

    @Transactional
    @Override
    public void guardar(Estudiante estudiante) {
        estudiante.setId(UUID.randomUUID().toString());
        crudEstudiante.save(estudiante);
    }

    @Transactional
    @Override
    public void eliminar(Estudiante estudiante) {
        crudEstudiante.delete(estudiante);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Estudiante> listarEstudiantes(){
        return (List<Estudiante>) crudEstudiante.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Estudiante buscar(Estudiante estudiante){
        return crudEstudiante.findById(estudiante.getId()).orElse(null);
    }
}
