package com.algaworks.algamoneyapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
@Data

public class Permissao {

    @Id
    private Long codigo;

    private String descricao;

}