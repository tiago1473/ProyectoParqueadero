package Models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Interface.CalculadoraPago;

public class Camion extends Vehiculo implements CalculadoraPago{

	public Camion(String placa, String color, String modelo, Membresia membresia) {
		super(placa, color, modelo, membresia);
	}
	
	public Camion(String placa) {
		super(placa);
	}
	
	//Pago Camión Temporal
	@Override
	public int calcularPagoVehiculo() { 
		setHoraSalida(LocalDateTime.now()); //Modifico la hora de salida justo en el momento en que se llama al método (hora de salida actual)
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); //Diferencia entre la hora de entrada y salida
        int minutosEstacionado = (int) duracion.toMinutes(); //Llevo esa diferencia a minutos
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); //Paso a horas y redondeo hacia arriba
        int valorPago = horasEstacionado * TarifaService.getTarifaCamion()[0];                                                    
        return valorPago;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Me permite darle formato especificado a las fechas
		String fechaInicioFormatted = getHoraEntrada().format(formatter);
		return "[CAMION] Placa: " + getPlaca() + " Color: " + getColor() + " Modelo: " + getModelo() + " Hora Entrada: " + fechaInicioFormatted 
		+  " Hora Salida: " + getHoraSalida();
	}
	
	@Override
	public String toStringTemporal() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Me permite darle formato especificado a las fechas
		String fechaInicioFormatted = getHoraEntrada().format(formatter);
		return "[CAMION] Placa: " + getPlaca() + " Hora Entrada: " + fechaInicioFormatted +  " Hora Salida: " + getHoraSalida();
	}
}
