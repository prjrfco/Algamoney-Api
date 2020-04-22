package com.algaworks.algamoneyapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data

public class Usuario {

    @Id
    private Long codigo;

    private String nome;
    private String email;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "codigo_usuario")
            , inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
    private List<Permissao> permissoes;

}