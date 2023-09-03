package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.IReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	private IReservaService iReservaService;
	
	@PostMapping("/guardar")
	public String reservarVehiculo(@RequestParam("placa")String placa,
			@RequestParam("cedula")String cedula,
			@RequestParam("fechaInicio")LocalDate fechaInicio,
			@RequestParam("fechaFin")LocalDate fechaFin, Model model) {
		String aux="";
		
		if(this.iReservaService.verificarDisponibilidad(placa,fechaInicio,fechaFin)) {
			BigDecimal totalAPagar = this.iReservaService.valorTotalAPagar(placa,fechaInicio, fechaFin);
	        model.addAttribute("totalAPagar", totalAPagar);
	     // Almacenar los datos en el modelo para la vista
	        model.addAttribute("placa", placa);
	        model.addAttribute("cedula", cedula);
	        model.addAttribute("fechaInicio", fechaInicio);
	        model.addAttribute("fechaFin", fechaFin);
	        
			aux="vistaRegistrarReserva";
		}else {
			LocalDate fechaDisponible =this.iReservaService.obtenerFechaDisponible(placa, fechaInicio, fechaFin);
			 model.addAttribute("fecha_inicio_seleccionada", fechaInicio.toString());
		     model.addAttribute("fecha_fin_seleccionada", fechaFin.toString());
		     model.addAttribute("fecha_disponible", fechaDisponible.toString());
			aux="vistaVehiculoIndisponible";
		}
		return aux;
	}
	@PostMapping("/registrar")
	public String registrarReserva(@RequestParam("placa") String placa,
	        @RequestParam("cedula") String cedula,
	        @RequestParam("fechaInicio") LocalDate fechaInicio,
	        @RequestParam("fechaFin") LocalDate fechaFin,
	        @RequestParam("tarjetaCredito") String tarjetaCredito) {
	  
		this.iReservaService.reservarVehiculo(placa, cedula, fechaInicio, fechaFin, tarjetaCredito);
		System.out.println(placa);
		System.out.println(fechaInicio);
		System.err.println(tarjetaCredito);
	    return "redirect:/paginas/cliente";
	}
}
