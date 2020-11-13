package com.github.claudioteles.javabanco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.claudioteles.javabanco.model.ChequeEspecial;
import com.github.claudioteles.javabanco.model.Pessoa;
import com.github.claudioteles.javabanco.repository.ChequeRepository;

@Service
@Transactional
public class ChequeService {
	
	@Autowired
	private ChequeRepository chequeRepository;
	
	public void criarCheque(Pessoa pessoa, ChequeEspecial chequeEspecial) {
		if (pessoa.getScore() != 0 || pessoa.getScore() != 1) {
			if (pessoa.getScore() >= 2 && pessoa.getScore() <= 5) {
				chequeEspecial.setLimiteCheque((short) 1000);
				chequeRepository.save(chequeEspecial);
			}
			if (pessoa.getScore() >= 6 && pessoa.getScore() <= 8) {
				chequeEspecial.setLimiteCheque((short) 2000);
				chequeRepository.save(chequeEspecial);
			}
			if (pessoa.getScore() == 9) {
				chequeEspecial.setLimiteCheque((short) 5000);
				chequeRepository.save(chequeEspecial);
			}
		}
	}
	
	public List<ChequeEspecial> listarCheque() {
		return chequeRepository.findAll(Sort.by(Sort.Direction.ASC, "idCheque"));
	}

}
