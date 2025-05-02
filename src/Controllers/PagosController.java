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
	private VehiculosController vehiculosController;
	/**algo parecido como tarifa service preguntar
	 como hago para que mi pagos controller pueda acceder 
	 a vehiculos controller* 
	 */
	private ArrayList<Pago> pagos;
	private TarifaService tarifas;
	
	public PagosController (Parqueadero parqueadero) {
		this.pagos= new ArrayList<>();
		this.tarifas=null;//todavia no se como va instanciado el tarifa service
	}
	
	public boolean actualizarTarifas(int tipoVehiculo, int tipoTarifa, int nuevaTarifa) {
		switch (tipoVehiculo) {
		case 1:
			if (tipoTarifa==1) {
				tarifas.setTarifaAutomovil(nuevaTarifa);
				return true;
			}else if (tipoTarifa==2) {
				tarifas.setAnualAutomovil(nuevaTarifa);
				return true;
			}else if (tipoTarifa==3) {
				tarifas.setTrimestralAutomovil(nuevaTarifa);
				return true;
			}else if (tipoTarifa==4) {
				tarifas.setMensualAutomovil(nuevaTarifa);
				return true;
			}else {
				return false;
			}
		case 2:
			if (tipoTarifa==1) {
				tarifas.setTarifaMoto(nuevaTarifa);
				return true;
			}else if (tipoTarifa==2) {
				tarifas.setAnualMoto(nuevaTarifa);
				return true;
			}else if (tipoTarifa==3) {
				tarifas.setTrimestralMoto(nuevaTarifa);
				return true;
			}else if (tipoTarifa==4) {
				tarifas.setMensualMoto(nuevaTarifa);
				return true;
			}else {
				return false;
			}
		case 3:
			if (tipoTarifa==1) {
				tarifas.setTarifaCamion(tipoTarifa);
				return true;
			}else if (tipoTarifa==2) {
				tarifas.setAnualCamion(nuevaTarifa);
				return true;
			}else if (tipoTarifa==3) {
				tarifas.setTrimestralCamion(nuevaTarifa);
				return true;
			}else if (tipoTarifa==4) {
				tarifas.setMensualCamion(nuevaTarifa);
				return true;
			}else {
				return false;
			}
		default:
			return false;
		}
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
	
	public String generarFactura(String idPago) { //Primero genero el pago y lo almaceno, de ahí mando el id e imprimo
		Pago pagoEncontrado = buscarPago(idPago);
		if (pagoEncontrado != null) {
			return pagoEncontrado.toString();
		}
		return "No hay factura generada para ese vehiculo";
	}
	
	public String obtenerHistorialPagoVehiculo(String placa) {
		String mensaje = null;
		for(Pago pago: this.pagos) {
			if (pago.getPlaca().equals(placa)) {
				mensaje+=pago.toString();
			}
		}
		return mensaje;
	}
	
	public int calcularIngresosTotales() {
		int ingresoTotal=0;
		for (Pago pago:this.pagos) {
			ingresoTotal+=pago.getIngreso();
		}
		return ingresoTotal;
	}
	
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

	public Pago buscarPago(String idPago) {
		for(Pago pago : this.pagos) {
			if(pago.getIdPago().equals(idPago)) {
				return pago;
			}
		}
		return null;
	}

	public VehiculosController getVehiculosController() {
		return this.vehiculosController;
	}

	public void setVehiculosController(VehiculosController vehiculosController) {
		this.vehiculosController = vehiculosController;
	}

	public ArrayList<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(ArrayList<Pago> pagos) {
		this.pagos = pagos;
	}

	public TarifaService getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(TarifaService tarifas) {
		this.tarifas = tarifas;
	}
}