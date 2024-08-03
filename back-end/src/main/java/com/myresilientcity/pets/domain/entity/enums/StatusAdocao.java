package com.myresilientcity.pets.domain.entity.enums;

public enum StatusAdocao {
	DOADO(1, "Doado"),
	DISPONIVEL(2, "Disponivel");
	
	private int cod;
	private String descricao;
	
	private StatusAdocao(int cod, String descricao) {
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
	
	public static StatusAdocao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(StatusAdocao x: StatusAdocao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException( "Id invalido " + cod );
	}
	
	
	
}
