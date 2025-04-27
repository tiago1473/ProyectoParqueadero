package Controllers;

import javax.swing.JOptionPane;

public class Parqueadero {
	private VehiculosController vehiculosController;
	private String nombre;
	private String direccion;
	private String representante;
	private String telefono;
	private String email;
	private int cuposAutomovil;
	private int cuposMoto;
	private int cuposCamion;
	
	public Parqueadero(String nombre, String direccion, String representante, String telefono, String email,
			int cuposAutos, int cuposMotos, int cuposCamiones) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.telefono = telefono;
		this.email = email;
		this.cuposAutomovil = cuposAutos;
		this.cuposMoto = cuposMotos;
		this.cuposCamion = cuposCamiones;
	}
	
	public void modificarCupos(String tipoVehiculo, int numeroCupos){
		switch (tipoVehiculo) {
		case "1":
			setCuposAutomovil(numeroCupos);
			break;
		case "2":
			setCuposMoto(numeroCupos);
			break;
		case "3":
			setCuposCamion(numeroCupos);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			break;
		}
	}
	
	public Boolean registrarVehiculo(String tipoVehiculo, String placa) {
		switch (tipoVehiculo) {
		case "1":
			if(getCuposAutomovil()>=1) {
				if (vehiculosController.registrarVehiculo(tipoVehiculo, placa)) {
					this.cuposAutomovil -= 1;
					return true;
				}
			}
		case "2":
			if(getCuposMoto()>=1) {
				if (vehiculosController.registrarVehiculo(tipoVehiculo, placa)) {
					this.cuposMoto -= 1;
					return true;
				}
			}
		case "3":
			if(getCuposCamion()>=1) {
				if (vehiculosController.registrarVehiculo(tipoVehiculo, placa)) {
					this.cuposCamion -= 1;
					return true;
				}
			}
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			return false;
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

	public int getCuposAutomovil() {
		return cuposAutomovil;
	}

	public void setCuposAutomovil(int cuposAutos) {
		this.cuposAutomovil = cuposAutos;
	}

	public int getCuposMoto() {
		return cuposMoto;
	}

	public void setCuposMoto(int cuposMotos) {
		this.cuposMoto = cuposMotos;
	}

	public int getCuposCamion() {
		return cuposCamion;
	}

	public void setCuposCamion(int cuposCamiones) {
		this.cuposCamion = cuposCamiones;
	}
}
