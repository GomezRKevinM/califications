package com.udc.app.califications.Services.InterfaceServices;

import com.udc.app.califications.Models.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();

    public void guardar(Usuario usuario);

    public void eliminar(Usuario usuario);

    public Usuario buscar(Usuario usuario);
}
