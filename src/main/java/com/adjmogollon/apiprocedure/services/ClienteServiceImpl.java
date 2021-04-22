package com.adjmogollon.apiprocedure.services;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import com.adjmogollon.apiprocedure.models.dto.ICantidadFacturasTodosClientesDto;
import com.adjmogollon.apiprocedure.models.dto.IFacturasClientePorEmailDto;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientePorCorreoDto;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientesTodosDto;
import com.adjmogollon.apiprocedure.models.dto.cantidadFacturasTodosClientesDto;
import com.adjmogollon.apiprocedure.models.entity.Cliente;
import com.adjmogollon.apiprocedure.models.repository.IClienteProcedureRepository;
import com.adjmogollon.apiprocedure.models.repository.IClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    @Autowired
    IClienteProcedureRepository clienteProcedureRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Object contarClientesEnteroProcedure() {
        return clienteProcedureRepository.contarClientesEntero();
    }

    @Override
    public List<Object[]> getCantidadFacturasTodosClientesProcedure() {
        return clienteProcedureRepository.getCantidadFacturasTodosClientes();
    }
    
    @Override
    public List<Object[]> getCantidadFacturasTodosClientesRepository() {
        return clienteRepository.getCantidadFacturasTodosClientesRepository();
    }
    
    @Override
	public List<cantidadFacturasTodosClientesDto> getCantidadFacturasTodosClientesTupleDTO() {
		List<Tuple> clientesFacturaTuples =  clienteRepository.getCantidadFacturasTodosClientesTupleDTO(); 
	    List<cantidadFacturasTodosClientesDto> clientesFacturaDTO = clientesFacturaTuples.stream()
	            .map(t -> new cantidadFacturasTodosClientesDto(
	                    t.get(0, String.class), 
	                    t.get(1, String.class),
	                    t.get(2, String.class), 
	                    t.get(3, BigInteger.class)
	                    ))
	            .collect(Collectors.toList());
		return clientesFacturaDTO;
	}
    
	@Override
	public List<ICantidadFacturasTodosClientesDto> getCantidadFacturasTodosClientesInterfaceDTO() {		
		return clienteRepository.getCantidadFacturasTodosClientesInterfaceDTO();
	}

	@Override
	public List<IFacturasClientePorEmailDto> getFacturasClientePorEmail(String email) {
		return clienteRepository.getFacturasClientePorEmail(email);
	}
	
	@Override
	public Integer getContarClientesRepository() {
		return clienteRepository.getContarClientesRepository();
	}

	@Override
	public Integer getContarClientePorRegion(Integer region) {
		return clienteRepository.getContarClientePorRegion(region);
	}

	@Override
	public IInfoClientePorCorreoDto getInfoClientePorCorreo(String correoCliente) {
		return clienteRepository.getInfoClientePorCorreo(correoCliente);
	}

	@Override
	public List<IInfoClientesTodosDto> getInfoClientesTodos() {
		return clienteRepository.getInfoClientesTodos();
	}

	
    
}
