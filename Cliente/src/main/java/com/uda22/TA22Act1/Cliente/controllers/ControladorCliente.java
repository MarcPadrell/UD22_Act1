package com.uda22.TA22Act1.Cliente.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.uda22.TA22Act1.Cliente.models.Cliente;
import com.uda22.TA22Act1.Cliente.views.VistaMain;

public class ControladorCliente implements ActionListener{
	
	private Cliente client;
	private VistaMain vista;
	
	public ControladorCliente(Cliente client, VistaMain vista) {
		this.client = client;
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
				
			} catch (Exception e) {
				// TODO: handle exception
			}
						

		} else if (vista.btnInsertSave == evento.getSource()){
			
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			

		}else if (vista.btnReadSubmit == evento.getSource()){
			
			try {
				
				int value = (Integer) vista.SpinnerRead.getValue();
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			

		}
				
		
	}
	
	
	
	

}
