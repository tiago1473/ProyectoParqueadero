package Models;

public class TarifaService {
	private int tarifaAutomovil;
	private int tarifaMoto;
	private int tarifaCamion;
	
	public TarifaService(int tarifaAutomovil, int tarifaMoto, int tarifaCamion) {
		this.tarifaAutomovil = tarifaAutomovil;
		this.tarifaMoto = tarifaMoto;
		this.tarifaCamion = tarifaCamion;
	}

	public int getTarifaAutomovil() {
		return tarifaAutomovil;
	}

	public void setTarifaAutomovil(int tarifaAutomovil) {
		this.tarifaAutomovil = tarifaAutomovil;
	}

	public int getTarifaMoto() {
		return tarifaMoto;
	}

	public void setTarifaMoto(int tarifaMoto) {
		this.tarifaMoto = tarifaMoto;
	}

	public int getTarifaCamion() {
		return tarifaCamion;
	}

	public void setTarifaCamion(int tarifaCamion) {
		this.tarifaCamion = tarifaCamion;
	}
}
