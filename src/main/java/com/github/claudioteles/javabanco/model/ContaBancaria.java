package com.github.claudioteles.javabanco.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3580677597071026162L;
	
	@Id
	@GeneratedValue(generator = "gerador_numero_conta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_numero_conta", sequenceName = "sequencia_conta", initialValue = 100000, allocationSize = 1)
	@Column(nullable = false)
	private BigInteger numero;
	@Column(length = 20, nullable = false)
	private String agencia;
	@Column(nullable = false)
	private char tipo;
	@Column(length = 20, nullable = false)
	private String vinculo;
	@OneToOne(targetEntity = Pessoa.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "conta_vinculada_a_pessoa"), nullable = false)
	private Pessoa pessoa;
	@OneToOne(targetEntity = ChequeEspecial.class, cascade=CascadeType.PERSIST)
	@JoinColumn(foreignKey = @ForeignKey(name = "conta_tem_cheque_especial"), nullable = true)
	private ChequeEspecial chequeEspecial;
	@OneToOne(targetEntity = CartaoCredito.class, cascade=CascadeType.PERSIST)
	@JoinColumn(foreignKey = @ForeignKey(name = "conta_tem_cartao_credito"), nullable = true)
	private CartaoCredito cartaoCredito;
	
	public ContaBancaria() {
		super();
	}

	public ContaBancaria(String agencia, char tipo, String vinculo, Pessoa pessoa) {
		super();
		this.agencia = agencia;
		this.tipo = tipo;
		this.vinculo = vinculo;
		this.pessoa = pessoa;
	}

	public BigInteger getNumero() {
		return numero;
	}

	public void setNumero(BigInteger numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ChequeEspecial getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(ChequeEspecial chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

}
