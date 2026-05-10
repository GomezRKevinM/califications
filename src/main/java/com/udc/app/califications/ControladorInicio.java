package com.udc.app.califications;

import com.udc.app.califications.modelo.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.mensaje}")
    String dato;

    @GetMapping("/")
    public String inicio(Model modelo){
        String mensaje = "Saludos desde spring MVC con paso de información";
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("dato", dato);
        Usuario u = new  Usuario();
        u.setCedula("123456789");
        u.setClave("123abc");
        u.setNombre("Mike");
        u.setEmail("miki@user.com");
        Usuario u2 = new  Usuario();
        u2.setCedula("987654321");
        u2.setClave("abc123");
        u2.setNombre("Selene");
        Usuario u3 = new  Usuario();
        u3.setCedula("123459876");
        u3.setClave("a1b2c3");
        u3.setNombre("Taylor");
        List<Usuario> usuarios = Arrays.asList(u,u2,u3);
        modelo.addAttribute("alguien", u);
        modelo.addAttribute("usuarios", usuarios);
        log.info("Ejecutando el controlador de Inicio");
        return "index";
    }
}
