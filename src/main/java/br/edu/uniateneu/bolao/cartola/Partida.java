package br.edu.uniateneu.bolao.cartola;

import br.edu.uniateneu.bolao.model.PartidaEntity;
import br.edu.uniateneu.bolao.util.StringUtil;

public class Partida {
	private Long id;
	private String data_realizacao;
	private String hora_realizacao;
	private Integer placar_oficial_visitante;
	private Integer placar_oficial_mandante;
	private Integer placar_penaltis_visitante;
	private Integer placar_penaltis_mandante;
    private Equipes equipes;
	private Estadio sede;
    private Transmissao transmissao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getData_realizacao() {
		return data_realizacao;
	}
	public void setData_realizacao(String data_realizacao) {
		this.data_realizacao = data_realizacao;
	}
	public String getHora_realizacao() {
		return hora_realizacao;
	}
	public void setHora_realizacao(String hora_realizacao) {
		this.hora_realizacao = hora_realizacao;
	}
	public Integer getPlacar_oficial_visitante() {
		return placar_oficial_visitante;
	}
	public void setPlacar_oficial_visitante(Integer placar_oficial_visitante) {
		this.placar_oficial_visitante = placar_oficial_visitante;
	}
	public Integer getPlacar_oficial_mandante() {
		return placar_oficial_mandante;
	}
	public void setPlacar_oficial_mandante(Integer placar_oficial_mandante) {
		this.placar_oficial_mandante = placar_oficial_mandante;
	}
	public Integer getPlacar_penaltis_visitante() {
		return placar_penaltis_visitante;
	}
	public void setPlacar_penaltis_visitante(Integer placar_penaltis_visitante) {
		this.placar_penaltis_visitante = placar_penaltis_visitante;
	}
	public Integer getPlacar_penaltis_mandante() {
		return placar_penaltis_mandante;
	}
	public void setPlacar_penaltis_mandante(Integer placar_penaltis_mandante) {
		this.placar_penaltis_mandante = placar_penaltis_mandante;
	}
	public Equipes getEquipes() {
		return equipes;
	}
	public void setEquipes(Equipes equipes) {
		this.equipes = equipes;
	}
	public Estadio getSede() {
		return sede;
	}
	public void setSede(Estadio sede) {
		this.sede = sede;
	}
	public Transmissao getTransmissao() {
		return transmissao;
	}
	public void setTransmissao(Transmissao transmissao) {
		this.transmissao = transmissao;
	}
	public PartidaEntity convertePartidaParaEntidade() {
		PartidaEntity entidade = new PartidaEntity();
		entidade.setPlacarMandante(this.placar_oficial_mandante);
		entidade.setPlacarVisitante(this.placar_oficial_visitante);
		entidade.setLocal(this.sede.getNome_popular());
		entidade.setData(StringUtil.converteStringToDate(this.data_realizacao));
		return entidade;
	}
    
}
