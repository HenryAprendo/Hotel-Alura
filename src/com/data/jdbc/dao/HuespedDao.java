package com.data.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.jdbc.factory.ConnectionFactory;
import com.data.jdbc.modelo.Huesped;

public class HuespedDao {

	private Connection conexion;

	public HuespedDao(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Huesped huesped) {

		try {

			PreparedStatement statement = conexion.prepareStatement(
					"INSERT INTO HUESPEDES (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva) VALUES (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, huesped.getFechaNacimiento());
			statement.setString(4, huesped.getNacionalidad());
			statement.setString(5, huesped.getTelefono());
			statement.setString(6, huesped.getIdReserva());
			statement.execute();

			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				huesped.setIdHuesped(resultSet.getInt(1));
				System.out.println(String.format("Fue insertado el huesped %s ", huesped.getNombre()));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huesped> listar() {

		List<Huesped> resultado = new ArrayList<>();

		Connection conexion = new ConnectionFactory().recuperaConexion();
		String sql = "SELECT id_huesped, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM HUESPEDES";

		try (PreparedStatement statement = conexion.prepareStatement(sql);) {

			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				Huesped fila = new Huesped(resultSet.getInt("id_huesped"), resultSet.getString("nombre"),
						resultSet.getString("apellido"), resultSet.getDate("fecha_nacimiento"),
						resultSet.getString("nacionalidad"), resultSet.getString("telefono"),
						resultSet.getString("id_reserva"));

				resultado.add(fila);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

}
