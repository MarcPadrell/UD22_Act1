package com.uda22.TA22Act1.Cliente.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ClienteDAO {

	private static String db = "clientes";
	private static String table_name = "cliente";

	// METODO QUE INSERTA DATOS DE LOS CLIENTES EN LAS TABLAS MYSQL
	public static void createClient(Cliente client) {
		
		MySQLConnection connection = new MySQLConnection();
		
		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = connection.getConexion().createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) Values ('"
					+ client.getNombre() + "','" + client.getApellido() + "','" + client.getDireccion() + "','"
					+ client.getDni() + "','" + client.getFecha() + "');";
			Statement st = connection.getConexion().createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");
			;
			JOptionPane.showMessageDialog(null, "Data inserted!!", "Done", JOptionPane.INFORMATION_MESSAGE);
			
			connection.disconnect();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}

	}

	// METODO QUE OBTIENE LOS VALORES DE LOCS CLIENTES DE MYSQL
	public static Cliente researchClient(int id) {

		Cliente client = new Cliente();
		boolean exists = false;
		
		MySQLConnection connection = new MySQLConnection();

		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = connection.getConexion().createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name + " WHERE id = \"" + id + "\"";
			Statement st = connection.getConexion().createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				exists = true;
				client.setId(Integer.parseInt(resultSet.getString("id")));
				client.setNombre(resultSet.getString("nombre"));
				client.setApellido(resultSet.getString("apellido"));
				client.setDireccion(resultSet.getString("direccion"));
				client.setDni(resultSet.getString("dni"));
				client.setFecha(resultSet.getString("fecha"));

				JOptionPane.showMessageDialog(null, "Client Found!!", "Done", JOptionPane.INFORMATION_MESSAGE);

				/*
				 * System.out.println(""); System.out.println("Identificador: " +
				 * resultSet.getString("id") + " " + "Nombre: " + resultSet.getString("nombre")
				 * + " " + "Apellido:" + resultSet.getString("apellido") + " " + "Dirección: " +
				 * resultSet.getString("direccion") + "DNI: " + resultSet.getString("dni") +
				 * "Fecha: " + resultSet.getString("fecha"));
				 */
			}
			connection.disconnect();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}

		if (exists) {
			return client;
		} else {
			return null;
		}

	}

	// METODO QUE OBTIENE LOS VALORES DE LOCS CLIENTES DE MYSQL
	public static void updateClient(Cliente client) {
		
		MySQLConnection connection = new MySQLConnection();

		try {
			//String Querydb = "USE " + db + ";";
			String query = "UPDATE Client SET nombre = ?, apellido = ? , direccion = ? , dni = ? , fecha = ? WHERE id= ? ";
			PreparedStatement pstdb = connection.getConexion().prepareStatement(query);
			
			pstdb.setString(1, client.getNombre());
			pstdb.setString(2, client.getApellido());
			pstdb.setString(3, client.getDireccion());
			pstdb.setString(4, client.getDni());
			pstdb.setString(5, client.getFecha());
			pstdb.setInt(6, client.getId());
			
			pstdb.executeUpdate();
			System.out.println("Query "+query);
			
			JOptionPane.showMessageDialog(null, "Client Found!!", "Done", JOptionPane.INFORMATION_MESSAGE);
			
			connection.disconnect();
			
			//stdb.executeUpdate(Querydb);

			
			/*Statement st = MySQLConnection.getConexion().createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);*/

			/*while (resultSet.next()) {
				exists = true;
				client.setId(Integer.parseInt(resultSet.getString("id")));
				client.setNombre(resultSet.getString("nombre"));
				client.setApellido(resultSet.getString("apellido"));
				client.setDireccion(resultSet.getString("direccion"));
				client.setDni(resultSet.getString("dni"));
				client.setFecha(resultSet.getString("fecha"));

				//JOptionPane.showMessageDialog(null, "Client Found!!", "Done", JOptionPane.INFORMATION_MESSAGE);

				/*
				 * System.out.println(""); System.out.println("Identificador: " +
				 * resultSet.getString("id") + " " + "Nombre: " + resultSet.getString("nombre")
				 * + " " + "Apellido:" + resultSet.getString("apellido") + " " + "Dirección: " +
				 * resultSet.getString("direccion") + "DNI: " + resultSet.getString("dni") +
				 * "Fecha: " + resultSet.getString("fecha"));
				 */
			//}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en modificación de datos");
		}

	}

	// METODO QUE LIMPIA LOS CLIENTES ESPECIFICADOS DE MYSQL
	public static void deleteRecord(int id) {
		
		MySQLConnection connection = new MySQLConnection();
		
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = connection.getConexion().createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + table_name + " WHERE id = \"" + id + "\"";
			Statement st = connection.getConexion().createStatement();
			st.executeUpdate(Query);

			System.out.println("Registros de tabla ELIMINADOS con exito!");

			JOptionPane.showMessageDialog(null, "Data deleted!!", "Done", JOptionPane.INFORMATION_MESSAGE);
			connection.disconnect();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}

}
