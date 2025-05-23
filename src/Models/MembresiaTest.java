package Models;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Assets.Categoria;

class MembresiaTest {
	
	public LocalDateTime fechaInicio;
	
	@BeforeEach
    void setUp() {
		fechaInicio = LocalDateTime.now().minusMonths(2);
    }

	@Test
	void testGetIsActiva() {
		LocalDateTime fechaFin1 = LocalDateTime.now().minusMonths(1); //Para que sea ya vencida y validar
		Categoria categoriaMembresia1 = Categoria.MENSUAL;
		Membresia membresia1 = new Membresia (fechaInicio, fechaFin1, true, categoriaMembresia1); //La mando como true, sabiendo que ya está vencida para que el método arroje lo que es
		assertFalse(membresia1.getIsActiva()); 
	
		LocalDateTime fechaFin2 = fechaInicio.plusYears(1); //No está vencida
		Categoria categoriaMembresia2 = Categoria.ANUAL;
		Membresia membresia2 = new Membresia (fechaInicio, fechaFin2, false, categoriaMembresia2); //Lo mando false sabiendo que es true
		assertTrue(membresia2.getIsActiva()); 	
	}   
}
