package com.data.jdbc.controller;
import java.util.List;

import com.data.jdbc.dao.HuespedDao;
import com.data.jdbc.factory.ConnectionFactory;
import com.data.jdbc.modelo.Huesped;

public class HuespedController {

	private HuespedDao huespedDao;
	
	public HuespedController() {
		ConnectionFactory factory = new ConnectionFactory();
		huespedDao = new HuespedDao(factory.recuperaConexion());
	}
	
	public void guardar(Huesped huesped) {
		this.huespedDao.guardar(huesped);
	}

	public List<Huesped> listar() {
		return this.huespedDao.listar();
	}
	
}
