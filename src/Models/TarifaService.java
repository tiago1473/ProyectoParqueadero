package Models;
import java.text.NumberFormat;
import java.util.Locale;

public class TarifaService {
	private static int[] tarifaAutomovil = new int[4];
	private static int[] tarifaMoto = new int[4];
	private static int[] tarifaCamion = new int[4];
	public static Locale colombia=new Locale("es","CO");
	
	/**Para las tarifas se hacen arreglos de 4 numeros enteros, la primera posicion (0) es la tarifa por hora
	 * la segunda posición (1) es la tarifa de la membresia anual, la tercera posición (2) es la membresia
	 * trimestral y la cuarta posición (3) es la membresia mensual*/
	
	private TarifaService() {
	}

	public static int[] getTarifaAutomovil() {
		return tarifaAutomovil;
	}

	public static void setTarifaAutomovil(int posicion,int tarifaA) {
		switch (posicion) {
		case 0:
			tarifaAutomovil[0]=tarifaA;
			break;
		case 1:
			tarifaAutomovil[1]=tarifaA;
			break;
		case 2:
			tarifaAutomovil[2]=tarifaA;
			break;
		case 3:
			tarifaAutomovil[3]=tarifaA;
			break;
		default:
			break;
		}
	}

	public static int[] getTarifaMoto() {
		return tarifaMoto;
	}
	
	public static void setTarifaMoto(int posicion,int tarifaM) {
		switch (posicion) {
		case 0:
			tarifaMoto[0]=tarifaM;
			break;
		case 1:
			tarifaMoto[1]=tarifaM;
			break;
		case 2:
			tarifaMoto[2]=tarifaM;
			break;
		case 3:
			tarifaMoto[3]=tarifaM;
			break;
		default:
			break;
		}
	}

	public static int[] getTarifaCamion() {
		return tarifaCamion;
	}
	
	public static void setTarifaCamion(int posicion,int tarifaC) {
		switch (posicion) {
		case 0:
			tarifaCamion[0]=tarifaC;
			break;
		case 1:
			tarifaCamion[1]=tarifaC;
			break;
		case 2:
			tarifaCamion[2]=tarifaC;
			break;
		case 3:
			tarifaCamion[3]=tarifaC;
			break;
		default:
			break;
		}
	}
	
	public static String cambiarFormato(int valor) {
		NumberFormat formatoMoneda=NumberFormat.getCurrencyInstance(colombia);
		return formatoMoneda.format(valor);
	}
	
	public static String mostrarTarifas() {
		return "Las tarifas actuales son las siguientes:\n"
				+"AUTOMOVIL: Hora:"+cambiarFormato(tarifaAutomovil[0])+", Anual:"+cambiarFormato(tarifaAutomovil[1])+", Trimestral:"
				+cambiarFormato(tarifaAutomovil[2])+", Mensual:"+cambiarFormato(tarifaAutomovil[3])+"\n"+"MOTO: Hora:"+cambiarFormato(tarifaMoto[0])
				+", Anual:"+cambiarFormato(tarifaMoto[1])+", Trimestral:"+cambiarFormato(tarifaMoto[2])+", Mensual:"+cambiarFormato(tarifaMoto[3])+"\n"
				+"CAMIÓN: Hora:"+cambiarFormato(tarifaCamion[0])+", Anual:"+cambiarFormato(tarifaCamion[1])+", Trimestral:"+cambiarFormato(tarifaCamion[2])
				+", Mensual:"+cambiarFormato(tarifaCamion[3]);
	}
}