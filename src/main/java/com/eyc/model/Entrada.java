package com.eyc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Entrada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Debe especificar un número de entrada")
	@Size(min = 4, max = 6, message = "entre 4 y 6 dígitos")
	@Column(unique = true)
	private String numeroEntrada;
	
	@Column
	private String fechaEntrada;
	
	@NotBlank(message = "Debe especificar un cliente para la entrada")
	@Column
	private String cliente;
	
	@Column
	private String cedula;
	
	@NotBlank(message = "Debe especificar número de celular del cliente")
	@Size(min = 7, max = 10, message = "entre 7 y 10 dígitos")
	@Column
	private String celular;
	
	@NotBlank(message = "Debe indicar objeto de entrada")
	@Column
	private String objeto;
	
	@NotBlank(message = "Debe indicar una marca")
	@Column
	private String marca;
	
	@NotBlank(message = "Debe indicar un modelo")
	@Column
	private String modelo;
	
	@NotBlank(message = "Debe indicar una observación de la entrada")
	@Size(min = 0, max = 5000 ,message = "Mucho texto.")
	@Column
	private String observacion;
	
	@NotBlank
	@Column
	private String estado;
	
	@NotBlank
	@Column
	private String tecnico;
	
	@NotNull(message = "El abono no puede estar vacío")
	@Min(value = 0, message = "no puede ser un número negativo")
	private double abono;
	
	@NotNull(message = "El total no puede estar vacío")
	@Min(value = 0, message = "no puede ser un número negativo")
	private double total;
	
	@NotBlank
	@Column
	private String entregado;
	
	public Entrada() {
	}

	public Entrada(@NotBlank String numeroEntrada, @NotBlank String fechaEntrada, @NotBlank String cliente,
			String cedula, @NotBlank String celular, @NotBlank String objeto, @NotBlank String marca,
			@NotBlank String modelo, @NotBlank String observacion, @NotBlank String estado, @NotBlank String tecnico,
			@NotNull @Min(0) double abono, @NotNull @Min(0) double total, @NotBlank String entregado) {
		this.numeroEntrada = numeroEntrada;
		this.fechaEntrada = fechaEntrada;
		this.cliente = cliente;
		this.cedula = cedula;
		this.celular = celular;
		this.objeto = objeto;
		this.marca = marca;
		this.modelo = modelo;
		this.observacion = observacion;
		this.estado = estado;
		this.tecnico = tecnico;
		this.abono = abono;
		this.total = total;
		this.entregado = entregado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroEntrada() {
		return numeroEntrada;
	}

	public void setNumeroEntrada(String numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public double getAbono() {
		return abono;
	}

	public void setAbono(double abono) {
		this.abono = abono;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	@Override
	public String toString() {
		return "Entrada [numeroEntrada=" + numeroEntrada + ", fechaEntrada=" + fechaEntrada + ", cliente=" + cliente
				+ ", cedula=" + cedula + ", celular=" + celular + ", objeto=" + objeto + ", marca=" + marca
				+ ", modelo=" + modelo + ", observacion=" + observacion + ", estado=" + estado + ", tecnico=" + tecnico
				+ ", abono=" + abono + ", total=" + total + ", entregado=" + entregado + "]";
	}
	
	
}
