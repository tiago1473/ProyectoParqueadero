package Models;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String id;
	private String telefono;
	private String correo;
	public ArrayList<Vehiculo> vehiculosCliente;
	
	public Cliente(String nombre, String id, String telefono, String correo) {
		this.nombre = nombre;
		this.id = id;
		this.telefono = telefono;
		this.correo = correo;
		this.vehiculosCliente = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public ArrayList<Vehiculo> getVehiculosCliente() {
		return this.vehiculosCliente;
	}

	public void agregarVehiculoCliente(Vehiculo vehiculo) {
		this.vehiculosCliente.add(vehiculo);
	}
	
	public Boolean eliminarVehiculoCliente(String placa) {
		Vehiculo vehiculoHallado = buscarVehiculoCliente(placa);
		if(vehiculoHallado != null) {
			this.vehiculosCliente.remove(vehiculoHallado);
			return true;
		}
		return false;		
	}
	
	public Vehiculo buscarVehiculoCliente(String placa) {
		for(Vehiculo vehiculo : this.vehiculosCliente) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" + "Id: " + this.id + "\n" + "Telefono: " + this.telefono + "\n" 
				+ "Correo: " + this.correo + "\n"; 
	}
}
