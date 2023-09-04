package com.example.demo.repository.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class VehiculoDTO {

	private String placa;
	private String modelo;
	private String cedulaCliente;
	private String estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String noReserva;
	
	public VehiculoDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public VehiculoDTO(String placa, String modelo, String cedulaCliente, String estado,
			LocalDate fechaFin, LocalDate fechaInicio, String noReserva) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.cedulaCliente=cedulaCliente;
		this.estado = estado;
		this.fechaFin =fechaFin;
		this.fechaInicio = fechaInicio;
		this.noReserva =noReserva;
	}


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCedulaCliente() {
		return cedulaCliente;
	}


	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getNoReserva() {
		return noReserva;
	}


	public void setNoReserva(String noReserva) {
		this.noReserva = noReserva;
	}

}
