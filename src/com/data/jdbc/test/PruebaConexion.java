package com.data.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.data.jdbc.factory.ConnectionFactory;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexion = factory.recuperaConexion();
		
		System.out.println("Cerrando la conexión");
		
		conexion.close();
	}
	
}
