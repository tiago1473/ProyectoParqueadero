package Models;

import java.time.Duration;
import java.time.LocalDateTime;

import Interface.CalculadoraPago;

public class Automovil extends Vehiculo implements CalculadoraPago{
	
	public Automovil(String placa, String color, String modelo, Membresia membresia) {
		super(placa, color, modelo, membresia);
	}
	
	public Automovil(String placa) {
		super(placa);
	}
	
	//Pago Automovil Temporal
	@Override
	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());  //Modifico la hora de salida justo en el momento en que se llama al método (hora de salida actual)
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); //Diferencia entre la hora de entrada y salida
        int minutosEstacionado = (int) duracion.toMinutes(); //Llevo esa diferencia a minutos
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); //Paso a horas y redondeo hacia arriba. Math.ceil arroja un "float", por lo que debo castear a int
        int valorPago = horasEstacionado * TarifaService.getTarifaAutomovil()[0];                                                                 
        return valorPago;
	}
	
	@Override
	public String toString() {
		return "[AUTOMOVIL] Placa: " + getPlaca() + " Color: " + getColor() + " Modelo: " + getModelo()
				+" Hora Entrada: " + getHoraEntrada() +  " Hora Salida: " + getHoraSalida();
	}
	
	@Override
	public String toStringTemporal() {
		return "[AUTOMOVIL] Placa: " + getPlaca() + " Hora Entrada: " + getHoraEntrada() + " Hora Salida: " + getHoraSalida();
	}
}
