package com.uda22.TA22Act1.Cliente.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLConnection {
	
	// Declaramos la variable de tipo conexion
		public static Connection conexion;

		// METODO QUE ABRE LA CONEXION CON SERVER MYSQL
		public static void openConnection() {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.78:3306?useTimezone=true&serverTimezone=UTC",
						"remote", "Reus_2022"); // credenciales temporales
				System.out.print("Server Connected");

			} catch (SQLException | ClassNotFoundException ex) {
				System.out.print("No se ha podido conectar con mi base de datos");
				System.out.println(ex.getMessage());

			}

		}

		// METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
		public static void closeConnection() {
			try {
				conexion.close();
				System.out.print("Server Disconnected");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.print("Error cerrando conexion");

			}
		}

		public static Connection getConexion() {
			return conexion;
		}


}
