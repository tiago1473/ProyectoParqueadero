package Controllers;
import Models.Automovil;
import Models.Camion;
import Models.Moto;
import Models.Pago;
import Models.TarifaService;
import Models.Vehiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Assets.Categoria;

public class PagosController {	
	private ArrayList<Pago> pagos;
	
	public PagosController (Parqueadero parqueadero) {
		this.pagos= new ArrayList<>();
	}
	
	public ArrayList<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(ArrayList<Pago> pagos) {
		this.pagos = pagos;
	}
	
	public void registrarPago(Pago pago) {
		this.pagos.add(pago);
	}
	
	public Pago buscarPago(String idPago) {
		for(Pago pago : this.pagos) {
			if(pago.getIdPago().equals(idPago)) {
				return pago;
			}
		}
		return null;
	}
	
	/**Metodo para actualizar las tarifas
	 * @param tipoVehiculo - tarifa que se quiere actualizar (Automovil, Moto, Camion)
	 * @param tipoTarifa - tipo de tarifa que se quiere actualizar (hora, anual, trimestral, mensual)
	 * @param nuevaTarifa - tarifa nueva
	 * @return true/false
	 */
	
	public boolean actualizarTarifas(int tipoVehiculo, int tipoTarifa, int nuevaTarifa) {
		switch (tipoVehiculo) {
		case 1:
			TarifaService.setTarifaAutomovil(tipoTarifa, nuevaTarifa);
			return true;
		case 2:
			TarifaService.setTarifaMoto(tipoTarifa, nuevaTarifa);
			return true;
		case 3:
			TarifaService.setTarifaCamion(tipoTarifa, nuevaTarifa);
			return true;
		default:
			return false;
		}
	}
	
	/**Método para registrar el pago de un vehiculo y añadir a la lista de pagos
	 * @param idPago - Consecutivo a discreción del usuario
	 * @param tipoVehiculo - Si el vehiculo es automovil, moto o camion
	 * @param placa
	 * @param fechaInicio - fecha de entrada o fecha de inicio de membresia
	 * @param fechaFin - fecha de salida o fecha de fin de membresia
	 * @param ingreso - Valor del pago por estadia temporal o membresia
	 * @return true/false
	 */
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
	
	/**Método para generar la factura nuevamente conociendo el id del pago
	 * @param idPago - Consecutivo a discreción del usuario definido cuando crea la factura por primera vez
	 * @return String - datos específicos de la factura
	 */
	
	public String generarFactura(String idPago) { 
		Pago pagoEncontrado = buscarPago(idPago);
		if (pagoEncontrado != null) {
			return pagoEncontrado.toString();
		}
		return "No hay factura generada para ese vehiculo";
	}
	
	/**Método para obtener el historial de pagos de un vehiculo específico
	 * @param placa - del vehiculo al que se le quiere conocer el historial de pagos
	 * @return String - pagos asociados a una placa 
	 */
	
	public String obtenerHistorialPagoVehiculo(String placa) {
		String mensaje = null;
		for(Pago pago: this.pagos) {
			if (pago.getPlaca().equals(placa)) {
				mensaje+=pago.toString();
			}
		}
		return mensaje;
	}
	
	/**Método para obtener los ingresos totales obtenidos por el parqueadero recorriendo la lista de pagos 
	 * @return int - Sumatoria del valor de los ingresos generados en el momento en que se corra el método
	 */
	
	public int calcularIngresosTotales() {
		int ingresoTotal=0;
		for (Pago pago:this.pagos) {
			ingresoTotal+=pago.getIngreso();
		}
		return ingresoTotal;
	}
	
		//OJO REVISAR LA CLASE TARIFA SERVICE QUE CAMBIO ENTONCES ESTE MÉTODO CAMBIA
	public  int verificarValorPagoMembresia(Vehiculo vehiculo, Categoria categoria) {
		int valorPagoMembresia = 0;
		if(vehiculo instanceof Automovil) {
			if(categoria.equals(Categoria.ANUAL)) {
				valorPagoMembresia = tarifas.getAnualAutomovil();
			}
			if(categoria.equals(Categoria.TRIMESTRAL)) {
				valorPagoMembresia = tarifas.getTrimestralAutomovil();
			}
			if(categoria.equals(Categoria.MENSUAL)) {
				valorPagoMembresia = tarifas.getMensualAutomovil();
			}
		}
		if(vehiculo instanceof Moto) {
			if(categoria.equals(Categoria.ANUAL)) {
				valorPagoMembresia = tarifas.getAnualMoto();
			}
			if(categoria.equals(Categoria.TRIMESTRAL)) {
				valorPagoMembresia = tarifas.getTrimestralMoto();
			}
			if(categoria.equals(Categoria.MENSUAL)) {
				valorPagoMembresia = tarifas.getMensualMoto();
			}
		}
		if(vehiculo instanceof Camion) {
			if(categoria.equals(Categoria.ANUAL)) {
				valorPagoMembresia = tarifas.getAnualCamion();
			}
			if(categoria.equals(Categoria.TRIMESTRAL)) {
				valorPagoMembresia = tarifas.getTrimestralCamion();
			}
			if(categoria.equals(Categoria.MENSUAL)) {
				valorPagoMembresia = tarifas.getMensualCamion();
			}
		}
		return valorPagoMembresia;
	}
	
	public int verificarValorPagoMembresia(Vehiculo vehiculo, Categoria categoria) 
}