package model;

import java.util.ArrayList;

public class FuenteDeDatos {
	
	private ArrayList<Corredor> coleccion;


	public FuenteDeDatos() {
		coleccion = new ArrayList<Corredor>();
	}

	public void addCorredor(Corredor ic) {
		coleccion.add(ic);
	}

	public ArrayList<Corredor> getColeccion() {
		return coleccion;
	} 
	
	// --------------------
	
	
	
	

}
