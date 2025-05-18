package Controllers;

import javax.swing.JOptionPane;

import Models.Automovil;
import Models.Camion;
import Models.Moto;
import Models.TarifaService;
import Models.Vehiculo;

public class Parqueadero {
	private VehiculosController vehiculosController;
	private PagosController pagosController;
	private ClientesController clientesController; 
	private String nombre;
	private String direccion;
	private String representante;
	private String telefono;
	private String email;
	private int cuposAutomovil;
	private int cuposMoto;
	private int cuposCamion;
	
	public Parqueadero(String nombre, String direccion, String representante, String telefono, String email,
			int cuposAutos, int cuposMotos, int cuposCamiones, int tarifaA1, int tarifaA2, int tarifaA3, int tarifaA4,
			int tarifaM1, int tarifaM2, int tarifaM3, int tarifaM4, int tarifaC1, int tarifaC2, int tarifaC3, int tarifaC4) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.telefono = telefono;
		this.email = email;
		this.cuposAutomovil = cuposAutos;
		this.cuposMoto = cuposMotos;
		this.cuposCamion = cuposCamiones;
		this.vehiculosController= new VehiculosController(this);
		this.pagosController= new PagosController(this);
		this.clientesController= new ClientesController(this);
		TarifaService.setTarifaAutomovil(0, tarifaA1);
		TarifaService.setTarifaAutomovil(1, tarifaA2);
		TarifaService.setTarifaAutomovil(2, tarifaA3);
		TarifaService.setTarifaAutomovil(3, tarifaA4);
		TarifaService.setTarifaMoto(0, tarifaM1);
		TarifaService.setTarifaMoto(1, tarifaM2);
		TarifaService.setTarifaMoto(2, tarifaM3);
		TarifaService.setTarifaMoto(3, tarifaM4);
		TarifaService.setTarifaCamion(0, tarifaC1);
		TarifaService.setTarifaCamion(1, tarifaC2);
		TarifaService.setTarifaCamion(2, tarifaC3);
		TarifaService.setTarifaCamion(3, tarifaC4);
	}
		
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCuposAutomovil() {
		return this.cuposAutomovil;
	}

	public void setCuposAutomovil(int cuposAutos) {
		this.cuposAutomovil = cuposAutos;
	}

	public int getCuposMoto() {
		return this.cuposMoto;
	}

	public void setCuposMoto(int cuposMotos) {
		this.cuposMoto = cuposMotos;
	}

	public int getCuposCamion() {
		return this.cuposCamion;
	}

	public void setCuposCamion(int cuposCamiones) {
		this.cuposCamion = cuposCamiones;
	}
	
	public VehiculosController getVehiculosController() {
		return this.vehiculosController;
	}

	public void setVehiculosController(VehiculosController vehiculosController) {
		this.vehiculosController = vehiculosController;
	}

	public PagosController getPagosController() {
		return this.pagosController;
	}

	public void setPagosController(PagosController pagosController) {
		this.pagosController = pagosController;
	}

	public ClientesController getClientesController() {
		return this.clientesController;
	}

	public void setClientesController(ClientesController clientesController) {
		this.clientesController = clientesController;
	}
	
	public boolean modificarDatosParqueadero(String nombre, String direccion, String representante, String telefono, String email) {
		setNombre(nombre);
		setDireccion(direccion);
		setRepresentante(representante);
		setTelefono(telefono);
		setEmail(email);
		return true;
	}

	public boolean modificarCupos(int tipoVehiculo, int numeroCupos){
		switch (tipoVehiculo) {
		case 1:
			setCuposAutomovil(numeroCupos);
			return true;
		case 2:
			setCuposMoto(numeroCupos);
			return true;
		case 3:
			setCuposCamion(numeroCupos);
			return true;
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			return false;
		}
	}
	
	public void liberarCupos(Vehiculo vehiculo) {
		if (vehiculo instanceof Automovil) { //Auto	
				this.cuposAutomovil += 1;
		}
		if (vehiculo instanceof Moto) { //Auto	
			this.cuposMoto += 1;
		}
		if (vehiculo instanceof Camion) { //Camion	
			this.cuposCamion+= 1;
		}	
	}
	
	
	public boolean verificarCupos(int tipoVehiculo) {
		switch (tipoVehiculo){
			case 1: //Auto
			case 4:
				if(getCuposAutomovil()>=1) {		
					this.cuposAutomovil -= 1;
					return true;
				}
			case 2: //Moto
			case 5:
				if(getCuposMoto()>=1) {				
					this.cuposMoto -= 1;
					return true;
				}
			case 3: //Camion
			case 6:
				if(getCuposCamion()>=1) {
					this.cuposCamion -= 1;
					return true;
				}
			default:
				return false;
			}
	}
	
	@Override
	public String toString() {
		return this.nombre + "\nDireccion=" + this.direccion + "\nRepresentante=" + this.representante + "\nTelefono=" + this.telefono 
				+ "\nEmail=" + this.email + "\n\n";
	}
	
	public String toStringCupos() {
		return this.nombre + "\nTotal Cupos Automovil=" + this.cuposAutomovil + "\nTotal Cupos Motos=" + this.cuposMoto + "\n Total Cupos Camion=" 
				+ this.cuposCamion + "\n\n";
	}
}
