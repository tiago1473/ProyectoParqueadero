package Main;

import Models.Cliente;
import Models.Membresia;
import Models.Pago;
import Models.TarifaService;
import Models.Vehiculo;
import java.time.LocalDateTime;
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
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese los cupos de camiones del parqueadero: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese las tarifas de los automoviles en el siguiente orden: \nHora: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Anual: ")), Integer.parseInt(JOptionPane.showInputDialog("Trimestral: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Mensual: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese las tarifas de las motos en el siguiente orden: \nHora: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Anual: ")), Integer.parseInt(JOptionPane.showInputDialog("Trimestral: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Mensual: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Ingrese las tarifas de los camiones en el siguiente orden: \nHora: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Anual: ")),Integer.parseInt(JOptionPane.showInputDialog("Trimestral: ")),
			Integer.parseInt(JOptionPane.showInputDialog("Mensual: ")));		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, parqueadero.toString());
		JOptionPane.showMessageDialog(null, TarifaService.mostrarTarifas());
		menuPrincipal();
	}
	
	//MENU PRINCIPAL DEL USUARIO
	
	public static void menuPrincipal() {
		String menu="(1) Ingresar Vehículo:\n"
				+"(2) Dar Salida a Vehículo:\n"
				+"(3) Gestionar Clientes:\n"
				+"(4) Gestionar Vehículos:\n"
				+"(5) Gestionar Parqueadero:\n"
				+"(6) Salir:\n";
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenuPrincipal(opcion);
		}while (opcion !=6);
	}
	
	public static void validarMenuPrincipal(int opcion) {
		switch (opcion) {
		case 1:
			menuIngresarVehiculo();
			break;
		case 2:
			menuRetirarVehiculo();
			break;
		case 3:
			menuGestionarClientes();
			break;
		case 4:
			menuGestionarVehiculos();
			break;
		case 5:
			menuGestionarParqueadero();
			break;
		case 6:
			mostrarMensaje("Saliendo del programa");
			break;
		default:
			mostrarMensaje("No ingresó ninguna opción válida");
			break;
		}
	}
		
	//MENU INGRESAR VEHICULO
	public static void menuIngresarVehiculo() {
		String menu="(1) Ingreso Automovil Temporal:\n"
				+"(2) Ingreso Moto Temporal:\n"
				+"(3) Ingreso Camión Temporal:\n"
				+"(4) Ingreso Membresía Automovil:\n"
				+"(5) Ingreso Membresía Moto:\n"
				+"(6) Ingreso Membresía Camión:\n"
				+"(7) Volver al Menú Principal:\n";
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenuIngresarVehiculo(opcion);
		}while (opcion !=7);
	}
		
	public static void validarMenuIngresarVehiculo(int opcion) {
		switch (opcion) {
			case 1:
			case 2:
			case 3: {
				String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
				if (parqueadero.verificarCupos(opcion)) { //Valido que sea temporal y resto el cupo
					IngresarVehiculoTemporal(opcion, placa);
				}else {
					JOptionPane.showInternalMessageDialog(null, "No hay cupos para el vehículo");
				}
				break;
			}
			case 4:
			case 5:
			case 6: {
				String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
				Vehiculo vehiculoHallado = parqueadero.getVehiculosController().buscarVehiculoMembresia(placa); 
				if (vehiculoHallado != null && vehiculoHallado.getMembresia().getIsActiva()){
					JOptionPane.showMessageDialog(null, "Ingresa vehículo con membresía activa");
				}
				if (vehiculoHallado != null && vehiculoHallado.getMembresia().getIsActiva() == false){ //No resto el cupo del vehiculo porque va a pagar la membresia
					String idCliente = JOptionPane.showInputDialog(null, "Ingrese el Id del cliente");
					Cliente clienteHallado = parqueadero.getClientesController().buscarCliente(idCliente);
					parqueadero.getVehiculosController().eliminarVehiculoMembresia(placa); //Elimino el vehiculo del dentro de la lista de vehiculos de vehiculosController
		            clienteHallado.eliminarVehiculoCliente(placa);                         //Elimino el vehiculo del dentro de la lista de vehiculos del cliente
		            registrarVehiculoConMembresia(opcion, placa, clienteHallado);
		        }
				if (vehiculoHallado == null && parqueadero.verificarCupos(opcion)) { //Aquí ya le resté y validé el cupo
					String idCliente = JOptionPane.showInputDialog(null, "Ingrese el Id del cliente"); //Busco el cliente si existe y solo le añado el vehiculo, sino, debo crear el cliente
					Cliente clienteHallado = parqueadero.getClientesController().buscarCliente(idCliente);
					if (clienteHallado != null) {   
						registrarVehiculoConMembresia(opcion, placa, clienteHallado);
					}else {
						Cliente nuevoCliente = crearCliente(idCliente); // Crea y Agrega el cliente a la lista de clientes
						registrarVehiculoConMembresia(opcion, placa, nuevoCliente);
					}
				}else {
	                JOptionPane.showMessageDialog(null, "No hay cupos disponibles para este tipo de vehículo.");		
				}
				break;
			}
			case 7:
				break;
			default:
	            JOptionPane.showMessageDialog(null, "Opción inválida");
	            break;
		}
	}
	
	public static void IngresarVehiculoTemporal(int opcion, String placaTemp) {
		boolean canCrear = parqueadero.getVehiculosController().registrarVehiculo(opcion, placaTemp);
		mostrarMensaje(canCrear? "Registro exitoso":"No se pudo hacer el registro, ya existe el vehículo");
	}
	
	public static Cliente crearCliente(String idCliente) {
        String nombre = JOptionPane.showInputDialog("Nombre: ");
        String telefono = JOptionPane.showInputDialog("Teléfono: ");
        String correo = JOptionPane.showInputDialog("Correo: ");
        Cliente clienteCreado = parqueadero.getClientesController().crearCliente(nombre, idCliente, telefono, correo);
        if(clienteCreado != null) {
        	mostrarMensaje("Cliente creado exitosamente");
        }else {
        	mostrarMensaje("No fue posible registrar el cliente");
        }
        return clienteCreado;
	}
	
	private static void registrarVehiculoConMembresia(int opcion, String placa, Cliente cliente) {
		String color = JOptionPane.showInputDialog("Ingrese el color del vehículo: ");
		String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo: ");
		Membresia membresia = crearMembresia();
		Vehiculo vehiculoRegistrado = crearVehiculoMembresia(opcion, placa, color, modelo, membresia); //Añade el vehiculo a la lista de vehiculosMembresia
		cliente.agregarVehiculoCliente(vehiculoRegistrado); //Le agrego el vehiculo al cliente
		Categoria categoriaMembresia = membresia.getCategoria();
		String tipoVehiculo = vehiculoRegistrado.getClass().getSimpleName(); //getName() me atrae tambien el nombre del paquete donde se cuarda la clase, getSimpleName() solo llama el nombre de la clase
		int pagoMembresia = parqueadero.getPagosController().verificarValorPagoMembresia(vehiculoRegistrado, categoriaMembresia);
		Pago pago = parqueadero.getPagosController().registrarPago(tipoVehiculo, placa, membresia.getFechaInicio(), membresia.getFechaFin(), pagoMembresia);
		JOptionPane.showMessageDialog(null, "Pago registrado exitosamente");
		mostrarMensaje(parqueadero.getPagosController().generarFactura(pago.getIdPago())); //Genero la factura
	}
	
	public static Membresia crearMembresia() {
		JOptionPane.showMessageDialog(null, "Seleccione la Categoría de la Membresía");
		Categoria categoriaMembresia = categoriaMembresia();
		LocalDateTime fechaInicio = LocalDateTime.now();
		LocalDateTime fechaFin = LocalDateTime.now(); //Se establece con la fecha del momento y en el swtich se modifica
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
                JOptionPane.showMessageDialog(null, "Opción inválida, intente crear nuevamente la membresía");
                menuCategoriaMembresia();
        }
        return membresia;
	}
	
	public static int menuCategoriaMembresia() {
		String menu="(1) ANUAL\n"
				+"(2) TRIMESTRAL\n"
				+"(3) MENSUAL";
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return opcion;
	}
	
	public static Vehiculo crearVehiculoMembresia(int opcion, String placa, String color, String modelo, Membresia membresia) {
		Vehiculo vehiculoNuevo = parqueadero.getVehiculosController().registrarVehiculo(opcion,placa,color,modelo,membresia);
		return vehiculoNuevo;
	}
	
	//MENU RETIRO VEHICULO
	public static void menuRetirarVehiculo() {
		String menu="(1) Retiro Vehículo Temporal:\n"
					+"(2) Retiro Vehículo con Membresía:\n"
					+"(3) Volver al Menú Principal:\n";
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenuRetirarVehiculo(opcion);
		}while(opcion !=3);
	}
		
	public static void validarMenuRetirarVehiculo(int opcion) {
		String placa;
		switch (opcion) {
			case 1:
				placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
				Vehiculo vehiculoHallado = parqueadero.getVehiculosController().buscarVehiculo(placa);
				if (vehiculoHallado != null) {
					String tipoVehiculo = vehiculoHallado.getClass().getSimpleName();
					vehiculoHallado.setHoraSalida(LocalDateTime.now()); //Modifico la hora de salida para luego llamarla
					int valorPago = vehiculoHallado.calcularPagoVehiculo();
					Pago pago = parqueadero.getPagosController().registrarPago(tipoVehiculo, placa, vehiculoHallado.getHoraEntrada(), vehiculoHallado.getHoraSalida(), valorPago);
					JOptionPane.showMessageDialog(null, "Pago registrado exitosamente");
					mostrarMensaje(parqueadero.getPagosController().generarFactura(pago.getIdPago())); //Genero la factura
					parqueadero.liberarCupos(vehiculoHallado); //Libero el cupo según la instancia
					parqueadero.getVehiculosController().eliminarVehiculoTemporal(placa);
				}
				break;
			case 2:	
				placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
				Vehiculo vehiculoHalladoMembresia = parqueadero.getVehiculosController().buscarVehiculoMembresia(placa);
				if (vehiculoHalladoMembresia != null) {
					JOptionPane.showMessageDialog(null, "Sale vehículo con membresía");
				}else {
					JOptionPane.showMessageDialog(null, "El vehículo no tiene membresia");
				}
				break;
			case 3:
				break;
			default:
				mostrarMensaje("Opción invalida");
				break;
		}
	}
	
	
	//MENU PARA GESTION DE CLIENTES
	public static void menuGestionarClientes() {
        String menu = "(1) Eliminar Cliente\n"
                     + "(2) Actualizar Cliente\n"
                     + "(3) Ver Vehículos de Cliente\n"
                     + "(4) Ver Clientes con Membresía Activa\n"
                     + "(5) Volver al Menú Principal";
        
        int opcion;
		do {opcion= Integer.parseInt(capturarDato(menu));
			validarMenuGestionarClientes(opcion);
		}while (opcion!=5);
	}

	
	public static void validarMenuGestionarClientes(int opcion) {
		switch (opcion) {
		case 1:
			//(1) Eliminar Cliente
			boolean canEliminar = parqueadero.getClientesController().eliminarCliente(capturarDato("Ingrese la identificación del cliente que desea eliminar: "));
			mostrarMensaje(canEliminar?"Se eliminó el cliente":"No se pudo eliminar el cliente");
			break;
		case 2:
			//(2) Actualizar Cliente
			boolean canActualizar=parqueadero.getClientesController().actualizarCliente(capturarDato("Ingrese la identificación del cliente que desea actualizar: "),
					capturarDato("Ingrese el teléfono actualizado: "), capturarDato("Ingrese el correo actualizado: "));
			mostrarMensaje(canActualizar?"Se actualizaron los datos del cliente exitosamente":"No se pudo realizar la actualización");
			break;
		case 3:
			//(3) Ver Vehículos de Cliente
			String mensajeVehiculo=parqueadero.getClientesController().verVehiculosCliente(capturarDato("Ingrese la identificación del cliente del que desea ver los vehiculos: "));
			mostrarMensaje(mensajeVehiculo);
			break;
		case 4:
			//(4) Ver Clientes con Membresia activa
			mostrarMensaje(parqueadero.getClientesController().verClientesMembresiaActiva());
			break;
		case 5:
			//(5) Volver al menú principal
			break;
		default:
			mostrarMensaje("Opción invalida");
			break;
		}
	}
	
	
	//MENU PARA GESTION DE VEHICULOS
	public static void menuGestionarVehiculos() {
		String menu="(1) Actualizar Datos de Vehiculo con Membresía: \n"
				+"(2) Ver Estado Membresía de un Vehículo\n"
				+"(3) Eliminar Vehiculo Temporal: \n"
				+"(4) Eliminar Vehiculo con Membresía: \n"
				+"(5) Ver Vehiculos del Parqueadero: \n"
				+"(6) Volver al Menú Principal: \n";
		
		int opcion;
		do {opcion= Integer.parseInt(capturarDato(menu));
			validarMenuGestionarVehiculos(opcion);
		}while (opcion!=6);
		}
	
	public static void validarMenuGestionarVehiculos(int opcion) {
		switch (opcion) {
		case 1:
			//(1) Actualizar Datos de Vehiculo con Membresia
			boolean canActualizar=parqueadero.getVehiculosController().actualizarVehiculo(capturarDato("Ingrese la placa del vehículo que quiere "
					+ "actualizar: "),capturarDato("Ingrese la placa actualizada: "), capturarDato("Ingrese el color actualizado: "),
					capturarDato("Ingrese el modelo actualizado: "));
			mostrarMensaje(canActualizar?"Se actualizaron los datos exitosamente":"No se pudo realizar la actualización");
			break;
		case 2:
			//(2) Actualizar Membresía de un Vehiculo
			String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo a actualizar membresía: ");
			Vehiculo vehiculoHalladoMembresia = parqueadero.getVehiculosController().buscarVehiculoMembresia(placa);
			if(vehiculoHalladoMembresia != null) {
				vehiculoHalladoMembresia.getMembresia().getIsActiva(); //Actualiza la membresía
				JOptionPane.showMessageDialog(null, vehiculoHalladoMembresia.getMembresia());
			}else {
				JOptionPane.showMessageDialog(null, "Vehículo no encontrado, verifique la placa ingresada");
			}
			break;
		case 3:
			//(3) Eliminar Vehiculo Temporal
			boolean canEliminar=parqueadero.getVehiculosController().eliminarVehiculoTemporal(capturarDato("Ingrese la placa del vehículo temporal que desea eliminar"));
			mostrarMensaje(canEliminar?"Se eliminó el vehículo":"No se pudo eliminar el vehículo");
			break;
		case 4:
			//(4) Eliminar Vehiculo con Membresia
			boolean canEliminar2=parqueadero.getVehiculosController().eliminarVehiculoMembresia(capturarDato("Ingrese la placa del vehículo con "
					+ "membresia que desea eliminar"));
			mostrarMensaje(canEliminar2?"Se eliminó el vehículo":"No se pudo eliminar el vehículo");
			break;
		case 5:
			//(5) Ver Vehiculos del Parqueadero
			mostrarMensaje(parqueadero.getVehiculosController().verVehiculos());
		case 6:
			//(6) Volver al menú principal
			break;
		default:
			mostrarMensaje("No ingresó ninguna opción válida");
			break;
		}
	}
	
	
	//MENU PARA GESTION DE PARQUEADERO
	public static void menuGestionarParqueadero() {
		String menu="(1) Actualizar Datos del Parqueadero:\n"
				+"(2) Actualizar los Cupos del Parqueadero: \n"
				+"(3) Actualizar Tarifas del Parqueadero:\n"
				+"(4) Generar Facturas con el ID del Pago:\n"
				+"(5) Obtener el Historial de Pago de un Vehículo:\n"
				+"(6) Calcular los Ingresos Totales del Parqueadero:\n"
				+"(7) Volver al Menú Principal:\n";
		
		int opcion;
		do {opcion= Integer.parseInt(capturarDato(menu));
			validarMenuGestionarParqueadero(opcion);
		}while (opcion!=7);	      	
    }
	
	public static void validarMenuGestionarParqueadero(int opcion) {
		switch (opcion) {
		case 1:
			//(1) Actualizar Datos del Parqueadero
			mostrarMensaje("Los datos acuales del parqueadero son: " + parqueadero.toString());
			boolean canModificarP=parqueadero.modificarDatosParqueadero(capturarDato("Ingrese el nombre del Parqueadero: "),capturarDato("Ingrese la dirección"
					+ " del Parqueadero: "),capturarDato("Ingrese el representante del Parqueadero: "),capturarDato("Ingrese el teléfono del Parqueadero: "),
					capturarDato("Ingrese el email del Parqueadero: "));
			mostrarMensaje(canModificarP?"Se actualizaron los datos del parqueadero":"No se pudieron actualizar los datos");
			break;
		case 2:
			//(2) Actualizar los cupos del Parqueadero
			mostrarMensaje("Los cupos actuales de los cupos del Parqueadero son:" + parqueadero.toStringCupos());
			boolean canModificar=parqueadero.modificarCupos(Integer.parseInt(capturarDato("Ingrese el tipo de vehiculo al que desea modificarle "
					+ "los cupos\n(1) Automovil\n(2) Moto\n(3) Camion\n")), Integer.parseInt(capturarDato("Ingrese el nuevo cupo: ")));
			mostrarMensaje(canModificar?"Se han actualizado exitosamente los cupos del Parqueadero":"No se pudo hacer la actualizar");
			parqueadero.toStringCupos();
			break;
		case 3:
			//(3) Actualizar Tarifas del Parqueadero
			mostrarMensaje("Los datos acuales de las tarifas son: " + TarifaService.mostrarTarifas());
			boolean canActualizar=parqueadero.getPagosController().actualizarTarifas(Integer.parseInt(capturarDato("Ingrese el vehiculo al que "
					+ "desea cambiarle la tarifa\n(1) Automovil\n(2) Moto\n(3) Camion\n")),Integer.parseInt(capturarDato( "Ingrese la tarifa que desea "
					+ "cambiar\n(1) Hora\n(2) Anual\n(3) Trimestral\n(4) Mensual\n")),Integer.parseInt(capturarDato("Ingrese el nuevo valor de la tarifa")));
			mostrarMensaje(canActualizar? "Actualización existosa":"No se pudo hacer la actualización");
			TarifaService.mostrarTarifas();
			break;
		case 4:
			//(4) Generar Facturas con el ID del pago
			String mensaje=parqueadero.getPagosController().generarFactura(capturarDato("Ingrese el ID del Pago: "));
			mostrarMensaje(parqueadero.toString()+"\n"+mensaje);
			break;
		case 5:
			//(5) Obtener el historial de pago de un vehículo
			String mensaje2=parqueadero.getPagosController().obtenerHistorialPagoVehiculo(capturarDato("Ingrese la placa de la que desea obtener"
					+ "el historial de pagos"));
			mostrarMensaje(mensaje2);
			break;
		case 6:
			//(6) Calcular los ingresos totales del parqueadero
			String mensajePagos = "Los pagos registrados son los siguientes: ";
			for (Pago p:parqueadero.getPagosController().getPagos()) {
				mensajePagos+=p.toString();
			}
			mostrarMensaje(mensajePagos+"\n\nA la fecha el parqueadero a generado los siguientes ingresos en pesos colombianos:\n"+TarifaService.cambiarFormato(parqueadero.getPagosController().calcularIngresosTotales()))
			
			;
			break;
		case 7:
			//(7) Volver al menú principal
			break;
		default:
			mostrarMensaje("No ingresó ninguna opción válida");
			break;
		}
	}
	
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static String capturarDato(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
}