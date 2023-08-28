package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;


@Controller
@RequestMapping("/vehiculos")

public class VehiculoController {
	
	@Autowired
    private IVehiculoService iVehiculoService;
    private static final Logger LOG = LoggerFactory.getLogger(VehiculoController.class);

    
    //http://localhost:8080/concesionario/vehiculos/buscarPorPlaca/?
    @GetMapping("/buscarPorPlaca/{placaPropietario}")
    public String buscaPorPlaca(@PathVariable("placaPropietario") String placa, Model modelo){
        Vehiculo buscado = this.iVehiculoService.buscarPorPlaca(placa);
       
        modelo.addAttribute("vehiculo",buscado);
        LOG.info(buscado.getEstadoReserva());
        return "vistaPorPlaca";
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

}
