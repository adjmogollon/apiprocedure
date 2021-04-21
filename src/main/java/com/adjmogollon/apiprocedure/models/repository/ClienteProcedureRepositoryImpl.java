package com.adjmogollon.apiprocedure.models.repository;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteProcedureRepositoryImpl implements IClienteProcedureRepository {

    @Autowired
    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    public Object contarClientesEntero() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("contarClientesEntero");
        storedProcedureQuery.execute();
        Object resultado = storedProcedureQuery.getSingleResult();
        return resultado;
    }

    @Override
    public List<Object[]>  getCantidadFacturasTodosClientes() {
       
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("cantidadFacturasTodosClientes");
        storedProcedureQuery.execute();
        List<Object[]> resultado = storedProcedureQuery.getResultList();
        return resultado;
    }
    
}
