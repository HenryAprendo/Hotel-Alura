package com.data.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.data.jdbc.modelo.Reserva;

public class ReservaDao {

	private Connection conexion;
	
	public ReservaDao(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Reserva reserva) {
		
		try{
			PreparedStatement statement = conexion.prepareStatement(
					"INSERT INTO RESERVAS (FechaEntrada, FechaSalida, Valor, FormaPago) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
			statement.setDate(1, reserva.getFechaEntrada());
			statement.setDate(2, reserva.getFechaSalida());
			statement.setInt(3, reserva.getValor());
			statement.setString(4, reserva.getFormaDePago());
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			while(resultSet.next()) {
				System.out.println(String.format("Fue insertada la reserva %s", reserva));
			}
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
				
	}
	
	
	
	
}

/**
 * 			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO PRODUCTO " + "(nombre, descripcion, cantidad, categoria_id)" + "VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
 */
