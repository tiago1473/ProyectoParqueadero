package Controllers;

import javax.swing.JOptionPane;

public class Parqueadero {
	private String nombre;
	private String direccion;
	private String representante;
	private String telefono;
	private String email;
	private int cuposMotos;
	private int cuposCarros;
	private int cuposCamiones;
	
	public Parqueadero(String nombre, String direccion, String representante, String telefono, String email,
			int cuposMotos, int cuposCarros, int cuposCamiones) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.telefono = telefono;
		this.email = email;
		this.cuposMotos = cuposMotos;
		this.cuposCarros = cuposCarros;
		this.cuposCamiones = cuposCamiones;
	}
	
	public void modificarCupos(String tipoVehiculo, int numeroCupos){
		switch (tipoVehiculo) {
		case "1":
			setCuposMotos(numeroCupos);
			break;
		case "2":
			setCuposCarros(numeroCupos);
			break;
		case "3":
			setCuposCamiones(numeroCupos);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			break;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCuposMotos() {
		return cuposMotos;
	}

	public void setCuposMotos(int cuposMotos) {
		this.cuposMotos = cuposMotos;
	}

	public int getCuposCarros() {
		return cuposCarros;
	}

	public void setCuposCarros(int cuposCarros) {
		this.cuposCarros = cuposCarros;
	}

	public int getCuposCamiones() {
		return cuposCamiones;
	}

	public void setCuposCamiones(int cuposCamiones) {
		this.cuposCamiones = cuposCamiones;
	}
	
	
	


}
