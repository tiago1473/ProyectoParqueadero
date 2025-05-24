package Models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {
	private String idPago;
	private String tipoVehiculo;
	private String placa;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private int valorPago;
	public static int valorId = 1;  //Propia de la clase
	
	public Pago(String tipoVehiculo, String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin, int valorPago) {
		this.idPago = "FDV" + valorId ;
		valorId += 1;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorPago = valorPago;
	}

	public String getIdPago() {
		return this.idPago;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Me permite darle formato especificado a las fechas
		String fechaInicioFormatted = this.fechaInicio.format(formatter);
		String fechaFinFormatted = this.fechaFin.format(formatter);

		return "\n"+ "Id Pago: " + this.idPago + "\n" +
			   "Tipo Vehiculo: " + this.tipoVehiculo.toUpperCase() + "\n" +
			   "Placa: " + this.placa + "\n" +
			   "Fecha Inicio: " + fechaInicioFormatted + "\n" +
			   "Fecha Fin: " + fechaFinFormatted + "\n" +
			   "Valor del Pago: " + this.valorPago + "\n";
	}
}
