package br.edu.uniateneu.bolao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gol")
public class GolEntity {
	@Id
	@Column(name = "cd_gol")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JoinColumn(name = "cd_jogador")
	@OneToOne(cascade = CascadeType.ALL)
	private JogadorEntity jogador;
	@JoinColumn(name = "cd_assistente")
	@OneToOne(cascade = CascadeType.ALL)
	private JogadorEntity assistente;
	@Column(name = "qt_minutos")
	private Integer minutos;
	@Column(name = "is_contra")
	private Boolean golContra;
	@ManyToOne
	@JoinColumn(name = "cd_partida", nullable = false)
	private PartidaEntity partida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JogadorEntity getJogador() {
		return jogador;
	}

	public void setJogador(JogadorEntity jogador) {
		this.jogador = jogador;
	}

	public JogadorEntity getAssistente() {
		return assistente;
	}

	public void setAssistente(JogadorEntity assistente) {
		this.assistente = assistente;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public Boolean isGolContra() {
		return golContra;
	}

	public void setGolContra(Boolean golContra) {
		this.golContra = golContra;
	}

	public PartidaEntity getPartida() {
		return partida;
	}

	public void setPartida(PartidaEntity partida) {
		this.partida = partida;
	}

}
