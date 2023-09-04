package com.example.demo.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import com.example.demo.repository.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IReservaRepository;
import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.iClienteRepository;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.dto.ReservaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	private iClienteRepository clienteRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Autowired
	private IReservaRepository iReservaRepository;

	@Override
	public Boolean reservarVehiculo(ReservaDTO reservaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verificarDisponibilidad(ReservaDTO reservaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva cambiarEstadoReserva(String numeroReserva) {
		// TODO Auto-generated method stub
		Reserva r =this.iReservaRepository.seleccionarPorNoReserva(numeroReserva);
		r.setEstado("E");
		this.iReservaRepository.actualizar(r);
		return r;
	}

	@Override
	public Reserva buscarPorReserva(String numeroReserva) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.seleccionarPorNoReserva(numeroReserva);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepository.actualizar(reserva);
	}

	
	

	

}
