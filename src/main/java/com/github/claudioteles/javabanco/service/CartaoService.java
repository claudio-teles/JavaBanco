package com.github.claudioteles.javabanco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.claudioteles.javabanco.model.CartaoCredito;
import com.github.claudioteles.javabanco.model.Pessoa;
import com.github.claudioteles.javabanco.repository.CartaoRepository;

@Service
@Transactional
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	public void criarCartao(Pessoa pessoa, CartaoCredito cartaoCredito) {
		if (pessoa.getScore() != 0 || pessoa.getScore() != 1) {
			if (pessoa.getScore() >= 2 && pessoa.getScore() <= 5) {
				cartaoCredito.setLimiteCartaoCredito((short)200);
				cartaoRepository.save(cartaoCredito);
			}
			if (pessoa.getScore() >= 6 && pessoa.getScore() <= 8) {
				cartaoCredito.setLimiteCartaoCredito((short)2000);
				cartaoRepository.save(cartaoCredito);
			}
			if (pessoa.getScore() == 9) {
				cartaoCredito.setLimiteCartaoCredito((short)15000);
				cartaoRepository.save(cartaoCredito);
			}
		}
	}
	
	public List<CartaoCredito> listarCartoes() {
		return cartaoRepository.findAll(Sort.by(Sort.Direction.ASC, "idCartao"));
	}

}
