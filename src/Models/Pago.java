package Models;

import java.time.LocalDateTime;

public class Pago {
	private String idPago;
	private String tipoVehiculo;
	private String placa;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private int valorPago;
	
	public Pago(String idPago, String tipoVehiculo, String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin, int valorPago) {
		this.idPago=idPago;
		this.tipoVehiculo=tipoVehiculo;
		this.placa=placa;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.valorPago=valorPago;
	}

	public String getIdPago() {
		return this.idPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	public String getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getIngreso() {
		return this.valorPago;
	}

	public void setIngreso(int ingreso) {
		this.valorPago= ingreso;
	}

	@Override
	public String toString() {
		return "Id Pago: " + this.idPago + "\n" + "Tipo Vehiculo: " + this.tipoVehiculo.toUpperCase() + "\n"+
				"Fecha Inicio: " + this.fechaInicio + "\n" + "Fecha Fin: " + this.fechaFin + "\n" + 
				 "Valor del Pago: " + this.valorPago;
	}
}
