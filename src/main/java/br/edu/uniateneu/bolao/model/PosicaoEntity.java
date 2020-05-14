package br.edu.uniateneu.bolao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_posicao")
public class PosicaoEntity {
	@Column(name = "cd_posicao")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nm_posicao")
	private String nome;
	@Column(name = "nm_abreviacao")
	private String abreviacao;
	@Column(name = "cd_globo")
	private Long cdGlobo;
	
	public Long getCdGlobo() {
		return cdGlobo;
	}

	public void setCdGlobo(Long cdGlobo) {
		this.cdGlobo = cdGlobo;
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

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
}
