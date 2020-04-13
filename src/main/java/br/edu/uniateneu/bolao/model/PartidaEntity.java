package br.edu.uniateneu.bolao.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_partida") 
public class PartidaEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="cd_partida")
public long id;
@Column(name="dt_partida")
private Date data;
@Column(name="nm_local")
private String local;
@Column(name="pl_mandante")
private Integer placarMandante;
@Column(name="pl_visitante")
private Integer placarVisitante;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cd_visitante")
private TimeEntity visitante;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cd_mandante")
private TimeEntity mandante;

public long getId() {
	return id;
}
public void setId(long id) {
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
