package br.edu.uniateneu.bolao.cartola;

import br.edu.uniateneu.bolao.model.TimeEntity;

public class Time {
	private Long id;
	private String nome;
	private String abreviacao;
	private Integer posicao;
	private Escudo escudos;
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
	public Escudo getEscudos() {
		return escudos;
	}
	public void setEscudos(Escudo escudos) {
		this.escudos = escudos;
	}

	public TimeEntity converteTimeParaEntidade() {
		TimeEntity timeEntity = new TimeEntity();
		timeEntity.setNome(this.nome);
		timeEntity.setSigla(this.abreviacao);
		timeEntity.setEscudo(this.escudos.getTrintaPorTrinta());
		timeEntity.setIdGlobo(this.id);
		//timeEntity.setEstadio(this);
		return timeEntity;
	}
}
