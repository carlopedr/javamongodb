package com.pdv.mongodb.modelo;

public class Cliente {
	
	private int id;
	private String nomcliente;
	private String emailcliente;
	public Cliente() {
	}

		public Cliente(int id, String nomcliente, String emailcliente) {
		super();
		this.id = id;
		this.nomcliente = nomcliente;
		this.emailcliente = emailcliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailcliente() {
		return this.emailcliente;
	}

	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}

	public String getNomcliente() {
		return this.nomcliente;
	}

	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", emailcliente=" + emailcliente + ", nomcliente=" + nomcliente
				+ "]";
	}
	

}