package com.adjmogollon.apiprocedure.models.repository;

import java.util.List;

import javax.persistence.Tuple;

import com.adjmogollon.apiprocedure.models.dto.ICantidadFacturasTodosClientesDTO;
import com.adjmogollon.apiprocedure.models.dto.IFacturasClientePorEmailDTO;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientePorCorreoDTO;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientesTodosDTO;
import com.adjmogollon.apiprocedure.models.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "CALL cantidadFacturasTodosClientes()", nativeQuery = true)
	public List<Object[]> getCantidadFacturasTodosClientesRepository();

	@Query(value = "CALL cantidadFacturasTodosClientes()", nativeQuery = true)
	public List<Tuple> getCantidadFacturasTodosClientesTupleDTO();

	@Query(value = "CALL cantidadFacturasTodosClientes()", nativeQuery = true)
	public List<ICantidadFacturasTodosClientesDTO> getCantidadFacturasTodosClientesInterfaceDTO();

	@Query(value = "CALL facturasClientePorEmail(:correoCliente)", nativeQuery = true)
	public List<IFacturasClientePorEmailDTO> getFacturasClientePorEmail(@Param("correoCliente") String correoCliente);

	@Procedure(procedureName = "contarClientes", outputParameterName = "cantidad")
	public Integer getContarClientesRepository();
	
	@Procedure(procedureName = "contarClientePorRegion", outputParameterName = "cantidad")
	public Integer getContarClientePorRegion(Integer region);
	
	@Query(value = "CALL infoClientePorCorreo(:correoCliente)", nativeQuery = true)
	public IInfoClientePorCorreoDTO getInfoClientePorCorreo(@Param("correoCliente") String correoCliente);

	@Query(value = "CALL infoClientesTodos()", nativeQuery = true)
	public List<IInfoClientesTodosDTO> getInfoClientesTodos();
	
}
