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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_partida")
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

}
