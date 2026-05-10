package com.udc.app.califications.Models;

import jakarta.persistence.*;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @Basic(optional = false)
    @NotEmpty
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;

    @NotEmpty
    String clave;

    @NotEmpty
    String nombre;

    @Email
    String email;
}
