package com.data.jdbc.controller;

import java.util.List;

import com.data.jdbc.dao.ReservaDao;
import com.data.jdbc.factory.ConnectionFactory;
import com.data.jdbc.modelo.Reserva;

public class ReservaController {

	private ReservaDao reservaDao;
	
	public ReservaController() {
		this.reservaDao = new ReservaDao(new ConnectionFactory().recuperaConexion());
	}

	public void guardar(Reserva reserva) {
		this.reservaDao.guardar(reserva);
		
	}

	public List<Reserva> listar() {
		return this.reservaDao.listar();
	}
	
	
	
}
