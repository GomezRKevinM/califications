package com.udc.app.califications.Dao;

import com.udc.app.califications.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {

}
