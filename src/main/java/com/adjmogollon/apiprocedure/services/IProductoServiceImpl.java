package com.adjmogollon.apiprocedure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjmogollon.apiprocedure.models.entity.Producto;
import com.adjmogollon.apiprocedure.models.repository.IProductoRepository;

@Service
public class IProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Producto> findProductosByNombreContains(String nombre_in) {

		return productoRepository.findProductosByNombreContains(nombre_in);
	}

}
