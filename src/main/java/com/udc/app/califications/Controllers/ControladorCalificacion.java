package com.udc.app.califications.Controllers;

import com.udc.app.califications.Models.Calificacion;
import com.udc.app.califications.Models.Estudiante;
import com.udc.app.califications.Services.CalificacionServicioImp;
import com.udc.app.califications.Services.EstudianteServicioImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class ControladorCalificacion {

    @Autowired
    CalificacionServicioImp calificacionService;

    @Autowired
    EstudianteServicioImp estudianteService;

    @GetMapping("/calification/")
    public String inicio(Model modelo){
        log.info("Ejecutando el controlador de Calificacion");
        List<Calificacion> calificaciones = calificacionService.listarCalificaciones();
        modelo.addAttribute("calificaciones", calificaciones);
        return "Calificacion/list";
    }

    @GetMapping("/calification/agregar")
    public String agregar(Calificacion calificacion, Model modelo){
        modelo.addAttribute("calificacion", calificacion);
        List<Estudiante> estudiantes = (List<Estudiante>) estudianteService.listarEstudiantes();
        modelo.addAttribute("estudiantes", estudiantes);
        return "Calificacion/modificar";
    }

    @GetMapping("/calification/eliminar")
    public String eliminar(Calificacion calificacion){
        calificacionService.eliminar(calificacion);
        return "redirect:/calification/";
    }

    @GetMapping("/calification/editar/{id}")
    public String editar(Calificacion calificacion, Model modelo){
        calificacion = calificacionService.buscar(calificacion);
        List<Estudiante> estudiantes = (List<Estudiante>) estudianteService.listarEstudiantes();
        modelo.addAttribute("calificacion", calificacion);
        modelo.addAttribute("estudiantes", estudiantes);
        return "Calificacion/modificar";
    }

    @PostMapping("/calification/guardar")
    public String guardar(@Valid Calificacion calificacion, Errors errores){
        if(errores.hasErrors()){
            return "Calificacion/modificar";
        }
        calificacionService.guardar(calificacion);
        return "redirect:/calification/";
    }
}
