package com.algaworks.algamoneyapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
@Data

public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String descricao;

    @NotNull
    @Column(name = "data_vencimento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPagamento;

    @NotNull
    private BigDecimal valor;

    private String observacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

}
