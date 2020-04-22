package com.algaworks.algamoneyapi.service;

import com.algaworks.algamoneyapi.model.Categoria;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria atualizar(Long codigo, Categoria categoria) {
        Categoria categoriaSalva = this.categoriaRepository.findById(codigo).get();
        BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
        return categoriaRepository.save(categoriaSalva);
    }
}
