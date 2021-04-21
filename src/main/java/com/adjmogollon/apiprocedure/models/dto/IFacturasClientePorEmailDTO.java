package com.adjmogollon.apiprocedure.models.dto;

public interface IFacturasClientePorEmailDTO {

	public Long getIdFactura();

	public Long getIdCliente();

	public String getDescripcionFactura();

	public String getObservacionFactura();

	public String getEmailCliente();

	public String getNombreCliente();

	public String getApellidoCliente();

}
