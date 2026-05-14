package com.udc.app.califications.Models;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Estudiante implements Serializable {

    public Estudiante() {}

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "`lastName`", nullable = false)
    private String apellido;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, updatable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, targetEntity = Calificacion.class)
    private List<Calificacion> calificaciones;

    @PrePersist
    public void prePersist() {
        Timestamp now = Timestamp.from(Instant.now());

        if (createdAt == null) {
            createdAt = now;
        }

        if (updatedAt == null) {
            updatedAt = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }
}
