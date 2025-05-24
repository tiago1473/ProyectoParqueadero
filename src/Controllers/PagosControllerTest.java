package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Assets.Categoria;
import Models.Camion;
import Models.Membresia;
import Models.TarifaService;
import Models.Vehiculo;

class PagosControllerTest {
	
	PagosController controller;
	
	@BeforeEach 
	public void setUp() {
		 controller = new PagosController(null);
	}

	@Test
	void testActualizarTarifas() {
		System.out.println("Iniciando Prueba para Actualizar Tarifas");
		TarifaService.setTarifaAutomovil(0, 2000);   //Prueba para tarifa por hora automovil
		controller.actualizarTarifas(1, 1, 8000);
		assertEquals(8000,TarifaService.getTarifaAutomovil()[0]);		
		TarifaService.setTarifaMoto(3, 30000);   //Prueba para tarifa mensual moto
		controller.actualizarTarifas(2, 4, 50000);
		assertEquals(50000,TarifaService.getTarifaMoto()[3]);
		TarifaService.setTarifaCamion(2, 2500000);   //Prueba para tarifa trimestral camion
		controller.actualizarTarifas(3, 3, 3000000);
		assertEquals(3000000,TarifaService.getTarifaCamion()[2]);
	}
	@Test
	void testVerificarValorPagoMembresia() {
		System.out.println("Iniciando Prueba para Verificar Valor Pago Membresia");
		TarifaService.setTarifaCamion(1, 2000000);
		Categoria c;
		c=Categoria.ANUAL;
		Membresia m=new Membresia(LocalDateTime.now(),LocalDateTime.of(2026,5,3,2,10),true,c);
		Vehiculo vehiculo=new Camion("111","rojo","2001",m);
		int pago=controller.verificarValorPagoMembresia(vehiculo,Categoria.ANUAL);
		assertEquals(2000000,pago);
		System.out.println("Finalizando Prueba para Verificar Valor Pago Membresia");
	}	
}
