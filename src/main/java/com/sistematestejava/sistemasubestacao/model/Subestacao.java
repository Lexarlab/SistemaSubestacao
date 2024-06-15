package com.sistematestejava.sistemasubestacao.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_SUBESTACAO")
public class Subestacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SUBESTACAO")
	private Long id;
	
	@Size(min = 01, max = 03)
	@Column(name = "CODIGO", unique = true, nullable = false)
    private String codigo;
	
	@Size(min = 01, max = 100)
    @Column(name = "NOME")
    private String nome;
	
	@DecimalMin("-90.0")
	@DecimalMax("90.0")
	@NotNull
    @Column(name = "LATITUDE", nullable = false, precision = 15, scale = 13)
    private BigDecimal latitude;
	
	@DecimalMin("-180.0")
	@DecimalMax("180.0")
    @Column(name = "LONGITUDE", precision = 15, scale = 13)
    private BigDecimal longitude;
    
    @OneToMany(mappedBy = "subestacao" , cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("subestacao")
    private List<RedeMT> redesMT;

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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public List<RedeMT> getRedesMT() {
		return redesMT;
	}

	public void setRedesMT(List<RedeMT> redesMT) {
		this.redesMT = redesMT;
	}
	
}
