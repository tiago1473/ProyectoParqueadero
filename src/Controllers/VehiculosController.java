package Controllers;

import java.util.ArrayList;
import Models.Automovil;
import Models.Camion;
import Models.Moto;
import Models.Vehiculo;

public class VehiculosController {
	public ArrayList<Vehiculo> vehiculosHora;
	
	public VehiculosController() {
		this.vehiculosHora = new ArrayList<>();
	}
	
	public Vehiculo buscarVehiculo(String placa) {
		for(Vehiculo vehiculo : this.vehiculosHora) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

	//Puedo hacer que desde el Main me mande el tipo de vehiculo a Registrar por Hora
	public Boolean registrarVehiculo(String tipoVehiculo, String placa) {
		Vehiculo vehiculoHallado = buscarVehiculo(placa);
		if (vehiculoHallado == null) {
			switch (tipoVehiculo) { //El Default ya lo trae por defecto en el método de registrarVehiculo de Parqueadero
			case "1":
				Automovil automovilNuevo = new Automovil(placa);
				this.vehiculosHora.add(automovilNuevo);
				return true;
			case "2":
				Moto motoNueva = new Moto(placa);
				this.vehiculosHora.add(motoNueva);
				return true;	
			case "3":
				Camion camionNuevo = new Camion(placa);
				this.vehiculosHora.add(camionNuevo);
				return true;	
			}
		}
		return false;
	}
	
	

}
