package com.example.demo.service;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteService {
	public void guardarCliente(Cliente cliente);
	public void guardarEmpleado(Cliente cliente);
	public Cliente buscarPorId(Integer id);
	public void actualizar(Cliente cliente);
	public void borrar(Integer id);

}
