package com.pdv.mongodb.modelo;

public class Articulo {
	
	private int idarticulo;
	private String nombrearticulo;

	public Articulo() {
	}

	public int getIdarticulo() {
		return this.idarticulo;
	}

	public void setIdarticulo(int idarticulo) {
		this.idarticulo = idarticulo;
	}

	public String getNombrearticulo() {
		return nombrearticulo;
	}

	public void setNombrearticulo(String nombrearticulo) {
		this.nombrearticulo = nombrearticulo;
	}


}