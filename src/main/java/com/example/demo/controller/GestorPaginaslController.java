package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;

@Controller

public class GestorPaginaslController {

	// http://localhost:8080/concesionario/paginas/principal
	
	
	@GetMapping("/paginas/principal")
	public String paginaPrincipal() {
		return "vistaPaginaPrincipal";
	}
	
	@GetMapping("/paginas/cliente")
	public String paginaCliente() {
		return "vistaClientePrincipal";
	}
	
	@GetMapping("/paginas/empleado")
	public String paginaEmpleado() {
		
		return "redirect:../empleados/principal";
	}
	
	@GetMapping("/paginas/reporte")
	public String paginaReporte() {
		return "vistaReportePrincipal";
	}

}
