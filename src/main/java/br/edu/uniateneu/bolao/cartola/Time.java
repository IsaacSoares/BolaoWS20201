package br.edu.uniateneu.bolao.cartola;

import java.util.List;

import br.edu.uniateneu.bolao.model.TimeEntity;

public class Time {
	private Long id;
	private String nome;
	private String abreviacao;
	private Integer posicao;
	private List<String> escudos;
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
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public List<String> getEscudos() {
		return escudos;
	}
	public void setEscudos(List<String> escudos) {
		this.escudos = escudos;
	}

	public TimeEntity converteTime2TimeEntity() {
		TimeEntity timeEntity = new TimeEntity();
		timeEntity.setNome(this.nome);
		timeEntity.setSigla(this.abreviacao);
		//timeEntity.setEstadio(this);
		return timeEntity;
	}
}
