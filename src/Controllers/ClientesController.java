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
		Cliente clienteHallado = buscarCliente(id);
		if (clienteHallado == null) {
			Cliente nuevoCliente = new Cliente(nombre, id, telefono, correo);
			this.clientes.add(nuevoCliente);
			return nuevoCliente;
		}
		return null;
	}
	
	public boolean eliminarCliente(String id) {
		Cliente clienteHallado = buscarCliente(id);
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
		Cliente clienteHallado = buscarCliente(id);
		if(clienteHallado != null) {
			clienteHallado.setTelefono(telefono);
			clienteHallado.setCorreo(correo);
			return true;
		}
		return false;		
	}
	
	public String verVehiculosCliente(String id) {
		Cliente clienteHallado = buscarCliente(id);
		if(clienteHallado != null) {
			return clienteHallado.getVehiculosCliente().toString(); //Aplicar el toString a una lista Java entiende que la recorre y aplica toString según la instancia de la clase
		}
		return "El cliente no existe";
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
}
