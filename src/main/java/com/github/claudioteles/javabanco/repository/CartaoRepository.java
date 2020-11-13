package com.github.claudioteles.javabanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.claudioteles.javabanco.model.CartaoCredito;

public interface CartaoRepository extends JpaRepository<CartaoCredito, Long> {

}
