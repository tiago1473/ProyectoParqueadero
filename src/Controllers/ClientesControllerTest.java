package Controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Cliente;

class ClientesControllerTest {
	
	ClientesController controller; 
			
	@BeforeEach //Se ejecuta antes de testear cada método
	public void setUp() {
		 controller = new ClientesController(null);
	}

	@Test
	void testCrearCliente() {
		Cliente cliente = controller.crearCliente("Diego", "123", "3127587497", "diego1505@gamil.com"); //mi método retorna null si mi cliente ya existe
		assertNotNull(cliente);
		assertEquals("123", cliente.getId());
		assertEquals(1,controller.getClientes().size()); //porque si lo creó, se supone que debe ser de tamaño 1 de momento
	}

	@Test
	void testBuscarCliente() {
		Cliente cliente = controller.crearCliente("Diego", "123", "3127587497", "diego1505@gamil.com");
		Cliente clienteHallado = controller.buscarCliente("123");
		assertEquals("123", clienteHallado.getId()); //Porque si lo crea y lo añade, cuando lo busca, lo retorna
		assertNull(controller.crearCliente("Diego", "123", "3127587497", "diego1505@gamil.com")); //Porque ya está creado
	}

}
