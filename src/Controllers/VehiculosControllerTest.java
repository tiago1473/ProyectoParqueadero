package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Automovil;
import Models.Camion;
import Models.Moto;
import Models.Vehiculo;

class VehiculosControllerTest {
	
	VehiculosController controller;
	
	@BeforeEach 
	public void setUp() {
		 controller = new VehiculosController(null);
	}
	
	@Test
	void testRegistrarVehiculoIntString() {
		assertTrue(controller.registrarVehiculo(1, "123")); //Debe retornar True toda vez que el vehiculo aún no existe
		assertFalse(controller.registrarVehiculo(1, "123")); //Falso porque ya existe y el metodo de buscar vehiculo retorna al vehiculo
		Vehiculo vehiculoHallado = controller.buscarVehiculo("123");
		
		Automovil auto = new Automovil("123"); //dado que es una instancia y que no la añado a la lista, debe permitir comparar ambos parámetros
		assertEquals(auto.getPlaca(), vehiculoHallado.getPlaca());
		
		assertInstanceOf(Automovil.class, vehiculoHallado); //Debe suceder que sea una instancia de automovil porque mandé la opción 1
		
		String clase = vehiculoHallado.getClass().getSimpleName(); //Otra forma de validar la clase de la instancia de vehiculoHallado
		assertEquals("Automovil", clase);
	}
	
}


