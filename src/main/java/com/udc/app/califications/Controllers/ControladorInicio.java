package com.udc.app.califications.Controllers;

import com.udc.app.califications.Dao.IUsuarioCrud;
import com.udc.app.califications.Models.Usuario;
import com.udc.app.califications.Services.IUsuarioServicio;
import com.udc.app.califications.Services.UsuarioServicioImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    //IUsuarioCrud crudUsuario;
    UsuarioServicioImp userService;
    @GetMapping("/")
    public String inicio(Model modelo){
        List<Usuario> usuarios = (List<Usuario>) userService.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        log.info("Ejecutando el controlador de Inicio");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Usuario usuario){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        userService.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{cedula}")
    public String editar(Usuario usuario, Model modelo){
        log.info("Invocamos el metodo EDITAR");
        usuario = userService.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Usuario usuario){
        userService.eliminar(usuario);
        return "redirect:/";
    }

}
