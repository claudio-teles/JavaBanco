package com.github.claudioteles.javabanco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.claudioteles.javabanco.model.ContaBancaria;
import com.github.claudioteles.javabanco.repository.ContaRepository;

@Service
@Transactional
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public void salvarConta(ContaBancaria contaBancaria) {
		contaRepository.save(contaBancaria);
	}
	
	public List<ContaBancaria> listarContas() {
		return contaRepository.findAll(Sort.by(Sort.Direction.ASC, "numero"));
	}

}
