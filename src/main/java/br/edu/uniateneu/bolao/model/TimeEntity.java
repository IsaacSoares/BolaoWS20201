package br.edu.uniateneu.bolao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_time")
public class TimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cd_time")
	private Long id;
	@Column(name="nm_time")
	private String nome;
	@Column(name="nm_estado")
	private String estado;
	@Column(name="nm_escudo")
	private String escudo;
	@Column(name="nm_estadio")
	private String estadio;
	@Column(name="nm_sigla")
	private String sigla;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEscudo() {
		return escudo;
	}
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
