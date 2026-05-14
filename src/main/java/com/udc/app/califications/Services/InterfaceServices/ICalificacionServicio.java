package com.udc.app.califications.Services.InterfaceServices;

import com.udc.app.califications.Models.Calificacion;

import java.util.List;

public interface ICalificacionServicio {

    public List<Calificacion> listarCalificaciones();

    public void guardar(Calificacion calificacion);

    public void eliminar(Calificacion calificacion);

    public Calificacion buscar(Calificacion calificacion);
}
