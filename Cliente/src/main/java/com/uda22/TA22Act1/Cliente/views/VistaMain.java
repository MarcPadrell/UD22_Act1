package com.uda22.TA22Act1.Cliente.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class VistaMain extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldInsertNombre;
	public JTextField textFieldInsertApellido;
	public JTextField textFieldInsertDireccion;
	public JTextField textFieldInsertDni;
	public JButton btnReadSubmit, btnInsertSave, btnDeleteSubmit;
	public JSpinner SpinnerDelete, SpinnerRead;

	/**
	 * Create the frame.
	 */
	public VistaMain() {
		setBounds(100, 100, 1016, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusqueda = new JLabel("Read Client from the DB");
		lblBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBusqueda.setBounds(176, 57, 228, 25);
		contentPane.add(lblBusqueda);
		
		JLabel lblUpdateClientFrom = new JLabel("Insert Client to the DB");
		lblUpdateClientFrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateClientFrom.setBounds(591, 57, 229, 25);
		contentPane.add(lblUpdateClientFrom);
		
		JLabel lblDeleteClientFrom = new JLabel("Delete Client from the DB");
		lblDeleteClientFrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeleteClientFrom.setBounds(176, 264, 245, 25);
		contentPane.add(lblDeleteClientFrom);
		
		JLabel lblBusqueda_1_1 = new JLabel("Modify Client from the DB");
		lblBusqueda_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBusqueda_1_1.setBounds(591, 264, 254, 25);
		contentPane.add(lblBusqueda_1_1);
		
		SpinnerRead = new JSpinner();
		SpinnerRead.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		SpinnerRead.setBounds(264, 98, 43, 23);
		contentPane.add(SpinnerRead);
		
		JLabel lblReadId = new JLabel("Select the Id:");
		lblReadId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReadId.setBounds(176, 102, 92, 13);
		contentPane.add(lblReadId);
		
		btnReadSubmit = new JButton("Submit");
		btnReadSubmit.setBounds(319, 98, 85, 21);
		contentPane.add(btnReadSubmit);
		
		JLabel lblInsertName = new JLabel("Name:");
		lblInsertName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInsertName.setBounds(591, 104, 92, 13);
		contentPane.add(lblInsertName);
		
		JLabel lblInsertApellido = new JLabel("Surname:");
		lblInsertApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInsertApellido.setBounds(591, 125, 92, 13);
		contentPane.add(lblInsertApellido);
		
		JLabel lblInsertDireccion = new JLabel("Direccion:");
		lblInsertDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInsertDireccion.setBounds(591, 149, 92, 13);
		contentPane.add(lblInsertDireccion);
		
		JLabel lblInsertDni = new JLabel("Dni:");
		lblInsertDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInsertDni.setBounds(591, 172, 92, 13);
		contentPane.add(lblInsertDni);
		
		btnInsertSave = new JButton("Save");
		btnInsertSave.setBounds(661, 199, 96, 25);
		contentPane.add(btnInsertSave);
		
		textFieldInsertNombre = new JTextField();
		textFieldInsertNombre.setBounds(661, 99, 96, 19);
		contentPane.add(textFieldInsertNombre);
		textFieldInsertNombre.setColumns(10);
		
		textFieldInsertApellido = new JTextField();
		textFieldInsertApellido.setColumns(10);
		textFieldInsertApellido.setBounds(661, 122, 96, 19);
		contentPane.add(textFieldInsertApellido);
		
		textFieldInsertDireccion = new JTextField();
		textFieldInsertDireccion.setColumns(10);
		textFieldInsertDireccion.setBounds(661, 147, 96, 19);
		contentPane.add(textFieldInsertDireccion);
		
		textFieldInsertDni = new JTextField();
		textFieldInsertDni.setColumns(10);
		textFieldInsertDni.setBounds(661, 170, 96, 19);
		contentPane.add(textFieldInsertDni);
		
		btnDeleteSubmit = new JButton("Submit");
		btnDeleteSubmit.setBounds(319, 308, 85, 21);
		contentPane.add(btnDeleteSubmit);
		
		SpinnerDelete = new JSpinner();
		SpinnerDelete.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		SpinnerDelete.setBounds(264, 308, 43, 23);
		contentPane.add(SpinnerDelete);
		
		JLabel lblDelete = new JLabel("Select the Id:");
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDelete.setBounds(176, 312, 92, 13);
		contentPane.add(lblDelete);
	}
}
