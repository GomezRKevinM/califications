package com.udc.app.califications.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class Usuario implements Serializable {
    @Id
    private String id;

    @NotEmpty
    String name;

    @NotEmpty
    @Email
    String email;

    @NotEmpty
    String password;

    @NotEmpty
    String Role;

    @NotEmpty
    String status;

    @NotEmpty
    @Column(name = "created_at", nullable = false, updatable = false)
    Timestamp createdAt;

    @NotEmpty
    @Column(name = "updated_at", nullable = false, updatable = true)
    Timestamp updatedAt;

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
