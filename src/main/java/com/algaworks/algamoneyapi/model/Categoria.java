package com.algaworks.algamoneyapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity //Entidade, tornando essa uma classe persistente
@Table(name = "categoria") //Mapeamento da tabela categoria do banco
@EqualsAndHashCode //Adicionando Equals and Hashcode com lombok
@Data //Adicionando os getters and setters com lombok a todos os atributos da classe


public class Categoria { //Mapeamento da classe categoria

    @Id //Tornando o atributo codigo nosso identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id gerado a partir da tabela, auto incremento (IDENTITY)
    private Long codigo;

    @NotNull   //javax.validation.constraint
    @Size (min = 3, max = 20)
    private String nome;

}
