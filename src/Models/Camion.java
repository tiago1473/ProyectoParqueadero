package Models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Camion extends Vehiculo {

	public Camion(String placa, String color, String modelo, Membresia membresia) {
		super(placa, color, modelo, membresia);
	}
	
	public Camion(String placa) {
		super(placa);
	}
	
	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); 
        int minutosEstacionado = (int) duracion.toMinutes(); 
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); 
        int valorPago = horasEstacionado * getTarifa().getTarifaCamion();                                                      //Math.ceil trabaja con float, por lo que debo castear el dato
        return valorPago;
	}
}
