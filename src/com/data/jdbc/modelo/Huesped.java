package com.data.jdbc.modelo;

import java.sql.Date;

public class Huesped {
	private Integer idHuesped;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private String idReserva;
	
	public Huesped(String nombre,String apellido,Date fechaNacimiento,String Nacionalidad, String telefono, String idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = Nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Huesped(int idHuesped, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, String idReserva) {
		this.idHuesped = idHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public Integer getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(Integer idHuesped) {
		this.idHuesped = idHuesped;
		
	}
	
}



















