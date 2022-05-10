package com.uda22.TA22Act1.Cliente.models;

import javax.swing.JOptionPane;

public class ClientValidation {

	public void validateCreation(Cliente client) {

		if (client.getDni().length() == 8) {

			ClienteDAO.createClient(client);

		} else {

			JOptionPane.showMessageDialog(null, "DNI needs to have 8 characters", "FAIL", JOptionPane.WARNING_MESSAGE);

		}

	}

	public Cliente validationReasearchClient(int id) {

		try {

			if (id > 0) {

				Cliente client = ClienteDAO.researchClient(id);
				
				if (client != null) {
					return client;
				}else {
					JOptionPane.showMessageDialog(null, "Ese usuario no existe", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
						
			} else {

				JOptionPane.showMessageDialog(null, "ID has to be higher than 0", "FAIL", JOptionPane.WARNING_MESSAGE);

			}

		} catch (NumberFormatException e) {
			System.out.println("Numeric data only accepted " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public void validateUpdateClient(Cliente client) {

		if (client.getDni().length() == 8 || client.getId() > 0 || client.getNombre().length() > 1
				|| client.getApellido().length() > 1) {

			ClienteDAO.updateClient(client);

		} else {

			JOptionPane.showMessageDialog(null, "Differents errors with the parametres of the cleint", "FAIL",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	public void validationDelete(int id) {

		try {

			if (id > 0) {

				ClienteDAO.deleteRecord(id);

			} else {

				JOptionPane.showMessageDialog(null, "ID has to be higher than 0", "FAIL", JOptionPane.WARNING_MESSAGE);

			}

		} catch (NumberFormatException e) {
			System.out.println("Numeric data only accepted " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
