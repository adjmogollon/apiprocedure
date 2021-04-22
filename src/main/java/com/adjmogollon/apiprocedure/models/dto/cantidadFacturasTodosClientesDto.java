package com.adjmogollon.apiprocedure.models.dto;

import java.io.Serializable;
import java.math.BigInteger;




public class cantidadFacturasTodosClientesDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreCliente;
	private String apellidoCliente;
	private String emailCliente;
	private BigInteger cantidadFacturas;

	public cantidadFacturasTodosClientesDto() {

	}

	public cantidadFacturasTodosClientesDto(String nombreCliente, String apellidoCliente, String emailCliente,
			BigInteger cantidadFacturas) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.emailCliente = emailCliente;
		this.cantidadFacturas = cantidadFacturas;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public BigInteger getCantidadFacturas() {
		return cantidadFacturas;
	}

	public void setCantidadFacturas(BigInteger cantidadFacturas) {
		this.cantidadFacturas = cantidadFacturas;
	}

	@Override
	public String toString() {
		return "cantidadFacturasTodosClientesDTO [nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", emailCliente=" + emailCliente + ", cantidadFacturas=" + cantidadFacturas + "]";
	}
}