package Controllers;

import java.util.ArrayList;

import Assets.Categoria;
import Models.Cliente;
import Models.Membresia;

public class ClientesController {
	public ArrayList<Cliente> clientes;
	
	public ClientesController(Parqueadero parqueadero) {
		this.clientes = new ArrayList<>();
	}

	public Cliente buscarCliente(String id) {
		for(Cliente cliente : this.clientes) {
			if(cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}
	
	public boolean crearCliente(String nombre, String id, String telefono, String correo, Membresia membresia) {
		Cliente clienteHallado = buscarCliente(id);
		if (clienteHallado == null) {
			Cliente nuevoCliente = new Cliente(nombre, id, telefono, correo, membresia);
			this.clientes.add(nuevoCliente);
			return true;
		}
		return false;
	}
	
	public boolean actualizarCliente(String id, String telefono, String correo, Membresia membresia) {
		Cliente clienteHallado = buscarCliente(id);
		if(clienteHallado != null) {
			clienteHallado.setTelefono(telefono);
			clienteHallado.setCorreo(correo);
			clienteHallado.setMembresia(membresia);
			return true;
		}
		return false;		
	}
	
	public boolean eliminarCliente(String id) {
		Cliente clienteHallado = buscarCliente(id);
		if(clienteHallado != null) {
			this.clientes.remove(clienteHallado);
			return true;
		}
		return false;		
	}
	
	public String verVehiculosCliente(String id) {
		Cliente clienteHallado = buscarCliente(id);
		if(clienteHallado != null) {
			return clienteHallado.getVehiculosCliente().toString();
		}
		return "El cliente no existe";
	}
	
	public String verClienteMembresiaActiva() {
		String mensaje= null;
		for (Cliente cliente:this.clientes) {
			if (cliente.getMembresia().isActiva()) {
				mensaje+=cliente.toString()+"\n";
			}
		}
		return mensaje;
	}
}
