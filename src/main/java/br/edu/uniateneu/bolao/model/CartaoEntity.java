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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_cartao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CartaoEntity {
@Id
@Column(name="cd_cartao")
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "cd_jogador")
private JogadorEntity jogador;

@Column(name = "qt_minutos")
private Integer minutos;

@Column(name = "tp_cartao")
private String tipo;

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

public Integer getMinutos() {
	return minutos;
}

public void setMinutos(Integer minutos) {
	this.minutos = minutos;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public PartidaEntity getPartida() {
	return partida;
}

public void setPartida(PartidaEntity partida) {
	this.partida = partida;
}

}
