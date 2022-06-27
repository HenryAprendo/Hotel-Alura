package com.data.jdbc.modelo;

import java.sql.Date;

public class Huesped {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String Nacionalidad;
	private String telefono;
	
	public Huesped(String nombre,String apellido,Date fechaNacimiento,String Nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.Nacionalidad = Nacionalidad;
		this.telefono = telefono;
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
		return Nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}
	
	
	
}



















