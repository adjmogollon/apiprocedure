package com.adjmogollon.apiprocedure.services;


import java.util.List;

import org.springframework.data.repository.query.Param;

import com.adjmogollon.apiprocedure.models.dto.ICantidadFacturasTodosClientesDto;
import com.adjmogollon.apiprocedure.models.dto.IFacturasClientePorEmailDto;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientePorCorreoDto;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientesTodosDto;
import com.adjmogollon.apiprocedure.models.dto.cantidadFacturasTodosClientesDto;
import com.adjmogollon.apiprocedure.models.entity.Cliente;

public interface IClienteService {
    
	// JPA SIMPLE Llamado desde CrudRepository
    public List<Cliente> findAll();

    // Ejecucion manual del procedimiento con storedProcedureQuery.getSingleResult en ClienteProcedureRepositoryImpl
    public Object contarClientesEnteroProcedure();

    // Ejecucion manual del procedimiento con storedProcedureQuery.getResultList en ClienteProcedureRepositoryImpl.
    // Se mapea en principalRestController de manera manual 
    public List<Object[]> getCantidadFacturasTodosClientesProcedure();
    
    // Ejecucion con anotacion @Query en IclienteRepository se retorna lista de objeto generico
    public List<Object[]> getCantidadFacturasTodosClientesRepository();
    
    
    // Ejecucion con anotacion @Query en IclienteRepository se retorna Tuple. 
    // Se mapea en ClienteServiceImpl con stream a cantidadFacturasTodosClientesDTO
    public List<cantidadFacturasTodosClientesDto> getCantidadFacturasTodosClientesTupleDTO();
    
    // Ejecucion con anotacion @Query en IclienteRepository se retorna Interfaz DTO (ICantidadFacturasTodosClientesDTO). 
    // Se mapea en ICantidadFacturasTodosClientesDTO creando un metodo get para cada atributo que retorne el procedimiento (RECOMENDADO)
    public List<ICantidadFacturasTodosClientesDto> getCantidadFacturasTodosClientesInterfaceDTO();
    
    
    public List<IFacturasClientePorEmailDto> getFacturasClientePorEmail(String email);
    
    public Integer getContarClientesRepository();
    
    public Integer getContarClientePorRegion(Integer region);
    
    public IInfoClientePorCorreoDto getInfoClientePorCorreo(String correoCliente);
    
    public List<IInfoClientesTodosDto> getInfoClientesTodos();

}
