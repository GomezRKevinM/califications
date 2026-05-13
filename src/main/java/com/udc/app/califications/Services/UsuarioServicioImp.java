package com.udc.app.califications.Services;

import com.udc.app.califications.Dao.IUsuarioCrud;
import com.udc.app.califications.Models.Usuario;
import com.udc.app.califications.Services.InterfaceServices.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {
    @Autowired
    IUsuarioCrud crudUser;
    @Autowired
    PasswordHash hash;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) crudUser.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario usuario) {

        usuario.setId(UUID.randomUUID().toString());

        String hasPass = hash.hashPassword(usuario.getPassword());
        usuario.setPassword(hasPass);
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
        return crudUser.findById(usuario.getId().toString()).orElse(null);
    }
}
