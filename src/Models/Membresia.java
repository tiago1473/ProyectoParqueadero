package Models;

import java.util.Date;

import Assets.Categoria;

public class Membresia {
	private Date fechaInicio;
	private Date fechaFin;
	private boolean isActiva;
	private Categoria categoria;
	private Cliente cliente;
	
	public Membresia(Date fechaInicio, Date fechaFin, boolean isActiva, Categoria categoria, Cliente cliente) {
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.isActiva=isActiva;
		this.categoria=categoria;
		this.cliente=cliente;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isActiva() {
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
