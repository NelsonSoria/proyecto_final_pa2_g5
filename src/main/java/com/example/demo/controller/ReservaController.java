package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.service.IReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private IReservaService iReservaService;

    @RequestMapping("/reservar")
	public String reservar(@RequestParam("numeroReserva") String numeroReserva, Model modelo){
        Reserva r=this.iReservaService.cambiarEstadoReserva(numeroReserva);
        modelo.addAttribute("reserva", r);
        return"redirect:../vehiculos/buscarPorPlaca";
    }
}
