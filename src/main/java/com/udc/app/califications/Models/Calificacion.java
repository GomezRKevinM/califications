package com.udc.app.califications.Models;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    public Calificacion() {}

    @Id
    @NotEmpty
    private String id;

    @NotEmpty
    private Timestamp fecha;

    @NotEmpty
    private String docente;

    @NotEmpty
    private String asignatura;

    @NotEmpty
    private String carrera;

    @NotEmpty
    private String universidad;

    @NotEmpty
    private String periodo;

    @NotEmpty
    private String actividadEvaluada;

    @NotEmpty
    @DecimalMin(value = "0")
    @DecimalMax(value = "1")
    private double porcentaje;


    @ManyToOne
    @JoinColumn(name = "student_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "calificacion_ibfk_1", value = ConstraintMode.CONSTRAINT, foreignKeyDefinition = "FOREIGN KEY (student_id) REFERENCES students(id)"))
    private Estudiante estudiante;

    @NotEmpty
    @DecimalMin(value = "0")
    @DecimalMax(value = "5")
    private double nota;

    @NotEmpty
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @NotEmpty
    @Column(name = "updated_at", nullable = false, updatable = true)
    private Timestamp updatedAt;

    @PrePersist
    public void prePersist() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (createdAt == null) {
            createdAt = now;
        }
        if (updatedAt == null) {
            updatedAt = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
