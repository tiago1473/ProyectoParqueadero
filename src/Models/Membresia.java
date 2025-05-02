package Models;

import java.time.LocalDateTime;
import Assets.Categoria;

public class Membresia {
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private boolean isActiva;
	private Categoria categoria;
	
	public Membresia(LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean isActiva, Categoria categoria) {
		this.fechaInicio =fechaInicio;
		this.fechaFin=fechaFin;
		this.isActiva=isActiva;
		this.categoria=categoria;
	}

	public LocalDateTime getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean getIsActiva() {
		return this.isActiva;
	}

	public void setActiva(boolean isActiva) {
		this.isActiva = isActiva;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
