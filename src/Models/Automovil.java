package Models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Automovil extends Vehiculo {
	
	public Automovil(String placa, String color, String modelo) {
		super(placa, color, modelo);
	}
	
	public Automovil(String placa) { //Y como hereda de vehiculo, guarda la hora de entrada porque ya se definió
		super(placa);
	}

	@Override
	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); //Diferencia entre la hora de entrada y salida
        int minutosEstacionado = (int) duracion.toMinutes(); //Llevo esa diferencia a minutos
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); //Paso a horas y redondeo hacia arriba
        int valorPago = horasEstacionado * getTarifa().getTarifaAutomovil();                                                                     //Math.ceil trabaja con float, por lo que debo castear el dato
        return valorPago;
	}
	
	

}
