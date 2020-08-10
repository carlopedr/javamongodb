package com.pdv.mongodb.modelo;

import java.util.Date;

public class Producto {
	
	private int idProdcuto;

	private Date fecha;

	private String nomProducto;

	public Producto() {
	}

	public int getIdProdcuto() {
		return this.idProdcuto;
	}

	public void setIdProdcuto(int idProdcuto) {
		this.idProdcuto = idProdcuto;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNomProducto() {
		return this.nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

}