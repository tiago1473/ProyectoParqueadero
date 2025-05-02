package Main;

import Models.Automovil;
import Models.Camion;
import Models.Cliente;
import Models.Membresia;
import Models.Moto;
import Models.Pago;
import Models.Vehiculo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Assets.Categoria;
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
		String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo a registrar: ");
		if (opcion == 1 || opcion == 2 || opcion == 3 && parqueadero.verificarCupos(opcion)) { //Valido que sea temporal y resto el cupo
			IngresarVehiculoTemporal(opcion, placa);
		}
		if(opcion == 4|| opcion == 5|| opcion == 6) {
			Vehiculo vehiculoHallado = parqueadero.getVehiculosController().buscarVehiculoMembresia(placa); 
			if (vehiculoHallado != null && vehiculoHallado.getMembresia().getIsActiva()){
				JOptionPane.showMessageDialog(null, "Ingresa vehiculo con membresía activa");
				break;
			} 
			else if (vehiculoHallado != null && vehiculoHallado.getMembresia().getIsActiva() == false){
				String idPago = JOptionPane.showInputDialog(null, "Ingrese el Id del Pago de la Membresia");
				String tipoVehiculo = vehiculoHallado.getClass().getName(); //Obtiene la clase, especificamente su nombre y la vuelve a formato string
				Membresia membresia = crearMembresia();
				vehiculoHallado.setMembresia(membresia); //Modifico la membresia vieja por la nueva con datos actualizados
				Categoria categoriaMembresia = membresia.getCategoria();
				int pagoMembresia = parqueadero.getPagosController().verificarValorPagoMembresia(vehiculoHallado, categoriaMembresia);
				parqueadero.getPagosController().registrarPago(idPago, tipoVehiculo, placa, membresia.getFechaInicio(), membresia.getFechaFin(), pagoMembresia); //Pago Registrado
				parqueadero.getPagosController().generarFactura(idPago); //Genero la factura
			}
			else if(vehiculoHallado == null && parqueadero.verificarCupos(opcion)) { //Aquí ya le resté y validé el cupo
				String color = JOptionPane.showInputDialog("Ingrese el color del vehiculo: ");
				String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo: ");
				Membresia membresia = crearMembresia();
				Vehiculo vehiculoRegistrado = crearVehiculoMembresia(opcion, placa, color, modelo, membresia); //Añade el vehiculo a la lista de vehiculosMembresia
				Cliente nuevoCliente = crearCliente(); //Agregar el cliente a la lista de clientes
				nuevoCliente.agregarVehiculoCliente(vehiculoRegistrado); //Le agrego el vehiculo al cliente
				Categoria categoriaMembresia = membresia.getCategoria();
				String idPago = JOptionPane.showInputDialog(null, "Ingrese el Id del Pago de la Membresia");
				String tipoVehiculo = vehiculoRegistrado.getClass().getName();
				int pagoMembresia = parqueadero.getPagosController().verificarValorPagoMembresia(vehiculoRegistrado, categoriaMembresia);
				parqueadero.getPagosController().registrarPago(idPago, tipoVehiculo, placa, membresia.getFechaInicio(), membresia.getFechaFin(), pagoMembresia);
				parqueadero.getPagosController().generarFactura(idPago); //Genero la factura
			}
		}
	}
	
	public static Cliente crearCliente() {
        String nombre = JOptionPane.showInputDialog("Nombre: ");
        String id = JOptionPane.showInputDialog("Id: ");
        String telefono = JOptionPane.showInputDialog("Teléfono: ");
        String correo = JOptionPane.showInputDialog("Correo: ");
        Cliente clienteCreado = parqueadero.getClientesController().crearCliente(nombre, id, telefono, correo);
        String mensaje = "";
        if(clienteCreado != null) {
        	mensaje = "No fue posible registrar el cliente";
        	mostrarMensaje(mensaje);
        }else {
        	mensaje = "Cliente registrado";
        	mostrarMensaje(mensaje);
        }
        return clienteCreado;
	}

	public static int menuCategoriaMembresia() {
		String menu="(1) ANUAL\n"
				+"(2) TRIMESTRAL\n"
				+"(3) MENSUAL";
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return opcion;
	}
	
	public static Categoria categoriaMembresia() {
        int opcion = menuCategoriaMembresia();  
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
	
	public static Membresia crearMembresia() {
		JOptionPane.showMessageDialog(null, "Seleccione la Categoría de la Membresía");
		Categoria categoriaMembresia = categoriaMembresia();
		LocalDateTime fechaInicio = LocalDateTime.now();
		LocalDateTime fechaFin;
		switch(categoriaMembresia){
			case ANUAL:
				fechaFin = fechaInicio.plusYears(1); //Agrega un año a la fecha de inicio
				break;
			case TRIMESTRAL:
				fechaFin = fechaInicio.plusMonths(3);
				break;
			case MENSUAL:
				fechaFin = fechaInicio.plusMonths(1);
				break;  //No creo que exista un default porque la opción invalida ya está puesta en el método crearMembresia
		}
		Boolean isActiva = true;
		Membresia membresia = new Membresia(fechaInicio, fechaFin, isActiva, categoriaMembresia);
		return membresia;
	}
	
	public static void IngresarVehiculoTemporal(int opcion, String placaTemp) {
		boolean canCrear = parqueadero.getVehiculosController().registrarVehiculo(opcion, placaTemp);
		mostrarMensaje(canCrear? "Registro existoso":"No se pudo hacer el registro");
	}
	
	public static Vehiculo crearVehiculoMembresia(int opcion, String placa, String color, String modelo, Membresia membresia) {
		Vehiculo vehiculoNuevo = parqueadero.getVehiculosController().registrarVehiculo(opcion,placa,color,modelo,membresia);
		return vehiculoNuevo;
	}
	
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
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
