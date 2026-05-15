package com.udc.app.califications.Dao;

import com.udc.app.califications.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
