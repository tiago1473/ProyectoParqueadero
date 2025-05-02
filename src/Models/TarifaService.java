package Models;

public class TarifaService {
	private int tarifaAutomovil;
	private int tarifaMoto;
	private int tarifaCamion;
	private int anualAutomovil;
	private int anualMoto;
	private int anualCamion;
	private int trimestralAutomovil;
	private int trimestralMoto;
	private int trimestralCamion;
	private int mensualAutomovil;
	private int mensualMoto;
	private int mensualCamion;
	
	public TarifaService(int tarifaAutomovil, int tarifaMoto, int tarifaCamion, int anualAutomovil
			, int anualMoto, int anualCamion, int trimestralAutomovil, int trimestralMoto
			, int trimestralCamion, int mensualAutomovil, int mensualMoto, int mensualCamion) {
		this.tarifaAutomovil = tarifaAutomovil;
		this.tarifaMoto = tarifaMoto;
		this.tarifaCamion = tarifaCamion;
		this.anualAutomovil= anualAutomovil;
		this.anualMoto= anualMoto;
		this.anualCamion= anualCamion;
		this.trimestralAutomovil=trimestralAutomovil;
		this.trimestralMoto=trimestralMoto;
		this.trimestralCamion=trimestralCamion;
		this.mensualAutomovil=mensualAutomovil;
		this.mensualMoto=mensualAutomovil;
		this.mensualCamion=mensualCamion;
	}

	public int getTarifaAutomovil() {
		return this.tarifaAutomovil;
	}

	public void setTarifaAutomovil(int tarifaAutomovil) {
		this.tarifaAutomovil = tarifaAutomovil;
	}

	public int getTarifaMoto() {
		return this.tarifaMoto;
	}

	public void setTarifaMoto(int tarifaMoto) {
		this.tarifaMoto = tarifaMoto;
	}

	public int getTarifaCamion() {
		return this.tarifaCamion;
	}

	public void setTarifaCamion(int tarifaCamion) {
		this.tarifaCamion = tarifaCamion;
	}

	public int getAnualAutomovil() {
		return this.anualAutomovil;
	}

	public void setAnualAutomovil(int anualAutomovil) {
		this.anualAutomovil = anualAutomovil;
	}

	public int getAnualMoto() {
		return this.anualMoto;
	}

	public void setAnualMoto(int anualMoto) {
		this.anualMoto = anualMoto;
	}

	public int getAnualCamion() {
		return this.anualCamion;
	}

	public void setAnualCamion(int anualCamion) {
		this.anualCamion = anualCamion;
	}

	public int getTrimestralAutomovil() {
		return this.trimestralAutomovil;
	}

	public void setTrimestralAutomovil(int trimestralAutomovil) {
		this.trimestralAutomovil = trimestralAutomovil;
	}

	public int getTrimestralMoto() {
		return this.trimestralMoto;
	}

	public void setTrimestralMoto(int trimestralMoto) {
		this.trimestralMoto = trimestralMoto;
	}

	public int getTrimestralCamion() {
		return this.trimestralCamion;
	}

	public void setTrimestralCamion(int trimestralCamion) {
		this.trimestralCamion = trimestralCamion;
	}

	public int getMensualAutomovil() {
		return this.mensualAutomovil;
	}

	public void setMensualAutomovil(int mensualAutomovil) {
		this.mensualAutomovil = mensualAutomovil;
	}

	public int getMensualMoto() {
		return this.mensualMoto;
	}

	public void setMensualMoto(int mensualMoto) {
		this.mensualMoto = mensualMoto;
	}

	public int getMensualCamion() {
		return this.mensualCamion;
	}

	public void setMensualCamion(int mensualCamion) {
		this.mensualCamion = mensualCamion;
	}
	
}