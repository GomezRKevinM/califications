package com.udc.app.califications.Dao;

import com.udc.app.califications.Models.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface IEstudianteCrud extends CrudRepository<Estudiante, String> {
}
