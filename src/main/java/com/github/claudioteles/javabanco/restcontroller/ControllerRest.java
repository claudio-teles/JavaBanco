package com.github.claudioteles.javabanco.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.claudioteles.javabanco.model.ContaBancaria;
import com.github.claudioteles.javabanco.model.Pessoa;
import com.github.claudioteles.javabanco.service.ContaService;
import com.github.claudioteles.javabanco.service.PessoaService;

import io.swagger.annotations.ApiOperation;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerRest {
	
	@Autowired
	private PessoaService ps;
	@Autowired
	private ContaService cs;
	
	@GetMapping("/api/pessoas")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Lista todos os usuários cadastrados no HSQLDB")
	public List<Pessoa> listarApiPessoas() {
		return ps.listarTodasPessoas();
	}
	
	@GetMapping("/api/contas")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Lista todas as contas bancárias cadastradas no HSQLDB")
	public List<ContaBancaria> listarApiContas() {
		return cs.listarContas();
	}

}
