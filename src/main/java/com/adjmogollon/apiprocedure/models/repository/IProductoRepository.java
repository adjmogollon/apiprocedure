package com.adjmogollon.apiprocedure.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adjmogollon.apiprocedure.models.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

	@Query(value = "CALL findProductosByNombreContains(:nombre_in);", nativeQuery = true)
	List<Producto> findProductosByNombreContains(@Param("nombre_in") String nombre_in);

}
