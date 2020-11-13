package com.github.claudioteles.javabanco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.claudioteles.javabanco.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	public Optional<Pessoa> findByNome(String nome);

}
