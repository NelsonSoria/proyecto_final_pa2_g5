package com.example.demo.service.dto;

import java.time.LocalDate;

public class VehiculoDTO {
    private String placa;
    private String modelo;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String cedulaCliente;

    private String noReserva;

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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fecha) {
        this.fechaInicio = fecha;
    }
    public String getCedulaCliente() {
        return cedulaCliente;
    }
    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
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
