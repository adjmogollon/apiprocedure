package com.adjmogollon.apiprocedure.models.repository;

import java.util.List;

public interface IClienteProcedureRepository {
    
    public Object contarClientesEntero();

    public List<Object[]> getCantidadFacturasTodosClientes();

}
