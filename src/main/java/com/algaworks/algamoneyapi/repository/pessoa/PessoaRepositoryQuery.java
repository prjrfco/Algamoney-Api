package com.algaworks.algamoneyapi.repository.pessoa;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.filter.PessoaFilter;

import java.util.List;

public interface PessoaRepositoryQuery  {

    public List<Pessoa> filtrar(PessoaFilter pessoaFilter);

}
