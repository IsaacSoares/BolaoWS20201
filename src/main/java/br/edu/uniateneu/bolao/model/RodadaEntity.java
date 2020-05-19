package br.edu.uniateneu.bolao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rodada")
public class RodadaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_rodada")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nm_rodada")
	private Integer numero;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	/*
	 * @OneToMany(mappedBy = "rodada",cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<PartidaEntity> partidas;
	 * 
	 * public List<PartidaEntity> getPartidas() { return partidas; }
	 * 
	 * public void setPartidas(List<PartidaEntity> partidas) { this.partidas =
	 * partidas; }
	 */
}
