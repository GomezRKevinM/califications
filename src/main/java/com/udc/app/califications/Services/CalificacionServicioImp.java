package com.udc.app.califications.Services;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udc.app.califications.Dao.ICalificacionCrud;
import com.udc.app.califications.Models.Calificacion;
import com.udc.app.califications.Services.InterfaceServices.ICalificacionServicio;

@Service
public class CalificacionServicioImp implements ICalificacionServicio {
    @Autowired
    ICalificacionCrud crudCalificacion;

    @Override
    @Transactional
    public void guardar(Calificacion calificacion) {
        if(calificacion.getId() == null || calificacion.getId().isEmpty()){
            calificacion.setId(UUID.randomUUID().toString());
        }
        crudCalificacion.save(calificacion);
    }

    @Override
    @Transactional
    public void eliminar(Calificacion calificacion) {
        crudCalificacion.delete(calificacion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Calificacion> listarCalificaciones() {
        return (List<Calificacion>) crudCalificacion.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Calificacion buscar(Calificacion calificacion) {
        return crudCalificacion.findById(calificacion.getId()).orElse(null);
    }
}
