package com.udc.app.califications.Services.InterfaceServices;

import com.udc.app.califications.Models.Estudiante;

import java.util.List;

public interface IEstudianteServicio {

    public List<Estudiante> listarEstudiantes();

    public void guardar(Estudiante estudiante);

    public void eliminar(Estudiante estudiante);

    public Estudiante buscar(Estudiante estudiante);
}
