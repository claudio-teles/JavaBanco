package com.github.claudioteles.javabanco.service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.claudioteles.javabanco.model.CartaoCredito;
import com.github.claudioteles.javabanco.model.ChequeEspecial;
import com.github.claudioteles.javabanco.model.ContaBancaria;
import com.github.claudioteles.javabanco.model.Pessoa;
import com.github.claudioteles.javabanco.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ChequeService cs;
	@Autowired
	private CartaoService cartSer;
	
	@Autowired
	private ContaService contaService;
	
	public void cadastrar(Pessoa pessoa) {
		byte numeroAleatorio = (byte) new Random().nextInt(9);
		pessoa.setScore(numeroAleatorio);
		pessoaRepository.save(pessoa);
		pessoaRepository.flush();
		
		int ag = new Random().nextInt(89999) + 10000;
		int vin = new Random().nextInt(2);
		String agencia = String.valueOf(ag);
		char tipo = pessoa.getTipo().equals("PF") ? 'C' : 'E';
		String vinculo = vin == 1 ? "Com Vínculo" : "Sem Vínculo";
		ContaBancaria cb = new ContaBancaria(agencia, tipo, vinculo, pessoa);
		
		
		ChequeEspecial ce = new ChequeEspecial();
		cs.criarCheque(pessoa, ce);
		CartaoCredito cc = new CartaoCredito();
		cartSer.criarCartao(pessoa, cc);
		
		cb.setChequeEspecial(ce);
		cb.setCartaoCredito(cc);
		
		contaService.salvarConta(cb);
	}
	
	public List<Pessoa> listarTodasPessoas() {
		return pessoaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

}
