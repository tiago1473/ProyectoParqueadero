package Models;

import java.time.LocalDateTime;

public abstract class Vehiculo {
	private String placa;
	private String color;
	private String modelo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSalida;
	private TarifaService tarifa; //muy probablemente no es así
	
	//SOBRECARGA DE MÉTODOS Constructor vehiculo asociado a un cliente (membresia)
	public Vehiculo(String placa, String color, String modelo) {
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.horaEntrada = LocalDateTime.now(); //Almacena la hora de entrada en el instante que se crea
		this.horaSalida = null;
	}
	
	//SOBRECARGA DE MÉTODOS Constructor vehiculo pago por horas
	public Vehiculo(String placa) {
		this.placa = placa;
		this.horaEntrada = LocalDateTime.now();
		this.horaSalida = null;
	}
	
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDateTime getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime ingreso) {
		this.horaEntrada = ingreso;
	}

	public LocalDateTime getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(LocalDateTime salida) {
		this.horaSalida = salida;
	}
	
	public TarifaService getTarifa() {
		return this.tarifa;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", color=" + color + ", modelo=" + modelo + ", horaEntrada=" + horaEntrada
				+ ", horaSalida=" + horaSalida;
	}

	public abstract int calcularPagoVehiculo();
}
