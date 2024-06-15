package com.sistematestejava.sistemasubestacao.model;

import java.math.BigDecimal;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_REDE_MT")
public class RedeMT {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REDE_MT")
    private Long id;
	
	@NaturalId
	@Size(min = 01, max = 05)
	@Column(name = "CODIGO", unique = true, nullable = false)
    private String codigo;
	
	@Size(min = 01, max = 100)
	@Column(name = "NOME")
    private String nome;

	
    @Column(name = "TENSAO_NOMINAL", scale = 2, precision = 5)
    private BigDecimal tensaoNominal;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ID_SUBESTACAO",  nullable = false)
    private Subestacao subestacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTensaoNominal() {
		return tensaoNominal;
	}

	public void setTensaoNominal(BigDecimal tensaoNominal) {
		this.tensaoNominal = tensaoNominal;
	}

	public Subestacao getSubestacao() {
		return subestacao;
	}

	public void setSubestacao(Subestacao subestacao) {
		this.subestacao = subestacao;
	}
    
}
