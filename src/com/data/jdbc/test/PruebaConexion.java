package com.data.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import com.data.jdbc.factory.ConnectionFactory;
import java.util.*;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexion = factory.recuperaConexion();
		
		System.out.println("Cerrando la conexión");
		
		conexion.close();		
		
	}
	
}
