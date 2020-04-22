package com.algaworks.algamoneyapi.repository;

import com.algaworks.algamoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

//A interface categoria repository extende a interface JpaRepository que já entrega vários métodos do CRUD prontos
//Ela é implementada pelo spring data Jpa que foi adicionado nas depêndencias
//Coloca-se onde vai se trabalhar com o Jpa repository que vai ser na classe categoria e onde se está o tipo da chave primária que é Long

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
