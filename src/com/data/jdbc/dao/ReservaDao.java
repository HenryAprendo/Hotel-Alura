package com.data.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.jdbc.factory.ConnectionFactory;
import com.data.jdbc.modelo.Reserva;

public class ReservaDao {

	private Connection conexion;
	
	public ReservaDao(Connection conexion) {
		this.conexion = conexion;
	}

	public void guardar(Reserva reserva) {
		
		String sqlSelector = "INSERT INTO RESERVAS (id_reserva, fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?,?,?,?,?)";
		
		try(PreparedStatement statement = conexion.prepareStatement(sqlSelector, Statement.RETURN_GENERATED_KEYS)){
			
			statement.setString(1, reserva.getidReserva());
			statement.setDate(2, reserva.getFechaEntrada());
			statement.setDate(3, reserva.getFechaSalida());
			statement.setInt(4, reserva.getValor());
			statement.setString(5, reserva.getFormaDePago());
			statement.execute();
			
			try(ResultSet resultSet = statement.getGeneratedKeys()){			
				while(resultSet.next()) {
					System.out.println(String.format("Fue insertada la reserva %s", reserva));
				}
			}
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
				
	}

	public List<Reserva> listar() {
		List<Reserva> resultado = new ArrayList<>();
		
		Connection conexion = new ConnectionFactory().recuperaConexion();
		String sql = "SELECT id_reserva, fecha_entrada, fecha_salida, valor, forma_pago FROM RESERVAS";
		
		try(PreparedStatement statement = conexion.prepareStatement(sql)){
			
			statement.execute();
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				Reserva fila = new Reserva(resultSet.getString("id_reserva"), resultSet.getDate("fecha_entrada"), 
						resultSet.getDate("fecha_salida"), resultSet.getInt("valor"), resultSet.getString("forma_pago"));
				resultado.add(fila);
			}
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		
		return resultado;
	}
	

	
	
}

/**
 * 			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO PRODUCTO " + "(nombre, descripcion, cantidad, categoria_id)" + "VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
 */
