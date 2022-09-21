package com.project.experto.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Integer id;

    @NotEmpty
    @Size(min = 6, max = 14)
    private String username;

    @NotEmpty
    @Size(min = 6, max = 16)
    private String password;

    @NotEmpty
    @Email(message = "Ingrese un correo electronico valido")
    private String email;

    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;

    public Usuario() {
    }

    

}