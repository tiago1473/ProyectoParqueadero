package Models;

public class Pago {
	private String idPago;
	private int pago;
	private Vehiculo vehiculo;
	
	public Pago(String idPago, int pago, Vehiculo vehiculo) {
		this.idPago=idPago;
		this.pago=pago;
		this.vehiculo=vehiculo;
	}

	public String getIdPago() {
		return idPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
