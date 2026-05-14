package com.udc.app.califications.Dao;

import com.udc.app.califications.Models.Calificacion;
import org.springframework.data.repository.CrudRepository;

public interface ICalificacionCrud extends CrudRepository<Calificacion, String> {
}
