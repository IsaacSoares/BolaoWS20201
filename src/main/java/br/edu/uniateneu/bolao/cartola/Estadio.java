package br.edu.uniateneu.bolao.cartola;

import br.edu.uniateneu.bolao.model.EstadioEntity;

public class Estadio {
	private String nome;
    private String local;
    private String uf;
    private Long capacidade;
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}

	public Estadio() {
		// TODO Auto-generated constructor stub
	}
	private String nome_popular;

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}
	
	public EstadioEntity converteEstadioParaEntidade() {
		EstadioEntity estadio = new EstadioEntity();
		estadio.setNome(this.nome);
		estadio.setNomePopular(this.nome_popular);
		estadio.setEndereco(this.local);
		estadio.setUf(this.uf);
		estadio.setCapacidade(this.capacidade);
		return estadio;
	}
	
}
