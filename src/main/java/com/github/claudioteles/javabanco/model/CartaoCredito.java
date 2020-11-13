package com.github.claudioteles.javabanco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cartao_credito")
public class CartaoCredito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4907268354844324082L;
	
	@Id
	@GeneratedValue(generator = "gerador_limite_cartao", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_limite_cartao", sequenceName = "sequencia_limite_cartao", initialValue = 30, allocationSize = 1)
	@Column(name = "id_cartao", nullable = false)
	private Long idCartao;
	@Column(name = "limite_cartao", nullable = false)
	private short limiteCartaoCredito;
	
	public CartaoCredito() {
		super();
	}

	public CartaoCredito(short limiteCartaoCredito) {
		super();
		this.limiteCartaoCredito = limiteCartaoCredito;
	}

	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public short getLimiteCartaoCredito() {
		return limiteCartaoCredito;
	}

	public void setLimiteCartaoCredito(short limiteCartaoCredito) {
		this.limiteCartaoCredito = limiteCartaoCredito;
	}

}
