package com.myresilientcity.pets.domain.entity.enums;

public enum TipoUsuario {

	DOADOR_CNPJ(1, "Doador CNPJ"),
	DOADOR_CPF(2, "Doador CPF"),
	DONATARIO(3, "Donatario"),
	INTERESSADO(4, "Interessado");
	
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoUsuario x: TipoUsuario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException( "Id invalido " + cod );
	}
	
}
