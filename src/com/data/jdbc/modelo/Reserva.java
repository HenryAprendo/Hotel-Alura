package com.data.jdbc.modelo;

import java.sql.Date;

public class Reserva {

	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;	
	private String formaDePago;
	private Integer valor;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, String formaDePago, Integer valor) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.formaDePago = formaDePago;
		this.valor = valor;
	}
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public String getFormaDePago() {
		return formaDePago;
	}
	public Integer getValor() {
		return valor;
	}
	
	
}
