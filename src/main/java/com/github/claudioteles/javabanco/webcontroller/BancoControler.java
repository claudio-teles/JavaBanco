package com.github.claudioteles.javabanco.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

import com.github.claudioteles.javabanco.model.Pessoa;
import com.github.claudioteles.javabanco.service.ContaService;
import com.github.claudioteles.javabanco.service.PessoaService;

@Controller(value = "/")
@SessionScope
public class BancoControler {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ContaService cs;
	
	@GetMapping
	public String irParaIndex() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String listarPessoas(Model model) {
		model.addAttribute("pessoas", pessoaService.listarTodasPessoas());
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String cadastrarPessoa(Pessoa pessoa) {
		pessoaService.cadastrar(pessoa);
		return "redirect:/cadastro";
	}
	
	@GetMapping("/contas")
	public String listarContas(Model model) {
		model.addAttribute("contas", cs.listarContas());
		return "contas";
	}

}
