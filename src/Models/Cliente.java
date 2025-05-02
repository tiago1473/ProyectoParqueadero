package Models;

import java.util.ArrayList;
import Assets.Categoria;

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

	public Membresia getMembresia() {
		return this.membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public ArrayList<Vehiculo> getVehiculosCliente() {
		return this.vehiculosCliente;
	}

	public void setVehiculosCliente(ArrayList<Vehiculo> vehiculosCliente) {
		this.vehiculosCliente = vehiculosCliente;
	}
	
	public void agregarVehiculoCliente(Vehiculo vehiculo) {
		this.vehiculosCliente.add(vehiculo);
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + this.nombre + ", id=" + this.id + ", telefono=" + this.telefono + ", correo=" + this.correo
				+ ", membresia=" + getMembresia().getCategoria() +", fecha de inicio=" +getMembresia().getFechaInicio()
				+ ", fecha de fin=" +getMembresia().getFechaFin()+", Activa=" +getMembresia().isActiva();
	}
}
