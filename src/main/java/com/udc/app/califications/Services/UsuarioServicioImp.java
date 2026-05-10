package com.udc.app.califications.Services;

import com.udc.app.califications.Dao.IUsuarioCrud;
import com.udc.app.califications.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {
    @Autowired
    IUsuarioCrud crudUser;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) crudUser.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario usuario) {
        crudUser.save(usuario);
    }

    @Transactional
    @Override
    public void eliminar(Usuario usuario) {
        crudUser.delete(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscar(Usuario usuario) {
        return crudUser.findById(usuario.getCedula()).orElse(null);
    }
}
