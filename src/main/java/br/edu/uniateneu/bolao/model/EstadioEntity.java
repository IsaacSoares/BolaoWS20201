package br.edu.uniateneu.bolao.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_estadio")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EstadioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cd_estadio")
	private Long id;
	@Column (name = "nm_estadio")
	private String nome;
	@Column (name = "nm_popular_estadio")
	private String nomePopular;
	@Column (name = "dt_inauguracao")
	private Date dataInauguracao;
	@Column (name = "nm_local")
	private String endereco;
	@Column (name= "nm_uf")
	private String uf;
	@Column (name = "vl_capacidade")
	private Long capacidade;
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
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
	public String getNomePopular() {
		return nomePopular;
	}
	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}
	public Date getDataInauguracao() {
		return dataInauguracao;
	}
	public void setDataInauguracao(Date dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}
	
	
	
}
