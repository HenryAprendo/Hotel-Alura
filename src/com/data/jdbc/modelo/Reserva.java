package com.data.jdbc.modelo;

import java.sql.Date;
import java.util.UUID;

public class Reserva {

	private Date fechaEntrada;
	private Date fechaSalida;	
	private String formaDePago;
	private Integer valor;
	private String idReserva;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, String formaDePago, Integer valor) {
		this.idReserva = getReservaId();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.formaDePago = formaDePago;
		this.valor = valor;
	}
	
	public Reserva(String idReserva, Date fecha_entrada, Date fecha_salida, int valor, String forma_pago) {
		this.idReserva = idReserva;
		this.fechaEntrada = fecha_entrada;
		this.fechaSalida = fecha_salida;
		this.valor = valor;
		this.formaDePago = forma_pago;
	}

	private String getReservaId() {
		UUID uuid= UUID.randomUUID();		
		return uuid.toString();
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
	public String getidReserva() {
		return this.idReserva;
	}
	
}
