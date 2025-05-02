package Main;

import Models.Automovil;
import Models.Camion;
import Models.Cliente;
import Models.Moto;
import Models.Vehiculo;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import Assets.Categoria;
import Assets.Membresia;
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
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenuIngresarVehiculo(opcion);
		}while (opcion !=0);
	}
	
	public static void validarMenuIngresarVehiculo(int opcion) {
		if(parqueadero.VerificarCupos(opcion)) { //Aquí ya le resté el cupo
			String placaTemp= JOptionPane.showInputDialog("Ingrese la placa del vehículo a registrar: ");
			if (opcion==1||opcion==2||opcion==3) {
				crearVehiculoTemporal(opcion, placaTemp);
			}else if(opcion==4||opcion==5||opcion==6) {
				String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo a registrar: ");
				String color = JOptionPane.showInputDialog("Ingrese el color del vehículo: ");
				String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo: ");
				Vehiculo vehiculoNuevo = crearVehiculoMembresia(opcion, placa, color, modelo);
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No ingresó ninguna opción válida");
			}
	}
	
	public static void crearVehiculoTemporal(int opcion, String placaTemp) {
		boolean canCrear = parqueadero.getVehiculosController().registrarVehiculo(opcion, placaTemp);
		mostrarMensaje(canCrear? "Registro existoso":"No se pudo hacer el registro");
	}
	
	public static Vehiculo crearVehiculoMembresia(int opcion, String placa, String color, String modelo) {
		Vehiculo vehiculoNuevo = parqueadero.getVehiculosController().registrarVehiculo(opcion,placa,color,modelo);
		return vehiculoNuevo;
	}
	
	public static Cliente crearCliente() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
		String id = JOptionPane.showInputDialog("Ingrese el id: ");
		String telefono = JOptionPane.showInputDialog("Ingrese el telefono: ");
		String correo = JOptionPane.showInputDialog("Ingrese el correo: ");
		LocalDateTime inicioMembresia = LocalDateTime.now();
		Boolean isActiva = true;
		
		
		
		String nombre, String id, String telefono, String correo, Membresia membresia
	}
	
	public static int menuTipoMembresia() {
		String menu="(1) ANUAL\n"
				+"(2) TRIMESTRAL\n"
				+"(3) MENSUAL";
		int opcion;
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return opcion;
		
	}
	public static Categoria crearMembresia() {
        int opcion = menuTipoMembresia();  
        Categoria membresia = null;
        switch (opcion) {
            case 1:
                membresia = Categoria.ANUAL; 
                break;
            case 2:
                membresia = Categoria.TRIMESTRAL;
                break;
            case 3:
                membresia = Categoria.MENSUAL;  
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
        }
        return membresia;
	}

	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public int calcularPagoVehiculo() {
		setHoraSalida(LocalDateTime.now());
        Duration duracion = Duration.between(getHoraEntrada(), getHoraSalida()); //Diferencia entre la hora de entrada y salida
        int minutosEstacionado = (int) duracion.toMinutes(); //Llevo esa diferencia a minutos
        int horasEstacionado = (int) Math.ceil(minutosEstacionado / 60.0); //Paso a horas y redondeo hacia arriba
        int valorPago = horasEstacionado * getTarifa().getTarifaAutomovil();                                                                     //Math.ceil trabaja con float, por lo que debo castear el dato
        return valorPago;
	}
	// menu que permite navegar en gestionar clients
	
	public static void menuGestionCliente() {
        String menu = "(1) Crear Cliente\n"
                     + "(2) Eliminar Cliente\n"
                     + "(3) Actualizar Cliente\n"
                     + "(4) Ver Vehículos de Cliente\n"
                     + "(5) Ver Clientes con Membresía Activa\n"
                     + "(6) Volver al Menú Principal";

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                	String nombre = JOptionPane.showInputDialog("Nombre:");
                    String id = JOptionPane.showInputDialog("ID:");
                    String telefono = JOptionPane.showInputDialog("Teléfono:");
                    String correo = JOptionPane.showInputDialog("Correo:");
                    Categoria membresia = seleccionarMembresia();
                    boolean creado = parqueadero.getClientesController().crearCliente(nombre, id, telefono, correo, membresia);
                    mostrarMensaje(creado ? "Cliente creado exitosamente" : "Ya existe un cliente con ese ID");
                    break;
                case 2:
                	id = JOptionPane.showInputDialog("ID del cliente a eliminar:");
                    boolean eliminado = parqueadero.getClientesController().eliminarCliente(id);
                    mostrarMensaje(eliminado ? "Cliente eliminado" : "Cliente no encontrado");  
                    break;
                case 3:
                	id = JOptionPane.showInputDialog("ID del cliente a actualizar:");
                    telefono = JOptionPane.showInputDialog("Nuevo teléfono:");
                    correo = JOptionPane.showInputDialog("Nuevo correo:");
                    membresia = seleccionarMembresia();
                    boolean actualizado = parqueadero.getClientesController().actualizarCliente(id, telefono, correo, membresia);
                    mostrarMensaje(actualizado ? "Cliente actualizado" : "Cliente no encontrado");
                    break;
                case 4:
                    verVehiculosDeCliente();  
                    break;
                case 5:
                    verClientesConMembresiaActiva();  
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Menu principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    
	        
	}



}
	// mostrar clientes con la una membresia activa
	
	public static void mostrarClientesConMembresiaActiva() {
	    String mensaje = "Clientes con membresía activa:\n";

	    for (Cliente cliente : parqueadero.getClientesController().clientes) {
	        if (cliente.getMembresia() != null && cliente.getMembresia().isActiva()) {
	            mensaje += "Nombre: " + cliente.getNombre() + "ID: " + cliente.getId() + "\n";
	        }
	    }

	    JOptionPane.showMessageDialog(null, mensaje);
	}
	 // Buscar el cliente por id para ver vehiculos
	
	public static void mostrarVehiculosDeCliente() {
	    String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente para ver sus vehículos:");

	    Cliente cliente = parqueadero.getClientesController().buscarCliente(idCliente);
	    
	    if (cliente != null) {
	        String mensaje = "Vehículos del cliente " + cliente.getNombre() + " (ID: " + cliente.getId() + "):\n";
	        
	        // Verificamoss si el cliente tiene vehículos:
	        if (cliente.getVehiculosCliente().isEmpty()) { //nos valida si la lista esta cvacia 
	            mensaje += "Este cliente no tiene vehículos registrados.";
	        } else {
	            // si la lista no esta vacia concatenamos los vehiculos por palaca
	            for (Vehiculo vehiculo : cliente.getVehiculosCliente()) {
	                mensaje += "Placa: " + vehiculo.getPlaca() + " | Tipo: " + vehiculo.getClass().getSimpleName() + "\n";
	            }
	        }
	        
	        // y ahora que estan concatenados los mostramos o decimos que no se encontro el cliente en caso tal
	        JOptionPane.showMessageDialog(null, mensaje);
	    } else {
	        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
	    }
	}
  
	}
