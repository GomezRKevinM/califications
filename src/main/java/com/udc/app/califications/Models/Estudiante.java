package com.udc.app.califications.Models;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "students")
@Data
public class Estudiante implements Serializable {
    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "lastName", nullable = false)
    private String apellido;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, updatable = true)
    private Timestamp updatedAt;

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
