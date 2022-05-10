package com.uda22.TA22Act1.Cliente.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;

import com.uda22.TA22Act1.Cliente.models.ClientValidation;
import com.uda22.TA22Act1.Cliente.models.Cliente;
import com.uda22.TA22Act1.Cliente.views.VistaMain;

public class ControladorCliente implements ActionListener{
	
	private VistaMain vista;
	private ClientValidation clientValidation = new ClientValidation();
	
	public ControladorCliente(VistaMain vista) {
		this.vista = vista;
		this.vista.btnDeleteSubmit.addActionListener(this);
		this.vista.btnInsertSave.addActionListener(this);
		this.vista.btnReadSubmit.addActionListener(this);
	}
	
	public void iniciarVista() {
		
		vista.setTitle("DB Cliente");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if (vista.btnDeleteSubmit == evento.getSource()){
			
			try {
				
				int value = (Integer) vista.SpinnerDelete.getValue(); // Cogemos el valor del spinner
				
				clientValidation.validationDelete(value); // Eliminamos el el cliente con ese id

				
			} catch (Exception e) {
				// TODO: handle exception
			}
						

		} else if (vista.btnInsertSave == evento.getSource()){
			
			try {
				
				Cliente client = new Cliente();
				
				// Fecha actual
				LocalDate localDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String formattedLocalDate = localDate.format(formatter);
				
				client.setNombre(vista.textFieldInsertNombre.getText());
				client.setApellido(vista.textFieldInsertApellido.getText());
				client.setDireccion(vista.textFieldInsertDireccion.getText());
				client.setDni(vista.textFieldInsertDni.getText());
				client.setFecha(formattedLocalDate.toString());
				
				clientValidation.validateCreation(client);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			

		}else if (vista.btnReadSubmit == evento.getSource()){
			
			try {
				
				int value = (Integer) vista.SpinnerRead.getValue(); // Valor del spinner
			
				
				Cliente clientRead = clientValidation.validationReasearchClient(value); // Nos devuelve el cliente con el identificador
				
				System.out.println("READ: "+clientRead.toString()); // Mostramos el cliente con sus atributos
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			

		}
				
		
	}
	

}
