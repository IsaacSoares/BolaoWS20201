package br.edu.uniateneu.bolao.cartola;

public class Equipe {
	private Long id;
	private String sigla;
	private String escudo;
	private String nome_popular;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_popular() {
		return nome_popular;
	}
	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEscudo() {
		return escudo;
	}
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}


}
