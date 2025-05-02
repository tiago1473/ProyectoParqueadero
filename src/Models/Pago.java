package Models;

import java.time.LocalDateTime;

public class Pago {
	private String idPago;
	private String tipoVehiculo;
	private String placa;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private int ingreso;
	
	public Pago(String idPago, String tipoVehiculo, String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin, int ingreso) {
		this.idPago=idPago;
		this.tipoVehiculo=tipoVehiculo;
		this.placa=placa;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.ingreso=ingreso;
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
		return this.ingreso;
	}

	public void setIngreso(int ingreso) {
		this.ingreso = ingreso;
	}

	@Override
	public String toString() {
		return "Pago [idPago=" + this.idPago + this.tipoVehiculo.toUpperCase() + ", placa=" + this.placa + ", fechaInicio="
				+ this.fechaInicio + ", fechaFin=" + this.fechaFin + ", pago=" + this.ingreso + "]";
	}
}
