package Models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Automovil extends Vehiculo {
	
	public Automovil(String placa, String color, String modelo, Membresia membresia) {
		super(placa, color, modelo, membresia);
	}
	
	public Automovil(String placa) {
		super(placa);
	}
	

	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); //Diferencia entre la hora de entrada y salida
        int minutosEstacionado = (int) duracion.toMinutes(); //Llevo esa diferencia a minutos
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); //Paso a horas y redondeo hacia arriba
        int valorPago = horasEstacionado * TarifaService.getTarifaAutomovil()[0];                                                                     //Math.ceil trabaja con float, por lo que debo castear el dato
        return valorPago;
	}
	
	public String toString() {
		return "[AUTOMOVIL] Placa: " + getPlaca() + "\n" + "Color: " + getColor() + "\n" + "Modelo: " + getModelo()
				+ "\n" + "Hora Entrada: " + getHoraEntrada() + "\n" +  "Hora Salida: " + getHoraSalida();
	}
	
	public String toStringTemporal() {
		return "[AUTOMOVIL] Placa: " + getPlaca() + "\n" + "Hora Entrada: " + getHoraEntrada() + "\n" +  "Hora Salida: " + getHoraSalida();
	}
}
