package Models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Moto extends Vehiculo {

	public Moto(String placa, String color, String modelo, Membresia membresia) {
		super(placa, color, modelo, membresia);
	}
	
	public Moto(String placa) {
		super(placa);
	}
	
	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); 
        int minutosEstacionado = (int) duracion.toMinutes(); 
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); 
        int valorPago = horasEstacionado * getTarifa().getTarifaMoto();                                                                     //Math.ceil trabaja con float, por lo que debo castear el dato
        return valorPago;
	}

}
