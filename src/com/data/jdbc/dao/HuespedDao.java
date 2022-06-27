package com.data.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.data.jdbc.modelo.Huesped;

public class HuespedDao {

	private Connection conexion;

	public HuespedDao(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Huesped huesped) {
		
		try {
				
			PreparedStatement statement = conexion.prepareStatement(
					"INSERT INTO HUESPEDES (Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono) VALUES (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, huesped.getFechaNacimiento());
			statement.setString(4, huesped.getNacionalidad());
			statement.setString(5, huesped.getTelefono());
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			while(resultSet.next()) {
				System.out.println(String.format("Fue insertado el huesped %s ", huesped.getNombre()));
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}












