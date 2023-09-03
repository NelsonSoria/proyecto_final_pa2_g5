package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;

import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private IClienteService clienteService;
    //http://localhost:8080/concesionario/empleados/principal
    @GetMapping("/principal")
	public String principal(Cliente cliente, Model modelo) {
        List<Cliente> lista = this.clienteService.buscarTodos();
		modelo.addAttribute("clientes", lista);
        modelo.addAttribute("cliente", cliente);
		return "vistaEmpleadoPrincipal";
	}

    @PostMapping("/registrar")
    public String registrarCliente(Cliente cliente){
        try {
			Cliente c = new Cliente();
			c.setCedula(cliente.getCedula());
			c.setNombre(cliente.getNombre());
			c.setApellido(cliente.getApellido());
			c.setFechaNacimiento(cliente.getFechaNacimiento());
			c.setGenero(cliente.getGenero());
			
			this.clienteService.guardarEmpleado(c);
			return "redirect:/empleados/principal";
		} catch (Exception e) {
			return "redirect:../paginas/principal";
		}
    }
   
    @GetMapping("/detalle/{idCliente}")
    public String detalle(@PathVariable("idCliente") Integer id, Model modelo){
        Cliente cliente = this.clienteService.buscarPorId(id);
        modelo.addAttribute("cliente",cliente);
        return "vistaEmpleadoDetalle";
    }
}
