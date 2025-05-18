package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.Automovil;
import Models.Camion;
import Models.Membresia;
import Models.Moto;
import Models.Vehiculo;

public class VehiculosController {
	public ArrayList<Vehiculo> vehiculosHora;
	public ArrayList<Vehiculo> vehiculosMembresia;
	
	public VehiculosController(Parqueadero parqueadero) {
		this.vehiculosHora = new ArrayList<>();
		this.vehiculosMembresia = new ArrayList<>();		
	}
	
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
	
	public Vehiculo registrarVehiculo(int opcion, String placa, String color, String modelo, Membresia membresia) {
		Vehiculo vehiculoHallado = buscarVehiculo(placa);
		if (vehiculoHallado == null) {
			switch (opcion) { //El Default ya lo trae por defecto en el método de registrarVehiculo de Parqueadero
			case 4:
				Automovil automovilNuevo = new Automovil(placa, color, modelo, membresia);
				this.vehiculosMembresia.add(automovilNuevo);
				return automovilNuevo;
			case 5:
				Moto motoNueva = new Moto(placa, color, modelo, membresia);
				this.vehiculosMembresia.add(motoNueva);
				return motoNueva;	
			case 6:
				Camion camionNuevo = new Camion(placa, color, modelo, membresia);
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
	
	public ArrayList<Vehiculo> getVehiculosHora() {
		return this.vehiculosHora;
	}

	public void setVehiculosHora(ArrayList<Vehiculo> vehiculosHora) {
		this.vehiculosHora = vehiculosHora;
	}

	public ArrayList<Vehiculo> getVehiculosMembresia() {
		return this.vehiculosMembresia;
	}

	public void setVehiculosMembresia(ArrayList<Vehiculo> vehiculosMembresia) {
		this.vehiculosMembresia = vehiculosMembresia;
	}
	
	public Vehiculo buscarVehiculo(String placa) {
		for(Vehiculo vehiculo : this.vehiculosHora) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}
	
	public Vehiculo buscarVehiculoMembresia(String placa) {
		for(Vehiculo vehiculo : this.vehiculosMembresia) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}
	
	public boolean actualizarVehiculo(String placa, String placaNueva, String color, String modelo) {
		Vehiculo vehiculoHallado = buscarVehiculoMembresia(placa);
		if(vehiculoHallado != null) {
			vehiculoHallado.setPlaca(placaNueva);
			vehiculoHallado.setColor(color);
			vehiculoHallado.setModelo(modelo);
			return true;
		}
		return false;
	}
	
	public boolean eliminarVehiculoTemporal(String placa) {
		Vehiculo vehiculoHallado = buscarVehiculo(placa);
		if(vehiculoHallado != null) {
			this.vehiculosHora.remove(vehiculoHallado);
			return true;
		}
		return false;		
	}
	
	public boolean eliminarVehiculoMembresia(String placa) {
		Vehiculo vehiculoHallado = buscarVehiculoMembresia(placa);
		if(vehiculoHallado != null) {
			this.vehiculosMembresia.remove(vehiculoHallado);
			return true;
		}
		return false;		
	}
	
	public String verVehiculos() {
		String mensaje="Los vehiculos registrados con membresía son los siguientes: \n";
		for (Vehiculo v:this.vehiculosMembresia) {
			mensaje+=v.toString()+"\n";
		}
		mensaje+="\nLos vehiculos registrados por hora son los siguientes: \n";
		for (Vehiculo v:this.vehiculosHora) {
			mensaje+=v.toStringTemporal()+"\n";
		}
		return mensaje;
	}
}
