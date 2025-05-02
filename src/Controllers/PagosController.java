package Controllers;
import Models.Pago;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PagosController {
	private VehiculosController vehiculosController;
	/**algo parecido como tarifa service preguntar
	 como hago para que mi pagos controller pueda acceder 
	 a vehiculos controller* 
	 */
	private ArrayList<Pago> pagos;
	
	
	public PagosController (Parqueadero parqueadero) {
		this.pagos= new ArrayList<>();
	}
	
	public Pago buscarPago(String idPago) {
		for(Pago pago : this.pagos) {
			if(pago.getIdPago().equals(idPago)) {
				return pago;
			}
		}
		return null;
	}
	
	public boolean registrarPago(String idPago, String tipoVehiculo, String placa, LocalDateTime fechaInicio, 
			LocalDateTime fechaFin, int ingreso) {
		Pago pagoEncontrado = buscarPago(idPago);
		if (pagoEncontrado == null) {
			Pago pago = new Pago(idPago,tipoVehiculo,placa,fechaInicio,fechaFin,ingreso);
			this.pagos.add(pago);
			return true;
		}
		return false;
	}
	
	public String generarFactura(String idPago) {
		Pago pagoEncontrado = buscarPago(idPago);
		if (pagoEncontrado != null) {
			return pagoEncontrado.toString();
		}
		return "No hay factura generada para ese vehiculo";
	}
	
}