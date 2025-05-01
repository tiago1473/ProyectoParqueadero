package Models;

import java.util.ArrayList;
import Assets.Membresia;

public class Cliente {
	private String nombre;
	private String id;
	private String telefono;
	private String correo;
	private Membresia membresia;
	public ArrayList<Vehiculo> vehiculosCliente;
	
	public Cliente(String nombre, String id, String telefono, String correo, Membresia membresia) {
		this.nombre = nombre;
		this.id = id;
		this.telefono = telefono;
		this.correo = correo;
		this.membresia = membresia;
		this.vehiculosCliente = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public ArrayList<Vehiculo> getVehiculosCliente() {
		return vehiculosCliente;
	}

	public void setVehiculosCliente(ArrayList<Vehiculo> vehiculosCliente) {
		this.vehiculosCliente = vehiculosCliente;
	}
	
	public void agregarVehiculoCliente(Vehiculo vehiculo) {
		this.vehiculosCliente.add(vehiculo);
	}

	
}
