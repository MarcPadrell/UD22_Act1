package com.uda22.TA22Act1.Cliente.AppMain;

import com.uda22.TA22Act1.Cliente.controllers.ControladorCliente;
import com.uda22.TA22Act1.Cliente.views.VistaMain;

/**
 * Hello world!
 *
 */
public class App{
		
    public static void main( String[] args )
    {
    	VistaMain vista = new VistaMain();
        ControladorCliente controlador = new ControladorCliente(vista);
        controlador.iniciarVista();
    }
}
