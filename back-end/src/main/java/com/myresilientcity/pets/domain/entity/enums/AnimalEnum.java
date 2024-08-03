package com.myresilientcity.pets.domain.entity.enums;

public enum AnimalEnum {

	CACHORRO(1, "Cachorro"),
	GATO(2, "Gato");
	
	private int cod;
	private String descricao;
	
	private AnimalEnum(int cod, String descricao) {
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
	
	public static AnimalEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(AnimalEnum x: AnimalEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException( "Id invalido " + cod );
	}
	
}
