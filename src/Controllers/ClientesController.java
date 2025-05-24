package Controllers;

import java.util.ArrayList;
import Models.Cliente;
import Models.Vehiculo;

public class ClientesController {
	public ArrayList<Cliente> clientes;
	
	public ClientesController(Parqueadero parqueadero) {
		this.clientes = new ArrayList<>();
	}

	public Cliente crearCliente(String nombre, String id, String telefono, String correo) {
		Cliente clienteHallado = buscarCliente(id.toUpperCase());
		if (clienteHallado == null) {
			Cliente nuevoCliente = new Cliente(nombre, id, telefono, correo);
			this.clientes.add(nuevoCliente);
			return nuevoCliente;
		}
		return null;
	}
	
	public boolean eliminarCliente(String id) {
		Cliente clienteHallado = buscarCliente(id.toUpperCase());
		if(clienteHallado != null) {
			this.clientes.remove(clienteHallado);
			return true;
		}
		return false;		
	}
	
	public Cliente buscarCliente(String id) {
		for(Cliente cliente : this.clientes) {
			if(cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}
	
	public boolean actualizarCliente(String id, String telefono, String correo) {
		Cliente clienteHallado = buscarCliente(id.toUpperCase());
		if(clienteHallado != null) {
			clienteHallado.setTelefono(telefono);
			clienteHallado.setCorreo(correo);
			return true;
		}
		return false;		
	}
	
	public String verVehiculosCliente(String id) {
		Cliente clienteHallado = buscarCliente(id.toUpperCase());
		String mensaje="No hay cliente registrado con ese Id";
		if(clienteHallado != null) {
			mensaje="Los vehiculos del cliente "+ clienteHallado.getNombre().toUpperCase() + " son: \n";
			for (Vehiculo v : clienteHallado.getVehiculosCliente()) {
				mensaje += v.toString()+ "\n";
			}
		}
		return mensaje;
	}
	
	public String verClientesMembresiaActiva() {
		String mensaje = "Los clientes con vehiculos de membresia activa son: \n";
		for(Cliente c : this.clientes) {
			for(Vehiculo vehiculo : c.getVehiculosCliente()) {
				if (vehiculo.getMembresia().getIsActiva()) {
					mensaje += c.getNombre() + ", Id: "+ c.getId() + ", Vehiculo: " + vehiculo.toString()+ "\n";
				}
			}
		}
		return mensaje;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
}
