package Controllers;

import javax.swing.JOptionPane;

public class Parqueadero {
	private VehiculosController vehiculosController;
	private PagosController pagosController;
	private ClientesController clientesController; 
	private String nombre;
	private String direccion;
	private String representante;
	private String telefono;
	private String email;
	private int cuposAutomovil;
	private int cuposMoto;
	private int cuposCamion;
	
	public Parqueadero(String nombre, String direccion, String representante, String telefono, String email,
			int cuposAutos, int cuposMotos, int cuposCamiones) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.telefono = telefono;
		this.email = email;
		this.cuposAutomovil = cuposAutos;
		this.cuposMoto = cuposMotos;
		this.cuposCamion = cuposCamiones;
		this.vehiculosController= new VehiculosController(this);
		this.pagosController= new PagosController(this);
		this.clientesController= new ClientesController(this);
		/**Preguntar si esta es la manera de hacerlo, o como funcionarian
		 * estos controladores en el programa* 
		 */
	}
	
	public void modificarCupos(String tipoVehiculo, int numeroCupos){
		switch (tipoVehiculo) {
		case "1":
			setCuposAutomovil(numeroCupos);
			break;
		case "2":
			setCuposMoto(numeroCupos);
			break;
		case "3":
			setCuposCamion(numeroCupos);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			break;
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCuposAutomovil() {
		return cuposAutomovil;
	}

	public void setCuposAutomovil(int cuposAutos) {
		this.cuposAutomovil = cuposAutos;
	}

	public int getCuposMoto() {
		return cuposMoto;
	}

	public void setCuposMoto(int cuposMotos) {
		this.cuposMoto = cuposMotos;
	}

	public int getCuposCamion() {
		return cuposCamion;
	}

	public void setCuposCamion(int cuposCamiones) {
		this.cuposCamion = cuposCamiones;
	}
	
	public VehiculosController getVehiculosController() {
		return vehiculosController;
	}

	public void setVehiculosController(VehiculosController vehiculosController) {
		this.vehiculosController = vehiculosController;
	}

	public PagosController getPagosController() {
		return pagosController;
	}

	public void setPagosController(PagosController pagosController) {
		this.pagosController = pagosController;
	}

	public ClientesController getClientesController() {
		return clientesController;
	}

	public void setClientesController(ClientesController clientesController) {
		this.clientesController = clientesController;
	

	public boolean verificarCupos(int tipoVehiculo) {
	switch (tipoVehiculo){
		case 1:
		case 4:
			if(getCuposAutomovil()>=1) {		
				this.cuposAutomovil -= 1;
				return true;
			}
		case 2:
		case 5:
			if(getCuposMoto()>=1) {				
				this.cuposMoto -= 1;
				return true;
			}
		case 3:
		case 6:
			if(getCuposCamion()>=1) {
				this.cuposCamion -= 1;
				return true;
			}
		default:
			return false;
		}
	}
}
