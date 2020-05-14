package br.edu.uniateneu.bolao.cartola;

import br.edu.uniateneu.bolao.model.JogadorEntity;

public class Jogador {
	private String nome;
	private String slug; 
	private String apelido;
	private String foto;
	private Long atleta_id;
	private Long rodada_id;
	private Long clube_id;
	private Long posicao_id;
	private Long status_id;
	private Double pontos_num;
	private Double preco_num;
	private Double variacao_num;
	private Double media_num;
	private Double jogos_num;
	private Scout scout;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Long getAtleta_id() {
		return atleta_id;
	}
	public void setAtleta_id(Long atleta_id) {
		this.atleta_id = atleta_id;
	}
	public Long getRodada_id() {
		return rodada_id;
	}
	public void setRodada_id(Long rodada_id) {
		this.rodada_id = rodada_id;
	}
	public Long getClube_id() {
		return clube_id;
	}
	public void setClube_id(Long clube_id) {
		this.clube_id = clube_id;
	}
	public Long getPosicao() {
		return posicao_id;
	}
	public void setPosicao(Long posicao) {
		this.posicao_id = posicao;
	}
	public Long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}
	public Double getPontos_num() {
		return pontos_num;
	}
	public void setPontos_num(Double pontos_num) {
		this.pontos_num = pontos_num;
	}
	public Double getPreco_num() {
		return preco_num;
	}
	public void setPreco_num(Double preco_num) {
		this.preco_num = preco_num;
	}
	public Double getVariacao_num() {
		return variacao_num;
	}
	public void setVariacao_num(Double variacao_num) {
		this.variacao_num = variacao_num;
	}
	public Double getMedia_num() {
		return media_num;
	}
	public void setMedia_num(Double media_num) {
		this.media_num = media_num;
	}
	public Double getJogos_num() {
		return jogos_num;
	}
	public void setJogos_num(Double jogos_num) {
		this.jogos_num = jogos_num;
	}
	public Scout getScout() {
		return scout;
	}
	public void setScout(Scout scout) {
		this.scout = scout;
	}
	
	public JogadorEntity converteJogadorParaEntidade() {
		JogadorEntity jogador = new JogadorEntity();
		jogador.setNome(this.nome);
		jogador.setApelido(this.apelido);
		//jogador.setTime(TimeEntity);
		return jogador;
	}
}
