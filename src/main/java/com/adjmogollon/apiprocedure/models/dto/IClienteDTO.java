package com.adjmogollon.apiprocedure.models.dto;

import java.util.Date;

public interface IClienteDTO {

    Long getId();
 
    String getnombre();
    
    String getApellido();
   
    String getEmail();

    Date getCreate_at();

    String getFoto();

    String getRegion_id();



}