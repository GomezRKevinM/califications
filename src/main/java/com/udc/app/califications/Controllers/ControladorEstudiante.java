package com.udc.app.califications.Controllers;

import com.udc.app.califications.Models.Estudiante;
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

@Controller
@Slf4j
public class ControladorEstudiante {
    @Autowired
    EstudianteServicioImp estudianteService;

    @GetMapping("/student/")
    public String inicio(Model modelo){
        log.info("Ejecutando el controlador de Estudiante");
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        modelo.addAttribute("estudiantes", estudiantes);
        return "Estudiante/list";
    }

    @GetMapping("/student/agregar")
    public String agregar(Estudiante estudiante, Model modelo){
        modelo.addAttribute("estudiante", estudiante);
        return "Estudiante/modificar";
    }

    @PostMapping("/student/guardar")
    public String guardar(@Valid Estudiante estudiante, Errors errores){
        if(errores.hasErrors()){
            return "Estudiante/modificar";
        }
        estudianteService.guardar(estudiante);
        return "redirect:/student/";
    }

    @GetMapping("/student/editar/{id}")
    public String editar(Estudiante estudiante,Model modelo){
        log.info("Invocamos el metodo EDITAR Estudiante");
        estudiante = estudianteService.buscar(estudiante);
        modelo.addAttribute("estudiante", estudiante);
        return "Estudiante/modificar";
    }

    @GetMapping("/student/eliminar")
    public String eliminar(Estudiante estudiante){
        estudianteService.eliminar(estudiante);
        return "redirect:/student/";
    }
}
