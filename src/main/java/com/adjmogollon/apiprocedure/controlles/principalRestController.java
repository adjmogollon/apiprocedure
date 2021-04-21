package com.adjmogollon.apiprocedure.controlles;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.adjmogollon.apiprocedure.models.dto.IFacturasClientePorEmailDTO;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientePorCorreoDTO;
import com.adjmogollon.apiprocedure.models.dto.IInfoClientesTodosDTO;
import com.adjmogollon.apiprocedure.models.dto.ICantidadFacturasTodosClientesDTO;
import com.adjmogollon.apiprocedure.models.dto.cantidadFacturasTodosClientesDTO;
import com.adjmogollon.apiprocedure.models.entity.Cliente;
import com.adjmogollon.apiprocedure.models.entity.Region;
import com.adjmogollon.apiprocedure.models.repository.IClienteRepository;
import com.adjmogollon.apiprocedure.models.repository.IRegionRepository;
import com.adjmogollon.apiprocedure.services.IClienteService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiRest")
public class principalRestController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IRegionRepository regionRepository;
	
	private final Logger log = LoggerFactory.getLogger(principalRestController.class);

	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");
		return clienteService.findAll();
	}

	@GetMapping("/contarClientesEntero")
	public ResponseEntity<?> contarClientesEntero() {
		Map<String, Object> response = new HashMap<>();
		// return (BigInteger) clienteService.contarClientesEntero();
		response.put("cantidadClientes", clienteService.contarClientesEnteroProcedure());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/cantidadFacturasTodosClientes00Procedure")
	public List<Object[]> cantidadFacturasTodosClientes00Procedure() {
		return clienteService.getCantidadFacturasTodosClientesProcedure();
	}

	@GetMapping("/cantidadFacturasTodosClientes01MapperController")
	public ResponseEntity<?> cantidadFacturasTodosClientes01MapperController() {
		List<Object[]> resultado = clienteService.getCantidadFacturasTodosClientesRepository();
		List<Map<String, Object>> respuesta = new ArrayList<>();

		for (Object[] cliente : resultado) {
			Map<String, Object> response = new HashMap<>();
			response.put("nombreCliente", cliente[0]);
			response.put("apellidoCliente", cliente[1]);
			response.put("correoCliente", cliente[2]);
			response.put("cantidadFacturasCliente", cliente[3]);
			respuesta.add(response);
		}
		return new ResponseEntity<List<Map<String, Object>>>(respuesta, HttpStatus.OK);
	}

	@GetMapping("/cantidadFacturasTodosClientes02TupleDTOMapperService")
	public List<cantidadFacturasTodosClientesDTO> cantidadFacturasTodosClientes02DTOMapperService() {
		return clienteService.getCantidadFacturasTodosClientesTupleDTO();
	}

	@GetMapping("/cantidadFacturasTodosClientes03DTOMapperRepository")
	public List<ICantidadFacturasTodosClientesDTO> cantidadFacturasTodosClientes03DTOMapperRepository() {
		return clienteService.getCantidadFacturasTodosClientesInterfaceDTO();
	}

	@GetMapping("/facturasClientePorEmail/{email}")
	public List<IFacturasClientePorEmailDTO> facturasClientePorEmail(@PathVariable String email) {
		return clienteService.getFacturasClientePorEmail(email);

	}

	@GetMapping("/contarClienteRepository")
	public Map<String, Integer> contarClienteRepository() {
		Map<String, Integer> response = new HashMap<>();
		response.put("CantidadTotalClientes", clienteService.getContarClientesRepository());
		return response;
	}
	
	@GetMapping("/contarClientePorRegion")
	public Map<String, Integer> contarClientePorRegion() {
		Map<String, Integer> response = new HashMap<>();
		response.put("CantidadClienteRegion", clienteService.getContarClientePorRegion(3));
		return response;
	}

	@GetMapping("/infoClientePorCorreo/{email}")
	public Cliente infoClientePorCorreo(@PathVariable String email) {
		
		// En este metodo se llama al procedimiento y se crea una Entidad cliente la cual es retornada 
		
		IInfoClientePorCorreoDTO miClienteDTO = clienteService.getInfoClientePorCorreo(email);
		
		Region regionCliente = regionRepository.findById(miClienteDTO.getNumberRegion()).orElse(null);		
		Cliente miCliente = new Cliente(miClienteDTO.getNumberClient(), miClienteDTO.getFirtsNameClient(), miClienteDTO.getLastNameClient(), miClienteDTO.getEmailCliente(), new Date(), null, regionCliente, null);
		
		//Cliente miCliente = clienteRepository.findById(miClienteDTO.getNumberClient()).orElse(null);
		
		return miCliente;
	}
	
	
	@GetMapping("/infoClientesTodos")
	public List<IInfoClientesTodosDTO> infoClientesTodos() {
		return clienteService.getInfoClientesTodos();
	}
	
}
