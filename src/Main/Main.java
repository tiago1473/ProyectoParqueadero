package Main;

import Models.Automovil;
import Models.Camion;
import Models.Cliente;
import Models.Moto;
import Models.Vehiculo;
import javax.swing.JOptionPane;

import Controllers.Parqueadero;

public class Main {
	
	public static Parqueadero parqueadero= new Parqueadero(
			JOptionPane.showInputDialog("Ingrese el nombre del Parqueadero: "),
			JOptionPane.showInputDialog("Ingrese la dirección del Parqueadero: "),
			JOptionPane.showInputDialog("Ingrese el representante del Parqueadero: "),
			JOptionPane.showInputDialog("Ingrese el teléfono del Parqueadero: "),
			JOptionPane.showInputDialog("Ingrese el email del Parqueadero: "),
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese los cupos de autos del parqueadero: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese los cupos de motos del parqueadero: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese los cupos de camiones del parqueadero: ")));
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void menuIngresarVehiculo() {
		String menu="(1)Ingreso automovil temporal:\n"
				+"(2)Ingreso moto temporal:\n"
				+"(3)Ingreso camión temporal:\n"
				+"(4) Ingreso membresía automovil:\n"
				+"(5) Ingreso membresía moto:\n"
				+"(6) Ingreso membresía camión:\n"
				+"(7) Volver al menú principal:\n";
		int opcion;
		do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenuIngresarVehiculo(opcion);
		}while (opcion !=0);
	}
	
	public static void validarMenuIngresarVehiculo(int opcion) {
		String placaTemp= JOptionPane.showInputDialog("Ingrese la placa del vehículo a registrar: ");
		if (opcion==1||opcion==2||opcion==3) {
			crearVehiculoTemporal(opcion,placaTemp);
			}else if(opcion==4||opcion==5||opcion==6) {
				String nombre=JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
				//SE DEBE CREAR EL METODO Y PEDIR TODOS LOS DATOS DEL CLIENTE INCLUYENDO EL ENUM MEMBRESIA
				Cliente cliente=añadirCliente()//OJO ESTE METODO FALTA CREARLO
				String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo a registrar: ");
				String color= JOptionPane.showInputDialog("Ingrese el color del vehículo: ");
				String modelo= JOptionPane.showInputDialog("Ingrese el modelo del vehículo: ");
				crearMembresia(opcion,placa,color,modelo,cliente);
			}else {
				JOptionPane.showMessageDialog(null, "No ingreso ninguna opción válida");
			}
	}
	
	public static void crearVehiculoTemporal(String opcion,String placaTemp) {
		boolean canCrear=parqueadero.getVehiculosController().registrarVehiculo(opcion, placaTemp);
		mostrarMensaje(canCrear? "Registro existoso":"No se pudo hacer el registro");
	}
	
	public static void crearMembresia(String opcion,String placa, String color, String modelo, Cliente cliente) {
		boolean canCrear=parqueadero.getVehiculosController().registrarVehiculo(opcion,placa,color,modelo,cliente);
		mostrarMensaje(canCrear? "Registro existoso":"No se pudo hacer el registro");
	}
	
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
