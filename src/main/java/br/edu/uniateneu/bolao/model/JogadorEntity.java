package br.edu.uniateneu.bolao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "tb_jogador")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class JogadorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cd_jogador")
	private Long id; 
	
	@Column(name="nm_jogador")
    private String nome;
	
	@Column(name="nm_apelido")
	private String apelido;
	
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="Titulares_Mandante_Partida",
			joinColumns={@JoinColumn(name="cd_partida")},
			inverseJoinColumns={@JoinColumn(name="cd_jogador")})
	private List<PartidaEntity> titularesMandante;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_posicao")
    private PosicaoEntity posicao;
	
	@Column(name="qt_idade")
    private int idade;
	
	@Column(name="qt_peso")
    private Double peso;
	
	@Column(name="nr_camisa")
    private int numeroCamisa;
	
	@Column(name="nr_altura")
    private double altura;
	
	@ManyToOne
    @JoinColumn(name="cd_time", nullable=false)
	@JsonBackReference
	private TimeEntity time;
	
	@ManyToMany(cascade =CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name="Reservas_Mandante_Partida",
			joinColumns={@JoinColumn(name="cd_partida")},
			inverseJoinColumns={@JoinColumn(name="cd_jogador")})
	private List<PartidaEntity> reservasMandante;
	@ManyToMany(cascade =CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name="Titulares_Visitante_Partida",
			joinColumns={@JoinColumn(name="cd_partida")},
			inverseJoinColumns={@JoinColumn(name="cd_jogador")})
	private List<PartidaEntity> titularesVisitante;
	@ManyToMany(cascade =CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name="Reservas_Visitante_Partida",
			joinColumns={@JoinColumn(name="cd_partida")},
			inverseJoinColumns={@JoinColumn(name="cd_jogador")})
	private List<PartidaEntity> reservasVisitante;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public List<PartidaEntity> getTitularesMandante() {
		return titularesMandante;
	}
	public void setTitularesMandante(List<PartidaEntity> titularesMandante) {
		this.titularesMandante = titularesMandante;
	}
	public PosicaoEntity getPosicao() {
		return posicao;
	}
	public void setPosicao(PosicaoEntity posicao) {
		this.posicao = posicao;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public int getNumeroCamisa() {
		return numeroCamisa;
	}
	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public TimeEntity getTime() {
		return time;
	}
	public void setTime(TimeEntity time) {
		this.time = time;
	}
	public List<PartidaEntity> getReservasMandante() {
		return reservasMandante;
	}
	public void setReservasMandante(List<PartidaEntity> reservasMandante) {
		this.reservasMandante = reservasMandante;
	}
	public List<PartidaEntity> getTitularesVisitante() {
		return titularesVisitante;
	}
	public void setTitularesVisitante(List<PartidaEntity> titularesVisitante) {
		this.titularesVisitante = titularesVisitante;
	}
	public List<PartidaEntity> getReservasVisitante() {
		return reservasVisitante;
	}
	public void setReservasVisitante(List<PartidaEntity> reservasVisitante) {
		this.reservasVisitante = reservasVisitante;
	}
	
	
}
