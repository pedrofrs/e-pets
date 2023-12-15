package com.softwaredev.epets_h2.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Data
@Entity
public class Usuario {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID idUsuario;
    @NotBlank
    private String login;
    @Email
    private String email;
    @CPF
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotNull
    @Min(value = 1900)
    @Max(value = 2024)
    private int anoNascimento;
    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    private int mesNascimento;
    @NotNull
    @Min(value = 1)
    @Max(value = 31)
    private int diaNascimento;
    @NotBlank
    private String password;
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String telefone;
}