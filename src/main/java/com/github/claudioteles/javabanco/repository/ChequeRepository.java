package com.github.claudioteles.javabanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.claudioteles.javabanco.model.ChequeEspecial;

public interface ChequeRepository extends JpaRepository<ChequeEspecial, Long> {

}
