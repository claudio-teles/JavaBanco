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
@Table(name = "cheque_especial")
public class ChequeEspecial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5885819438240159040L;
	
	@Id
	@GeneratedValue(generator = "gerador_limite_cheque", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_limite_cheque", sequenceName = "sequencia_limite_cheque", initialValue = 30, allocationSize = 1)
	@Column(name = "id_cheque", nullable = false)
	private Long idCheque;
	@Column(name = "limite_cheque", nullable = false)
	private short limiteCheque;
	
	public ChequeEspecial() {
		super();
	}

	public ChequeEspecial(short limiteCheque) {
		super();
		this.limiteCheque = limiteCheque;
	}

	public Long getIdCheque() {
		return idCheque;
	}

	public void setIdCheque(Long idCheque) {
		this.idCheque = idCheque;
	}

	public short getLimiteCheque() {
		return limiteCheque;
	}

	public void setLimiteCheque(short limiteCheque) {
		this.limiteCheque = limiteCheque;
	}

}
