package Models;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CamionTest {

	@Test
	void testCalcularPagoVehiculo() {
		Camion camion = new Camion("KMO722"); //Cuando la creo, por defecto la hora de entrada se crea en el momento, y como voy a comparar con una hora de salida actual, le resto a esa hora para que quede más atrás
		camion.setHoraEntrada(LocalDateTime.now().minusMinutes(122));  //2 horas 2 minutos
		TarifaService.setTarifaCamion(0, 50000); //tarifa camion por hora 50000
		int valorPagoEsperado = 3 * 50000;
		int valorGenerado = camion.calcularPagoVehiculo(); //Invoco al método que voy a testear
		assertEquals(valorPagoEsperado, valorGenerado);    //y es correcto porque está cobrando 3 horas
	}

}
