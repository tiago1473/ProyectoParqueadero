package Models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Camion extends Vehiculo {

	public Camion(String placa, String color, String modelo) {
		super(placa, color, modelo);
	}
	
	public Camion(String placa) {
		super(placa);
	}
	
	@Override
	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); 
        int minutosEstacionado = (int) duracion.toMinutes(); 
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); 
        int valorPago = horasEstacionado * getTarifa().getTarifaCamion();                                                                     //Math.ceil trabaja con float, por lo que debo castear el dato
        return valorPago;
	}
}
