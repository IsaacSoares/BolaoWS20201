package br.edu.uniateneu.bolao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_partida")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class PartidaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_partida")
	public Long id;
	@Column(name = "dt_partida")
	private Date data;
	@Column(name = "nm_local")
	private String local;
	@Column(name = "pl_mandante")
	private Integer placarMandante;
	@Column(name = "pl_visitante")
	private Integer placarVisitante;
	@Column(name = "vl_renda")
	private Double renda;
	@Column(name = "nm_publico")
	private Long publico;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_visitante")
	private TimeEntity visitante;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_mandante")
	private TimeEntity mandante;

	@ManyToMany(mappedBy = "titularesMandante", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JogadorEntity> titularesMandante;

	@ManyToMany(mappedBy = "reservasMandante", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JogadorEntity> reservasMandante;

	@ManyToMany(mappedBy = "titularesVisitante", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JogadorEntity> titularesVisitante;

	@ManyToMany(mappedBy = "reservasVisitante", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JogadorEntity> reservasVisitante;

	@OneToMany(mappedBy = "partida")
	@JsonManagedReference
	private List<GolEntity> gols;

	@OneToMany(mappedBy = "partida")
	@JsonManagedReference
	private List<CartaoEntity> cartoes;

	@ManyToOne
	@JoinColumn(name = "cd_rodada")
	@JsonIgnore
	private RodadaEntity rodada;

	public List<GolEntity> getGols() {
		return gols;
	}

	public void setGols(List<GolEntity> gols) {
		this.gols = gols;
	}

	public List<CartaoEntity> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoEntity> cartoes) {
		this.cartoes = cartoes;
	}

	public RodadaEntity getRodada() {
		return rodada;
	}

	public void setRodada(RodadaEntity rodada) {
		this.rodada = rodada;
	}

	public TimeEntity getVisitante() {
		return visitante;
	}

	public void setVisitante(TimeEntity visitante) {
		this.visitante = visitante;
	}

	public TimeEntity getMandante() {
		return mandante;
	}

	public void setMandante(TimeEntity mandante) {
		this.mandante = mandante;
	}

	public List<JogadorEntity> getTitularesMandante() {
		return titularesMandante;
	}

	public void setTitularesMandante(List<JogadorEntity> titularesMandante) {
		this.titularesMandante = titularesMandante;
	}

	public List<JogadorEntity> getReservasMandante() {
		return reservasMandante;
	}

	public void setReservasMandante(List<JogadorEntity> reservasMandante) {
		this.reservasMandante = reservasMandante;
	}

	public List<JogadorEntity> getTitularesVisitante() {
		return titularesVisitante;
	}

	public void setTitularesVisitante(List<JogadorEntity> titularesVisitante) {
		this.titularesVisitante = titularesVisitante;
	}

	public List<JogadorEntity> getReservasVisitante() {
		return reservasVisitante;
	}

	public void setReservasVisitante(List<JogadorEntity> reservasVisitante) {
		this.reservasVisitante = reservasVisitante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getPlacarMandante() {
		return placarMandante;
	}

	public void setPlacarMandante(Integer placarMandante) {
		this.placarMandante = placarMandante;
	}

	public Integer getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(Integer placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Long getPublico() {
		return publico;
	}

	public void setPublico(Long publico) {
		this.publico = publico;
	}

}
