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
	private int cuposDisponiblesAutomovil;
	private int cuposDisponiblesMoto;
	private int cuposDisponiblesCamion;
	
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
		this.cuposDisponiblesAutomovil = cuposAutos;
		this.cuposDisponiblesMoto = cuposMotos;
		this.cuposDisponiblesCamion = cuposCamion;
		this.vehiculosController= new VehiculosController(this);
		this.pagosController= new PagosController(this);
		this.clientesController= new ClientesController(this);
		TarifaService.setTarifaAutomovil(1, tarifaA1);
		TarifaService.setTarifaAutomovil(2, tarifaA2);
		TarifaService.setTarifaAutomovil(3, tarifaA3);
		TarifaService.setTarifaAutomovil(4, tarifaA4);
		TarifaService.setTarifaMoto(1, tarifaM1);
		TarifaService.setTarifaMoto(2, tarifaM2);
		TarifaService.setTarifaMoto(3, tarifaM3);
		TarifaService.setTarifaMoto(4, tarifaM4);
		TarifaService.setTarifaCamion(1, tarifaC1);
		TarifaService.setTarifaCamion(2, tarifaC2);
		TarifaService.setTarifaCamion(3, tarifaC3);
		TarifaService.setTarifaCamion(4, tarifaC4);
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

	public boolean modificarCupos(int tipoVehiculo, int nuevoTotal){
		switch (tipoVehiculo) {
		case 1:
			if (nuevoTotal < (this.cuposAutomovil - this.cuposDisponiblesAutomovil)) { //Osea, el nuevo que le mando no puede ser menor a lo que ya tengo demandado, es decir, si tengo 10 cupos totales (por ahora) y tengo 6 disponibles, ese nuevo total no puede ser menor a 4 porque son 4 que ya estan parqueados
				JOptionPane.showMessageDialog(null, "No puede establecer un cupo menor al número de vehículos ya parqueados.");
				return false;
			}
			this.cuposDisponiblesAutomovil += (nuevoTotal - this.cuposAutomovil); //Porqur son los nuevos que estoy agregando
			this.cuposAutomovil = nuevoTotal;
			return true;
		case 2:
			if (nuevoTotal < (this.cuposMoto - this.cuposDisponiblesMoto)) { //Osea, el nuevo que le mando no puede ser menor a lo que ya tengo demandado, es decir, si tengo 10 cupos totales (por ahora) y tengo 6 disponibles, ese nuevo total no puede ser menor a 4 porque son 4 que ya estan parqueados
				JOptionPane.showMessageDialog(null, "No puede establecer un cupo menor al número de vehículos ya parqueados.");
				return false;
			}
			this.cuposDisponiblesMoto += (nuevoTotal - this.cuposAutomovil); //Porqur son los nuevos que estoy agregando
			this.cuposMoto = nuevoTotal;
			return true;
		case 3:
			if (nuevoTotal < (this.cuposCamion - this.cuposDisponiblesCamion)) { //Osea, el nuevo que le mando no puede ser menor a lo que ya tengo demandado, es decir, si tengo 10 cupos totales (por ahora) y tengo 6 disponibles, ese nuevo total no puede ser menor a 4 porque son 4 que ya estan parqueados
				JOptionPane.showMessageDialog(null, "No puede establecer un cupo menor al número de vehículos ya parqueados.");
				return false;
			}
			this.cuposDisponiblesCamion += (nuevoTotal - this.cuposAutomovil); //Porqur son los nuevos que estoy agregando
			this.cuposCamion = nuevoTotal;
			return true;
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			return false;
		}
	}
	
	public void liberarCupos(Vehiculo vehiculo) {
		if (vehiculo instanceof Automovil) { //Auto	
			this.cuposDisponiblesAutomovil += 1;
		}
		if (vehiculo instanceof Moto) { //Auto	
			this.cuposDisponiblesMoto += 1;
		}
		if (vehiculo instanceof Camion) { //Camion	
			this.cuposDisponiblesCamion+= 1;
		}	
	}
	
	
	public boolean verificarCupos(int tipoVehiculo) {
		switch (tipoVehiculo){
			case 1: //Auto
			case 4:
				if(getCuposDisponiblesAutomovil()>=1) {		
					this.cuposDisponiblesAutomovil -= 1;
					return true;
				}
				break;
			case 2: //Moto
			case 5:
				if(getCuposDisponiblesMoto()>=1) {				
					this.cuposDisponiblesMoto -= 1;
					return true;
				}
				break;
			case 3: //Camion
			case 6:
				if(getCuposDisponiblesCamion()>=1) {
					this.cuposDisponiblesCamion -= 1;
					return true;
				}
				break;
			}
		return false;
	}
	
	public int getCuposDisponiblesAutomovil() {
		return this.cuposDisponiblesAutomovil;
	}

	public void setCuposDisponiblesAutomovil(int cuposDisponiblesAutomovil) {
		this.cuposDisponiblesAutomovil = cuposDisponiblesAutomovil;
	}

	public int getCuposDisponiblesMoto() {
		return this.cuposDisponiblesMoto;
	}

	public void setCuposDisponiblesMoto(int cuposDisponiblesMoto) {
		this.cuposDisponiblesMoto = cuposDisponiblesMoto;
	}

	public int getCuposDisponiblesCamion() {
		return this.cuposDisponiblesCamion;
	}

	public void setCuposDisponiblesCamion(int cuposDisponiblesCamion) {
		this.cuposDisponiblesCamion = cuposDisponiblesCamion;
	}

	@Override
	public String toString() {
		return this.nombre + "\nDireccion=" + this.direccion + "\nRepresentante=" + this.representante + "\nTelefono=" + this.telefono 
				+ "\nEmail=" + this.email + "\n\n";
	}
	
	public String toStringCupos() {
		return "\nTotal Cupos Automovil =" + this.cuposAutomovil + "\nTotal Cupos Motos =" + this.cuposMoto + "\n Total Cupos Camión =" 
				+ this.cuposCamion + "\n\n"
				+"\nTotal Cupos Disponibles Automovil =" + this.cuposDisponiblesAutomovil + "\nTotal Cupos Motos =" + this.cuposDisponiblesMoto + "\n Total Cupos Camión =" 
				+ this.cuposDisponiblesCamion + "\n\n";
	}
}
