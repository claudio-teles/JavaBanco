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
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5008629968411070941L;
	
	@Id
	@GeneratedValue(generator = "gerador_id_pessoa", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_id_pessoa", sequenceName = "sequencia_pessoa", initialValue = 30, allocationSize = 1)
	@Column(nullable = false)
	private Long id;
	@Column(length = 25, nullable = false)
	private String nome;
	@Column(length = 2, nullable = false)
	private String tipo;
	@Column(name = "numero_de_documento", length = 14, nullable = false)
	private String numeroDeDocumento;
	@Column(nullable = false)
	private byte score;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String tipo, String numeroDeDocumento, byte score) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.numeroDeDocumento = numeroDeDocumento;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	public void setNumeroDeDocumento(String numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	public byte getScore() {
		return score;
	}

	public void setScore(byte score) {
		this.score = score;
	}

}
