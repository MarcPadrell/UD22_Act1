package com.uda22.TA22Act1.Cliente.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;

import com.uda22.TA22Act1.Cliente.models.ClientValidation;
import com.uda22.TA22Act1.Cliente.models.Cliente;
import com.uda22.TA22Act1.Cliente.views.VistaMain;

public class ControladorCliente implements ActionListener {

	private VistaMain vista;
	private ClientValidation clientValidation = new ClientValidation();
	private Cliente client = new Cliente();

	public ControladorCliente(VistaMain vista, Cliente client) {
		this.vista = vista;
		this.client = client;
		this.vista.btnDeleteSubmit.addActionListener(this);
		this.vista.btnInsertSave.addActionListener(this);
		this.vista.btnReadSubmit.addActionListener(this);
		this.vista.btnModifySave.addActionListener(this);
		this.vista.btnReadClear.addActionListener(this);
	}

	public void iniciarVista() {

		vista.setTitle("DB Cliente");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (vista.btnDeleteSubmit == evento.getSource()) {

			try {

				int value = (Integer) vista.SpinnerDelete.getValue(); // Cogemos el valor del spinner

				clientValidation.validationDelete(value); // Eliminamos el el cliente con ese id

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else if (vista.btnInsertSave == evento.getSource()) {

			try {

				// Fecha actual
				LocalDate localDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String formattedLocalDate = localDate.format(formatter);

				this.client.setNombre(vista.textFieldInsertNombre.getText());
				client.setApellido(vista.textFieldInsertApellido.getText());
				client.setDireccion(vista.textFieldInsertDireccion.getText());
				client.setDni(vista.textFieldInsertDni.getText());
				client.setFecha(formattedLocalDate.toString());

				clientValidation.validateCreation(client);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else if (vista.btnReadSubmit == evento.getSource()) {

			try {

				int value = (Integer) vista.SpinnerRead.getValue(); // Valor del spinner

				client = clientValidation.validationReasearchClient(value); // Nos devuelve el cliente con
																			// el identificador

				vista.textAreaRead.setText(client.toString());

				
			} catch (Exception e) {
				vista.textAreaRead.setText(e.getMessage());
				//System.out.println(e.getMessage());
			}

		} else if (vista.btnModifySave == evento.getSource()) {

			try {

				System.out.println("Modify");

				// Fecha actual
				LocalDate localDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String formattedLocalDate = localDate.format(formatter);

				int value = (Integer) vista.SpinnerModify.getValue(); // Valor del spinner

				client.setNombre(vista.textFieldNameModify.getText());
				client.setApellido(vista.textFieldSurnameModify.getText());
				client.setDireccion(vista.textFieldDirectionModify.getText());
				client.setDni(vista.textFieldDniModify.getText());
				client.setFecha(formattedLocalDate.toString());

				clientValidation.validateUpdateClient(value, client); // Nos devuelve el cliente con
																		// el identificador
				// System.out.println("READ: " + client.getId().toString()); // Mostramos el
				// cliente con sus atributos

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}else if (evento.getSource() == vista.btnReadClear) {

			vista.textAreaRead.setText("");

		}

	}

}
