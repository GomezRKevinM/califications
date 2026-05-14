package com.udc.app.califications.Services;

import com.udc.app.califications.Dao.ICalificacionCrud;
import com.udc.app.califications.Models.Calificacion;
import com.udc.app.califications.Services.InterfaceServices.ICalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalificacionServicioImp implements ICalificacionServicio {
    @Autowired
    ICalificacionCrud crudCalificacion;

    @Override
    @Transactional
    public void guardar(Calificacion calificacion) {
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
