package model;

public class Corredor {
	
	public static final String[] MODALIDAD = {"10000", "Media Maratón", "Maratón"};

	
	private String nombre;
	private String dorsal;
	private String sexo;
	private int edad;
	private String modalidad;
	
	
	public Corredor(String nombre, String dorsal, String sexo, int edad, String modalidad) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.sexo = sexo;
		this.edad = edad;
		this.modalidad = modalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDorsal() {
		return dorsal;
	}

	public String getSexo() {
		return sexo;
	}

	public int getEdad() {
		return edad;
	}

	public String getModalidad() {
		return modalidad;
	}
}
