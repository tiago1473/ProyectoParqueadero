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
			if(pago.getIdPago().equals(idPago.toUpperCase())) {
				return pago;
			}
		}
		return null;
	}
	
	/*Método para actualizar tarifas, el tipo de tarifa se le pide al usuario por pantalla, si desea cambiar la tarifa por 
	 * hora, anual, trimestral o mensual y que tambien mande el valor de la nueva tarifa
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
	
	public Pago registrarPago(String tipoVehiculo, String placa, LocalDateTime fechaInicio, 
			LocalDateTime fechaFin, int ingreso) {
			Pago pago = new Pago(tipoVehiculo,placa,fechaInicio,fechaFin,ingreso);
			this.pagos.add(pago);
			return pago;
	}
	
	public String generarFactura(String idPago) { 
		Pago pagoEncontrado = buscarPago(idPago.toUpperCase());
		if (pagoEncontrado != null) {
			return pagoEncontrado.toString();
		}
		return "No hay factura generada con ese ID de pago";
	}
	
	public String obtenerHistorialPagoVehiculo(String placa) {
		String mensaje = "El historial de pagos del vehiculo es el siguiente: \n";
		for(Pago pago: this.pagos) {
			if (pago.getPlaca().equals(placa)) {
				mensaje += pago.toString()+"\n";
			}
		}
		return mensaje;
	}
		
	public int calcularIngresosTotales() {
		int ingresoTotal = 0;
		for (Pago pago:this.pagos) {
			ingresoTotal+=pago.getIngreso();
		}
		return ingresoTotal;
	}
	
	
	public int verificarValorPagoMembresia(Vehiculo vehiculo, Categoria categoria) {
		int valorPagoMembresia = 0;
		if(vehiculo instanceof Automovil) {
			if(categoria.equals(Categoria.ANUAL)) {
				valorPagoMembresia = TarifaService.getTarifaAutomovil()[1];
			}
			if(categoria.equals(Categoria.TRIMESTRAL)) {
				valorPagoMembresia = TarifaService.getTarifaAutomovil()[2];
			}
			if(categoria.equals(Categoria.MENSUAL)) {
				valorPagoMembresia = TarifaService.getTarifaAutomovil()[3];
			}
		}
		if(vehiculo instanceof Moto) {
			if(categoria.equals(Categoria.ANUAL)) {
				valorPagoMembresia = TarifaService.getTarifaMoto()[1];
			}
			if(categoria.equals(Categoria.TRIMESTRAL)) {
				valorPagoMembresia = TarifaService.getTarifaMoto()[2];
			}
			if(categoria.equals(Categoria.MENSUAL)) {
				valorPagoMembresia = TarifaService.getTarifaMoto()[3];
			}
		}
		if(vehiculo instanceof Camion) {
			if(categoria.equals(Categoria.ANUAL)) {
				valorPagoMembresia = TarifaService.getTarifaCamion()[1];
			}
			if(categoria.equals(Categoria.TRIMESTRAL)) {
				valorPagoMembresia = TarifaService.getTarifaCamion()[2];
			}
			if(categoria.equals(Categoria.MENSUAL)) {
				valorPagoMembresia = TarifaService.getTarifaCamion()[3];
			}
		}
		return valorPagoMembresia;
	}
}