package com.adjmogollon.apiprocedure.services;

import java.util.List;

import com.adjmogollon.apiprocedure.models.entity.Producto;

public interface IProductoService {

	List<Producto> findProductosByNombreContains(String nombre_in);

}
