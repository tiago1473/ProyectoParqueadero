package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.Automovil;
import Models.Camion;
import Models.Cliente;
import Models.Moto;
import Models.Vehiculo;

public class VehiculosController {
	public ArrayList<Vehiculo> vehiculosHora;
	public ArrayList<Vehiculo> vehiculosMembresia;
	
	public VehiculosController(Parqueadero parqueadero) {
		this.vehiculosHora = new ArrayList<>();
		this.vehiculosMembresia = new ArrayList<>();		
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
	public boolean registrarVehiculo(int opcion, String placa) {
		Vehiculo vehiculoHallado = buscarVehiculo(placa);
		if (vehiculoHallado == null) {
			switch (opcion) { //El Default ya lo trae por defecto en el método de registrarVehiculo de Parqueadero
			case 1:
				Automovil automovilNuevo = new Automovil(placa);
				this.vehiculosHora.add(automovilNuevo);
				return true;
			case 2:
				Moto motoNueva = new Moto(placa);
				this.vehiculosHora.add(motoNueva);
				return true;	
			case 3:
				Camion camionNuevo = new Camion(placa);
				this.vehiculosHora.add(camionNuevo);
				return true;	
			}
		}
		return false;
	}
	
	public Vehiculo registrarVehiculo(int opcion, String placa, String color, String modelo) {
		Vehiculo vehiculoHallado = buscarVehiculo(placa);
		if (vehiculoHallado == null) {
			switch (opcion) { //El Default ya lo trae por defecto en el método de registrarVehiculo de Parqueadero
			case 4:
				Automovil automovilNuevo = new Automovil(placa,color,modelo);
				this.vehiculosMembresia.add(automovilNuevo);
				return automovilNuevo;
			case 5:
				Moto motoNueva = new Moto(placa,color,modelo);
				this.vehiculosMembresia.add(motoNueva);
				return motoNueva;	
			case 6:
				Camion camionNuevo = new Camion(placa,color,modelo);
				this.vehiculosMembresia.add(camionNuevo);
				return camionNuevo;	
			default:
				JOptionPane.showInternalMessageDialog(null, "Tipo de vehículo inválido");
				return null;
			}
		}
		 JOptionPane.showInternalMessageDialog(null, "No fue posible registrar el vehículo: ya existe");
		    return null;
	}
	
}
