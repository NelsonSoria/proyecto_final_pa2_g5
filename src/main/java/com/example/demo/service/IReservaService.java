package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.dto.ReservaDTO;

public interface IReservaService {
	
	public void reservarVehiculo(String placa,String cedula,LocalDate fechaInicio,LocalDate fechaFin,String numeroTarjeta);
	public boolean verificarDisponibilidad(String placa,LocalDate fechaInicio,LocalDate fechaFin);
	public LocalDate obtenerFechaDisponible(String placa, LocalDate fechaInicio, LocalDate fechaFin);
	public BigDecimal valorTotalAPagar(String placa, LocalDate fechaInicio, LocalDate fechaFin);
	

}
