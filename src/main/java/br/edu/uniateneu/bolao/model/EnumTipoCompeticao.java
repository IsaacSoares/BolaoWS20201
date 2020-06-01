package br.edu.uniateneu.bolao.model;

public enum EnumTipoCompeticao {
	ESTADUAL("E"), REGIONAL("R"), NACIONAL("N"), CONTINENTAL("C"), MUNDIAL("M");

	private String valor;  

	private EnumTipoCompeticao(String valor) {  
		this.valor = valor;  
	}  

	public String toString() {
		return valor;
	}

}
