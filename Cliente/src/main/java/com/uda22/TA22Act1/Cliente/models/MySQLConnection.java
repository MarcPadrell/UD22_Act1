package com.uda22.TA22Act1.Cliente.models;

import java.sql.*;

public class MySQLConnection {
	
		// Declaramos la variable de tipo conexion
		Connection conexion = null;

		// METODO QUE ABRE LA CONEXION CON SERVER MYSQL
		public MySQLConnection() {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.78:3306?useTimezone=true&serverTimezone=UTC",
						"remote", "Reus_2022"); // credenciales temporales
				System.out.print("Server Connected\n");

			} catch (SQLException | ClassNotFoundException ex) {
				System.out.print("No se ha podido conectar con mi base de datos");
				System.out.println(ex.getMessage());

			} catch (Exception e) {
				System.out.println(e);
			}

		}

		public Connection getConexion() {
			return conexion;
		}
		
		public void disconnect() {
			conexion = null;
		}


}
