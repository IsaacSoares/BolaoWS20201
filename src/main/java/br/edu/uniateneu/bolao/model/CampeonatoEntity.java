package br.edu.uniateneu.bolao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_competicao")
public class CampeonatoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_competicao")
	private Long id;
	@Column(name = "nm_competicao")
	private String nome;
	@Column(name = "nr_ano")
	private int ano;

	@Column(name = "tp_competicao", nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumTipoCompeticao tipoCompeticao;

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

	public EnumTipoCompeticao getTipoCompeticao() {
		return tipoCompeticao;
	}

	public void setTipoCompeticao(EnumTipoCompeticao tipoCompeticao) {
		this.tipoCompeticao = tipoCompeticao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
