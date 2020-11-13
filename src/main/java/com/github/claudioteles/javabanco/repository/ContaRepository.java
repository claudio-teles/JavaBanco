package com.github.claudioteles.javabanco.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.claudioteles.javabanco.model.ContaBancaria;
import com.github.claudioteles.javabanco.model.Pessoa;

public interface ContaRepository extends JpaRepository<ContaBancaria, BigInteger> {
	
	Optional<ContaBancaria> findByPessoa(Pessoa pessoa);

}
