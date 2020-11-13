package com.github.claudioteles.javabanco;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.claudioteles.javabanco.model.CartaoCredito;
import com.github.claudioteles.javabanco.model.ChequeEspecial;
import com.github.claudioteles.javabanco.model.ContaBancaria;
import com.github.claudioteles.javabanco.model.Pessoa;
import com.github.claudioteles.javabanco.restcontroller.ControllerRest;
import com.github.claudioteles.javabanco.service.CartaoService;
import com.github.claudioteles.javabanco.service.ChequeService;
import com.github.claudioteles.javabanco.service.ContaService;
import com.github.claudioteles.javabanco.service.PessoaService;

@SpringBootTest
class JavaBancoApplicationTests {
	
	@Autowired
	private ControllerRest contRest;
	@Autowired
	private PessoaService ps;
	@Autowired
	private ChequeService chs;
	@Autowired
	private CartaoService cartS;
	@Autowired
	private ContaService cs;

	@Test
	void contextLoads() {
		assertThat(contRest).isNotNull();
	}
	
	@Test
	void testeCadastrarPessoa() {
		Pessoa p1 = new Pessoa("P1", "PF", "00000000001", (byte) 0);
		ps.cadastrar(p1);
		
		ChequeEspecial ce1 = new ChequeEspecial((short) 0);
		chs.criarCheque(p1, ce1);
		CartaoCredito cc1 = new CartaoCredito((short) 0);
		cartS.criarCartao(p1, cc1);
		
		ContaBancaria cb1 = new ContaBancaria("1000000", 'C', "Com Vínculo", p1);
		cs.salvarConta(cb1);
		
		// -----------------------------------------------------------------------------
		
		Pessoa p2 = new Pessoa("P2", "PJ", "00000000000001", (byte) 3);
		ps.cadastrar(p2);
		
		ChequeEspecial ce2 = new ChequeEspecial((short) 1000);
		chs.criarCheque(p2, ce2);
		CartaoCredito cc2 = new CartaoCredito((short) 200);
		cartS.criarCartao(p2, cc2);
		
		ContaBancaria cb2 = new ContaBancaria("1000001", 'E', "Sem Vínculo", p2);
		cs.salvarConta(cb2);
		
		// ------------------------------------------------------------------------------
		
		Pessoa p3 = new Pessoa("P3", "PF", "00000000002", (byte) 7);
		ps.cadastrar(p3);
		
		ChequeEspecial ce3 = new ChequeEspecial((short) 2000);
		chs.criarCheque(p3, ce3);
		CartaoCredito cc3 = new CartaoCredito((short) 2000);
		cartS.criarCartao(p3, cc3);
		
		ContaBancaria cb3 = new ContaBancaria("1000000", 'C', "Com Vínculo", p3);
		cs.salvarConta(cb3);
		
		int quantidadeDeContas = cs.listarContas().size();
		assertThat(quantidadeDeContas == 3);
	}
	
	@Test
	void testarQuantidadePessoasSalvas() {
		int quantidadeDePessoas = ps.listarTodasPessoas().size();
		assertThat(quantidadeDePessoas == 3);
	}

}
