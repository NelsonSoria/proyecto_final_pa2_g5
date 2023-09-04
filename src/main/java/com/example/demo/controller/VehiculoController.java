package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.dto.VehiculoDTO;


@Controller
@RequestMapping("/vehiculos")

public class VehiculoController {
	
	@Autowired
    private IVehiculoService iVehiculoService;
    @Autowired
    private IReservaService iReservaService;

    private static final Logger LOG = LoggerFactory.getLogger(VehiculoController.class);
    private String numeroReserva;
    
    //http://localhost:8080/concesionario/vehiculos/buscarPorPlaca/?
    @GetMapping("/buscarPorPlaca")
    public String buscaPorPlaca(@RequestParam("placa") String placa, Model modelo){
        Vehiculo buscado = this.iVehiculoService.buscarPorPlaca(placa);
       
        modelo.addAttribute("vehiculo",buscado);
      
        return "vistaPorPlaca";
    }
    @GetMapping("/buscarPorReserva")
    public String buscarPorReserva(@RequestParam("noReserva") String noReserva,Model modelo){
        VehiculoDTO vDto= this.iVehiculoService.buscarDto(noReserva);
        modelo.addAttribute("vehiculoDTO", vDto);
        this.numeroReserva =noReserva;
        return "vistaPorReserva";
    }

    @GetMapping("/disponibles")
    public String buscarDisponibles(List<Vehiculo> disponibles,Model modelo){
        disponibles = this.iVehiculoService.buscarDisponibles();
        modelo.addAttribute("vehiculos", disponibles);
        return "vistaVehiculosDisponibles";
    }
    //http://localhost:8080/concesionario/vehiculos/buscar
	@GetMapping("/buscar")
    public String buscarVehiculos(@RequestParam("marca") String marca,
                                  @RequestParam("modelo") String modelo,
                                  Model model) {
        List<Vehiculo> vehiculosFiltrados = this.iVehiculoService.buscarPorMarcaModelo(marca, modelo); 
        model.addAttribute("vehiculos", vehiculosFiltrados);
        
        return "vistaListaVehiculos";
    }
    @PutMapping("/retirar/{noReserva}")
    public String retirarReservado(@PathVariable("noReserva") String numeroReserva,Model modelo){
        Reserva r = this.iReservaService.buscarPorReserva(numeroReserva); 
        Vehiculo v = r.getVehiculo();
        r.setEstado("E");
        v.setEstado("I");
        this.iVehiculoService.actualizar(v);
        this.iReservaService.actualizar(r);
        return "success.html";
    }
}
